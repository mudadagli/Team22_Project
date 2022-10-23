package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class YasinPage {
    public YasinPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy (xpath = "//span[text()='Sign In']")
    public WebElement ilkSayfaSignInButonu;

    @FindBy (css = "input#username")
    public WebElement signInUserNameBox;

    @FindBy (css = "input#password")
    public WebElement signInPasswordBox;

    @FindBy(css = "button[value='Sign In']")
    public WebElement signInButonu;

    @FindBy (xpath = "//span[text()='Sign Out']")
    public WebElement signOutButonu;

    @FindBy (xpath = "//a[text()='My Account']")
    public WebElement myAccountButonu;

    @FindBy (xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerButonu;

    @FindBy (xpath = "(//span[@class='text'])[6]")
    public WebElement couponsButonu;

    @FindBy (xpath = "//span[text()='Add New']")
    public WebElement addNewButonu;

   // @FindBy (xpath = "//*[@id='title']")
    //public WebElement codeBox;

    @FindBy (css = "input#title")
    public WebElement codeBox;

    @FindBy (css = "textarea#description")
    public WebElement descriptionBox;

    @FindBy (css = "select#discount_type")
    public WebElement discountType;

    @FindBy (css = "input#coupon_amount")
    public WebElement couponAmountBox;

    @FindBy (css = "input#expiry_date")
    public WebElement couponExpiryDateBox;


    @FindBy(xpath = "//a[@data-date='19']")
    public WebElement selectedDay;

    @FindBy (css = "input#free_shipping")
    public WebElement allowFreeShippingBox;

    @FindBy (css = "input#show_on_store")
    public WebElement showOnStoreBox;

    @FindBy(css = "input#minimum_amount")
    public WebElement minimumSpendBox;

    @FindBy(css = "input#maximum_amount")
    public WebElement maximumSpendBox;

    @FindBy (css = "input#individual_use")
    public WebElement individualUseOnlyBox;

    @FindBy (css = "input#exclude_sale_items")
    public WebElement excludeSaleItemsBox;

    @FindBy (css= "select#exclude_product_categories")
    public WebElement excludeCategoriesBox;
}
