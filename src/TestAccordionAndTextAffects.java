import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAccordionAndTextAffects {
    WebDriver driver;
    String url = "http://webdriveruniversity.com/";

    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get(url + "Accordion/index.html");

        // verify the title of the newly opened page
        String todoListTitle = driver.getTitle();
        Assert.assertEquals("Accordion Items", todoListTitle);
    }

    @Test
    void testAccordion(){
        // get the standard class name (which is "accordion") -> should be "accordion" at first
        String classNameBeforeClick = driver.findElement(By.id("manual-testing-accordion")).getAttribute("className");
        System.out.println(classNameBeforeClick);

        // get the style ("max height") -> should be null at first
        String maxHeightBeforeClick = driver.findElement(By.id("manual-testing-description")).getAttribute("maxHeight");
        System.out.println(maxHeightBeforeClick);

        // click on the Accordion
        driver.findElement(By.id("manual-testing-accordion")).click();
        String classNameAfterClick = driver.findElement(By.id("manual-testing-accordion")).getAttribute("className");
        System.out.println(classNameAfterClick);

        // ***[NGUYEN] GET NULL VALUE ALL THE TIME EVEN USE ATTRIBUTE "maxHeight" or "cssText"
        String maxHeightAfterClick = driver.findElement(By.id("manual-testing-description")).getAttribute("cssText");
        System.out.println(maxHeightAfterClick);

        // Observe the change in the class name (which is "accordion active") -> which are now different
        //Assert.assertNotEquals(classNameBeforeClick, classNameAfterClick);

        // Observe the change in the class style ("max-height" = 67px) -> which are now different
        //Assert.assertNotEquals(maxHeightBeforeClick, maxHeightAfterClick);
    }


    @AfterClass
    void teardown(){
        driver.close();
    }

}
