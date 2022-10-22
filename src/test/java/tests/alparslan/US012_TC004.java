package tests.alparslan;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;

public class US012_TC004 extends TestBaseReport {
    // https://allovercommerce.com/ Url'e gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tıklanır
    //My Account sayfası butonuna tıklanir
    //Store Manager tiklanir
    //Setting tiklanir
    //Email bilgisi silinir ve verilen email adresi girilir girilir
    //Sayfa refresh yapilir ve emailin degistigi dogrulanir
    //Ayni sayfada Payment tiklanir
    //Preferred Payment Method sekmesinden Bank Transfer secilir
    //Kutucuklar yeniden doldurulur
    //"""Settings saved successfully"" yazisinin goruntulendigi dogrulanir


    AlparslanPage alparslanPage;
    JavascriptExecutor jse;
    WebDriverWait wait;
    Faker faker;
    Select select;



    @Test
    public void indirimliUrunlerTanimlanmissaIndirimliUrunleriListeliGörebilmeliyimUS012TestCase003() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Test",
                "Hesap detaylari ve hesap bilgisi test edildi.");
        //https://allovercommerce.com/ sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("allovercommerce sitesine gidildi");

        //Sign In butonuna tiklanir
        alparslanPage = new AlparslanPage();
        alparslanPage.homePageSignInButton.click();
        extentTest.info("sign in butonuna basıldı");

        //kullanici adi ve sifre girilir
        alparslanPage.signInPopUpUsernameTextBox.sendKeys("fikeka2419@charav.com");
        alparslanPage.signInPopUpPasswordTextBox.sendKeys("asd123456");
        extentTest.info("Doğru kullanıcı email ve password girildi");

        //Sıgn In butonuna tıklanır
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("PopUp uzerindeki Ikinci sign in butonuna basıldı");

        //My Account sayfasi butonuna tiklanir
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.afterSignedInMyAccountLink);
        extentTest.info("My account butonuna tiklandi");

        //Store Manager tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.myAccountPageStoreManagerButton);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageStoreManagerButton);
        extentTest.info("Store Manager butonuna tiklandi");

        //Setting tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.storeManagerPageSettingsButton);
        Thread.sleep(2300);
        extentTest.info("Settings butonuna tiklandi");

        //Email bilgisi silinir ve verilen email adresi girilir girilir
        Assert.assertTrue(alparslanPage.settingsPagestoreEmailTextBox.isDisplayed(), "email bilgisi goruntulenmedi");
        alparslanPage.settingsPagestoreEmailTextBox.clear();
        faker = new Faker();
        String expectedEmail = faker.internet().emailAddress();
        alparslanPage.settingsPagestoreEmailTextBox.sendKeys(expectedEmail);
        Thread.sleep(2000);
        jse.executeScript("arguments[0].click();", alparslanPage.settingPageStoreSaveButton);
        extentTest.info("yeni email bilgisi girildi");

        //Sayfa refresh yapilir ve emailin degistigi dogrulanir
        Thread.sleep(500);
        Driver.getDriver().navigate().refresh();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.settingsPagestoreEmailTextBox));
        Assert.assertNotEquals(alparslanPage.settingsPagestoreEmailTextBox.getText(), expectedEmail);

        //  String actualEmail = alparslanPage.settingsPage_storeEmailTextBox.getText();
        extentTest.info("emailin degistiği dogrulanir");

        //Ayni sayfada Payment tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.settingPagePaymentButton);
        Assert.assertTrue(alparslanPage.settingPagePaymentHesapBilgisi.isDisplayed(), "Hesap bilgisi goruntulenmedi ");
        extentTest.info("Payment tıklandi ve hesap bilgisi test edildi");

        //Preferred Payment Method sekmesinden Bank Transfer secilir
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.settingPagePaymentPaymentMethod));
        select = new Select(alparslanPage.settingPagePaymentPaymentMethod);
        select.selectByValue("bank_transfer");
        extentTest.info("Preferred Payment Method sekmesinden Bank Transfer secildi");

        //Kutucuklar yeniden doldurulur  ***--> actions class calismadi.
        alparslanPage.settingPagePaymentAccountName.clear();
        alparslanPage.settingPagePaymentAccountName.sendKeys("asdAcc4569");

        alparslanPage.settingPagePaymentAccNumberTextBox.clear();
        alparslanPage.settingPagePaymentAccNumberTextBox.sendKeys("123456");

        alparslanPage.settingPagePaymentBankNameTextBox.clear();
        alparslanPage.settingPagePaymentBankNameTextBox.sendKeys("BankOfasdRe");

        alparslanPage.settingPagePaymentBankAdressTextBox.clear();
        alparslanPage.settingPagePaymentBankAdressTextBox.sendKeys("adressOfTheBank");

        alparslanPage.settingPagePaymentRoutingNumberTextBox.clear();
        alparslanPage.settingPagePaymentRoutingNumberTextBox.sendKeys("12545");

        alparslanPage.settingPagePaymentIBANTextBox.clear();
        alparslanPage.settingPagePaymentIBANTextBox.sendKeys("123456985745812365");

        alparslanPage.settingPagePaymentSwiftCodeTextBox.clear();
        alparslanPage.settingPagePaymentSwiftCodeTextBox.sendKeys("45698");

        alparslanPage.settingPagePaymentIFSCcodeTextBox.clear();
        alparslanPage.settingPagePaymentIFSCcodeTextBox.sendKeys("46985");
        extentTest.info("Ilgili kutucuklar dolduruldu");

        //"""Settings saved successfully"" yazisinin goruntulendigi dogrulanir
        jse.executeScript("arguments[0].click();", alparslanPage.settingPagePaymentSaveButton);
        Assert.assertTrue(alparslanPage.settingPageSettingsSavedSuccessfully_Text.isDisplayed(), "son kapanista Settings saved successfully gozukmedi");
        extentTest.info("Settings saved successfully yazisinin goruntulendigi dogrulandi.");

    }
}
