package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Localtor {

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
        driver.get("https://demo.nopcommerce.com/register");
        //
    }
    //TestNG: order testcase theo Alphabet (0-9, a-z)
    //Firstname textbox - HTML Code
    //HTML Element gồm: <tagname attribute_name_1 = 'attribute_value_1' attribute_name_2 = 'attribute_value_2'...>
    /*
    <input type = "text" data-val-required = "First name is required." id = "FirstNam" name ="FirstName">
     */
    @Test
    public void TC_01_ID(){
        //Biến driver, FindElement: dùng đề tìm 1 element
        //driver.findElement(By.)

        //Tìm element có id là FirstName
        driver.findElement((By.id("FirstName"))).sendKeys("FirstName");//Tìm thấy và nhập giá trị là FirstName và textbox

    }
    @Test
    public void TC_02_Class(){
        //lấy class là duy nhất
        driver.findElement(By.className("header-logo"));

    }
    @Test
    public void TC_03_Name(){
        driver.findElement(By.name("DateOfBirthDay"));
    }
    @Test
    public void TC_04_Tagname(){
        //Tìm thẻ giống nhau, trả về số nhiều
        driver.findElement(By.tagName("input"));
    }
    @Test
    public void TC_05_LinkText(){
        //Chỉ dùng với link, tìm toàn bộ link, độ chính xác cao
        driver.findElement(By.linkText("Shipping & returns"));
    }
    @Test
    public void TC_06_Partial_LinkText(){
        //Chỉ dùng với link, khác với link text là chỉ lấy 1 phần link thì Partial linktext cũng tìm được, nhưng độ chính xác không cao
        driver.findElement(By.partialLinkText("for vendor"));
        driver.findElement(By.partialLinkText("vendor account"));
        driver.findElement(By.partialLinkText("Apply for vendor"));
    }
    @Test
    public void TC_07_Css(){
        //dùng Css Với Id
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //dùng Css với Class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        // Css với Name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css với Tagname
        driver.findElement(By.cssSelector("input"));

        //css với link
        driver.findElement(By.cssSelector("a[href='/customer/addresses']"));
        //css với partial linktext
        driver.findElement(By.cssSelector("a[href*='address']"));
    }
    @Test
    public void TC_08_XPath(){
        //dùng Xpath Với Id
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //dùng Xpath với Class
        driver.findElement(By.xpath("//div[@class= 'page-title']"));

        // Xpath với Name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //Xpath với Tagname
        driver.findElement(By.xpath("//input"));

        //Xpath với link
        driver.findElement(By.xpath("//a[@href='/customer/addresses']"));
        driver.findElement(By.xpath("//a[text()='Addresses']"));
        //Xpath với partial linktext
        driver.findElement(By.xpath("//a[contains(@href,'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(),'Addresses')]"));
    }

    @AfterClass
    public void afterClas(){
      driver.quit();
    }
}

