package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AslanPage {
    public AslanPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[@class='w-icon-account']")
    public WebElement singButon;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement usarName;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='login logout inline-type']")
    public WebElement singOut;

    @FindBy(xpath = "//*[@id=\"menu-item-1079\"]/a[text()='My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement products;

    @FindBy(xpath = "(//*[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "(//*[@class='wcfm_title wcfm_full_ele'])[2]")
    public WebElement brands;


    @FindBy(xpath = "(//*[text()='Elegant Auto Group'])[1]")
    public WebElement eleganntAutoGroup;

    @FindBy(xpath = "(//*[@name='product_custom_taxonomies[product_brand][]'])[11]")
    public WebElement eleganntAutoGroup2;

    @FindBy(xpath = "(//*[text()='Green Grass'])[1]")
    public WebElement greenGrass;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[16]")
    public WebElement greenGrass2;


    @FindBy(xpath = "(//*[text()='Node Js'])[1]")
    public WebElement nodeJs;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[30]")
    public WebElement nodeJs2;

    @FindBy(xpath = "(//*[text()='NS8'])[1]")
    public WebElement ns8;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[33]")
    public WebElement ns82;

    @FindBy(xpath = "(//*[text()='RED'])[1]")
    public WebElement red;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[37]")
    public WebElement red2;

    @FindBy(xpath = "(//*[text()='Skysuite Tech'])[1]")
    public WebElement skysuitTech;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[44]")
    public WebElement skysuitTech2;

    @FindBy(xpath = "(//*[text()='Sterling'])[1]")
    public WebElement sterling;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_brand '])[46]")
    public WebElement sterling2;


    // US008 ile ilgili lokeytler:


    @FindBy(xpath = "(//*[text()='Manage Stock?'])[1]")
    public WebElement manegeStock;

    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement manegetStockButton;

    @FindBy(xpath = "(//*[text()='Stock Qty'])[1]")
    public WebElement stockQty;
    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQtyGiris;

    @FindBy(xpath = "(//*[text()='Allow Backorders?'])[1]")
    public WebElement allowBackorders;

    @FindBy(xpath = "//*[@name='backorders']")//*[@id='backorders']
    public WebElement allowGiris;

    @FindBy(xpath = "(//*[text()='Do not Allow'])[1]")
    public WebElement doNotAllowWE;

    @FindBy(xpath = "(//*[text()='Allow'])[1]")
    public WebElement allowWE;

        @FindBy(xpath = "(//*[text()='Allow, but notify customer'])[1]")
    public WebElement allowButWE;
}