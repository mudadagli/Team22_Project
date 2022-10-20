package tests.orhan.US016;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_001 {
    /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Customers a tiklanir
    7- Name in gorunur oldugu test edilir
    8- Username in  gorunur oldugu test edilir
    9- Email in gorunur oldugu test edilir
    10- Location in gorunur oldugu test edilir
    11- Money Spent in gorunur oldugu test edilir
    12- Last Order in gorunur oldugu test edilir
     */

    OrhanPage orhanPage = new OrhanPage();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    @Test
    public void testManageCustomers(){
        //1
        Driver.getDriver().get(ConfigReader.getProperty("url"));

        //2
        orhanPage.anaSayfaSignInLink.click();

        //3
        orhanPage.signInUsernameBox.sendKeys(ConfigReader.getProperty("userNameOrhan"));
        orhanPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("passwordOrhan"));
        orhanPage.signInButton.click();


        //4
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.myAccountButton);
        jse.executeScript("arguments[0].click();",orhanPage.myAccountButton);


        //5
        orhanPage.storeManagerLink.click();

        //6
        orhanPage.customerLink.click();

        //7
        ReusableMethods.waitForVisibility(orhanPage.customerTBodyTable,4000);
        assert orhanPage.customerNamesText.size()!=0;

        //8
        assert orhanPage.customerUserNamesText.size()!=0;

        //9
        assert orhanPage.customerEmailsText.size()!=0;

        //10
        assert orhanPage.customerLocationsText.size()!=0;

        //11
        assert orhanPage.customerMoneySpentsText.size()!=0;

        //12
        assert orhanPage.customerOrdersText.size()!=0;
    }
}
