import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestToDoList {
    WebDriver driver;
    String url = "http://webdriveruniversity.com/";

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get(url + "To-Do-List/index.html");

        // verify the title of the newly opened page
        String todoListTitle = driver.getTitle();
        Assert.assertEquals("WebDriver | To Do List", todoListTitle);
    }

    @Test
    // Test case 1: Click on + icon to add more note
    void testAddNewNote(){

        // Click on "+" icon
        driver.findElement(By.id("plus-icon")).click();
        // [Nguyen] How to verify the style="display: none;" is not there?
        //      --> use getAttribute() with style
        WebElement plusButton = driver.findElement(By.xpath("//*[@id = 'container']//input"));
        String displayStyle = plusButton.getCssValue("display");
        System.out.println(displayStyle);

        // Next step:
        // 1. write script to remove all existing item from the list
        // 2. check when an item is added, the list has element



    }

    // Test case 2: click on note to check strikethrough

    // Test case 3: click on note again to remove strikethrough


    // Test case 3: click on the Trash icon to remove note


    @AfterClass
    void teardown(){
        driver.close();
    }
}
