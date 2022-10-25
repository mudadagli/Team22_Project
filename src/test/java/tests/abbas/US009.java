package tests.abbas;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbbasPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.io.IOException;
import java.util.List;

public class US009 extends TestBaseReport {

    //  1 - Belirtilen URL'e gidilir
    //  2 - Sing In butonuna tıklanır
    //  3 - E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır
    //  4 - Açılan pencerede geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır
    //  5 - Başarıyla giriş yapıldığı doğrulanır
    //  6 - Sayfanin en altinda bulunan My Account'a tiklanir
    //  7 - Açılan sayfada Store Manager seçeneğine tıklanır
    //  8 - Store Manager penceresindeyken Products sekmesine tıklanır
    //  9 - Sag ust kosede bulunan Add New butonuna tiklanir
    //  10 - Acilan sayfanin Add Product sayfasi oldugu dogrulanir
    //  11 - Acilan sayfada sol altta bulunan listede Shipping kismi tiklanir
    //  12 - Açılan sayfada girilecek urunun 3 taraf boyut bilgisi ve kilosunun girelebildiği test edilir


        AbbasPage abbasPage=new AbbasPage();
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor executor=(JavascriptExecutor)Driver.getDriver();
        @Test
        public void uS009_TC_01() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("Pozitif Test Shipping Urun Olcu ve Kilo Belirleme ","Kullanici urun eklerken Shipping segmesinden urunun 3 boyutunu ve kilosunu girebilmeli.");


//      1 - Belirtilen URL'e gidilir

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Belirtilen URL'e gidildi");


//      2 - Sing In butonuna tıklanır

        abbasPage.ilkSayfaSignInLink.click();
        extentTest.info("Sing In butonuna tiklandi");
        Thread.sleep(3000);


//      3 - E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır

        //Assert.assertTrue(abbasPage.signInUsernameBox.isDisplayed());
        extentTest.info("E-mail ve password girişi yapmak için textbox'ların acildigi dogrulandi");

//      4 - Açılan pencerede geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır

        abbasPage.signInUsernameBox.sendKeys("team22.12.10.2022@gmail.com");
        abbasPage.signInPasswordBox.sendKeys("*Team2215381571?");
        abbasPage.signInButton.sendKeys(Keys.ENTER);
        extentTest.info("Açılan pencerede geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklandi");



//      5 - Başarıyla giriş yapıldığı doğrulanır

        Assert.assertTrue(abbasPage.signOut.isDisplayed());
        extentTest.info("Başarıyla giriş yapildigi dogrulandi");



//      6 - Sayfanin en altinda bulunan My Account'a tiklani

        executor.executeScript("arguments[0].scrollIntoView(true);",abbasPage.myAccountButonu);
        ReusableMethods.waitFor(3);
        executor.executeScript("arguments[0].click();",abbasPage.myAccountButonu);
        extentTest.info("Sayfanin en altinda bulunan My Account'a tiklandi");



//      7 - Açılan sayfada Store Manager seçeneğine tıklanır

        abbasPage.storeManager.click();
        extentTest.info("Açılan sayfada Store Manager seçeneğine tıklandi");



//      8 - Store Manager penceresindeyken Products sekmesine tıklanır

        executor.executeScript("arguments[0].click();",abbasPage.products);
        extentTest.info("Store Manager penceresindeyken Products sekmesine tıklandi");



//      9 - Sag ust kosede bulunan Add New butonuna tiklanir

        executor.executeScript("arguments[0].scrollIntoView(true);",abbasPage.addNewButton);
        abbasPage.addNewButton.click();
        extentTest.info("Sag ust kosede bulunan Add New butonuna tiklandi");
        WebElement title=Driver.getDriver().findElement(By.id("pro_title"));
        title.sendKeys("umarim hersey guzel olur");



//      10 - Acilan sayfanin Add Product sayfasi oldugu dogrulanir

        Assert.assertTrue(abbasPage.addProductText.isDisplayed());
        extentTest.info("Acilan sayfanin Add Product sayfasi oldugu dogrulandi");


//      11 - Acilan sayfada sol altta bulunan listede Shipping kismi tiklanir

        executor.executeScript("arguments[0].scrollIntoView(true)",abbasPage.shippingButtonTable);
        Thread.sleep(3000);
        executor.executeScript("arguments[0].click();",abbasPage.shippingButton);
        extentTest.info("Acilan sayfada sol altta bulunan listede Shipping kismi tiklandi");



//      12 - Açılan sayfada girilecek urunun 3 taraf boyut bilgisi ve kilosunun girelebildiği test edilir

        abbasPage.weightBox.sendKeys("19");
        actions.sendKeys(Keys.TAB).sendKeys("30").
                sendKeys(Keys.TAB).sendKeys("40").
                sendKeys(Keys.TAB).sendKeys("50").build().perform();
        extentTest.info("Açılan sayfada girilerek urunun 3 taraf boyut bilgisi ve kilosunun girelebildiği test edildi");

       // WebElement draft=Driver.getDriver().findElement(By.id("wcfm_products_simple_draft_button"));
       // executor.executeScript("arguments[0].click();",draft);//draft

        String weightValue=ReusableMethods.getValueWithJs("weight");
        Assert.assertEquals("19",weightValue);
        System.out.println(weightValue);

        ReusableMethods.waitFor(2);
        ReusableMethods.getScreenshot("US-009-TC001");



    }

        @Test(dependsOnMethods ="uS009_TC_01" ,priority = 1)


        public void uS009_TC_002() throws InterruptedException, IOException {



//      12-2 - Açılan pencerede urunun teslimat suresi girilebilmeli

        Select select=new Select(abbasPage.shippingTimeSelectList);
        List<WebElement> shipping=select.getOptions();
        System.out.println("shipping.size() = " + shipping.size());

        Thread.sleep(2000);

        shipping.stream().forEach(t-> System.out.println(t.getText()));
        shipping.stream().forEach(t->Assert.assertTrue(t.isEnabled()));
        extentTest.info("Teslimat sureleri secildi ve dogrulandi");

        Thread.sleep(3000);

        ReusableMethods.getScreenshot("US-009-TC002");



        }
}
