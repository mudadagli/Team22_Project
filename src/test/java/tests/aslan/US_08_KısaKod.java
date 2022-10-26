package tests.aslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AslanPage;
import utilities.Driver;
import utilities.TestBaseReport;

public class US_08_KısaKod extends TestBaseReport {

/*
    1-)Belirtilen URL' e gidilir https://allovercommerce.com/
    2-)Sıng in botununa tıklanır
    3-)gecerli mail  ve gecerli bir sifre girilir ve SIGN IN butonuna basılır
    4-)Acılan pencerede my count a tiklanilir
    5-)Acilan pencerede store manager butonuna tıklanır
    6_)Acilan pencerede Product butonunda Add New 'e Tıklanır
    7-)Acılan Add Product ekranın da Manage Stock?  görünür oldugu test ediniz ve seçim butonu tıklanır}
     */


    AslanPage aslanPage = new AslanPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void testOrtak08() throws InterruptedException {

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
    }

    @Test(dependsOnMethods = "testOrtak08",priority = 1)
    public void testTC_01(){
        //8_)Acılan Stock Qty   görünür oldugu test edinizve stok miktarın (50) girilebildiği test edilir

        //Allow Backorders?  butonuna tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.allowGiris);
        jse.executeScript("arguments[0].click();", aslanPage.allowGiris);
        extentTest.pass("'Allow Backorders?' butonuna tıklandı");

        //Stock Qty  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.stockQty.isDisplayed());
        extentTest.pass("'Stock Qty' yazısı başarıyla görüldü ");

        //Stock Qty herhangi miktar girildği test edilir
        aslanPage.stockQtyGiris.sendKeys(Keys.CLEAR,"5");
        extentTest.pass("'Stock Qty' butonuna tıklandı");

    }
    @Test(dependsOnMethods = "testOrtak08",priority = 2)
    public void testTC_02(){
        /*
        8-)Acılan Allow Backorders?   görünür oldugu test ediniz
        9-)Allow olarak girilebildiği test edilir
         */

        //Allow Backorders?  butonuna tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.allowGiris);
        jse.executeScript("arguments[0].click();", aslanPage.allowGiris);
        extentTest.pass("'Allow Backorders?' butonuna tıklandı");

        // Allow alrak secim yapılır
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ENTER).perform();
        extentTest.pass("'Allow ' secimi yapildi");
        //Allow olarak göründügü test edildi
        Assert.assertTrue(aslanPage.allowWE.isDisplayed());
        extentTest.pass("'Allow' görünür oldugu test edildi");


    }
    @Test(dependsOnMethods = "testOrtak08",priority = 3)
    public void testTC_03(){
        /*
        8-)Acılan Allow Backorders?   görünür oldugu test ediniz
        9_)Acılan Allow Backorders?   görünür oldugu test ediniz ve Do not Allow olarak girilebildiği test edilir

         */
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


    }
    @Test(dependsOnMethods = "testOrtak08",priority = 4)
    public void testTC_04() throws InterruptedException {
        /*
        8-)Acılan Allow Backorders?   görünür oldugu test ediniz
        9_)Acılan Allow Backorders?   görünür oldugu test ediniz ve Allow,but notify customer olarak girilebildiği test edilir

         */

        //Allow Backorders?  butonuna tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.allowGiris);
        jse.executeScript("arguments[0].click();", aslanPage.allowGiris);
        extentTest.pass("'Allow Backorders?' butonuna tıklandı");
        Thread.sleep(3000);

        //Allow,but notify customer olarak girilmeli
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ENTER).perform();
        extentTest.pass("'Allow,but notify customer' butonuna tıklandı");
        Thread.sleep(2000);

        //Allow,but notify customer olarak göründügü test edildi
        Assert.assertTrue(aslanPage.allowButWE.isDisplayed());
        extentTest.pass("'Allow,but notify customer' görünür oldugu test edildi");

    }


}

