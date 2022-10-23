package tests.orhan;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class US_016 extends TestBaseReport {


    OrhanPage orhanPage = new OrhanPage();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    Faker faker = new Faker();

    @Test
    public void testEntry16(){
    /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Customers a tiklanir
     */

        extentTest=extentReports.createTest("URL","Web Otomasyon Raporlama");


    //1
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        extentTest.info("belirtilen URL'e gidildi");

    //2
        orhanPage.anaSayfaSignInLink.click();
        extentTest.info("Sign in butonuna basildi");

    //3
        orhanPage.signInUsernameBox.sendKeys(ConfigReader.getProperty("userNameOrhan"));
        orhanPage.signInPasswordBox.sendKeys(ConfigReader.getProperty("passwordOrhan"));
        orhanPage.signInButton.click();
        extentTest.pass("Sayfaya basarili sekilde girildi");

    //4
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.myAccountButton);
        jse.executeScript("arguments[0].click();",orhanPage.myAccountButton);
        extentTest.info("'My Account' butonuna tıklandı");

    //5
        orhanPage.storeManagerLink.click();
        extentTest.info("'Store Manager' butonuna tıklandı");

    //6
        orhanPage.customerLink.click();
        extentTest.info("'Customer' basligina tıklandı");

    }
    @Test(dependsOnMethods = "testEntry16",priority = 1)
    public void testManageCustomers(){
       /*
    7- Name in gorunur oldugu test edilir
    8- Username in  gorunur oldugu test edilir
    9- Email in gorunur oldugu test edilir
    10- Location in gorunur oldugu test edilir
    11- Money Spent in gorunur oldugu test edilir
    12- Last Order in gorunur oldugu test edilir
        */


        //7
        ReusableMethods.waitForVisibility(orhanPage.customerTBodyTable,4000);
        assert orhanPage.customerNamesText.size()!=0;
        extentTest.info("'Customer Names' basliginin gorunur oldugu test edildi");

        //8
        assert orhanPage.customerUserNamesText.size()!=0;
        extentTest.info("'User Name' basliginin gorunur oldugu test edildi");

        //9
        assert orhanPage.customerEmailsText.size()!=0;
        extentTest.info("'Customer Email' basliginin gorunur oldugu test edildi");

        //10
        assert orhanPage.customerLocationsText.size()!=0;
        extentTest.info("'Customer Locations' basliginin gorunur oldugu test edildi");

        //11
        assert orhanPage.customerMoneySpentsText.size()!=0;
        extentTest.info("'Customer Money Spents' basliginin gorunur oldugu test edildi");

        //12
        assert orhanPage.customerOrdersText.size()!=0;
        extentTest.info("'Customer Orders' basliginin gorunur oldugu test edildi");
    }


    @Test(dependsOnMethods = "testEntry16",priority = 2)
    public void testKisilerinTumBilgileri() throws Exception {


        //7
        orhanPage.pdfButton.click();
        extentTest.info("'PDF' butonuna tıklandı");

        //8
        orhanPage.excelButton.click();
        extentTest.info("'Excel' butonuna tıklandı");

        //9
        orhanPage.csvButton.click();
        extentTest.info("'CSV' butonuna tıklandı");

        //10
        String filePath = "/Users/orhan/Downloads";
        String pdfDocumentName = "Store Manager - Allover Commerce.pdf";
        String excelDocumentName = "Store Manager - Allover Commerce.xlsx";
        String csvDocumentName =  "Store Manager - Allover Commerce.csv";

        ReusableMethods.fileNameWrittenExtensionPDF(filePath,pdfDocumentName);
        extentTest.pass("'Store Manager - Allover Commerce.pdf' dosyasinin indigi dogrulandi");
        ReusableMethods.fileNameWrittenExtensionEXCEL(filePath, excelDocumentName);
        extentTest.pass("'Store Manager - Allover Commerce.xlsx' dosyasinin indigi dogrulandi");
        ReusableMethods.fileNameWrittenExtensionCSV(filePath, csvDocumentName);
        extentTest.pass("'Store Manager - Allover Commerce.csv' dosyasinin indigi dogrulandi");


//        Assert.assertTrue(fileName.equals(pdfDocumentName), "Downloaded file name is not matching with pdf file name");
//        Assert.assertTrue(fileName.equals(excelDocumentName), "Downloaded file name is not matching with excel file name");
//        Assert.assertTrue(fileName.equals(csvDocumentName), "Downloaded file name is not matching with csv file name");
    }

    @Test(dependsOnMethods = "testEntry16",priority = 3)
    public void testYeniKisiEklenebilmeli(){

        //7
        orhanPage.addNewCustomerButton.click();
        extentTest.info("'Add New Customer' butonuna tıklandı");

        //8
        orhanPage.userNameBox.sendKeys(faker.internet().uuid());
        extentTest.pass("'User Name' butonuna istenen deger girildi");

        //9
        orhanPage.userEmailBox.sendKeys(faker.internet().emailAddress());
        extentTest.pass("'User Email' butonuna istenen deger girildi");

        //10
        orhanPage.firstNameBox.sendKeys(faker.name().firstName());
        extentTest.pass("'First Name' butonuna istenen deger girildi");

        //11
        orhanPage.lastNameBox.sendKeys(faker.name().lastName());
        extentTest.pass("'Last Name' butonuna istenen deger girildi");

        //12
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.customerSubmitButton);
        ReusableMethods.waitForVisibility(orhanPage.customerSubmitButton,1000);
        jse.executeScript("arguments[0].click();",orhanPage.customerSubmitButton);
        extentTest.pass("'Submit' butonuna tıklandı");

        String expectedText = "Customer Successfully Saved.";
        ReusableMethods.waitForVisibility(orhanPage.customerSuccessllyScriptText,1500);
        Assert.assertEquals(orhanPage.customerSuccessllyScriptText.getText(),expectedText);
        extentTest.pass("'Customer Successfully Saved.' yazisi goruldu");


    }


}
