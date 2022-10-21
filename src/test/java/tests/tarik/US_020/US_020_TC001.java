package tests.tarik.US_020;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TarikPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;

public class US_020_TC001 extends TestBaseReport {

      /*
      1. Belirtilen URL'e gidilir
      2. Ana sayfanın göründüğü doğrulanır
      3. Sing In butonuna tıklanır
      4. E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır
      5. Açılan pencerede ilgili kısımlara geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır
      6. Başarıyla giriş yapıldığı doğrulanır
      7. Sağ üst taraftaki Sing Out seçeneğine tıklanır
      8. Açılan sayfada Store Manager seçeneğine tıklanır
      9. Store Manager penceresindeyken Reviews sekmesine tıklanır
      11. Açılan ekranda Product Reviews butonuna tıklanır
      10. Author ve Comment sekmelerinin altında kullanıcı bilgisinin ve yorum içeriğinin görüntülendiği doğrulanır
      */

    TarikPage tarikObje = new TarikPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Yorumların İncelenebilmesi Testi", "Yorumlar görüntülendi");

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
        jse.executeScript("arguments[0].scrollIntoView(true);", tarikObje.reviewsLink);
        jse.executeScript("arguments[0].click();", tarikObje.reviewsLink);
        extentTest.info("Reviews sekmesine tıklandı");

        //10
        tarikObje.productReviewsLink.click();
        extentTest.info("Product Reviews butonuna tıklandı");

        //11
        Assert.assertTrue(tarikObje.kullaniciBilgisiText.isDisplayed());
        Assert.assertTrue(tarikObje.yorumIcerigiText.isDisplayed());
        extentTest.info("Yorumlar ve kullanıcı bilgileri listelendi");

    }
}