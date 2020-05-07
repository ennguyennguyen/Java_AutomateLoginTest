import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestButtonClick {
    WebDriver driver;

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get("http://webdriveruniversity.com/");

        // Click on Button Click section
        driver.findElement(By.xpath("//*[@id='button-clicks']//h1")).click();

        // verify the title of the newly opened page
        String buttonClickTitle = driver.getTitle();
        System.out.println(buttonClickTitle);
        //Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test
    // Test case 1: use WebElement Click
    void useWebElement(){

        // Create a Web Element and perform click()
        WebElement buttonclick1 = driver.findElement(By.xpath("//*[@id='button1']"));
        buttonclick1.click();

        // Verify a popup windows displayed with the "Close" button and there is a message say "Congratulation!"
        String message1 = driver.findElement(By.xpath("//*[@id='myModalClick']//h4")).getText();
        Assert.assertEquals("Congratulations!", message1);

        // Click on the close button
        driver.findElement(By.xpath("//*[@id='myModalClick']//button[@class='btn btn-default']")).click();
    }

    @Test
    // Test case 2: use JS Click
    void useJavaScript(){
        WebElement buttonclick2 = driver.findElement(By.xpath("//*[@id='button2']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("argument[0].click();", buttonclick2);

        // Verify a popup windows displayed with the "Close" button and there is a message say "Congratulation!"
        String message2 = driver.findElement(By.xpath("//*[@id='myModalJSClick']//h4")).getText();
        Assert.assertEquals("It’s that Easy!!  Well I think it is.....", message2);

        // Click on the close button
        driver.findElement(By.xpath("//*[@id='myModalJSClick']//button[@class='btn btn-default']")).click();
    }

    @Test
    // Test case 3: use Action Move & click
    void useActionMoveAndClick(){

        // [Nguyen] Don't know how to do it yet. leave it for now...

    }

    @AfterClass
    void teardown(){
        driver.close();
    }
}
