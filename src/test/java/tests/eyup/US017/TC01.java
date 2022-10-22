package tests.eyup.US017;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EyupPage;
import utilities.Driver;
import utilities.TestBaseReport;

public class TC01 extends TestBaseReport {


    EyupPage eyupPage=new EyupPage();
    @Test
    public void test01() {

        extentTest=extentReports.createTest("Pozitif Test","Fatura adresine gidebilir");
        //Kullanici "https://allovercommerce.com/"gider
        Driver.getDriver().get("https://allovercommerce.com/");
        extentTest.info("Kullanici https://allovercommerce.com/ adresine gitti");

        //Sign In butonuna tiklanir
        eyupPage.anaSayfaSignInLink.click();
        extentTest.info("Kullanici sign-in linkine tikladi");


        //Kullanici bilgileri girilir ve sign in'e tiklanir.
        eyupPage.signInUsernameBox.sendKeys("team222");
        eyupPage.signInPasswordBox.sendKeys("*Team2215381571?");
        eyupPage.signInButton.click();
        extentTest.info("Kullanici bilgileri girildi ve sign in'e tiklandi");

        //Sign Out a tiklanir
        eyupPage.anaSayfaSignOutLink.click();
        extentTest.info("Sign outa tiklandi");

        //Kullanici "Adres" butonuna tiklar
        eyupPage.vedorAdresButton.click();
        extentTest.info("Kullanici adres butonuna tikladi");


        //Fatura adres sayfasina girildigi dogrulanir.
        Assert.assertTrue(eyupPage.vedorAdresFatureText.isDisplayed());
        extentTest.info("Fatura adres sayfasina girildigi dogrulandi");






    }
}
