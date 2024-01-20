package webdirver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Random;

public class Topic_09_Default_Dropdown {
    WebDriver driver;
    String firstName = "Chi", lastName = "Beo", emailAddress = getEmailAddress(),companyName = "CHIBEO COMPANY";
    String password = "123456";
    String day ="15",month ="May",year ="1950";
    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://demo.nopcommerce.com/");
    }
    @Test
    public void TC_01_Register() {

        driver.findElement(By.cssSelector("a.ico-register")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);

        //chọn ngày
        Select dayDropdown = new Select(driver.findElement(By.name("DateOfBirthDay")));
        dayDropdown.selectByVisibleText(day);
        //veryfi dropdown là singer (không không multiple)

        Assert.assertFalse(dayDropdown.isMultiple());
        //verify số lượng item trong dropdown là 32
        Assert.assertEquals(dayDropdown.getOptions().size(),32);

        new Select(driver.findElement(By.name("DateOfBirthMonth"))).selectByVisibleText(month);
        new Select(driver.findElement(By.name("DateOfBirthYear"))).selectByVisibleText(year);

        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Company")).sendKeys(companyName);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

        driver.findElement(By.cssSelector("button#register-button")).click();
        sleepInSeconds(3);

        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
    }

    @Test
    public void TC_02_Login() {
        driver.get("https://demo.nopcommerce.com/");
        driver.findElement(By.cssSelector("a.ico-login")).click();
        sleepInSeconds(2);
        driver.findElement(By.id("Email")).sendKeys(emailAddress);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.cssSelector("button.login-button")).click();
        sleepInSeconds(2);

        //Verify
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"),firstName);
        Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"),lastName);

        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthDay"))).getFirstSelectedOption().getText(),day);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthMonth"))).getFirstSelectedOption().getText(),month);
        Assert.assertEquals(new Select(driver.findElement(By.name("DateOfBirthYear"))).getFirstSelectedOption().getText(),year);

        Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailAddress);
        Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"),companyName);
    }

    @AfterClass
    public void afterClass() {
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