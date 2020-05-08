import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestContactForm {

    WebDriver driver;
    String url = "http://webdriveruniversity.com/";

    @BeforeClass
    void setup() {
        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get(url + "Contact-Us/contactus.html");

        // Use Implicit wait to wait for the website to load successfully
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Check the title is displayed correctly
        String contactUsTitle = driver.getTitle();
        Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test(priority = 1)
    void testContactSubmitButtonCase1() {
        // TestCase 1: Fill in all valid information and hit Submit

        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).sendKeys("Donald");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).sendKeys("Trump");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).sendKeys("dtrump@whitehouse.gov");
        driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).sendKeys("stay calm and be president");

        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='SUBMIT']")).click();

        String submitSuccessMessage = driver.findElement(By.xpath("//div[@id='contact_reply']//h1")).getText();
        Assert.assertEquals("Thank You for your Message!", submitSuccessMessage);

        // go back to the previous page
        driver.navigate().back();
    }

    @Test(priority = 2)
    void testContactSubmitButtonCase2() {
        // TestCase 2: Leave all field blank and hit Submit

        // Clear all previous information
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).clear();
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).clear();
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).clear();
        driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).clear();

        // Click Submit button with all fields empty
        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='SUBMIT']")).click();
        String submitUnsuccessful = driver.getTitle();

        // Verify if a blank page with title "Contact from handler" displayed
        Assert.assertEquals("Contact form handler", submitUnsuccessful);

        // go back to the previous page
        driver.navigate().back();
    }

    @Test(priority = 3)
    void testContactResetButton() {

        // Fill in some information
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).sendKeys("Donald");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).sendKeys("Trump");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).sendKeys("dtrump@whitehouse.gov");
        driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).sendKeys("stay calm and be president");

        // Click on Reset button
        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='RESET']")).click();

        // Check if all the text in these fields are empty
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).getText().equals(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).getText().equals(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).getText().equals(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).getText().equals(""));
    }

    @AfterClass
    void teardown() {
        driver.close();
    }
}
