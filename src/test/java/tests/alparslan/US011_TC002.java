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
import utilities.TestBaseReport;


import java.time.Duration;
import java.util.Random;

public class US011_TC002 extends TestBaseReport {
    //https://allovercommerce.com/ Url'e gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tiklanir
    //My Account butonuna tiklanir
    //Store Manager tiklanir
    //Products tiklanir
    //Belirtilen urune tiklanir
    //Toptan Urun Gosterme sekmesine tiklanir
    //Piece Type'i Kg secin
    //MUnits Per Piece'e fiyat giriniz
    //Min Order Quantity?'e miktar giriniz
    //Submit tiklanir
    //Product Successfully Published. yazisinin goruntulendigini dogrulayin
    AlparslanPage alparslanPage;
    WebDriverWait wait;
    Random rnd;
    Select select;
    JavascriptExecutor jse;

    @Test
    public void toptanUrunGostermeUs011TestCase002Test() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Test", "Satista olan random bir urunun Piece Type, Units Per Piece ve Min Order Quantity ozelliklerinin etkinligi test edildi ");
        //https://allovercommerce.com/ Url'e gidilir
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("allovercommerce sitesine gidildi");

        //Sign In butonuna tiklanir
        alparslanPage = new AlparslanPage();
        alparslanPage.homePageSignInButton.click();
        extentTest.info("Sıgn In butonuna tiklandi.");

        //kullanici adi ve sifre girilir
        alparslanPage.signInPopUpUsernameTextBox.sendKeys("fikeka2419@charav.com");
        alparslanPage.signInPopUpPasswordTextBox.sendKeys("asd123456");
        extentTest.info("Gecerli kullanici adi ve sifre girildi");

        //Sıgn In butonuna tiklanir
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("Sıgn In butonuna tiklandi");

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

        //Belirtilen urune tiklanir
        rnd = new Random();
        int randomSayi = rnd.nextInt(alparslanPage.productsPageproductsList.size());
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.productsPageproductsList.get(randomSayi));
        jse.executeScript("arguments[0].click();", alparslanPage.productsPageproductsList.get(randomSayi));
        extentTest.info("Random bir urun tiklandi");

        //Toptan Urun Gosterme sekmesine tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.productsPageTopUrunGostermeAyarlar);
        extentTest.info("Toptan Urun Gosterme butonuna tiklandi");

        //Piece Type'i Kg secin
        select = new Select(alparslanPage.topUrunGayarlarpieceType);
        select.selectByValue("Kg");
        Assert.assertTrue(alparslanPage.topUrunGayarlarpieceType.isEnabled());
        extentTest.info("Piece Type olarak Kg secildi ve test edildi");

        //Units Per Piece'e fiyat giriniz
        alparslanPage.topUrunGayarlarUnitPerPiece.clear();
        alparslanPage.topUrunGayarlarUnitPerPiece.sendKeys("15");
        Assert.assertTrue(alparslanPage.topUrunGayarlarUnitPerPiece.isEnabled());
        extentTest.info("Units Per Piece'e fiyat girildi ve test edildi.");

        //Min Order Quantity?'e miktar giriniz
        alparslanPage.topUrunGayarlarMinOrderQuantity.clear();
        alparslanPage.topUrunGayarlarMinOrderQuantity.sendKeys("1");
        Assert.assertTrue(alparslanPage.topUrunGayarlarMinOrderQuantity.isDisplayed());
        extentTest.info("Min Order Quantity'ye random bir miktar yazildi ve test edildi ");

        //Submit tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.topUrunGayarlarSubmitButton);
        jse.executeScript("arguments[0].click();", alparslanPage.topUrunGayarlarSubmitButton);
        extentTest.info("Submint tiklandi");

        //Product Successfully Published. yazisinin goruntulendigini dogrulayin
        String expectedText = "Product Successfully Published.";
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.topUrunGayarlarProductSuccesfullyPublishedText));

        // ***bilgisayar kaynakli bazen hata veriyor. O yuzden yorumda kod satiri yazildi.
        Assert.assertEquals(alparslanPage.topUrunGayarlarProductSuccesfullyPublishedText.getText(), expectedText);
        //Assert.assertTrue(alparslanPage.topUrunGayarlarProductSuccesfullyPublishedText.isDisplayed());
        extentTest.pass("Product Successfully Published. yazisinin goruntulendigi test edildi.");



    }
}
