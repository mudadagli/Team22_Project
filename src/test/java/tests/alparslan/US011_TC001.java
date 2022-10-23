package tests.alparslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;

import utilities.TestBaseReport;

import java.time.Duration;
import java.util.Random;

public class US011_TC001 extends TestBaseReport {

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
    JavascriptExecutor jse;
    @Test
    public void toptanUrunGostermeUs011TestCase001Test() throws InterruptedException {

        extentTest=extentReports.createTest("Pozitif Test","Satista olan random bir urunun Piece Type, Units Per Piece ve Min Order Quantity ozelliklerinin gorunurlugu test edildi");

        //https://allovercommerce.com/ Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("allovercommerce sitesine gidildi");

        //Sign In butonuna tiklanir
        alparslanPage = new AlparslanPage();
        alparslanPage.homePageSignInButton.click();
        extentTest.info("sign in butonuna basıldı");

        //kullanici adi ve sifre girilir
        alparslanPage.signInPopUpUsernameTextBox.sendKeys("fikeka2419@charav.com");
        alparslanPage.signInPopUpPasswordTextBox.sendKeys("asd123456");
        extentTest.info("Doğru kullanıcı email ve password girildi");

        //Sıgn In butonuna tiklanir
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("PopUp uzerindeki Ikinci sign in butonuna basıldı");

        //My Account butonuna tiklanir
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.afterSignedInMyAccountLink);
        extentTest.info("My account butonuna tiklandi");

        //Store Manager tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(alparslanPage.myAccountPageStoreManagerButton));
        alparslanPage.myAccountPageStoreManagerButton.click();
        extentTest.info("Store Manager butonuna tiklandi");

        //Products tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.storeManagerPageProductsButton);
        extentTest.info("Products butonuna tiklandi");

        //random bir urune tiklanir
        rnd = new Random();
        int randomSayi = rnd.nextInt(alparslanPage.productsPageproductsList.size());

      // jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.productsPage_productsList.get(randomSayi));
        // jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.productsPage_productsList.get(randomSayi));

        jse.executeScript("arguments[0].click();", alparslanPage.productsPageproductsList.get(randomSayi));
        extentTest.info("Random bir urun tiklandi");

        //Toptan Urun Gosterme sekmesine tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.productsPageTopUrunGostermeAyarlar); Thread.sleep(1000);
        extentTest.info("Toptan Urun Gosterme butonuna tiklandi");

        //Piece Type goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarpieceType.isEnabled(),"ToptanUrunGostermeAyarlarinda PieceType dogrulanamadi");
        extentTest.info("Piece Type'in goruntulendigi test edildi");

        //Units Per Piece goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarUnitPerPiece.isEnabled(),"ToptanUrunGostermeAyarlarinda Units Per Piece dogrulanamadi");
        extentTest.info("Units Per Piece'in goruntulendigi test edildi");

        //Min Order Quantity? goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarMinOrderQuantity.isDisplayed(),
                "ToptanUrunGostermeAyarlarinda Min Order Quantity dogrulanamadi");
        extentTest.pass("Min Order Quantity'nin goruntulendigi test edildi ");


    }
}
