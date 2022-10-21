package tests.orhan.US016;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;

public class TC_002 {
    /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Customers a tiklanir
    7- PDF tusuna basilir
    8- Excel tusuna basilir
    9- Csa tusuna basilir
    10- Tum bilgilerin indirildigi test edilir
     */

    OrhanPage orhanPage = new OrhanPage();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testKisilerinTumBilgileri() throws Exception {
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
        orhanPage.pdfButton.click();

        //8
        orhanPage.excelButton.click();

        //9
        orhanPage.csvButton.click();

        //10
        String filePath = "/Users/orhan/Downloads";
        String pdfDocumentName = "Store Manager - Allover Commerce.pdf";
        String excelDocumentName = "Store Manager - Allover Commerce.xlsx";
        String csvDocumentName =  "Store Manager - Allover Commerce.csv";

        ReusableMethods.fileNameWrittenExtensionPDF(filePath,pdfDocumentName);
        ReusableMethods.fileNameWrittenExtensionEXCEL(filePath, excelDocumentName);
        ReusableMethods.fileNameWrittenExtensionCSV(filePath, csvDocumentName);


//        Assert.assertTrue(fileName.equals(pdfDocumentName), "Downloaded file name is not matching with pdf file name");
//        Assert.assertTrue(fileName.equals(excelDocumentName), "Downloaded file name is not matching with excel file name");
//        Assert.assertTrue(fileName.equals(csvDocumentName), "Downloaded file name is not matching with csv file name");
    }
}
