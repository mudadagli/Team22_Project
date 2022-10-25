package tests.eyup.US018;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EyupPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class TC02 extends TestBaseReport {
    EyupPage eyupPage = new EyupPage();

    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","Order ID: verilen urun numarası belli edilmeli");


        //Kullanici url'e gider
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

        //My Account sayfasina gelgini dogrular
        Assert.assertTrue(eyupPage.vendorMyAccountText.isDisplayed());
        extentTest.info("My Account sayfasina gelgini dogrulandi");

        //Store Manager butonuna tiklar
        eyupPage.storeManagerLink.click();
        extentTest.info("Store Manager butonuna tiklandi");

        //Store Maneger sayfasina gelgini dogrular
        Assert.assertTrue(eyupPage.vendorStoreManegerText.isDisplayed());
        Thread.sleep(4000);
        extentTest.info("Store Maneger sayfasina gelgini dogrulandi");

        //Refund butonuna tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        eyupPage.vendorRefundButton.click();
        extentTest.info("Refund butonuna tiklandi");

        // //Order ID bolumunun gorunur oldugunu dogrular
        Assert.assertTrue(eyupPage.vendorOrderIdText.isDisplayed());
        extentTest.info("Order ID bolumunun gorunur oldugunu dogrulandi");




    }
}
