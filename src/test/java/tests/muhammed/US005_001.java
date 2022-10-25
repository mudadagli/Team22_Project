package tests.muhammed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.muhammedPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US005_001 extends TestBaseReport {
   muhammedPage muhammedPage=new muhammedPage();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void test1 () throws InterruptedException {
        extentTest=extentReports.createTest("urun listesi testi","urun listelerimi gormeliyim");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("siteye gidildi");

        actions.sendKeys(Keys.END).perform();
        jse.executeScript("arguments[0].scrollIntoView(true);",muhammedPage.MyCount);
        jse.executeScript("arguments[0].click();",muhammedPage.MyCount);
       // muhammedObject.MyCount.click();
        extentTest.info("my account butonuna tiklandi");

        muhammedPage.UsernameORemailAddress.sendKeys(ConfigReader.getProperty("validKullaniciAdiMUhammed"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("validSifreMuhammed")).perform();
        extentTest.info("gecerli kullanici adi  ve sifre girildi");

        jse.executeScript("arguments[0].scrollIntoView(true);",muhammedPage.signinButton);
        jse.executeScript("arguments[0].click();",muhammedPage.signinButton);
        extentTest.info("sign in butonuna tiklandi");

        // muhammedObject.signinButton.click();
        //muhammedObject.storeManagerLink.click();
        jse.executeScript("arguments[0].scrollIntoView(true);",muhammedPage.storeManagerLink);
        jse.executeScript("arguments[0].click();",muhammedPage.storeManagerLink);
        Assert.assertTrue(muhammedPage.storeManagerText.isDisplayed());
        extentTest.info("Store manager sekmesine tiklandi ve ilgili sayfaya gidildigi dogrulandi");

        jse.executeScript("arguments[0].scrollIntoView(true);",muhammedPage.productLink);
        jse.executeScript("arguments[0].click();",muhammedPage.productLink);
        extentTest.info("Product sekmesini giris yapildi");

        jse.executeScript("arguments[0].scrollIntoView(true);",muhammedPage.showAllProductBrands);
        jse.executeScript("arguments[0].click();",muhammedPage.showAllProductBrands);
        extentTest.info("Tum marka listesi sergilendi");

        Assert.assertTrue(muhammedPage.statusText.isDisplayed());
        extentTest.info("Status sekmesine gidildigi dogrulandi");
        Thread.sleep(3000);

        Assert.assertTrue(muhammedPage.stockText.isDisplayed());
        extentTest.info("Stock sekmesine gidildigi dogrulandi");
        Thread.sleep(3000);

        Assert.assertTrue(muhammedPage.priceText.isDisplayed());
        extentTest.info("Price sekmesine gidildigi dogrulandi");
        Thread.sleep(3000);

        Assert.assertTrue(muhammedPage.dateText.isDisplayed());
        extentTest.info("Date sekmesine gidildigi dogrulandi");
        Thread.sleep(3000);
        extentTest.pass("passed");


















    }
}






