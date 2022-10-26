package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EyupPage {
    public EyupPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Register']")
    public WebElement anaSayfaRegisterLink;

    @FindBy(xpath = "//a[@href='mailto:info@allovercommerce.com']")
    public WebElement anaSayfaInfoMailLink;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendorLink;

    @FindBy(xpath = "//h2[text()='Vendor Registration']")
    public WebElement vendorRegText;

    @FindBy(xpath = "(//*[text()='Email'])[1]")
    public WebElement vendorRegEmailText;

    @FindBy(xpath = "(//*[text()='Password'])[1]")
    public WebElement vendorRegPasswordText;

    @FindBy(xpath = "(//*[text()='Confirm Password'])[1]")
    public WebElement vendorRegConfirmPasswordText;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement vendorRegEmailBox;

    @FindBy(xpath = "//span[@id='email']")
    public WebElement fakeEmailBox;

    @FindBy(xpath = "(//*[text()='Allover Commerce '])[1]")
    public WebElement fakeEmailGelen;

    @FindBy(xpath = "//span[@id='predmet']")
    public WebElement fakeEmailGelenCod;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_input']")
    public WebElement vendorRegCodeBox;

    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-success']")
    public WebElement vendorRegCodeUyariText;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement vendorRegPasswordBox;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement vendorRegConfirmPasswordBox;

    @FindBy(xpath = "//*[@id='wcfm_membership_register_button']")
    public WebElement vendorRegisterButton;

    @FindBy(xpath = "//*[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement vendorRegMailUyariText;

    @FindBy(xpath = "//*[text()='Welcome to Allover Commerce!']")
    public WebElement vendorRegOnayText;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-error']")
    public WebElement vendorRegMailUniceUyariText;

    @FindBy(xpath = "//*[@id='password_strength']")
    public WebElement vendorRegPasswordUyariText;

    @FindBy(xpath = "//*[text()='Password and Confirm-password are not same.']")
    public WebElement vendorRegPasswordUyari2Text;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement anaSayfaSignInLink;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signUpUsernameBox;

    @FindBy(xpath = "//input[@id='reg_email']")
    public WebElement signUpMailBox;

    @FindBy(xpath = "//input[@id='reg_password']")
    public WebElement signUpPasswordBox;

    @FindBy(xpath = "//button[text()='Sign Up']")
    public WebElement signUpOnayButton;





    @FindBy (css = "#username")
    public WebElement signInUsernameBox;

    @FindBy (css = "#password")
    public WebElement signInPasswordBox;

    @FindBy (xpath = "//button[@name='login']")
    public WebElement signInButton;

    @FindBy (xpath = "//*[text()='Sign Out']")
    public WebElement anaSayfaSignOutLink;

    @FindBy (xpath = "//a[text()='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "//*[@class='wcfmfa fa-gift']")
    public WebElement cuponsLink;

    @FindBy(xpath = "//a[text()='C_005']")
    public WebElement couponCodeC005Link;

    @FindBy(xpath = "//*[text()='Limit']")
    public WebElement limitText;

    @FindBy(xpath = "//div[@class='page_collapsible collapse-close collapse-open']")
    public WebElement limitLink;

    @FindBy (css = "#usage_limit")
    public WebElement usageLimitPerCouponBox;

    @FindBy(css = "#wcfm_coupon_manager_submit_button")
    public WebElement cuoponManagerSubmitButton;

    @FindBy (xpath = "//*[@id='wcfm_coupons_manage_js-js-extra']")
    public WebElement successfullyScriptText;


    //eyup
    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement vedorAdresButton;


    @FindBy(xpath = "//*[text()='Billing address']")
    public WebElement vedorAdresFatureText;

    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[1]")
    public WebElement vedorAdresDuzenlemeButton;

    @FindBy(xpath = "//*[@name='billing_first_name']")
    public WebElement vedorFaturaAdresFirstnameButton;

    @FindBy(xpath = "//*[text()='Billing address']")
    public WebElement vedorFaturaAdresCountrySelect;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement vedorFaturaAdres1Button;

    @FindBy(xpath = "//*[text()='Shipping address']")
    public WebElement vedorShippingaddressText;

    @FindBy(xpath = "(//*[@class='edit btn btn-link btn-primary btn-underline mb-4'])[2]")
    public WebElement vendorShippingAddressDuzenleButton;

    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement vendorShippingfirstNameBox;

    @FindBy(xpath = "//*[@id='shipping_address_1']")
    public WebElement vendorShippingAdress1Box;

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement vendorMyAccountText;

    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")
    public WebElement vendorStoreManegerText;

    @FindBy(xpath = "(//*[@class='text'])[8]")
    public WebElement vendorRefundButton;

    @FindBy(xpath = "(//*[@class='sorting_disabled'])[1]")
    public WebElement vendorRequestIdText;

    @FindBy(xpath = "(//*[@class='sorting_disabled'])[2]")
    public WebElement vendorOrderIdText;

    @FindBy(xpath = "(//*[@class='sorting_disabled'])[2]")
    public WebElement vendorAmountText;

    @FindBy(xpath = "(//*[@class='sorting_disabled'])[4]")
    public WebElement vendorTypeText;


    @FindBy(xpath = "(//*[@class='sorting_disabled'])[5]")
    public WebElement vendorReasonText;

    @FindBy(xpath = "//*[text()='Edit Your Shipping Address']")
    public WebElement editYourShippingAddressLink;

    @FindBy(xpath = "//*[@id='shipping_first_name']")
    public WebElement shippingfirstnameBox;

    @FindBy (xpath = "//*[@id=\"menu-item-1079\"]/a[text()='My Account']")
    public WebElement myAccountButton;





}
