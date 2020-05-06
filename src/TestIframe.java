import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIframe {
    WebDriver driver;

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get("http://webdriveruniversity.com/");

        // Click on.......


        // verify the title of the newly opened page
        String loginPortalTitle = driver.getTitle();
        System.out.println(loginPortalTitle);
        //Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test
    // Write Your test here


    @AfterClass
    void teardown(){
        driver.close();
    }
}
