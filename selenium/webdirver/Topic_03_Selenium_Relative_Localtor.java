package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_03_Selenium_Relative_Localtor {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01_Relative(){
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
        //Login button
        By loginButtonBy = By.cssSelector("button.login-button");
        WebElement loginButtonElement = driver.findElement(By.cssSelector("button.login-button"));

        //Remember Me checkbox
        By rememberMeCheckboxBy = By.id("RememberMe");

        //Fogot Password Link
        WebElement forgotPasswordElement = driver.findElement(By.cssSelector("span.forgot-password"));

        //password textbox
        By passwordTextboxBy = By.cssSelector("input#Password");

        //GUI: Test giao diện (localtion/posision)
        WebElement rememberMeTextElement = driver
                .findElement(RelativeLocator.with(By.tagName("label"))
                        .above(loginButtonBy) //nằm trên login button
                        .toRightOf(rememberMeCheckboxBy) //nằm bên phải checkbox
                        .toLeftOf(forgotPasswordElement)// nằm bên trái link fogot password
                        .below(passwordTextboxBy) //nằm bên dưới textbox nhập password
                        .near(forgotPasswordElement));
        System.out.println((rememberMeTextElement.getText()));

        //Tìm số nhiều
        List<WebElement> alllinks = driver.findElements(RelativeLocator.with(By.tagName("a")));
        System.out.println((alllinks.size()));
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
