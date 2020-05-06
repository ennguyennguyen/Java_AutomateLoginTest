import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLoginPortal {
    WebDriver driver;

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get("http://webdriveruniversity.com/");

        // click on Contact Us title
        driver.findElement(By.xpath("//a[@id = 'login-portal']//h1")).click();

        // verify the title of the newly opened page
        String loginPortalTitle = driver.getTitle();
        System.out.println(loginPortalTitle);
        //Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test
    void testLoginSuccessful(){
        driver.findElement(By.id("text")).sendKeys("abc");
        driver.findElement(By.id("password")).sendKeys("123");
        driver.findElement(By.id("login-button")).click();

        // need to check the correct username and password for this test

    }


    @AfterClass
    void teardown(){
        driver.close();
    }
}
