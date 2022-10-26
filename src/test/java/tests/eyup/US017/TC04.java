package tests.eyup.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EyupPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class TC04 extends TestBaseReport {
    EyupPage eyupPage = new EyupPage();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker= new Faker();
    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Yeniden Billing Address  bilgilerini farklı olarak ekleyebilirler");

        //Kullanici  "https://allovercommerce.com/"url'e gider
        Driver.getDriver().get("https://allovercommerce.com/");
        extentTest.info("Kullanici https://allovercommerce.com/ adresine gitti");

        //Sign In butonuna tiklanir
        eyupPage.anaSayfaSignInLink.click();
        extentTest.info("Kullanici sign-in linkine tikladi");

        //Kullanici bilgileri girilir ve sign in'e tiklanir.
        eyupPage.signInUsernameBox.sendKeys("team222");
        eyupPage.signInPasswordBox.sendKeys("*Team2215381571?");
        eyupPage.signInButton.click();
        extentTest.info("Kullanici bilgileri girildi ve sign in'e tiklandi");

        //My Account a tiklanir.
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);",eyupPage.myAccountButton);
        jse.executeScript("arguments[0].click();",eyupPage.myAccountButton);
        extentTest.info("My acounta tiklandi");

        //Kullanici "Adres" butonuna tiklar
        eyupPage.vedorAdresButton.click();
        extentTest.info("Kullanici adres butonuna tikladi");

        //Fatura adres sayfasina girildigi dogrulanir.
        Assert.assertTrue(eyupPage.vedorAdresFatureText.isDisplayed());
        extentTest.info("Fatura address sayfasina girildigi dogrulandi");


        //Fatura adresinizi duzenleme butonuna tiklanir
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        eyupPage.vedorAdresDuzenlemeButton.click();
        Thread.sleep(5000);
        extentTest.info("Fatura adres duzenleme butonuna tiklandi");

        //Kullanici ad,soyad,ulke/bolge,acik adres,sehir,devlet,posta kodu,telefon,e-posta adresi kutularini girer
        //"Adresi Kaydet butonunu tiklar

        eyupPage.vedorFaturaAdresFirstnameButton.clear();
        eyupPage.vedorFaturaAdresFirstnameButton.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).

                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().fullAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.address().streetAddress()).sendKeys(Keys.TAB).
                sendKeys(faker.number().digit()).sendKeys(Keys.TAB).sendKeys(faker.address().city()).
                sendKeys(Keys.TAB).sendKeys(faker.number().digit()).sendKeys(Keys.TAB).
                sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(3000);

        extentTest.info("Kullanici ad,soyad,ulke/bolge,acik adres,sehir,devlet,posta kodu,telefon,e-posta adresi kutularini girer");
        extentTest.info("Adresi Kaydet butonunu tikladi");


        //Fatura adresin basirili kaydedildigi dogrulanir.
        Assert.assertTrue(eyupPage.vedorAdresFatureText.isDisplayed());
        extentTest.info("Fatura adresin basirili kaydedildigi dogrulandi");
    }
}
