package tests.yasin;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YasinPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import java.io.IOException;
import java.util.List;

public class US013 extends TestBaseReport {

    YasinPage yasinPage = new YasinPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testEntry13() {

        /*
          1-)Belirtilen URL' e gidilir
          2-)Sign In butonuna tiklanir
          3-)Kullanici bilgileri girilir
          4-)My Account a tiklanir
          5-)Store Manager a tiklanir
          6-)Coupons basligina tiklanir
          7-)Add New butonuna  tiklanir

         */

        extentTest=extentReports.createTest("URL","Web Otomasyon Raporlama");

        // 1-)
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("Belirtilen URL e gidildi");

        // 2-)
        yasinPage.ilkSayfaSignInButonu.click();
        extentTest.info("Sign In butonuna basildi");

        // 3-)
        yasinPage.signInUserNameBox.sendKeys("team22.12.10.2022@gmail.com");
        yasinPage.signInPasswordBox.sendKeys("*Team2215381571?");
        yasinPage.signInButonu.click();

        Assert.assertTrue(yasinPage.signOutButonu.isDisplayed());
        extentTest.pass("Sayfaya basarili bir sekilde girildi");


        // 4-)
        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.myAccountButonu);
        executor.executeScript("arguments[0].click();",yasinPage.myAccountButonu);

        Assert.assertTrue(yasinPage.storeManagerButonu.isDisplayed());
        extentTest.info("My Account botununa tiklandi");

        // 5-)
        executor.executeScript("arguments[0].click();",yasinPage.storeManagerButonu);
        extentTest.info("Store Manager butonuna tiklandi");

        // 6-)
        executor.executeScript("arguments[0].click();",yasinPage.couponsButonu);
        extentTest.info("Coupons basligina tiklandi");

        // 7-)
        executor.executeScript("arguments[0].click();",yasinPage.addNewButonu);
        extentTest.info("Add New butonuna tiklandi");
        
    }

    @Test(dependsOnMethods = "testEntry13",priority = 1)
    public void testCouponKoduVerilmeli() {

        // 8-)Code kutusuna kod girilebildigi test edilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.codeBox.sendKeys("135645");

        Assert.assertTrue(yasinPage.codeBox.isEnabled());
        extentTest.pass("Code kutusuna kod girilebildigi goruldu");

    }

    @Test(dependsOnMethods = "testEntry13",priority = 2)
    public void testTanimlamaYazilmali() {

        // 8-) Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.codeBox.sendKeys("135645");


        // 9-) Description kutusuna tanim yazilabildigi gorulur
        executor.executeScript("arguments[0].click();",yasinPage.descriptionBox);
        yasinPage.descriptionBox.sendKeys("leiknaklme");
        Assert.assertTrue(yasinPage.descriptionBox.isEnabled());
        extentTest.pass("Description kutusuna tanim yazilabildigi goruldu");

    }

    @Test(dependsOnMethods = "testEntry13",priority = 3)
    public void testindirimSekliDiscount() {

        // 8-)Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.codeBox.sendKeys("135645");

        // 9-)Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 10-)Discount Type secilebildigi test edilir

        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));
        extentTest.pass("Discount Type secilebildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry13",priority = 4)
    public void testCouponAmount() {

        // 8-)Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 9-)Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 10-)Discount Type secilir
        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));

        // 11-)Coupon Amount kutusuna miktar girilebildigi test edilir
        executor.executeScript("arguments[0].click();",yasinPage.couponAmountBox);
        yasinPage.couponAmountBox.clear();
        yasinPage.couponAmountBox.sendKeys("35");
        

        /* System.out.println(yasinPage.couponAmountBox.getText().toString()); */
        try {
            ReusableMethods.getScreenshot("couponEmauntBox");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.pass("Coupon Amount kutusuna miktar girilebildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry13",priority = 5)
    public void testCouponExpiryDate() throws InterruptedException {

        // 8-)Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 9-)Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 10-)Discount Type secilir

        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));




        // 11-)Coupon Amount kutusuna miktar girilir
        executor.executeScript("arguments[0].click();",yasinPage.couponAmountBox);
        yasinPage.couponAmountBox.clear();
        yasinPage.couponAmountBox.sendKeys("35");

        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.couponExpiryDateBox);
        Thread.sleep(2000);
        
        // 12-)Coupon expiry date kutusuna tarih girilebildigi test edilir
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(yasinPage.couponExpiryDateBox).doubleClick().perform();
        Assert.assertTrue(yasinPage.selectedDay.isEnabled());
        yasinPage.selectedDay.click();
        //executor.executeScript("arguments[0].click();",yasinPage.couponExpiryDateBox);
        //yasinPage.couponExpiryDateBox.sendKeys("2022-10-08");
        //asinPage.onlyDate.click();
        try {
            ReusableMethods.getScreenshot("US_13_TC005");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }  
        extentTest.pass("Coupon expiry date kutusuna tarih girilebildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry13",priority = 6)
    public void testFreeShippingUygulanmali() throws InterruptedException {

        // 8-)Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 9-)Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        // 10-)Discount Type secilir
        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));

        // 11-)Coupon Amount kutusuna miktar girilir
        executor.executeScript("arguments[0].click();",yasinPage.couponAmountBox);
        yasinPage.couponAmountBox.clear();
        yasinPage.couponAmountBox.sendKeys("35");

        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.couponExpiryDateBox);
        Thread.sleep(2000);

        // 12-)Coupon expiry date kutusuna tarih girilir
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(yasinPage.couponExpiryDateBox).doubleClick().perform();
        Assert.assertTrue(yasinPage.selectedDay.isEnabled());
        yasinPage.selectedDay.click();

        // 13-)Allow free shipping kutusuna tiklanilabildigi test edilir
        Assert.assertTrue(yasinPage.allowFreeShippingBox.isEnabled());
        yasinPage.allowFreeShippingBox.click();

        try {
            ReusableMethods.getScreenshot("US_13_TC006");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.pass("Allow free shipping kutusuna tiklanabildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry13",priority = 7)
    public void testShowOnStore() throws InterruptedException {

        // 8-)Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.codeBox.sendKeys("135645");

        // 9-)Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.descriptionBox.sendKeys("leiknaklme");

        // 10-)Discount Type secilir
        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));

        // 11-)Coupon Amount kutusuna miktar girilir
        executor.executeScript("arguments[0].click();",yasinPage.couponAmountBox);
        yasinPage.couponAmountBox.clear();
        yasinPage.couponAmountBox.sendKeys("35");

        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.couponExpiryDateBox);
        Thread.sleep(2000);

        // 12-)Coupon expiry date kutusuna tarih girilir
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(yasinPage.couponExpiryDateBox).doubleClick().perform();
        Assert.assertTrue(yasinPage.selectedDay.isEnabled());
        yasinPage.selectedDay.click();
        Thread.sleep(2000);

        // 13-)Allow free shipping kutusuna tiklanir
        Assert.assertTrue(yasinPage.allowFreeShippingBox.isEnabled());
        yasinPage.allowFreeShippingBox.click();



        // 14-)Show on store kutusuna tiklanilabildigi test edilir
        Assert.assertTrue(yasinPage.showOnStoreBox.isEnabled());
        yasinPage.showOnStoreBox.click();
        try {
            ReusableMethods.getScreenshot("US_13_TC007");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.pass("Show on store kutusuna tiklanabildigi goruldu");

    }
}
