package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AbbasPage {

    public AbbasPage() {PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[text()='Sign In']")
    public WebElement ilkSayfaSignInLink;

    @FindBy(css = "input#username")
    public WebElement signInUsernameBox;

    @FindBy(css = "input#password")
    public WebElement signInPasswordBox;

    @FindBy(css="button[value='Sign In']")
    public WebElement signInButton;

    @FindBy(xpath = "//p[text()='WELCOME TO ALLOVER COMMERCE...']")
    public WebElement welcomeText;

    @FindBy (xpath = "//a[text()='My Account']")
    public WebElement myAccountButonu;

    @FindBy(xpath = "//span[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "//a[@href='https://allovercommerce.com/store-manager/']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNewButton;

    @FindBy(xpath = "//h2[text()='Add Product']")
    public WebElement addProductText;

    @FindBy(css = "div#wcfm_products_manage_form_shipping_head")
    public WebElement shippingButton;

    @FindBy(css = "select#_wcfmmp_processing_time")
    public WebElement shippingTimeSelectList;
    @FindBy(css="div.wcfm-tabWrap")
    public WebElement shippingButtonTable;

    @FindBy(css="input#weight")
    public WebElement weightBox;

    @FindBy(xpath = " (//input[@name='wcfm_nonce'])")
    public WebElement submitHiddenElement;

    @FindBy(css = "div#wcfm_products_manage_form_attribute_head")
    public WebElement attributes;

    @FindBy(xpath = "(//span[@title='Toggle Block'])[2]")
    public WebElement attributescolorArrowButton;

    @FindBy(css="select#attributes_value_1")
    public WebElement colorSelect;

    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[2]")
    public WebElement attributesColor;

    @FindBy(xpath = "(//span[@title='Toggle Block'])[3]")
    public WebElement attributesSizeArrowButton;

    @FindBy(css = "select#attributes_value_2")
    public WebElement attributesSize;




}
