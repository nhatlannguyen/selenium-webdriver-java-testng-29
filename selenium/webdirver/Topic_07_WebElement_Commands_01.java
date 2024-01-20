package webdirver;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Topic_07_WebElement_Commands_01 {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        }
    @Test
    public void TC_01_Element(){
        //Tìm, chưa tương tác lên
        driver.findElement(By.id(""));

        //tìm và tương tác lên
        driver.findElement(By.id("")).sendKeys("");

        //tìm và lưu nó vào 1 biến WebElement (chưa tuương tác
        WebElement fullNameTextbox = driver.findElement(By.id(""));
        fullNameTextbox.clear();
        fullNameTextbox.sendKeys("Automation FC");
        fullNameTextbox.getAttribute("value");

        //dùng để xóa dữ liệu trong 1 field cho phép nhập (editable)
        //textbox/textArea/dropdown (editable)
        //thường được sử dụng trước hàm sendkeys
        driver.findElement(By.id("")).clear();//*

        //dùng đề nhập liệu vào các field trên
        driver.findElement(By.id("")).sendKeys("");//**

        //dùng để click lên element
        driver.findElement(By.id("")).click();//**

        //tìm từ node cha vào node con
        driver.findElement(By.id("")).findElement(By.id(""));//không nên viết như này
        driver.findElement(By.cssSelector("form#form-validate input#firstname"));

        //Trả về nhiều element khớp với điều kiện
        List<WebElement> textboxes = driver.findElements(By.cssSelector("")); //khởi tạo truyền kiểu dữ liệu

        //Java non Generic
        ArrayList name = new ArrayList();
        name.add("Automation FC");
        name.add(15);
        name.add('B');
        name.add(true);

        //Java Generic
        ArrayList<String> address = new ArrayList<String>(); // yêu cầu kiểu String
        address.add("Automation FC");

        //dùng để verify 1 checkbox/radio/dropdown đã được chọn hay chưa
        Assert.assertTrue(driver.findElement(By.id("")).isSelected());//*
        Assert.assertFalse(driver.findElement(By.id("")).isSelected());

        //Dropdown (default/custom)
        Select select = new Select(driver.findElement(By.id("")));

        //dùng để verify 1 element có hiển thị hat không
        Assert.assertTrue(driver.findElement(By.id("")).isDisplayed());//**
        Assert.assertFalse(driver.findElement(By.id("")).isDisplayed());

        //dùng để verify 1 element có được thao tác lên hay không
        Assert.assertTrue(driver.findElement(By.id("")).isEnabled());//*
        Assert.assertFalse(driver.findElement(By.id("")).isEnabled());

        //HTML Element
        //<input type="text" id="firstname" name="firstname" value=""
        // title="First Name" maxlength="255" class="input-text required-entry">
        driver.findElement(By.id("")).getAttribute("title");//truyền vào tên của Attribute để lấy ra giá trị của attribute
        driver.findElement(By.id("")).getAttribute("type");//*
        driver.findElement(By.id("")).getAttribute("id");

        //tab Accesibility /Properties trong Element khi bật DevTool
        driver.findElement(By.id("")).getAccessibleName();
        driver.findElement(By.id("")).getDomAttribute("checked");
        driver.findElement(By.id("")).getDomProperty("baseURI");
        driver.findElement(By.id("")).getDomProperty("outerHTML");

        //tab Style trong Element
        //verify font, size, color, background...
        driver.findElement(By.id("")).getCssValue("background-color");//*
        //rgb (46, 138, 184)
        driver.findElement(By.id("")).getCssValue("font-size");

        //lấy vị trí của element so với độ phân giải màn hình
        Point nameTextboxLocation = driver.findElement(By.id("")).getLocation();
        nameTextboxLocation.getX();
        nameTextboxLocation.getY();

        //lấy ra chiều cao + rộng
        Dimension addressSize = driver.findElement(By.id("")).getSize();

        //Location + size, lấy ra vị trí kèm kích thước của element
        Rectangle nameTextboxRect = driver.findElement(By.id("")).getRect();

        Point namePoint = nameTextboxRect.getPoint();//lấy ra location ra kiểu point
        Dimension nameSize = nameTextboxRect.getDimension();//lấy ra size kiểu Dimension
        nameSize.getHeight();
        nameSize.getWidth();

        //Shadow Element (JavaScrip Excutor)
        driver.findElement(By.id("")).getShadowRoot();//*

        //từ id/class/name/css/xpath có thể truy ra ngược lại tagname html
        driver.findElement(By.cssSelector("firstname")).getTagName(); //input
        driver.findElement(By.id("firstname")).getTagName(); //input
        driver.findElement(By.className("form-instructions")).getTagName(); //p
        //element A -> đầu ra của nó là tagnem của element A
        String formListTag = driver.findElement(By.xpath("//*[@class='form-list']")).getTagName();//ul
        //đầu vào của Element B sẽ nhận tagname của element A là tham số
        driver.findElement(By.xpath("////div[@class='remember-me-popup']/preceding-sibling::" + formListTag));

        driver.findElement(By.cssSelector("address.copyright")).getText();//**
        //© 2015 Magento Demo Store. All Rights Reserved.

        //chup hình bị lỗi và lưu dưới dạng Byte/file - lưu hình có kích thước trong ổ cứng /base64 - hình dạng text
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.FILE);
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BASE64);//*
        driver.findElement(By.cssSelector("address.copyright")).getScreenshotAs(OutputType.BYTES);

        //Form (element nào là thẻ form hoặc nằm trong thẻ form thì sẽ được áp dụng)
        //hành vi giống phím enter trên bàn phím
        // register/ login/ search ...
        driver.findElement(By.id("")).submit();//**
    }
}
