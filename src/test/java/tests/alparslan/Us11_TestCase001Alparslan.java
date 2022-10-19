package tests.alparslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.Random;

public class Us11_TestCase001Alparslan {

    //  UserStory11_TestCase001

    //https://allovercommerce.com/ Url'e gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tiklanir
    //My Account butonuna tiklanir
    //Store Manager tiklanir
    //Products tiklanir
    //random bir urune tiklanir
    //Toptan Urun Gosterme sekmesine tiklanir
    //Piece Type goruntulendigini test edin
    //MUnits Per Piece goruntulendigini test edin
    //Min Order Quantity? goruntulendigini test edin


    AlparslanPage alparslanPage;
    WebDriverWait wait;
    Random rnd;

    @Test
    public void toptanUrunGostermeUs011TestCase001Test() throws InterruptedException {

        //https://allovercommerce.com/ Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //Sign In butonuna tiklanir
        alparslanPage = new AlparslanPage();
        alparslanPage.homePage_SıgnInButton.click();

        //kullanici adi ve sifre girilir
        alparslanPage.sıgnInPopUp_UsernameTextBox.sendKeys("fikeka2419@charav.com");
        alparslanPage.sıgnInPopUp_PasswordTextBox.sendKeys("asd123456");

        //Sıgn In butonuna tiklanir
        alparslanPage.sıgnInPopUp_SıgnInButton.click();
        Thread.sleep(2000);

        //My Account butonuna tiklanir
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSıgnedIn_MyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.afterSıgnedIn_MyAccountLink);


        //Store Manager tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(alparslanPage.myAccountPage_StoreManagerButton));
        alparslanPage.myAccountPage_StoreManagerButton.click();

        //Products tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.storeManagerPage_ProductsButton);

        //random bir urune tiklanir
        rnd = new Random();
        int randomSayi = rnd.nextInt(alparslanPage.productsPage_productsList.size());
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.productsPage_productsList.get(randomSayi));
        jse.executeScript("arguments[0].click();", alparslanPage.productsPage_productsList.get(randomSayi));

        //Toptan Urun Gosterme sekmesine tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.productsPage_TopUrunGostermeAyarlar);
        Thread.sleep(1000);

        //Piece Type goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlar_pieceType.isEnabled(),"ToptanUrunGostermeAyarlarinda PieceType dogrulanamadi");

        //Units Per Piece goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlar_UnitPerPiece.isEnabled(),"ToptanUrunGostermeAyarlarinda Units Per Piece dogrulanamadi");

        //Min Order Quantity? goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlar_MinOrderQuantity.isDisplayed(),"ToptanUrunGostermeAyarlarinda Min Order Quantity? dogrulanamadi");

    }
}
