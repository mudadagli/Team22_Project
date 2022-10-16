package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class OrhanPage {

    public OrhanPage() {
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
}
