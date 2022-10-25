package tests.abbas;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AbbasPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.io.IOException;

public class US010 extends TestBaseReport {

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
    //  12 - Açılan pencerede urunun rengi secilebilmeli birden fazla
    AbbasPage abbasPage=new AbbasPage();

    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor executor=(JavascriptExecutor)Driver.getDriver();

    @Test(priority = 1)

    public void uS010_TC_01() throws InterruptedException, IOException {

        extentTest=extentReports.createTest("Pozitif Test Shipping Renk ve Boyut Secimi","Açılan pencerede urunun rengi secilebilmeli birden fazla");


//      1 - Belirtilen URL'e gidilir

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Belirtilen URL'e gidilidi");


//      2 - Sing In butonuna tıklanır

        abbasPage.ilkSayfaSignInLink.click();
        extentTest.info("Sing In butonuna tıklandi");
        Thread.sleep(3000);


//      3 - E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulanır

        Assert.assertTrue(abbasPage.signInUsernameBox.isDisplayed());
        extentTest.info("E-mail ve password girişi yapmak için textbox'ların açıldığı doğrulandi");

//      4 - Açılan pencerede geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklanır

        abbasPage.signInUsernameBox.sendKeys("team22.12.10.2022@gmail.com");
        abbasPage.signInPasswordBox.sendKeys("*Team2215381571?");
        abbasPage.signInButton.sendKeys(Keys.ENTER);
        extentTest.info("Açılan pencerede geçerli e-mail ve şifre girildikten sonra Sign In butonuna tıklandi");



//      5 - Başarıyla giriş yapıldığı doğrulanır

        Assert.assertTrue(abbasPage.signOut.isDisplayed());
        extentTest.info("Başarıyla giriş yapıldığı doğrulandi");



//      6 - Sayfanin en altinda bulunan My Account'a tiklani

        executor.executeScript("arguments[0].scrollIntoView(true);",abbasPage.myAccountButonu);
        ReusableMethods.waitFor(3);
        executor.executeScript("arguments[0].click();",abbasPage.myAccountButonu);
        extentTest.info("Sayfanin en altinda bulunan My Account'a tiklandi");



//      7 - Açılan sayfada Store Manager seçeneğine tıklanır

        abbasPage.storeManager.click();
        extentTest.info("Açılan sayfada Store Manager seçeneğine tiklandi");



//      8 - Store Manager penceresindeyken Products sekmesine tıklanır

        executor.executeScript("arguments[0].click();",abbasPage.products);
        extentTest.info("Store Manager penceresindeyken Products sekmesine tıklandi");



//      9 - Sag ust kosede bulunan Add New butonuna tiklanir

        executor.executeScript("arguments[0].scrollIntoView(true);",abbasPage.addNewButton);
        abbasPage.addNewButton.click();
        extentTest.info("Sag ust kosede bulunan Add New butonuna tiklandi");
        //WebElement title=Driver.getDriver().findElement(By.id("pro_title"));
        //title.sendKeys("umarim hersey guzel olur");



//      10 - Acilan sayfanin Add Product sayfasi oldugu dogrulanir

        Assert.assertTrue(abbasPage.addProductText.isDisplayed());
        extentTest.info("Acilan sayfanin Add Product sayfasi oldugu dogrulandi");


//      11 - Acilan sayfada sol altta bulunan listede Shipping kismi tiklanir

        executor.executeScript("arguments[0].scrollIntoView(true)",abbasPage.shippingButtonTable);
        Thread.sleep(3000);
        executor.executeScript("arguments[0].click();",abbasPage.shippingButton);
        extentTest.info("Acilan sayfada sol altta bulunan listede Shipping kismi tiklandi");
        Thread.sleep(3000);


//      12 - Açılan pencerede urunun rengi secilebilmeli birden fazla

        abbasPage.attributes.click();//attributes segmesine tiklandi
        abbasPage.attributescolorArrowButton.click();// attributes' e tikladiktan sonra color'un alt ok tusuna bailsdi

        Thread.sleep(3000);

       // Select select=new Select(abbasPage.colorSelect);
       // List<WebElement> colors=select.getOptions();
       // colors.stream().forEach(t->t.click());
       // colors.stream().forEach(t->Assert.assertTrue(t.isSelected()));
       // colors.stream().forEach(t-> System.out.println(t.getText()));

        ReusableMethods.selectObjectMenu(abbasPage.colorSelect);
        extentTest.info("Urunu renkleri secildi ve test edildi.");

        // abbasPage.attributesColor.click();
        // color dan renk secildi
        // actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_RIGHT).build().perform();


         Thread.sleep(2000);
         ReusableMethods.getScreenshot("US010_TC_01");


    }

    @Test(dependsOnMethods = "uS010_TC_01",priority = 2)

    public void uS010_TC_02() throws InterruptedException, IOException {

        abbasPage.attributes.click();
        abbasPage.attributesSizeArrowButton.click();

        //  abbasPage.attributesSize.click();
        //  actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        //  extentTest.info("Urunun boyutu secildi ve test edildi");

        ReusableMethods.selectObjectMenu(abbasPage.attributesSize);

        Thread.sleep(2000);
        ReusableMethods.getScreenshot("US010_TC_02");
    }
}
