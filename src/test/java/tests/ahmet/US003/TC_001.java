package tests.ahmet.US003;

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
    //Test Case: Orders da Browse products a gidilmeli
    @Test
    public void test001() throws InterruptedException {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");
        //Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("belirtilen URL'e gidildi");

        //Sign in 'e tiklanir
        ahmetPage.anaSayfaSignInLink.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //Gecerli kullanici bilgileri girilir
        ahmetPage.signInUsernameBox.sendKeys("a.palta1314@hotmail.com");
        ahmetPage.signInPasswordBox.sendKeys("Ahmet1314.,");
        extentTest.info("'Geçerli email ve password' girildi");

        //Sign in 'e tiklanir
        ahmetPage.signInOnayButton.click();
        extentTest.info("'Sign in' linkine tıklandı");

        //My Account sayfasina giris yapilir.
        jse.executeScript("arguments[0].scrollIntoView(true);", ahmetPage.myAccountLink);
        Thread.sleep(2000   );
        jse.executeScript("arguments[0].click();", ahmetPage.myAccountLink);
        extentTest.info("My Account sayfasına giris yapıldı");

        //Acilan sayfada order bolumune tiklanir
        ahmetPage.ordersLink.click();
        extentTest.info("Acilan sayfada order bolumune tıklandı");

        //Acilan sayfada go shop butonuna tiklanir
        Assert.assertTrue(ahmetPage.goShopButton.isDisplayed());
        jse.executeScript("arguments[0].scrollIntoView(true);", ahmetPage.goShopButton);
        jse.executeScript("arguments[0].click();", ahmetPage.goShopButton);
        extentTest.info("Acilan sayfada go shop butonuna tıklandı");

        //Products sayfasina girildigi  test edilir
        Assert.assertTrue(ahmetPage.shopLabelProductPage.isDisplayed());
        extentTest.pass("Products sayfasina başarıyla girildigi görüldü");
    }


}
