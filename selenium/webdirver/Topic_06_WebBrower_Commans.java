package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Topic_06_WebBrower_Commans {
    //các câu lệnh để thao tác với Brower sẽ đứng sau biến driver.
    //driver.
    WebDriver driver;

    //Các câu lệnh thao tác với element sẽ đứng sau biến element
    // element.
    WebElement element;
    @BeforeClass
    public void beforeClass() {
        //Muốn dùng được thì phải khởi tạo, không khởi tạo sẽ gặp lỗi
        //Lỗi NullPointerException
        //dùng trình duyệt nào thì new driver của trình duyệt đó lên
        driver = new FirefoxDriver();
        System.out.println(driver.toString()); //log ra dữ liệu của biến driver
        //FirefoxDriver: firefox on windows (0d252642-b1b5-421b-8126-a38cc617ab1f) - GUI: Số duy nhất không trùng lặp

        driver = new ChromeDriver();
        driver = new EdgeDriver();

        //selenium ver 3/2/1
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //selenium ver 4
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01(){
//nguyên tắc khi dùng hàm: tên hàm - hàm dùng làm gì, có tham số hay không, trả về cái gì
        //void: không trả về cái gì, chỉ là đang thao tác trên brower
        //set trực tiếp giá trị
        driver.get("https://www.facebook.com/");
        driver.get("http://live.techpanda.org/index.php");

        driver.quit();//đóng brower không quan tâm trình tuyệt đang có bao nhiêu tab
        driver.close(); // nếu trình duyệt đang có 1 tab thì tương tự hàm quit, nếu nhiều tab thì đóng tab đang thực hiện

        //2 hàm findElement sẽ bị ảnh hưởng timeout của implicitlyWait
        //nó sẽ đi tìm với loại By nào trả về element nếu như được tìm thấy
        //không tìm thấy trả về fail tại step này - throw exception:NullSuchElementException
        //Trả về 1 elemet, nếu tìm thấy nhiều cũng trả về 1 element
        driver.findElement(By.id("email"));

        //trả về danh sách element
        //nếu không tìm thấy cũng không bị fail mà sẽ trả về list rỗng
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        //tại sao lại cần phải lấy dữ liệu ra để làm gì? để kiểm tra xem đúng hay sai (verify dữ liệu)
        driver.getCurrentUrl();
        driver.getPageSource();
        driver.getTitle();
        driver.getWindowHandle();
        driver.getWindowHandles();//không cho lưu trùng lặp, id các cửa sổ là duy nhất, nếu có nhiều id trùng nhau sẽ chỉ lấy 1 giá trị

        //nếu chỉ dùng 1 lần thì không cần khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

    }
    @Test
    public void TC_02(){

    }
    @Test
    public void TC_03(){

    }
}
