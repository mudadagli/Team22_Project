package tests.aslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AslanPage;
import utilities.Driver;
import utilities.TestBaseReport;

public class US_07_KısaKod extends TestBaseReport {

     /*
    1-)Belirtilen URL' e gidilir https://allovercommerce.com/
    2-)Sıng in botununa tıklanır
    3-)gecerli mail  ve gecerli bir sifre girilir ve SIGN IN butonuna basılır
    4-)Acılan pencerede my count a tiklanilir
    5-)Acilan pencerede store manager butonuna tıklanır
    6_)Acilan pencerede Product butonunda Add New 'e Tıklanır
    7-)Product brands sayfasında  Elegant Auto group brandının olduğu ve seçilebilr oldugunu test ediniz

      */

    AslanPage aslanPage = new AslanPage();

    Actions actions = new Actions(Driver.getDriver());
    JavascriptExecutor jse =(JavascriptExecutor) Driver.getDriver();


    @Test
    public void testOrtak() throws InterruptedException {

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

        //Product brands  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.brands.isDisplayed());
        extentTest.pass("'Product brands' yazısı başarıyla görüldü butonuna tıklandı");
    }

    @Test(dependsOnMethods = "testOrtak",priority = 1)
    public void testTC_01(){
        //7-)Product brands sayfasında  Elegant Auto group brandının olduğu ve seçilebilr oldugunu test ediniz


        //Elegant Auto group  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.eleganntAutoGroup.isDisplayed());
        extentTest.pass("'Elegant Auto group' yazısı başarıyla görüldü butonuna tıklandı");


        //Elegant Auto group seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.eleganntAutoGroup2);
        jse.executeScript("arguments[0].click();", aslanPage.eleganntAutoGroup2);
        extentTest.pass("'Elegant Auto group' butonuna tıklandı");

    }

    @Test(dependsOnMethods = "testOrtak",priority = 2)
    public void testTC_02(){
       // 7-)Product brands sayfasında  Green Grass brandının olduğu ve seçilebilr oldugunu test ediniz

        //Green Grass  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.greenGrass.isDisplayed());
        extentTest.pass("'Green Grass' yazısı başarıyla görüldü butonuna tıklandı");


        //Green Grass seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.greenGrass2);
        jse.executeScript("arguments[0].click();", aslanPage.greenGrass2);
        extentTest.pass("'Green Grass' butonuna tıklandı");
    }

    @Test(dependsOnMethods = "testOrtak",priority = 3)
    public void testTC_03(){
      // 7-)Product brands sayfasında  Node JS brandının olduğu ve seçilebilr oldugunu test ediniz


        //Node JS  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.nodeJs.isDisplayed());
        extentTest.pass("'Node JS' yazısı başarıyla görüldü butonuna tıklandı");


        //Node JS seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.nodeJs2);
        jse.executeScript("arguments[0].click();", aslanPage.nodeJs2);
        extentTest.pass("'Node JS' butonuna tıklandı");

    }

    @Test(dependsOnMethods = "tetstOrtak",priority = 4)
    public void testTC_04(){
        //7-)Product brands sayfasında   NS8 brandının olduğu ve seçilebilr oldugunu test ediniz

        // NS8 yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.ns8.isDisplayed());
        extentTest.pass("' NS8' yazısı başarıyla görüldü butonuna tıklandı");


        // NS8 seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.ns82);
        jse.executeScript("arguments[0].click();", aslanPage.ns82);
        extentTest.pass("' NS8' butonuna tıklandı");
    }
    @Test(dependsOnMethods = "testOrtak",priority = 5)
    public void tetsTC_05(){
        // 7-)Product brands sayfasında    RED brandının olduğu ve seçilebilr oldugunu test ediniz
        //  RED yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.red.isDisplayed());
        extentTest.pass("'  RED' yazısı başarıyla görüldü butonuna tıklandı");


        //  RED seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.red2);
        jse.executeScript("arguments[0].click();", aslanPage.red2);
        extentTest.pass("'  RED' butonuna tıklandı");

    }
    @Test(dependsOnMethods = "testOrtak",priority = 6)
    public void testTC_06(){
        //7-)Product brands sayfasında    RED brandının olduğu ve seçilebilr oldugunu test ediniz


        //   SkySuite Tech yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.skysuitTech.isDisplayed());
        extentTest.pass("'  SkySuite Tech' yazısı başarıyla görüldü butonuna tıklandı");


        //   SkySuite Tech seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.skysuitTech2);
        jse.executeScript("arguments[0].click();", aslanPage.skysuitTech2);
        extentTest.pass("'  SkySuite Tech' butonuna tıklandı");
    }

    @Test(dependsOnMethods = "testOrtak",priority = 7)
    public void testTC_07(){
        //7-)Product brands sayfasında    Sterling  brandının olduğu ve seçilebilr oldugunu test ediniz

        //  Sterling  yazısının göründüğü test edilir
        Assert.assertTrue(aslanPage.sterling.isDisplayed());
        extentTest.pass("'Sterling ' yazısı başarıyla görüldü butonuna tıklandı");


        //Sterling seçimi tıklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", aslanPage.sterling2);
        jse.executeScript("arguments[0].click();", aslanPage.sterling2);
        extentTest.pass("'Sterling ' butonuna tıklandı");

    }

}
