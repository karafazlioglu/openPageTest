import com.sun.jdi.IntegerValue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;


import java.awt.*;
import java.time.Duration;

public class OpenPageTest {


    public WebDriver driver;
    protected static String url = "https://www.network.com.tr/";

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void correctOpen() {

        driver.get(url);
        //Assert.assertEquals(driver.getTitle(), "NetWork");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://www.network.com.tr/");

        driver.get(url);
        WebElement arKutu = driver.findElement(By.xpath("//input[@name='searchKey']"));
        arKutu.sendKeys("ceket");
        arKutu.submit();

        WebElement dahaFazla = driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']"));
        Actions action = new Actions(driver);

        action.click(dahaFazla);


        WebElement hover = driver.findElement(By.xpath("(//div[@data-order='3'])[1]"));
        action.moveToElement(hover).build().perform();

        WebElement sizeCl = driver.findElement(By.xpath("//label[@extcode='1083770004']"));
        sizeCl.click();
        action.click(sizeCl);

        WebElement basket = driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']"));
        action.click(basket);

        WebElement newPrice = driver.findElement(By.xpath("//span[@class='a-product__price -salePrice']"));
        String np = newPrice.getText();
        System.out.println(np);

        WebElement oldPrice = driver.findElement(By.xpath("//span[@class='a-product__price -oldPrice -labelPrice']"));
        String op = oldPrice.getText();
        System.out.println(op);

        //WebElement go = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));
        //action.click(go);

        //WebElement cont = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));

    }
    //@After
    //public void tearDown() {
    // driver.quit();
    //}
}
