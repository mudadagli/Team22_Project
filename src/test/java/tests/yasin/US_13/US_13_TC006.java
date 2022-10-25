package tests.yasin.US_13;

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

import java.io.IOException;
import java.util.List;

public class US_13_TC006 {
    @Test
    public void uS_13_TC006() throws InterruptedException {

        /*
    Belirtilen URL' e gidilir
    Sign In butonuna tiklanir
    Kullanici bilgileri girilir
    My Account a tiklanir
    Store Manager a tiklanir
    Coupons basligina tiklanir
    Add New butonuna  tiklanir
    Code kutusuna kupon kodu yazilir
    Description kutusuna tanim yazilir
    Discount Type secilir
    Coupon Amount kutusuna miktar girilir
    Coupon expiry date kutusuna tarih girilir
    Allow free shipping kutusuna tiklanilabildigi test edilir


     */

        YasinPage yasinPage = new YasinPage();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

        // Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Sign In butonuna tiklanir
        yasinPage.ilkSayfaSignInButonu.click();

        yasinPage.signInUserNameBox.sendKeys("team22.12.10.2022@gmail.com");
        yasinPage.signInPasswordBox.sendKeys("*Team2215381571?");
        yasinPage.signInButonu.click();

        Assert.assertTrue(yasinPage.signOutButonu.isDisplayed());

        //My Account a tiklanir
        executor.executeScript("arguments[0].scrollIntoView(true);", yasinPage.myAccountButonu);
        executor.executeScript("arguments[0].click();", yasinPage.myAccountButonu);

        Assert.assertTrue(yasinPage.storeManagerButonu.isDisplayed());

        // Store Manager a tiklanir
        executor.executeScript("arguments[0].click();", yasinPage.storeManagerButonu);

        //Coupons basligina tiklanir
        executor.executeScript("arguments[0].click();", yasinPage.couponsButonu);

        //Add New butonuna  tiklanir
        executor.executeScript("arguments[0].click();", yasinPage.addNewButonu);

        //Code kutusuna kupon kodu yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        //Description kutusuna tanim yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        //Discount Type secilir
        Select select=new Select(yasinPage.discountType);
        List<WebElement> discount=select.getOptions();
        discount.stream().forEach(t->Assert.assertTrue(t.isEnabled()));

        //Coupon Amount kutusuna miktar girilir
        executor.executeScript("arguments[0].click();",yasinPage.couponAmountBox);
        yasinPage.couponAmountBox.clear();
        yasinPage.couponAmountBox.sendKeys("35");

        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.couponExpiryDateBox);
        Thread.sleep(2000);

        //Coupon expiry date kutusuna tarih girilir
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(yasinPage.couponExpiryDateBox).doubleClick().perform();
        Assert.assertTrue(yasinPage.selectedDay.isEnabled());
        yasinPage.selectedDay.click();

        //Allow free shipping kutusuna tiklanilabildigi test edilir
        Assert.assertTrue(yasinPage.allowFreeShippingBox.isEnabled());
        yasinPage.allowFreeShippingBox.click();

        try {
            ReusableMethods.getScreenshot("US_13_TC006");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
