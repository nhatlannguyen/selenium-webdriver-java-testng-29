package javaTester;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class Topic_01_Data_Type {
    //Khai báo biến lưu trữ loại dữ liệu nào đó
    //Access Modifier : Phạm vi truy cập (public/Private/Protected/default)
    //Kiểu dữ liệu
    //Tên biến
    //giá tị của biến - gán vào với phép =
    //Nếu như không gán: Dữ liệu mặc định

    //Khai báo biến kiểu số nguyên
    byte bNumber = 40;
    short sNumber = 3000;
    int iNumber = 15635658;
    long lNumber = 234343400;

    //Khai báo biến kiểu số thực (có phần thập phân)
    float fNumber = 9.99f;
    double dNumber = 35.800789d;

    //Khai báo biến kiểu ký tự: Đại diện cho 1 ký tự duy nhất
    char c = 'M'; //giá trị nằm trong dấu '', có thể là 1 ký tự trên bàn phím
    char d = 'i';

    //Logic: boolean(mang tính luận lý)
    boolean status = true;
    //Khai báo kiểu dữ liệu tham chiếu

    //Class
    FirefoxDriver firefoxDrive = new FirefoxDriver();
    Select select = new Select(firefoxDrive.findElement(By.className("")));
    Topic_01_Data_Type topic01 = new Topic_01_Data_Type();

    //Interface
    WebDriver driver;
    JavascriptExecutor jsExecutor;
    //Object
    Object FullName = "Nguyễn Văn B";
    //Array (kiểu nguyên thủy/tham chiếu
    //trong quá trình chạy không thể tăng giảm Array được mà phải khai báo từ đầu
    int[] studentAge = {15,20,8};
    String[] studentName = {"Automation","Testing"};

    //Colection: List/Set/Queue
    List<String> StudentAddress = new ArrayList<String>();

    List<String> StudentCity = new LinkedList<>();

    List<String> StudentPhone = new Vector<>();

    //String
    String name = "Minh";
}