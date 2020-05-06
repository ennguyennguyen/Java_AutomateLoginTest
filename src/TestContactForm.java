import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestContactForm {

    WebDriver driver;
    @BeforeClass
    void setup() {

        // Initiate a chrome driver
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();

        // Access the webpage
        driver.get("http://webdriveruniversity.com/");

        // click on Contact Us title
        driver.findElement(By.xpath("//a[@id = 'contact-us']//h1")).click();

        // verify the title of the newly opened page
        String contactUsTitle = driver.getTitle();
        System.out.println(contactUsTitle);
        //Assert.assertEquals("WebDriver | Contact Us", contactUsTitle);
    }

    @Test
    void testContactSubmitButtonCase1(){
        // TestCase 1: Fill in all valid information and hit Submit

        //[Nguyen] ideally I want to take all of these fields for reusable. How to do it?
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).sendKeys("Donald");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).sendKeys("Trump");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).sendKeys("dtrump@whitehouse.gov");
        driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).sendKeys("stay calm and be president");

        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='SUBMIT']")).click();

        String submitSuccessMessage = driver.findElement(By.xpath("//div[@id='contact_reply']//h1")).getText();
        Assert.assertEquals("Thank You for your Message!", submitSuccessMessage);
    }

    @Test
    void testContactSubmitButtonCase2(){
        // TestCase 2: Leave all field blank and hit Submit

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Click on Submit button with all fields empty
        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='SUBMIT']")).click();
        String submitUnsuccessful = driver.getTitle();
        System.out.println(submitUnsuccessful);

        // Verify if a blank page with title "Contact from handler" displayed
        Assert.assertEquals("Contact form handler", submitUnsuccessful);
    }

    @Test
    void testContactResetButton(){
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        // Fill in some information
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).sendKeys("Donald");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).sendKeys("Trump");
        driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).sendKeys("dtrump@whitehouse.gov");
        driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).sendKeys("stay calm and be president");

        // Click on Reset button
        driver.findElement(By.xpath("//*[@id='form_buttons']//input[@value='RESET']")).click();

        // Check if all the text in these fields are empty
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='first_name']")).getText().equalsIgnoreCase(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='last_name']")).getText().equalsIgnoreCase(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//input[@name='email']")).getText().equalsIgnoreCase(""));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='contact_form']//textarea[@name='message']")).getText().equalsIgnoreCase(""));
    }

    @AfterClass
    void teardown(){
        driver.close();
    }
}
