import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
public class welcomtest {
	WebDriver driver;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        String page = new File("webpage/welcome.html")
                .getAbsoluteFile()
                .toURI()
                .toString();

        driver.get(page);
    }

    @Test
    public void welcomeTest() {

        System.out.println("================================");
        System.out.println("Welcome Test Case Started");
        System.out.println("================================");

        String message = driver.findElement(By.id("welcome"))
                .getText();

        System.out.println("Welcome Message: " + message);

        Assert.assertEquals(
                message.trim(),
                "Welcome to Selenium Automation!");

        System.out.println("TEST CASE PASSED");
    }

    @Test
    public void testCaseName() {

        String testcase = driver.findElement(By.id("testcase"))
                .getText();

        System.out.println("Test Case: " + testcase);

        Assert.assertEquals(testcase, "Test Case: TC001");

        System.out.println("TEST CASE PASSED");
    }

    @Test
    public void statusTest() {

        String status = driver.findElement(By.id("status"))
                .getText();

        System.out.println("Status: " + status);

        Assert.assertEquals(status, "Status: Passed");

        System.out.println("TEST CASE PASSED");
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}

