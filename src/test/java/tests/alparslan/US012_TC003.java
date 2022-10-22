package tests.alparslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.TestBaseReport;

import java.time.Duration;

public class US012_TC003 extends TestBaseReport {
    //https://allovercommerce.com/ sayfasina gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tıklanır
    //My Account sayfası butonuna tıklanir
    //Store Manager tiklanir
    //Orders tiklanir
    //Acilan listede Billing Address goruntulendigi dogrulanir
    //Acilan listede  Shipping Address goruntulendigi dogrulanir
    AlparslanPage alparslanPage;
    JavascriptExecutor jse;
    WebDriverWait wait;

    @Test
    public void indirimliUrunlerTanimlanmissaIndirimliUrunleriListeliGörebilmeliyimUS012TestCase003() throws InterruptedException {

        extentTest=extentReports.createTest("Pozitif Test",
                "listede Billing Address ve Shipping Address goruntulendigi test edildi");

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
        extentTest.info("Gecerli kullanıcı email ve password girildi");

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

        //Orders tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.afterSignedInMyAccountLink));
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //Acilan listede Billing Address goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageBillingAdresses){
            Assert.assertTrue(each.isDisplayed(),"Billing Address goruntulenemiyor");
        }
        extentTest.info("Acilan listede Billing Address goruntulendigi test edildi");

        //Acilan listede  Shipping Address goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageShippingAdresses
        ) {
            Assert.assertTrue(each.isDisplayed(),"Shipping Address goruntulenemiyor");
        }
        extentTest.pass("Acilan listede  Shipping Address goruntulendigi");


    }
}
