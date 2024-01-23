package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_11_Button_Radio_Checkbox {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01_Egov_Button(){
        driver.get("https://egov.danang.gov.vn/reg");

        WebElement registerButton = driver.findElement(By.cssSelector("input.egov-button"));

        //verify button b disable khi chưa click checkbox
        Assert.assertFalse((registerButton.isEnabled()));

        driver.findElement(By.cssSelector("input#chinhSach")).click();
        sleepInSeconds(2);
        //verify butotn khi đã được enalbe khi click vào checkbox
        Assert.assertTrue(registerButton.isEnabled());

        //lấy ra mã màu nên của button
        String registerBackgroundRGB= registerButton.getCssValue("background-color");
        System.out.println("Background color = " + registerBackgroundRGB);
        //convert từ kiểu String (mã RGB qua kiểu Color
        Color registerBackgroundColor = Color.fromString(registerBackgroundRGB);
        //Convert qua kiểu hexa
        String registerBackgroundHexa = registerBackgroundColor.asHex();
        System.out.println("Background color Hexa =" + registerBackgroundHexa);
        System.out.println("Background color Hexa =" + registerBackgroundHexa.toLowerCase());
        System.out.println("Background color Hexa =" + registerBackgroundHexa.toUpperCase());

        Assert.assertEquals(registerBackgroundHexa.toLowerCase(),"#ef5a00");

    }

    @Test
    public void TC_02_Fahasa_Button(){
        driver.get("https://www.fahasa.com/customer/account/create");
        //chuyển qua tab Đăng nhập
        driver.findElement(By.cssSelector("li.popup-login-tab-login"));
        sleepInSeconds(2);
        WebElement loginButton = driver.findElement(By.cssSelector("button.fhs-btn-login"));

        Assert.assertFalse(loginButton.isEnabled());

        //viết gộp
        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#000000");

        driver.findElement(By.cssSelector("input#login_username")).sendKeys("lanntn@gmail.com");
        driver.findElement(By.cssSelector("input#login_password")).sendKeys("123456");
        sleepInSeconds(2);
        Assert.assertTrue(loginButton.isEnabled());

        Assert.assertEquals(Color.fromString(loginButton.getCssValue("background-color")).asHex().toLowerCase(),"#C92127");;
    }
    private void sleepInSeconds(int i) {
    }
    @Test
    public void TC_03(){

    }
}
