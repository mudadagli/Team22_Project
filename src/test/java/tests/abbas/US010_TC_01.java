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

import java.io.IOException;
import java.util.List;

public class US010_TC_01 {
    @Test
    public void uS010_TC_01() throws InterruptedException, IOException {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        // Assert.assertTrue();
        AbbasPage abbasPage=new AbbasPage();
        Actions actions=new Actions(Driver.getDriver());
        JavascriptExecutor executor=(JavascriptExecutor)Driver.getDriver();

        abbasPage.ilkSayfaSignInLink.click(); //sag ust kosede bulunan sign in bolumune tikladik

        Thread.sleep(3000);

        Assert.assertTrue(abbasPage.signInUsernameBox.isDisplayed());//sign in kutucugu gorundu mu

        abbasPage.signInUsernameBox.sendKeys("team22.12.10.2022@gmail.com");//acilan kutucuktaki username bolumune isim gonderdik

        abbasPage.signInPasswordBox.sendKeys("*Team2215381571?");// yine acilan bolumdeki password kismina sifremizi gonderdik

        abbasPage.signInButton.sendKeys(Keys.ENTER);// kutucugun alt kismindaki sign in butonuna tikladik

        Assert.assertTrue(abbasPage.signOut.isDisplayed());//ana sayfaya dogru bir sekilde girdigimizi sorguladik

        abbasPage.signOut.click();

        abbasPage.storeManager.click();

        executor.executeScript("arguments[0].click();",abbasPage.products);//products'a tikladik

        executor.executeScript("arguments[0].scrollIntoView(true);",abbasPage.addNewButton);// sayfayi add new gorunene kadar asagi kaydirdik

        abbasPage.addNewButton.click();

        Assert.assertTrue(abbasPage.addProductText.isDisplayed());



        executor.executeScript("arguments[0].scrollIntoView(true)",abbasPage.shippingButtonTable);

        Thread.sleep(3000);

        abbasPage.attributes.click();
        abbasPage.attributescolorArrowButton.click();
        Thread.sleep(3000);
        abbasPage.attributesColor.click();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_RIGHT).build().perform();

        Thread.sleep(2000);
        ReusableMethods.getScreenshot("US010_TC_01");


    }


}
