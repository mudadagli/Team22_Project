package tests.muhammed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.muhammedPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US005_003 extends TestBaseReport {
    pages.muhammedPage muhammedPage=new muhammedPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test3() throws InterruptedException {
        extentTest = extentReports.createTest("urun listesi testi", "urun listelerimi gormeliyim");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("siteye gidildi");

        actions.sendKeys(Keys.END).perform();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.MyCount);
        jse.executeScript("arguments[0].click();", muhammedPage.MyCount);
        // muhammedObject.MyCount.click();
        extentTest.info("my account butonuna tiklandi");

        muhammedPage.UsernameORemailAddress.sendKeys(ConfigReader.getProperty("validKullaniciAdiMUhammed"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("validSifreMuhammed")).perform();
        extentTest.info("gecerli kullanici adi  ve sifre girildi");

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.signinButton);
        jse.executeScript("arguments[0].click();", muhammedPage.signinButton);
        extentTest.info("sign in butonuna tiklandi");

        // muhammedObject.signinButton.click();
        //muhammedObject.storeManagerLink.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.storeManagerLink);
        jse.executeScript("arguments[0].click();", muhammedPage.storeManagerLink);

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.productLink);
        jse.executeScript("arguments[0].click();", muhammedPage.productLink);
        extentTest.info("Product sekmesine giris yapildi");

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.addNewtLink);
        jse.executeScript("arguments[0].click();", muhammedPage.addNewtLink);
        extentTest.info("Add new sekmesine giris yapildi");
        Thread.sleep(3000);

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.productTitleLink);
        jse.executeScript("arguments[0].click();", muhammedPage.productTitleLink);
        extentTest.info("Product Title kisamina tikllandi");
        Thread.sleep(3000);

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.manageStock);
        jse.executeScript("arguments[0].click();", muhammedPage.manageStock);
        extentTest.info("Manage Stok kisamina tikllandi ve stok miktarina veri girisi saglandi");
       // actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);
        muhammedPage.stockQtyLink.clear();
        muhammedPage.stockQtyLink.sendKeys("20");
        Thread.sleep(2000);
        extentTest.pass("passed");
















    }

}