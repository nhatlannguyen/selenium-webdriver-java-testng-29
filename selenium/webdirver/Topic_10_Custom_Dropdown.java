package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Topic_10_Custom_Dropdown {
    WebDriver driver;
    //Wait tường minh: trạng thái cụ thể cho Element
    //Visible: hiển thị
    //Invisible: không hiển thị
    // Present: có trong HTML nhưng không hiển thị
    //Number: số lượng element là bao nhiêu
    //Clickble: element có được click hay không
    //...
    WebDriverWait explicitWait;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        // Wait ngầm định, không rõ ràng cho 1 trạng thái cụ thể nào của element
        //Wait cho việc tìm element - findElement(s)
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(30));//khởi tạo
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01(){
        driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
        //1. click vào 1 thẻ để cho nó xổ hết các item trong dropdown ra
        driver.findElement(By.cssSelector("span#number-button")).click();
        sleepInSeconds(5);
        //2.1: nó xổ ra list có tất cả các item
        //2.2: nó xổ ra lits chỉ chưa 1 phần và đang load thêm
        //Chờ cho nó xổ hết các item trong dropdown
        //Xuất hiện đầy đủ trong HTML
        explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("ul#number-menu div")));
        List<WebElement> allItem = driver.findElements(By.cssSelector("ul#number-menu div"));//allItem lưu trữ 19 item bên trong
        for (WebElement item:allItem){
            String textItem = item.getText();
            System.out.println("Text item = "+ textItem);
            //String không dùng == trong if, phải dùng hàm riêng của String
            //3.1: kiểm tra text của từng item thỏa mãn điều kiện thì click vào
            if (textItem.equals("8")){
                item.click();
                break;// thoát vòng lặp, không kiểm tra các giá trị còn lại (for/while/do-while/switch-case)
            }
        }
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
    public void sleepInSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getEmailAddress(){
        Random rand=new Random();
        return "chibeo" + rand.nextInt(99999) + "@gmail.net";
    }
}