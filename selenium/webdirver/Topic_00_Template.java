package webdirver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Topic_00_Template {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
            //
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
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
