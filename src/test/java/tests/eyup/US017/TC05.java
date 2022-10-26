package tests.eyup.US017;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EyupPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class TC05 extends TestBaseReport {
    EyupPage eyupPage = new EyupPage();

    Actions actions = new Actions(Driver.getDriver());


    Faker faker= new Faker();


    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Yeniden Shipping address bilgilerini farklı olarak ekleyebilirler");

        //Kullanici  "https://allovercommerce.com/"url'e gider
        Driver.getDriver().get("https://allovercommerce.com/");
        extentTest.info("Kullanici https://allovercommerce.com/ adresine gitti");

        //Sign In butonuna tiklanir
        eyupPage.anaSayfaSignInLink.click();
        extentTest.info("Kullanici sign-in linkine tikladi");

        //Kullanici bilgileri girilir ve sign in'e tiklanir.
        eyupPage.signInUsernameBox.sendKeys("team222");
        eyupPage.signInPasswordBox.sendKeys("*Team2215381571?");
        eyupPage.signInButton.click();
        extentTest.info("Kullanici bilgileri girildi ve sign in'e tiklandi");

        //My Account a tiklanir.
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);",eyupPage.myAccountButton);
        jse.executeScript("arguments[0].click();",eyupPage.myAccountButton);
        extentTest.info("My acounta tiklandi");

        //Kullanici "Adres" butonuna tiklar
        eyupPage.vedorAdresButton.click();
        extentTest.info("Kullanici adres butonuna tikladi");


        //Kullanici "EDIT YOUR SHIPPING ADDRESS" butonuna tiklar
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        eyupPage.editYourShippingAddressLink.click();
        extentTest.info("Kullanici EDIT YOUR SHIPPING ADDRESS butonuna tikladi");


        //Shipping Address sayfasinin gorunur oldunu test eder
        Assert.assertTrue(eyupPage.vedorShippingaddressText.isDisplayed());
        extentTest.info("Shipping Address sayfasinin gorunur oldunu test edildi");


        //Kullanici yeniden tum bilgileri girer
        //Save address butonuna basar
        eyupPage.vendorShippingfirstNameBox.clear();
        Thread.sleep(3000);
        eyupPage.vendorShippingfirstNameBox.sendKeys(faker.name().firstName());
        actions.sendKeys(Keys.TAB).sendKeys("kaya").perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        eyupPage.vendorShippingAdress1Box.clear();
        eyupPage.vendorShippingAdress1Box.sendKeys("adres 1");
        actions.sendKeys(Keys.TAB).sendKeys("adres 2").sendKeys(Keys.TAB).sendKeys("il").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("12345").sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

        extentTest.info("Kullanici yeniden tum bilgileri girdi");
        extentTest.info("Save address butonuna basti");



        //Shipping Address sayfasinin gorunur oldunu test eder
        Assert.assertTrue(eyupPage.vedorShippingaddressText.isDisplayed());
        extentTest.info("Shipping Address sayfasinin gorunur oldunu test etti");




    }
}
