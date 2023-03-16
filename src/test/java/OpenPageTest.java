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

public class OpenPageTest {         // openpagetest adında bir sınıf açılır


    public WebDriver driver;        // driver adında bir webdriver tanımlanır
    protected static String url = "https://www.network.com.tr/";        // string url ine gidilecek web sitesinin adresi depolanır

    @Before
    public void setUp()         // setup sınıfı başlatılır
    {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");         // chrome driverın lokasyonu belirtilerek set edilir
        driver = new ChromeDriver();            // driver webdriverı chrome drivera atanır
        driver.manage().window().maximize();        // chrome ekranı maksimize edilir

    }

    @Test
    public void openPageTest() {             // sayfa açılımını test eden sınıf başlatılır

        driver.get(url);            // sayfaya get metoduyla gidilir
        //Assert.assertEquals(driver.getTitle(), "NetWork");            // sayfa başlığının network olduğu test edilir
        //Assert.assertEquals(driver.getCurrentUrl(), "https://www.network.com.tr/");       // sayfa url inin başta url stringine atadığımız url olduğu test edilir

        WebElement arKutu = driver.findElement(By.xpath("//input[@name='searchKey']"));
        arKutu.sendKeys("ceket");
        arKutu.submit();

        WebElement dahaFazla = driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']"));
        Actions action = new Actions(driver);

        action.click(dahaFazla);


        WebElement hover = driver.findElement(By.xpath("(//div[@data-order='3'])[1]"));
        action.moveToElement(hover).build().perform();

        WebElement sizeCl = driver.findElement(By.xpath("//label[@extcode='1083770004']"));
        action.click(sizeCl);

        WebElement basket = driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']"));
        action.click(basket);

        WebElement newPrice = driver.findElement(By.xpath("//span[@class='a-product__price -salePrice']"));
        String np = newPrice.getText();
        System.out.println(np);

        WebElement oldPrice = driver.findElement(By.xpath("//span[@class='a-product__price -oldPrice -labelPrice']"));
        String op = oldPrice.getText();
        System.out.println(op);

        WebElement go = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));
        action.click(go);

        //WebElement cont = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));

    }
    //@After
    //public void tearDown() {
    // driver.quit();
    //}
}
