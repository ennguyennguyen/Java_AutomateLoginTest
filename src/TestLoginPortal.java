import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPortal {
    WebDriver driver;
    String url = "http://webdriveruniversity.com/";

    @BeforeClass
    void setup() {
        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get(url + "Login-Portal/index.html");

        // verify the title of the newly opened page
        String loginPortalTitle = driver.getTitle();
        Assert.assertEquals("WebDriver | Login Portal", loginPortalTitle);
    }

    @Test
    void testLoginUnsuccessfulCase1(){
        // Test case 1: Because we dont have the valid account so i just test the invalid case

        driver.findElement(By.id("text")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login-button")).click();

        // Get the text of the alert and verify if it's correct or not
        String message = driver.switchTo().alert().getText();
        Assert.assertTrue(message.equals("validation failed"));

        // Click on OK button of the alert
        driver.switchTo().alert().accept();
    }

    @Test
    void testLoginUnsuccessfulCase2(){
        // Test case 2: Leave all fields emtpy and click on login button

        // Because as designed, when i click OK on the alert, all fields are automatically cleared so i dont need to clear them
        driver.findElement(By.id("login-button")).click();

        // Get the text of the alert and verify if it's correct or not
        String message = driver.switchTo().alert().getText();
        Assert.assertTrue(message.equals("validation failed"));

        // Click on OK button of the alert
        driver.switchTo().alert().accept();
    }

    @AfterClass
    void teardown(){
        driver.close();
    }
}
