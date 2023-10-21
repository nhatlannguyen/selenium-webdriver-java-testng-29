package webdirver;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
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
        //Dùng để lấy ra Url của màn hình/page hiện tại đang đứng
        driver.getCurrentUrl();

        //nếu chỉ dùng 1 lần thì không cần khai báo biến
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/");

        //Lấy ra page source HTML/CSS/JS của page hiện tại
        //Verify 1 cách tương đối
        driver.getPageSource();
        Assert.assertTrue(driver.getCurrentUrl().contains("Tạo Trang dành cho người nổi tiếng, thương hiệu hoặc doanh nghiệp."));


        //Lấy ra title của page hiện tại
        driver.getTitle();

        //Lấy ra id của cửa sổ/Tab hiện tại
        //Handle Window/Tab
        driver.getWindowHandle();
        driver.getWindowHandles();//không cho lưu trùng lặp, id các cửa sổ là duy nhất, nếu có nhiều id trùng nhau sẽ chỉ lấy 1 giá trị

        //Cookie - Framework
        driver.manage().getCookies();

        //get ra những log ở DevTool - Framework
        driver.manage().logs().get(LogType.DRIVER);

        //Apply cho việc tìm element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        //chờ cho page được load xong
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        //set trước khi dùng với thư viện JavascripExcutor
        //Inject 1 đoạn code JS vào trong Brower/Element
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

        //chạy full màn hình
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        //Test GUI
        //Test Responsive (Resolution)
        driver.manage().window().setSize(new Dimension(1366,768));
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().window().setSize(new Dimension(2560,1440));
        driver.manage().window().getSize();

        //set cho brower ở vị trí nào so với độ phân giải màn hình (run trên màn hình có kích thước bao nhiêu)
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().getPosition();



    }
    @Test
    public void TC_02(){

    }
    @Test
    public void TC_03(){

    }
}
