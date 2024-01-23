package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_13_Alert {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
            //
        }
    @Test
    public void TC_01_Accept_Alert(){

        driver.get("https://automationfc.github.io/basic-form/index.html");
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
        sleepInSeconds(3);
        driver.switchTo().alert();

        driver.switchTo().frame(1);
        }

    private void sleepInSeconds(int i) {
    }


    @Test
    public void TC_02_Confirm_Alert(){

    }
    @Test
    public void TC_03_Prompt_Alert(){
        //Nhập text vào Alert

    }
    @Test
    public void TC_04_Authentication_Alert(){
        String username = "admin";
        String pasword = "admin";

        // thư viện Alert không sử dụng cho Authentication Alert được
        //Chrome DevTool Protocol

        //Cách 2: Từ page A thao tác lên 1 element nó sẽ qua page B(Cần phải thao tác vs Authen Alert trước)
        driver.get("https://the-internet.herokuapp.com/");
        String authenLinkUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");

        String[] authenArray = authenLinkUrl.split("//");
        System.out.println(authenArray[0]);
        System.out.println(authenArray[1]);

        driver.get(authenArray[0] + "//" + username + ":" + pasword + "@" + authenArray[1]);

        //driver.get(authenLinkUrl);
    }

    public void TC_06_Authentication_Selenium_4x(){

    }
}
