package tests.orhan.US015;

import io.opentelemetry.sdk.autoconfigure.spi.ConfigProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;

public class TC_001 {
    /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Coupons basligina tiklanir
    7- Istenen coupon tiklanir
    8- Limit sekmesine tiklanir
    9- Usage limit per coupon kutusuna miktar yazilir
    10- Submit butonuna basilir
    11- Submit oldugu test edilir
     */

    OrhanPage orhanPage = new OrhanPage();

    Actions actions = new Actions(Driver.getDriver());
    @Test
    public void testUsageLimitPerCoupon(){

        //1
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //2
        orhanPage.anaSayfaSignInLink.click();

        //3
        orhanPage.signInUsernameBox.sendKeys(ConfigReader.getProperty("userNameOrhan"));
        orhanPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("passwordOrhan"));
        orhanPage.signInButton.click();


        //4
        orhanPage.anaSayfaSignOutLink.click();


        //5
        orhanPage.storeManagerLink.click();

        //6
        orhanPage.cuponsLink.click();

        //7
        orhanPage.couponCodeC005Link.click();

        //8
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.limitLink);
        ReusableMethods.waitFor(2000);
        orhanPage.limitText.click();


        //9
        orhanPage.usageLimitPerCouponBox.sendKeys("44");

        //10
        orhanPage.cuoponManagerSubmitButton.click();

        //11
//        String expectedText ="Coupon Successfully Published.";
        assert orhanPage.successfullyScriptText.isDisplayed();
    }
}
