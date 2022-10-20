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

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement homePageSignInButton;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInPopUpUsernameTextBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signInPopUpPasswordTextBox;

    @FindBy(xpath = "//button[@value='Sign In']")
    public WebElement signInPopUpSignInButton;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement afterSignedInMyAccountLink;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/store-manager/']")
    public WebElement myAccountPageStoreManagerButton;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement storeManagerPageProductsButton;

    @FindBy(xpath = "//tbody/tr/td/a/img")
    public List<WebElement> productsPageproductsList;

    @FindBy(xpath = "//div[text()='Toptan Ürün Gösterme Ayarları']")
    public WebElement productsPageTopUrunGostermeAyarlar;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement topUrunGayarlarpieceType;

    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement topUrunGayarlarUnitPerPiece;

    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement topUrunGayarlarMinOrderQuantity;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement topUrunGayarlarSubmitButton;

    @FindBy(xpath = "//*[contains(text(),'Product Successfully Published.')]")
    public WebElement topUrunGayarlarProductSuccesfullyPublishedText;


    @FindBy(xpath = "(//span[@class='text'])[5]")
    public WebElement myAccountPageOrdersButton;

    @FindBy(xpath = "//tbody/tr/td[2]/a[@class='wcfm_order_title']")
    public List<WebElement> ordersPageordersList;


    @FindBy(xpath = "//tbody/tr/td[3]/div[@class='order_items order_items_visible']")
    public List<WebElement> ordersTablepurchasedList;

    @FindBy(xpath = "//tbody")
    public WebElement productsPagetable;

    @FindBy(xpath = "//tbody/tr/td[4]/div[@style='text-align:left;']")
    public List<WebElement> ordersPageBillingAdresses;

    @FindBy(xpath = "//tbody/tr/td[4]/div[@style='text-align:left;']")
    public List<WebElement> ordersPageShippingAdresses;

    @FindBy(xpath = "(//span[@class='text'])[9]")
    public WebElement storeManagerPageSettingsButton;

    @FindBy(xpath = "//input[@id='store_email']")
    public WebElement settingsPagestoreEmailTextBox;

    @FindBy(xpath = "//input[@name='save-data']")
    public WebElement settingPageStoreSaveButton;

    @FindBy(xpath = "//div[text()='Settings saved successfully']")
    public WebElement settingPageSettingsSavedSuccessfully_Text;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[3]")
    public WebElement settingPagePaymentButton;

    @FindBy(xpath = "//div[@id='wcfm_settings_form_payment_expander']")
    public WebElement settingPagePaymentHesapBilgisi;

    @FindBy(xpath = "//select[@id='payment_mode']")
    public WebElement settingPagePaymentPaymentMethod;

    @FindBy(xpath = "//input[@id='wcfm_settings_save_button']")
    public WebElement settingPagePaymentSaveButton;

    @FindBy(xpath = "//input[@id='ac_name']")
    public WebElement settingPagePaymentAccountName;

    @FindBy(xpath = "//input[@id='ac_number']")
    public WebElement settingPagePaymentAccNumberTextBox;

    @FindBy(xpath = "//input[@id='bank_name']")
    public WebElement settingPagePaymentBankNameTextBox;

    @FindBy(xpath = "//input[@id='bank_addr']")
    public WebElement settingPagePaymentBankAdressTextBox;

    @FindBy(xpath = "//input[@id='routing_number']")
    public WebElement settingPagePaymentRoutingNumberTextBox;

    @FindBy(xpath = "//input[@id='iban']")
    public WebElement settingPagePaymentIBANTextBox;

    @FindBy(xpath = "//input[@id='swift']")
    public WebElement settingPagePaymentSwiftCodeTextBox;

    @FindBy(xpath = "//input[@id='ifsc']")
    public WebElement settingPagePaymentIFSCcodeTextBox;

   
    
    
    
    
    
    
    

}
