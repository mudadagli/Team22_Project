package tests.yasin.US_14;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.YasinPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;

public class US_14_TC005 {

    //Belirtilen URL' e gidilir
    //Sign In butonuna tiklanir
    //Kullanici bilgileri girilir
    //My Account a tiklanir
    //Store Manager a tiklanir
    //Coupons basligina tiklanir
    //Add New butonuna  tiklanir
    //Code kutusuna miktar yazilir
    //Minimum spend kutusuna miktar girilir
    //Maximum spend kutusuna miktar girilir
    //Individual use only secenegi oldugu görülür
    //Exclude sale items secenegi tiklanır
    //Exclude categories seceneginden bazi kategorilerin seçilebildiği test edilir

    @Test
    public void uS_14_TC005() throws InterruptedException {

        YasinPage yasinPage=new YasinPage();
        JavascriptExecutor executor=(JavascriptExecutor) Driver.getDriver();

        // Belirtilen URL' e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Sign In butonuna tiklanir
        yasinPage.ilkSayfaSignInButonu.click();

        yasinPage.signInUserNameBox.sendKeys("team22.12.10.2022@gmail.com");
        yasinPage.signInPasswordBox.sendKeys("*Team2215381571?");
        yasinPage.signInButonu.click();

        Assert.assertTrue(yasinPage.signOutButonu.isDisplayed());

        //My Account a tiklanir
        executor.executeScript("arguments[0].scrollIntoView(true);",yasinPage.myAccountButonu);
        executor.executeScript("arguments[0].click();",yasinPage.myAccountButonu);

        Assert.assertTrue(yasinPage.storeManagerButonu.isDisplayed());

        // Store Manager a tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.storeManagerButonu);

        //Coupons basligina tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.couponsButonu);

        //Add New butonuna  tiklanir
        executor.executeScript("arguments[0].click();",yasinPage.addNewButonu);

        //Code kutusuna miktar yazilir
        executor.executeScript("arguments[0].click();",yasinPage.codeBox);

        //Minimum spend kutusuna miktar girilir
        yasinPage.minimumSpendBox.sendKeys("1");
        Assert.assertTrue(yasinPage.minimumSpendBox.isEnabled());

        //Maximum spend kutusuna miktar girilir
        yasinPage.maximumSpendBox.sendKeys("99");
        Assert.assertTrue(yasinPage.maximumSpendBox.isEnabled());

        //Individual use only secenegi isaretlenir
        Assert.assertTrue(yasinPage.individualUseOnlyBox.isEnabled());
        //yasinPage.individualUseOnlyBox.click();
        executor.executeScript("arguments[0].click();",yasinPage.individualUseOnlyBox);

        //Exclude sale items secenegi isaretlenir
        Assert.assertTrue(yasinPage.excludeSaleItemsBox.isEnabled());
        executor.executeScript("arguments[0].click();",yasinPage.excludeSaleItemsBox);

        //Exclude categories seceneginden bazi kategorilerin seçilebildiği test edilir
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


    }

}
