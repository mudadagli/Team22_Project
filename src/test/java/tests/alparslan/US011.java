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

public class US011 extends TestBaseReport {


    AlparslanPage alparslanPage;
    WebDriverWait wait;
    Random rnd;
    JavascriptExecutor jse;
    Select select;

    @Test
    public void testEntry11() throws InterruptedException {
        //https://allovercommerce.com/ Url'e gidilir
        //Sign In butonuna tiklanir
        //kullanici adi ve sifre girilir
        //Sıgn In butonuna tiklanir
        //My Account butonuna tiklanir
        //Store Manager tiklanir
        //Products tiklanir
        //random bir urune tiklanir

        extentTest = extentReports.createTest("Pozitif Test", "Urun Gosterme ozellikleri");
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
        jse.executeScript("arguments[0].click();", alparslanPage.productsPageproductsList.get(randomSayi));
        extentTest.info("Random bir urun tiklandi");

        //Toptan Urun Gosterme sekmesine tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.productsPageTopUrunGostermeAyarlar);
        Thread.sleep(1000);
        extentTest.info("Toptan Urun Gosterme butonuna tiklandi");
    }

    @Test(dependsOnMethods = "testEntry11", priority = 1)
    public void topUrunGosterme_US011_TC001_Test() throws InterruptedException {

        //Toptan Urun Gosterme sekmesine tiklanir
        //Piece Type goruntulendigini test edin
        //MUnits Per Piece goruntulendigini test edin
        //Min Order Quantity? goruntulendigini test edin

        //Piece Type goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarpieceType.isEnabled(), "ToptanUrunGostermeAyarlarinda PieceType dogrulanamadi");
        extentTest.info("Piece Type'in goruntulendigi test edildi");

        //Units Per Piece goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarUnitPerPiece.isEnabled(), "ToptanUrunGostermeAyarlarinda Units Per Piece dogrulanamadi");
        extentTest.info("Units Per Piece'in goruntulendigi test edildi");

        //Min Order Quantity? goruntulendigini test edin
        Assert.assertTrue(alparslanPage.topUrunGayarlarMinOrderQuantity.isDisplayed(),
                "ToptanUrunGostermeAyarlarinda Min Order Quantity dogrulanamadi");
        extentTest.pass("Min Order Quantity'nin goruntulendigi test edildi ");
    }

    @Test(dependsOnMethods = "testEntry11", priority = 2)
    public void topUrunGosterme_US011_TC002_Test() throws InterruptedException {

        //Piece Type'i Kg secin
        //MUnits Per Piece'e fiyat giriniz
        //Min Order Quantity?'e miktar giriniz
        //Submit tiklanir
        //Product Successfully Published. yazisinin goruntulendigini dogrulayin

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
