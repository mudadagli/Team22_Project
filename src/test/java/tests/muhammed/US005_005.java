package tests.muhammed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.muhammedPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class US005_005 extends TestBaseReport {

    pages.muhammedPage muhammedPage=new muhammedPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void test5() throws InterruptedException {

        extentTest = extentReports.createTest("Urun listesi testi", "urun listelerimi gormeliyim");
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Siteye gidildi");

        actions.sendKeys(Keys.END).perform();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.MyCount);
        jse.executeScript("arguments[0].click();", muhammedPage.MyCount);
        // muhammedObject.MyCount.click();
        extentTest.info("My account butonuna tiklandi");

        muhammedPage.UsernameORemailAddress.sendKeys(ConfigReader.getProperty("validKullaniciAdiMUhammed"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("validSifreMuhammed")).perform();
        extentTest.info("Gecerli kullanici adi  ve sifre girildi");

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.signinButton);
        jse.executeScript("arguments[0].click();", muhammedPage.signinButton);
        extentTest.info("Sign in butonuna tiklandi");

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
        Thread.sleep(2000);

       Driver.getDriver().switchTo().frame(muhammedPage.iframe);
      // muhammedPage.tiklanacakYer.click();
       jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.shortdescription);
       jse.executeScript("arguments[0].click();", muhammedPage.shortdescription);
       extentTest.info("Short Description kismina tiklama yapildi");
       Thread.sleep(2000);
       Driver.getDriver().switchTo().defaultContent();

        Driver.getDriver().switchTo().frame(muhammedPage.iframedescription);
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.description);
        jse.executeScript("arguments[0].click();", muhammedPage.description);
        extentTest.info("Description kismina tiklama yapildi");



















    }
}
