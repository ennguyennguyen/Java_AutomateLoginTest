import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

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

        // Remove all existing item from the list
        List<WebElement> itemList = driver.findElements(By.xpath("//*[@id = 'container']//ul"));
        while (!itemList.isEmpty()){
            itemList.clear();
        }
        System.out.println("List has no items");

        // Check when an item is added, the list has element
        driver.findElement(By.xpath("//*[@id = 'container']//input")).sendKeys("eat burger");
        System.out.println("Item added successfully");
        driver.findElement(By.xpath("//*[@id = 'container']//input")).sendKeys("pick up kids");
        System.out.println("Item added successfully");
        driver.findElement(By.xpath("//*[@id = 'container']//input")).sendKeys("clean up house");
        System.out.println("Item added successfully");

        // Verify the item is added correctly
        // ***[NGUYEN] after added, the itemList is still empty
        for (WebElement w : itemList){
            System.out.println(w.getText());
        }

        // Verify if the list is not empty because it has new items added
        Assert.assertTrue(!itemList.isEmpty());
        System.out.println("List has items");

    }

    // Test case 2: click on note to check strikethrough

    // Test case 3: click on note again to remove strikethrough


    // Test case 3: click on the Trash icon to remove note


    @AfterClass
    void teardown(){
        driver.close();
    }
}
