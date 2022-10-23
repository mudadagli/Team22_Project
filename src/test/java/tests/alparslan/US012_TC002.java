package tests.alparslan;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class US012_TC002 extends TestBaseReport {

    //https://allovercommerce.com/ sayfasina gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tıklanır
    //My Account sayfası butonuna tıklanir
    //Store Manager tiklanir
    //Orders tiklanir
    //indirimli urun oldugu onaylanir

    AlparslanPage alparslanPage;
    JavascriptExecutor jse;
    WebDriverWait wait;

    @Test
    public void indirimliUrunlerTanimlanmissaIndirimliUrunleriListeliGörebilmeliyimUS012TestCase002() throws InterruptedException {
        extentTest=extentReports.createTest("Pozitif Test","indirimli urun oldugu test edildi");

        //https://allovercommerce.com/ sayfasina gidilir
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

        //Sıgn In butonuna tıklanır
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("PopUp uzerindeki Ikinci sign in butonuna basıldı");

        //My Account sayfasi butonuna tiklanir
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.afterSignedInMyAccountLink);
        extentTest.info("My account butonuna tiklandi");

        //Store Manager tiklanir
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.myAccountPageStoreManagerButton);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageStoreManagerButton);
        extentTest.info("Store Manager butonuna tiklandi");

        //Orders tiklanir
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.afterSignedInMyAccountLink));
        jse.executeScript("arguments[0].scrollIntoView(true);", alparslanPage.afterSignedInMyAccountLink);
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //indirimli urun oldugu onaylanir
        List<WebElement> tableUrunler;
        String indirimliUrun = "";
        wait.until(ExpectedConditions.visibilityOf(alparslanPage.storeManagerPageProductsButton));
        jse.executeScript("arguments[0].click();", alparslanPage.storeManagerPageProductsButton);

        wait.until(ExpectedConditions.visibilityOf(alparslanPage.productsPagetable));
        for (int i = 1; i < alparslanPage.productsPageproductsList.size() + 1; i++) {
            tableUrunler = Driver.getDriver().findElements(By.xpath("//tbody/tr[" + i + "]/td//bdi"));

            if (tableUrunler.size() > 1) {
                indirimliUrun = Driver.getDriver().findElement(By.xpath("//tbody/tr[" + i + "]/td[" + i + "]")).getText();

            }
        }

        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        List<String> purchasedItems = new ArrayList<>();
        for (WebElement each : alparslanPage.ordersTablepurchasedList
        ) {
            purchasedItems.add(each.getText().substring(2));
        }

        Assert.assertTrue(purchasedItems.contains(indirimliUrun), "indirimli ürün görüntülenemedi");
        extentTest.pass("Indirimli urun oldugu test edildi");

    }
}
