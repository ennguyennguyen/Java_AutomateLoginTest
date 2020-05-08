import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestButtonClick {
    WebDriver driver;
    String url = "http://webdriveruniversity.com/";

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get(url + "Click-Buttons/index.html");

        // verify the title of the newly opened page
        String buttonClickTitle = driver.getTitle();
        Assert.assertEquals("WebDriver | Button Clicks", buttonClickTitle);
    }

    @Test (priority = 1)
    // Test case 1: use WebElement Click
    void useWebElement(){

        // Create a Web Element and perform click()
        WebElement buttonclick1 = driver.findElement(By.xpath("//*[@id='button1']"));
        buttonclick1.click();

        // Wait for a while
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Verify a popup windows displayed with the "Close" button and there is a message say "Congratulation!"
        String message1 = driver.findElement(By.xpath("//*[@id='myModalClick']//h4")).getAttribute("innerText");
        System.out.println(message1);

        Assert.assertEquals(message1, "Congratulations!");

        // Click on the close button
        driver.findElement(By.xpath("//*[@id='myModalClick']//button[@class='btn btn-default']")).click();
    }

    @Test (priority = 2)
    // Test case 2: use JS Click
    void useJavaScript(){
        WebElement buttonclick2 = driver.findElement(By.xpath("//*[@id='button2']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", buttonclick2);

        // Wait for a while
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Verify a popup windows displayed with the "Close" button and there is a message say "Congratulation!"
        String message2 = driver.findElement(By.xpath("//*[@id='myModalJSClick']//h4")).getAttribute("innerText");
        Assert.assertEquals(message2, "It’s that Easy!!  Well I think it is.....");

        // Click on the close button
        driver.findElement(By.xpath("//*[@id='myModalJSClick']//button[@class='btn btn-default']")).click();
    }

    @AfterClass
    void teardown(){
        driver.close();
    }
}
