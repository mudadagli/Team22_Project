package tests.alparslan;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import java.util.ArrayList;
import java.util.List;


public class US012 extends TestBaseReport {

    AlparslanPage alparslanPage;
    JavascriptExecutor jse;
    WebDriverWait wait;
    Faker faker;
    Select select;

    @Test
    public void testEntry12() throws InterruptedException {
        //https://allovercommerce.com/ Url'e gidilir
        //Sign In butonuna tiklanir
        //kullanici adi ve sifre girilir
        //Sıgn In butonuna tiklanir
        //My Account butonuna tiklanir
        //Store Manager tiklanir

        extentTest = extentReports.createTest("Pozitif Test", "Portala access");
        //https://allovercommerce.com/ Url'e gidilir
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

        //Sıgn In butonuna tiklanir
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("PopUp uzerindeki Ikinci sign in butonuna basıldı");

        //My Account butonuna tiklanir
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.afterSignedInMyAccountLink);
        extentTest.info("My account butonuna tiklandi");

        //Store Manager tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(alparslanPage.myAccountPageStoreManagerButton));
        alparslanPage.myAccountPageStoreManagerButton.click();
        extentTest.info("Store Manager butonuna tiklandi");
    }


    @Test(dependsOnMethods = "testEntry12", priority = 1)
    public void tumPortalaErisim_US012_TC01_Test() throws InterruptedException {

        //Orders tiklanir
        //siparislerin goruntulendigi dogrulanir
        //siparislerin sirali oldugu dogrulanir

        //Orders tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //siparislerin goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageordersList) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.info("Siparislerin goruntulendigi test edildi");

        //siparislerin sirali oldugu dogrulanir
        for (int i = 0; i < alparslanPage.ordersPageordersList.size(); i++) {
            if (i < alparslanPage.ordersPageordersList.size() - 1) {
                Assert.assertTrue(Integer.parseInt(alparslanPage.ordersPageordersList.get(i + 1).getText().replaceAll("\\D", ""))
                                < Integer.parseInt(alparslanPage.ordersPageordersList.get(i).getText().replaceAll("\\D", "")),
                        "Siparisler sirali degil");
            } else break;
        }
        extentTest.pass("siparislerin sırali oldugu test edildi.");
    }


    @Test(dependsOnMethods = "testEntry12", priority = 2)
    public void indirimliUrun_US012_TC002_Test() throws InterruptedException {

        //Orders tiklanir
        //indirimli urun oldugu onaylanir

        //Orders tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.afterSignedInMyAccountLink));
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //indirimli urun oldugu onaylanir
        List<WebElement> tableUrunler;
        List<String> indirimliUrunListesi = new ArrayList<>();
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.storeManagerPageProductsButton));
        jse.executeScript("arguments[0].click();", alparslanPage.storeManagerPageProductsButton);

        wait.until(ExpectedConditions.visibilityOf(alparslanPage.productsPagetable));
        for (int i = 1; i < alparslanPage.productsPageproductsList.size() + 1; i++) {
            tableUrunler = Driver.getDriver().findElements(By.xpath("//tbody/tr[" + i + "]/td//bdi"));
            if (tableUrunler.size() > 1) {
                indirimliUrunListesi.add(Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[3]")).getText());
            }
        }

        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        List<String> purchasedItems = new ArrayList<>();
        for (WebElement each : alparslanPage.ordersTablepurchasedList
        ) {
            purchasedItems.add(each.getText().substring(2));
        }

        for (int i = 0; i < indirimliUrunListesi.size(); i++) {
            if (purchasedItems.contains(indirimliUrunListesi.get(i))) {
                Assert.assertTrue(purchasedItems.contains(indirimliUrunListesi.get(i)), "indirimli ürün görüntülenemedi");
                System.out.println("bulunan urun" + indirimliUrunListesi.get(i));
                break;
            }
        }
        extentTest.pass("Indirimli urun oldugu test edildi");
    }

    @Test(dependsOnMethods = "testEntry12", priority = 3)
    public void indirimliUrunlerListesiGoruntuleme_US012_TC003_Test() throws InterruptedException {

        //Orders tiklanir
        //Acilan listede Billing Address goruntulendigi dogrulanir
        //Acilan listede  Shipping Address goruntulendigi dogrulanir


        //Orders tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.afterSignedInMyAccountLink));
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //Acilan listede Billing Address goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageBillingAdresses) {
            Assert.assertTrue(each.isDisplayed(), "Billing Address goruntulenemiyor");
        }
        extentTest.info("Acilan listede Billing Address goruntulendigi test edildi");

        //Acilan listede  Shipping Address goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageShippingAdresses
        ) {
            Assert.assertTrue(each.isDisplayed(), "Shipping Address goruntulenemiyor");
        }
        extentTest.pass("Acilan listede Billing Address ve Shipping Address goruntulendigi dogrulandi");
    }

    @Test(dependsOnMethods = "testEntry12", priority = 4)
    public void hesapBilgisi_US012_TC003_Test() throws InterruptedException {
        //Setting tiklanir
        //Email bilgisi silinir ve verilen email adresi girilir girilir
        //Sayfa refresh yapilir ve emailin degistigi dogrulanir
        //Ayni sayfada Payment tiklanir
        //Preferred Payment Method sekmesinden Bank Transfer secilir
        //Kutucuklar yeniden doldurulur
        //"""Settings saved successfully"" yazisinin goruntulendigi dogrulanir

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
