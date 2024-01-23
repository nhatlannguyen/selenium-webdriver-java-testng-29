package webdirver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_14_Action {
    WebDriver driver;
    Actions actions;
    String fullName;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        actions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    @Test
    public void TC_01(){


    }
    @Test
    public void TC_02(){

    }
    @Test
    public void TC_03(){

    }
}
