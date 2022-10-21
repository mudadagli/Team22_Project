package tests.muhammed;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.muhammedPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;

public class US006_010 extends TestBaseReport {
    pages.muhammedPage muhammedPage=new muhammedPage();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));

    @Test
    public void test006_010() {

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

        // muhammedPage.editLink.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.editLink);
        jse.executeScript("arguments[0].click();", muhammedPage.editLink);
        extentTest.info("Edit butonuna tiklama yapildi");

        //muhammedPage.addNewCatagoryButton.click();
        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.addNewCatagoryButton);
        jse.executeScript("arguments[0].click();", muhammedPage.addNewCatagoryButton);
        extentTest.info("Add new butonuna tiklama yapildi");

        muhammedPage.categoryNameBox.sendKeys("Taki&Aksesuar");

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.addButton);
        jse.executeScript("arguments[0].click();", muhammedPage.addButton);
        extentTest.info("Add butonuna tiklama yapildi");

        wait.until(ExpectedConditions.alertIsPresent());

        Driver.getDriver().switchTo().alert().accept();

        jse.executeScript("arguments[0].scrollIntoView(true);", muhammedPage.takiAksesuarClickButton);
        jse.executeScript("arguments[0].click();", muhammedPage.takiAksesuarClickButton);

        Assert.assertTrue(muhammedPage.takiAksesuarClickButton.isSelected());
        extentTest.info("Taki & aksesuar urunler butonuna tiklama yapildi");
    }

}
