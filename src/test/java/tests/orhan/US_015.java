package tests.orhan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.*;


public class US_015 extends TestBaseReport {


    OrhanPage orhanPage = new OrhanPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();


    @Test
    public void testEntry15(){
        /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Coupons basligina tiklanir
    7- Istenen coupon tiklanir

         */

        extentTest=extentReports.createTest("URL","Web Otomasyon Raporlama");

        //1
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("belirtilen URL'e gidildi");

        //2
        orhanPage.anaSayfaSignInLink.click();
        extentTest.info("Sign in butonuna basildi");

        //3
        orhanPage.signInUsernameBox.sendKeys(ConfigReader.getProperty("userNameOrhan"));
        orhanPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("passwordOrhan"));
        orhanPage.signInButton.click();
        extentTest.pass("Sayfaya basarili sekilde girildi");

        //4
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.myAccountButton);
        jse.executeScript("arguments[0].click();",orhanPage.myAccountButton);
        extentTest.info("'My Account' butonuna tıklandı");

        //5
        orhanPage.storeManagerLink.click();
        extentTest.info("'Store Manager' butonuna tıklandı");

        //6
        orhanPage.cuponsLink.click();
        extentTest.info("'Cupons' basligina tıklandı");

        //7
        orhanPage.couponCodeC005Link.click();
        extentTest.info("Cupon kodu secildi");


    }

    @Test(dependsOnMethods = "testEntry15",priority = 1)
    public void testUsageLimitPerCoupon(){

        /*
    8- Limit sekmesine tiklanir
    9- Usage limit per coupon kutusuna miktar yazilir
    10- Submit butonuna basilir
    11- Submit oldugu test edilir
     */
        //8
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.logOutLink);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        ReusableMethods.waitForVisibility(orhanPage.limitLink,1000);
        jse.executeScript("arguments[0].click();",orhanPage.limitLink);
        extentTest.info("'Limit' butonuna tıklandı");

        //9
        orhanPage.usageLimitPerCouponBox.clear();
        orhanPage.usageLimitPerCouponBox.sendKeys("25");
        extentTest.pass("'Usage Limit' butonuna istenen deger girildi");

        //10
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.cuoponManagerSubmitButton);
        ReusableMethods.waitForVisibility(orhanPage.cuoponManagerSubmitButton,1000);
        jse.executeScript("arguments[0].click();",orhanPage.cuoponManagerSubmitButton);
        extentTest.pass("'Submit' butonuna tıklandı");

        //11
        ReusableMethods.waitForVisibility(orhanPage.successfullyScriptText,1500);
        String expectedText ="Coupon Successfully Published.";
        Assert.assertEquals(orhanPage.successfullyScriptText.getText(),expectedText);
        extentTest.pass("'Coupon Successfully Published' yazisi goruldu");
    }

    @Test(dependsOnMethods = "testEntry15", priority = 2 )
    public void testLimitUsageToXItems(){
    /*
        8- Limit sekmesine tiklanir
        9- Limit usage to X items kutusuna miktar yazilir
        10- Submit butonuna basilir
        11- Submit oldugu test edilir
     */

        ReusableMethods.waitFor(2);

        //8
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.logOutLink);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        ReusableMethods.waitForVisibility(orhanPage.limitLink,1000);
        jse.executeScript("arguments[0].click();",orhanPage.limitLink);
        extentTest.info("'Limit' butonuna tıklandı");


        //9
        orhanPage.limitUsageToXItemsButton.clear();
        orhanPage.limitUsageToXItemsButton.sendKeys("16");
        extentTest.pass("'Usage Limit X' butonuna istenen deger girildi");

        //10
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.cuoponManagerSubmitButton);
        ReusableMethods.waitForVisibility(orhanPage.cuoponManagerSubmitButton,1000);
        jse.executeScript("arguments[0].click();",orhanPage.cuoponManagerSubmitButton);
        extentTest.pass("'Submit' butonuna tıklandı");

        //11
        ReusableMethods.waitForVisibility(orhanPage.successfullyScriptText,1500);
        String expectedText ="Coupon Successfully Published.";
        Assert.assertEquals(orhanPage.successfullyScriptText.getText(),expectedText);
        extentTest.pass("'Coupon Successfully Published' yazisi goruldu");

    }



    @Test(dependsOnMethods = "testEntry15", priority = 3)
    public void testUsageLimitPerUser(){
    /*
    8- Limit sekmesine tiklanir
    9- Usage limit per user kutusuna miktar yazilir
    10- Submit butonuna basilir
    11- Submit oldugu test edilir
     */

        ReusableMethods.waitFor(2);

        //8
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.logOutLink);
        actions.sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).perform();
        ReusableMethods.waitForVisibility(orhanPage.limitLink,1000);
        jse.executeScript("arguments[0].click();",orhanPage.limitLink);
        extentTest.info("'Limit' butonuna tıklandı");

        //9
        orhanPage.usageLimitPerUserBox.clear();
        orhanPage.usageLimitPerUserBox.sendKeys("8");
        extentTest.pass("'Usage Limit per User' butonuna istenen deger girildi");

        //10
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.cuoponManagerSubmitButton);
        ReusableMethods.waitForVisibility(orhanPage.cuoponManagerSubmitButton,1000);
        jse.executeScript("arguments[0].click();",orhanPage.cuoponManagerSubmitButton);
        extentTest.pass("'Submit' butonuna tıklandı");

        //11
        ReusableMethods.waitForVisibility(orhanPage.successfullyScriptText,1500);
        String expectedText ="Coupon Successfully Published.";
        Assert.assertEquals(orhanPage.successfullyScriptText.getText(),expectedText);
        extentTest.pass("'Coupon Successfully Published' yazisi goruldu");
    }


}
