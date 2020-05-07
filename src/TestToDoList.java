import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestToDoList {
    WebDriver driver;

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get("http://webdriveruniversity.com/");

        // Click on To Do List section
        driver.findElement(By.xpath("//*[@id='to-do-list']"));

        // verify the title of the newly opened page
        String todoListTitle = driver.getTitle();
        System.out.println(todoListTitle);
        //Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test
    // Test case 1: Click on + icon to add more note
    void testAddNewNote(){
        driver.findElement(By.id("plus-icon")).click();
        // [Nguyen] How to verify the style="display: none;" is not there?
        //      --> use getAttribute() with style

        // use findElements().get(...).getText().... to check to do item is added

    }

    // Test case 2: click on note to check strikethrough

    // Test case 3: click on note again to remove strikethrough


    // Test case 3: click on the Trash icon to remove note


    @AfterClass
    void teardown(){
        driver.close();
    }
}
