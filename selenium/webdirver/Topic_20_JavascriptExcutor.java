package webdirver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_20_JavascriptExcutor {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
}
