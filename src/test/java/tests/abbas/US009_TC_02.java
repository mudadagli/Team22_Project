package tests.abbas;

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

public class US009_TC_02 {
    @Test
    public void uS009_TC_002() throws InterruptedException, IOException { Driver.getDriver().get(ConfigReader.getProperty("url"));

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

     abbasPage.shippingButton.click();
     abbasPage.weightBox.sendKeys("19");


     actions.sendKeys(Keys.TAB).sendKeys("30").
             sendKeys(Keys.TAB).sendKeys("40").
             sendKeys(Keys.TAB).sendKeys("50").perform();
       //sendKeys(Keys.TAB).sendKeys(Keys.TAB).
            // sendKeys(Keys.ARROW_RIGHT).build().perform();

        Select select=new Select(abbasPage.shippingTimeSelectList);
        List<WebElement> shipping=select.getOptions();
        System.out.println("shipping.size() = " + shipping.size());

        shipping.stream().forEach(t-> System.out.println(t.getText()));
        shipping.stream().forEach(t->Assert.assertTrue(t.isEnabled()));

     Thread.sleep(3000);

     ReusableMethods.getScreenshot("US-009-TC002");

     //github ilk gonderim

    }
}
