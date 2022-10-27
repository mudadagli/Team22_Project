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

public class US014 extends TestBaseReport {

    YasinPage yasinPage = new YasinPage();

    Actions actions = new Actions(Driver.getDriver());

    JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testEntry14() {

        /*
        Belirtilen URL' e gidilir
        Sign In butonuna tiklanir
        Kullanici bilgileri girilir
        My Account a tiklanir
        Store Manager a tiklanir
        Coupons basligina tiklanir
        Add New butonuna  tiklanir
        Code kutusuna miktar yazilir 
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

        // 8-) 
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);
        yasinPage.codeBox.sendKeys("135645");
        extentTest.pass("Code kutusuna miktar yazildi");
    }

    @Test(dependsOnMethods = "testEntry14",priority = 1)
    public void testMinimumSpend() {

        // 9-)Minimum spend kutusuna miktar girilebildiği test edilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());
        extentTest.pass("Minimum spend kutusuna miktar girilebildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry14",priority = 2)
    public void testMaximumSpend() {

        // 9-)Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        // 10-)Maximum spend kutusuna miktar girilebildiği test edilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());
        extentTest.pass("Maximum spend kutusuna miktar girilebildigi goruldu");
    }

    @Test(dependsOnMethods = "testEntry14",priority = 3)
    public void testIndividualUseOnly() {

        // 9-)Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        // 10-)Maximum spend kutusuna miktar girilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());

        // 11-)Individual use only secenegi oldugu  test edilir
        Assert.assertTrue(yasinPage.individualUseOnlyBox.isEnabled());
        //yasinPage.individualUseOnlyBox.click();
        executor.executeScript("arguments[0].click();",yasinPage.individualUseOnlyBox);
        extentTest.pass("Individual use only secenegi oldugu  test edildi");
    }

    @Test(dependsOnMethods = "testEntry14",priority = 4)
    public void testExcludeSaleItems() {

        // 9-)Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        // 10-)Maximum spend kutusuna miktar girilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());

        // 11-)Individual use only secenegi isaretlenir
        Assert.assertTrue(yasinPage.individualUseOnlyBox.isEnabled());
        //yasinPage.individualUseOnlyBox.click();
        executor.executeScript("arguments[0].click();",yasinPage.individualUseOnlyBox);

        // 12-)Exclude sale items secenegi tiklanabildigi test edilir
        Assert.assertTrue(yasinPage.excludeSaleItemsBox.isEnabled());
        executor.executeScript("arguments[0].click();",yasinPage.excludeSaleItemsBox);
        extentTest.pass("Exclude sale items secenegi tiklanabildigi test edildi");

    }

    @Test(dependsOnMethods = "testEntry14",priority = 5)
    public void testExcludeCategories() throws InterruptedException {

        // 9-)Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        // 10-)Maximum spend kutusuna miktar girilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());

        // 11-)Individual use only secenegi isaretlenir
        Assert.assertTrue(yasinPage.individualUseOnlyBox.isEnabled());
        //yasinPage.individualUseOnlyBox.click();
        executor.executeScript("arguments[0].click();",yasinPage.individualUseOnlyBox);

        // 12-)Exclude sale items secenegi isaretlenir
        Assert.assertTrue(yasinPage.excludeSaleItemsBox.isEnabled());
        executor.executeScript("arguments[0].click();",yasinPage.excludeSaleItemsBox);

        // 13-)Exclude categories seceneginden bazi kategorilerin seçilebildiği test edilir
        Select select=new Select(yasinPage.excludeCategoriesBox);
        List<WebElement> excludeCategories=select.getOptions();
        System.out.println(excludeCategories.size());
        excludeCategories.stream().forEach(t->Assert.assertTrue(t.isEnabled()));
        Thread.sleep(3000);
        excludeCategories.stream().forEach(t->t.click());
        try {
            ReusableMethods.getScreenshot("US_14_TC005");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extentTest.pass("Exclude categories seceneginden bazi kategorilerin seçilebildiği test edildi");

    }
}
