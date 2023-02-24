import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenPageTest {


    public WebDriver driver;
    protected static String url = "https://www.google.com/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void correctOpen() {
        driver.get(url);
        Assert.assertEquals(driver.getTitle(), "Google");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}