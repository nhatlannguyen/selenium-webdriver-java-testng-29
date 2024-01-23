package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_12_Checkbox_Radio {
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
    public void TC_01_Default_() {
        driver.get("https://www.facebook.com/");
        //Click vào checkbox
        driver.findElement(By.xpath(""));
    }

    @Test
    public void TC_02_Logo() {
        Assert.assertTrue(driver.findElement(By.cssSelector("img.fb_logo")).isDisplayed());
    }

    @Test
    public void TC_03_Form() {
        Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
    }

    @Test
    public void TC_04(){
        //add comment
    }

    @Test
    public void TC_05_Custom_Google_Docs(){
        driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
        By canthoRadio = By.xpath("//div[@aria-label='Cần Thơ']");
        //verify radio is not selected
        Assert.assertEquals(driver.findElement(canthoRadio).getAttribute("aria-checked"),"false");

        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Cần Thơ' and @aria-checked='false']")).isDisplayed());
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}