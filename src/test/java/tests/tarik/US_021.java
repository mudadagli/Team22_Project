package tests.tarik;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TarikPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;

public class US_021 extends TestBaseReport {
    TarikPage tarikObje = new TarikPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void testEntry21() {
        /*
        1.  Belirtilen URL'e gidilir
        2.  Ana sayfanın görünür olduğu doğrulanır
        3.  Sign In butonuna tıklanır
        4.  E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır
        5.  Açılan pencerede ilgili kısımlara geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır
        6.  Başarıyla giriş yapıldığı doğrulanır
        7.  Sağ üst taraftaki Sing Out seçeneğine tıklanır
        8.  Açılan sayfada Store Manager seçeneğine tıklanır
        9.  Store Manager penceresindeyken Reports sekmesine tıklanır
        */

        extentTest = extentReports.createTest("Satış Raporlarının İncelebilmesi Testi", "Yıllık rapor incelendi");

        //1
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("İlgili web sitesine gidildi");

        //2
        String expectedUrl = "https://allovercommerce.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        extentTest.info("Ana sayfanın görüntülendiği doğrulandı");

        //3
        tarikObje.ilkSayfaSignInLink.click();
        extentTest.info("Sign In butonuna tıklandı");

        //4
        wait.until(ExpectedConditions.visibilityOf(tarikObje.signInMailBox));
        wait.until(ExpectedConditions.visibilityOf(tarikObje.signInPasswordBox));
        Assert.assertTrue(tarikObje.signInMailBox.isDisplayed());
        Assert.assertTrue(tarikObje.signInPasswordBox.isDisplayed());
        extentTest.info("E-mail ve password textboxlarının açıldığı doğrulandı");

        //5
        tarikObje.signInMailBox.sendKeys(ConfigReader.getProperty("validEmailTarik"));
        tarikObje.signInPasswordBox.sendKeys(ConfigReader.getProperty("validPasswordTarik"));
        tarikObje.signInOnayButton.click();
        extentTest.info("E-mail ve password textboxlarına geçerli değerler girildi");

        //6
        Assert.assertTrue(tarikObje.signOutLink.isDisplayed());
        extentTest.info("Giriş yapıldığı doğrulandı");

        //7
        tarikObje.signOutLink.click();

        //8
        tarikObje.storeManagerLink.click();
        extentTest.info("Store Manager bölümüne gidildi");

        //9
        jse.executeScript("arguments[0].scrollIntoView(true);", tarikObje.reportsLink);
        jse.executeScript("arguments[0].click();", tarikObje.reportsLink);
        extentTest.info("Reports sekmesine tıklandı");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 1)
    public void yearRaporTesti() {
        // 10. Year sekmesine tıklanır ve ilgili raporun göründüğü doğrulanır
        tarikObje.yearLink.click();
        Assert.assertTrue(tarikObje.rapor.isDisplayed());
        extentTest.info("Yıllık rapor incelendi");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 2)
    public void lastMonthRaporTesti() {
        // 11. Last Month sekmesine tıklanır ve ilgili raporun göründüğü doğrulanır
        tarikObje.lastMonthLink.click();
        Assert.assertTrue(tarikObje.rapor.isDisplayed());
        extentTest.info("Bir önceki ayın raporu incelendi");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 3)
    public void thisMonthRaporTesti() {
        // 12. This Month sekmesine tıklanır ve ilgili raporun göründüğü doğrulanır
        tarikObje.thisMonthLink.click();
        Assert.assertTrue(tarikObje.rapor.isDisplayed());
        extentTest.info("İçinde bulunulan ayın raporu incelendi");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 4)
    public void last7DaysRaporTesti() {
        // 13. Last 7 Days sekmesine tıklanır ve ilgili raporun göründüğü doğrulanır
        tarikObje.last7DaysLink.click();
        Assert.assertTrue(tarikObje.rapor.isDisplayed());
        extentTest.info("Son 7 günün raporu incelendi");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 5)
    public void ozelTarihSecilebilirlikTesti() {
        // 14. Custom kutucuğundan özel bir tarih aralığı seçilebildiği doğrulanır
        tarikObje.customBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        tarikObje.gunler.get(15).click();
        tarikObje.gunler.get(25).click();
        tarikObje.customBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(tarikObje.seciliGunlerText.isDisplayed());
        extentTest.info("Özel bir tarih aralığı seçildi");
    }

    @Test(dependsOnMethods = "testEntry21", priority = 6)
    public void ozelTarihRaporTesti() {
        // 15. Seçilen tarih aralığının raporunun görüntülendiği doğrulanır
        tarikObje.customBox.click();
        wait.until(ExpectedConditions.visibilityOf(tarikObje.takvim));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        tarikObje.gunler.get(15).click();
        tarikObje.gunler.get(25).click();
        tarikObje.customBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Assert.assertTrue(tarikObje.rapor.isDisplayed());
        extentTest.info("Seçilen tarih aralığının raporu görüntülendi");
    }
}