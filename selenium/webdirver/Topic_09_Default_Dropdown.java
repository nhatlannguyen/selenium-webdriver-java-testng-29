package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_09_Default_Dropdown {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Register() {

    }

    @Test
    public void TC_02_Login() {


    }

    @Test
    public void TC_03_Form() {
        Assert.assertTrue(driver.findElement(By.xpath("//form[@data-testid='royal_login_form']")).isDisplayed());
    }

    @Test
    public void TC_04(){
        //add comment
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}