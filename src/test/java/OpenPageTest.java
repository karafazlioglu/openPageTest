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

        WebElement arKutu = driver.findElement(By.xpath("//input[@name='searchKey']"));     // arama kurusu web elementi driverda bulunur
        arKutu.sendKeys("ceket");       // elementin içine ceket yazılır
        arKutu.submit();        // enter a tıklanır

        WebElement dahaFazla = driver.findElement(By.xpath("//button[@class='button -secondary -sm relative']"));           // daha fazla göster butonunun sayfadaki html kodundan xpath i alınır
        Actions action = new Actions(driver);           // daha fazla kutusuna tıklanır
        action.click(dahaFazla);


        WebElement hover = driver.findElement(By.xpath("(//div[@data-order='3'])[1]"));     // ilk indirlimli cekete hover edilir
        action.moveToElement(hover).build().perform();

        WebElement sizeCl = driver.findElement(By.xpath("//label[@extcode='1083770004']"));     // beden seçimi yapılır
        action.click(sizeCl);

        WebElement basket = driver.findElement(By.xpath("//button[@class='header__basketTrigger js-basket-trigger -desktop']"));        // sepetim'e gidilir
        action.click(basket);

        WebElement newPrice = driver.findElement(By.xpath("//span[@class='a-product__price -salePrice']"));     // indirimli fiyat np stringine depolanır
        String np = newPrice.getText();
        System.out.println(np);

        WebElement oldPrice = driver.findElement(By.xpath("//span[@class='a-product__price -oldPrice -labelPrice']"));      // ham fiyat op stringine depolanır
        String op = oldPrice.getText();
        System.out.println(op);

        // TODO: 16.03.2023 indirimli fiyatın eski fiyattan düşük olduğunun kontrolü





        WebElement go = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));   // devam et butonuna tıklanır
        action.click(go);

        //WebElement cont = driver.findElement(By.xpath("//a[@class='button -primary header__basket--checkout header__basketModal -checkout']"));

    }
    //@After
    //public void tearDown() {
    // driver.quit();
    //}
}
