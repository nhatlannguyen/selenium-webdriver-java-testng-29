package javaTester;

import org.bouncycastle.pqc.crypto.newhope.NHOtherInfoGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Topic_04_Scope {
    //Biến được khai báo ở bên ngoài hàm -> phạm vi là Class
    // Biến Global (biến toàn cục)
    // có thể dùng cho tất cả các hàm trong class

    String homePageUrl; //Khai bảo: Declare

    String fullName = "Automation FC"; //Khai báo + khởi tạo (Initial)
    WebDriver driver;
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
    }
    @Test
    public void TC_01_(){
        //Các biến được khai báo ở trong 1 hàm/block code -> Phạm vị cục bộ (Local)
        //dùng trong hàm nó đc sinh ra/block code đc sinh ra

        String homePageUrl = "https://www.facebook.com/";

        //trong 1 hàm nếu như có 2 biến cùng tên (Global/Local) thì sẽ ưu tiên lấy biến Local dùng
        //1 biến Local nếu như gọi tới dùng mà chưa được khởi tạo thì sẽ bị lỗi

        //Biến Local chưa khởi tạo mà gọi ra dùng thì báo lỗi ngay (compile code)
        driver.get(homePageUrl);// hoặc this.driver.get(homePageUrl);

        //Nếu trong 1 hàm có 2 biến cùng tên (Global/Local) mà mình muốn lấy biến Global ra để dùng
        //Dùng từ khóa this
        //Biến Global chưa khởi tạo mà gọi ra dùng thì không báo lỗi ngay ở level Compile
        //mà sẽ báo lỗi ở level RunTime (khi chạy)
        driver.get(this.homePageUrl);//giống với this.driver.get(this.homePageUrl);
    }

    @Test
    public void TC_02_(){

    }

    @Test
    public void TC_03_(){

    }

    @Test
    public void TC_04_(){

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
