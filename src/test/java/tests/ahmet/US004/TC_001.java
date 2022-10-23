package tests.ahmet.US004;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AhmetPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class TC_001 extends TestBaseReport {
    AhmetPage ahmetPage = new AhmetPage();
    Actions actions;
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    //Test Case: Secilen ürünler View Cartta görülmeli; Rakam, miktar ve toplam olarak görülmeli
    @Test
    public void test001() throws InterruptedException {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");
        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("belirtilen URL'e gidildi");

        //Giris yap' a tiklanir
        ahmetPage.anaSayfaSignInLink.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //Gecerli kullanici bilgileri girilir
        ahmetPage.signInUsernameBox.sendKeys("a.palta1314@hotmail.com");
        ahmetPage.signInPasswordBox.sendKeys("Ahmet1314.,");
        extentTest.info("'Geçerli email ve password' girildi");

        //Giris yap' a tiklanir.
        ahmetPage.signInOnayButton.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //My Account sayfasina gidilir
        jse.executeScript("arguments[0].scrollIntoView(true);", ahmetPage.myAccountLink);
        Thread.sleep(2000   );
        jse.executeScript("arguments[0].click();", ahmetPage.myAccountLink);
        extentTest.info("My Account sayfasına giris yapıldı");

        //Acilan sayfada order bolumune tiklanir
        ahmetPage.ordersLink.click();
        extentTest.info("Acilan sayfada order bolumune tıklandı");

        //Acilan sayfada go shop butonuna tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);",ahmetPage.goShopButton);
        jse.executeScript("arguments[0].click();", ahmetPage.goShopButton);
        extentTest.info("Acilan sayfada go shop butonuna tıklandı");

        //Rastgele 5 urun secilir ve sepete eklenir
        for (int i=0 ;i<=4;i++) {
            jse.executeScript("arguments[0].scrollIntoView(true);",ahmetPage.addCart);
            jse.executeScript("arguments[0].click();", ahmetPage.addCart);
            Thread.sleep(2000);
        }
        extentTest.info("Rastgele 5 urun secildi ve sepete eklendi");

        //Cart ' a click yapılır
        jse.executeScript("window.scrollTo(document.body.scrollHeight,0)");
        Thread.sleep(3000);
        ahmetPage.cardLink.click();
        extentTest.info("Cart'a click yapıldı");

        //Burada açılan segmede view card 'a tiklanir.
        ahmetPage.viewCartLink.click();
        Thread.sleep(2000);
        extentTest.info("view card 'a tiklandi");

        //Urunlerin fiyatı miktarı ve toplam tutarinin sepette gorundugu test edilir
        Assert.assertTrue(ahmetPage.productPriceAlani.isDisplayed());
        Assert.assertTrue(ahmetPage.productQuantityAlani.isDisplayed());
        Assert.assertTrue(ahmetPage.productSubtotalAlani.isDisplayed());
        extentTest.pass("Urunlerin fiyatı miktarı ve toplam tutarinin sepette yer aldigi goruldu");

    }


}
