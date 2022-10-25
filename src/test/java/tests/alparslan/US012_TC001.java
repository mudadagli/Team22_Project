package tests.alparslan;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlparslanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;


public class US012_TC001 extends TestBaseReport {

    //https://allovercommerce.com/ sayfasina gidilir
    //Sign In butonuna tiklanir
    //kullanici adi ve sifre girilir
    //Sıgn In butonuna tıklanır
    //My Account sayfasi butonuna tiklanir
    //Store Manager tiklanir
    //Orders tiklanir
    //siparislerin goruntulendigi dogrulanir
    //siparislerin sirali oldugu dogrulanir
    AlparslanPage alparslanPage;
    JavascriptExecutor jse;

    @Test
    public void SManagerOlarakHesabımaGidinceTumPortalaAccessEldeEtmeliyimUS012TestCase02Test() throws InterruptedException {

        extentTest=extentReports.createTest("Pozitif Test","siparislerin sirali oldugu test edildi");
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
        extentTest.info("Valid kullanıcı email ve password girildi");

        //Sıgn In butonuna tıklanır
        alparslanPage.signInPopUpSignInButton.click();
        Thread.sleep(2000);
        extentTest.info("PopUp uzerindeki Ikinci sign in butonuna basıldı");

        //My Account sayfasi butonuna tiklanir
        jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].click();", alparslanPage.afterSignedInMyAccountLink);
        extentTest.info("My account butonuna tiklandi");

        //Store Manager tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageStoreManagerButton);
        extentTest.info("Store Manager butonuna tiklandi");

        //Orders tiklanir
        jse.executeScript("arguments[0].click();", alparslanPage.myAccountPageOrdersButton);
        extentTest.info("Orders butonuna tiklandi");

        //siparislerin goruntulendigi dogrulanir
        for (WebElement each : alparslanPage.ordersPageordersList) {
            Assert.assertTrue(each.isDisplayed());
        }
        extentTest.info("Siparislerin goruntulendigi test edildi");

        //siparislerin sirali oldugu dogrulanir
        for (int i = 0; i < alparslanPage.ordersPageordersList.size(); i++) {
            if (i < alparslanPage.ordersPageordersList.size() - 1) {
                Assert.assertTrue(Integer.valueOf(alparslanPage.ordersPageordersList.get(i + 1).getText().replaceAll("\\D", ""))
                                < Integer.valueOf(alparslanPage.ordersPageordersList.get(i).getText().replaceAll("\\D", "")),
                        "Siparisler sirali degil");
            } else break;
        }
        extentTest.pass("siparislerin sırali oldugu test edildi.");


    }
}
