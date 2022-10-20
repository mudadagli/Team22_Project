package tests.orhan.US016;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrhanPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC_003 {
    /*
    1- Belirtilen URL' e gidilir
    2- Sign In butonuna tiklanir
    3- Kullanici bilgileri girilir
    4- My Account a tiklanir
    5- Store Manager a tiklanir
    6- Customers a tiklanir
    7- Add New butonuna tiklanir
    8- Username  kutusuna kullanici adi yazilir
    9- Email kutusuna email adresi yazilir
    10- First Name kutusuna isim yazilir
    11- Last Name kutusuna soy isim yazilir
    12- Yeni kisi eklenebildigi test edilir
     */

    OrhanPage orhanPage = new OrhanPage();

    Faker faker = new Faker();

    JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

    @Test
    public void testYeniKisiEklenebilmeli(){
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
        orhanPage.addNewCustomerButton.click();

        //8
        orhanPage.userNameBox.sendKeys(faker.internet().uuid());

        //9
        orhanPage.userEmailBox.sendKeys(faker.internet().emailAddress());

        //10
        orhanPage.firstNameBox.sendKeys(faker.name().firstName());

        //11
        orhanPage.lastNameBox.sendKeys(faker.name().lastName());

        //12
        jse.executeScript("arguments[0].scrollIntoView(true);",orhanPage.customerSubmitButton);
        ReusableMethods.waitForVisibility(orhanPage.customerSubmitButton,1000);
        jse.executeScript("arguments[0].click();",orhanPage.customerSubmitButton);

        String expectedText = "Customer Successfully Saved.";
        ReusableMethods.waitForVisibility(orhanPage.customerSuccessllyScriptText,1500);
        Assert.assertEquals(orhanPage.customerSuccessllyScriptText.getText(),expectedText);


    }
}
