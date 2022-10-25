package tests.aslan.US_08;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AslanPage;
import utilities.Driver;

import utilities.TestBaseReport;

public class US_008_TC_03 extends TestBaseReport {
     /*

    1-)Belirtilen URL' e gidilir https://allovercommerce.com/
    2-)Sıng in botununa tıklanır
    3-)gecerli mail  ve gecerli bir sifre girilir ve SIGN IN butonuna basılır
    4-)Acılan pencerede my count a tiklanilir
    5-)Acilan pencerede store manager butonuna tıklanır
    6_)Acilan pencerede Product butonunda Add New 'e Tıklanır
    7-)Acılan Add Product ekranın da Manage Stock?  görünür oldugu test ediniz ve seçim
    8-)Acılan Allow Backorders?   görünür oldugu test ediniz
    9_)Acılan Allow Backorders?   görünür oldugu test ediniz ve Do not Allow olarak girilebildiği test edilir

     */

    AslanPage aslanPage = new AslanPage();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();

    @Test
    public void test03() throws InterruptedException {
        extentTest = extentReports.createTest("URL", "Web Otomasyon Raporlama");
        // Belirtilen URL'e gidilir
        Driver.getDriver().get("https://allovercommerce.com/");
        Thread.sleep(3000);
        extentTest.pass("belirtilen Url eye gidildi");


        //Sign in 'e tiklanir
        aslanPage.singButon.click();
        Thread.sleep(3000);
        extentTest.pass("'Sign in' linkine tıklandı");

        //Gecerli bir mail girilir
        aslanPage.usarName.sendKeys("leon.g29.i35@gmail.com");
        Thread.sleep(2000);
        extentTest.pass("Geçerli bir email girildi");


        //Gecerli bir password girilir
        aslanPage.password.sendKeys("Za132428");
        Thread.sleep(2000);
        extentTest.pass("'Geçerli bir password' girildi");

        //Sign in 'e tiklanir
        aslanPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.pass("'Sign in' butonuna tıklandı");


        //My Account butonuna tıklanir
        Driver.getDriver().navigate().refresh();
        Thread.sleep(4000);
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.myAccountButton);
        jse.executeScript("arguments[0].click();", aslanPage.myAccountButton);
        extentTest.pass("'My Account' butonuna tıklandı");


        //Store Maneger butonuna tıklanir
        aslanPage.storeManager.click();
        Thread.sleep(2000);
        extentTest.pass("'Store Maneger' butonuna tıklandı");

        //Product butonuna tıklanir
        aslanPage.products.click();
        extentTest.pass("'Product' butonuna tıklandı");

        //Add New  butonuna tıklanir
        aslanPage.addNew.click();
        extentTest.pass("'Add New' butonuna tıklandı");

        //Manage Stock?  butonuna tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.manegetStockButton);
        jse.executeScript("arguments[0].click();", aslanPage.manegetStockButton);
        extentTest.pass("'Manage Stock?' butonuna tıklandı");

        Thread.sleep(2000);
        //Manage Stock?  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.manegeStock.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("'Manage Stock?' yazısı başarıyla görüldü butonuna tıklandı");


        //Allow Backorders?  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.allowBackorders.isDisplayed());
        Thread.sleep(2000);
        extentTest.pass("'Allow Backorders?' yazısı başarıyla görüldü");

        //Allow Backorders?  butonuna tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.allowGiris);
        jse.executeScript("arguments[0].click();", aslanPage.allowGiris);
        extentTest.pass("'Allow Backorders?' butonuna tıklandı");

        //Do not Allow olarak girilmeli
        actions.sendKeys(Keys.ENTER).perform();
        extentTest.pass("'Do not Allow' butonuna tıklandı");

        //Do not Allow olarak göründügü test edildi
        Assert.assertTrue(aslanPage.doNotAllowWE.isDisplayed());
        extentTest.pass("'Do not Allow' görünür oldugu test edildi");


        Driver.closeDriver();
        extentTest.pass(" Sayfa kapatildi");






    }


}
