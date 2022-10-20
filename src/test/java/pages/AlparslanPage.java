package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AlparslanPage {
    public AlparslanPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//a[@class='login inline-type']")
    public WebElement homePage_SıgnInButton;

    @FindBy (xpath = "//input[@id='username']")
    public WebElement sıgnInPopUp_UsernameTextBox;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement sıgnInPopUp_PasswordTextBox;


    @FindBy (xpath = "//button[@value='Sign In']")
    public WebElement sıgnInPopUp_SıgnInButton;

   @FindBy (xpath = "//a[text()='My Account']")
    public WebElement afterSıgnedIn_MyAccountLink;

   @FindBy (xpath = "//a[@href='https://allovercommerce.com/store-manager/']")
    public WebElement myAccountPage_StoreManagerButton;

     @FindBy (xpath = "(//span[@class='text'])[4]")
    public WebElement storeManagerPage_ProductsButton ;

     @FindBy (xpath = "//tbody/tr/td/a/img")
    public List<WebElement> productsPage_productsList;

     @FindBy (xpath = "//div[text()='Toptan Ürün Gösterme Ayarları']")
     public WebElement productsPage_TopUrunGostermeAyarlar;


    @FindBy (xpath = "//select[@id='piecetype']")
    public WebElement topUrunGayarlar_pieceType;


     @FindBy (xpath = "//input[@id='unitpercart']")
    public WebElement topUrunGayarlar_UnitPerPiece;

    @FindBy (xpath = "//input[@id='minorderqtytr']")
    public WebElement topUrunGayarlar_MinOrderQuantity;

    // @FindBy (xpath = "")
    // public WebElement ;

}
