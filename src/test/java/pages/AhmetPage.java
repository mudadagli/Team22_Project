package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AhmetPage {
    public AhmetPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement anaSayfaSignInLink;//anasayfa

    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInUsernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement signInPasswordBox;

    @FindBy(xpath = "(//*[text()='Sign In'])[2]")
    public WebElement signInOnayButton;

    @FindBy(xpath = "(//a[@href='https://allovercommerce.com/my-account-2/'])[2]")
    public WebElement myAccountLink;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public WebElement ordersLink;
    @FindBy(xpath = "//*[text()='Go Shop']")
    public WebElement goShopButton;
    @FindBy(xpath = "//li[text()='Shop']")
    public WebElement shopLabelProductPage;

    @FindBy(xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement addCart;

    @FindBy(xpath ="(//*[@class='cart-count'])[1]")
    public WebElement cardCountLink;

    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/cart/'])[1]")
    public WebElement cardLink;

    @FindBy(xpath ="//a[@href='https://allovercommerce.com/checkout-2/']")
    public WebElement checkoutLink;
    @FindBy(xpath ="//*[.='Billing details']")
    public WebElement billingText;

    @FindBy(xpath ="//input[@id='billing_first_name']")
    public WebElement billFirstNameBox;

    @FindBy(xpath ="//input[@id='billing_last_name']")
    public WebElement billLastNameBox;

    @FindBy(xpath ="//*[@id='select2-billing_country-container']")
    public WebElement billCountryDropBox;

    @FindBy(xpath ="//a[.='View cart']")
    public WebElement viewCartLink;

    @FindBy(xpath ="//*[@id='billing_address_1']")
    public WebElement billStreetBox;

    @FindBy(xpath ="//input[@id='billing_postcode']")
    public WebElement billPostCodeBox;

    @FindBy(xpath ="//input[@id='billing_city']")
    public WebElement billTownCityBox;

    @FindBy(xpath ="//input[@class='select2-search__field']")
    public WebElement billProvinceDropBox;

    @FindBy(xpath ="//input[@id='billing_phone']")
    public WebElement billPhoneBox;

    @FindBy(xpath ="//input[@id='billing_email']")
    public WebElement billEmailBox;

    @FindBy(xpath ="//input[@id='payment_method_cod']")
    public WebElement billPaymentRadioButton;

    @FindBy(id ="place_order")
    public WebElement billPlaceOrderButton;

    @FindBy(xpath = "//*[.='Thank you. Your order has been received.']")
    public WebElement thankYouText;

    @FindBy(xpath ="//*[@id='calc_shipping_country']")
    public WebElement shipCountryDropBox;

    @FindBy(xpath ="//input[@class='select2-search__field']")
    public WebElement shipCountryDropTextBox;

    @FindBy(xpath ="//*[@id='calc_shipping_city']")
    public WebElement shipStateDropBox;

    @FindBy(xpath ="//input[@class='select2-search__field']")
    public WebElement shipStateDropTextBox;

    @FindBy(xpath ="//*[@id='calc_shipping_state']")
    public WebElement shipCityDropBox;

    @FindBy(xpath ="//*[@id='calc_shipping_postcode']")
    public WebElement shipPostCodeBox;

    @FindBy(xpath ="(//*[.='46500 Afsin Kahramanmaraş, Turkey'])[1]")
    public WebElement shipAdresText;


    @FindBy(xpath ="//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedtoCheckoutButton;

    @FindBy(xpath ="//*[.='Apply coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath ="(//*[.='Update Totals'])[2]")
    public WebElement updateTotalButton;

    @FindBy(xpath ="(//a[@href='https://allovercommerce.com/shop/'])[1]")
    public WebElement continueShoppingLink;

    @FindBy(xpath ="//*[@class='btn btn-rounded btn-outline btn-default btn-border-thin mb-4 ml-2 mr-2 clear-cart-button']")
    public WebElement clearCartButton;

    @FindBy(xpath ="//*[text()='Update cart']")
    public WebElement updateCartButton;

    @FindBy(xpath ="//button[@class='quantity-plus w-icon-plus']")
    public WebElement productplusButton;

    @FindBy(xpath ="(//*[@class='quantity-minus w-icon-minus'])[1]")
    public WebElement productMinusButton;

    @FindBy(xpath ="//*[.='Checkout']")
    public WebElement cartCheckOutLink;

    @FindBy(xpath ="(//*[@class='woocommerce-Price-amount amount'])[8]")
    public WebElement productPriceAlani;

    @FindBy(xpath ="(//*[@class='input-text qty text'])[1]")
    public WebElement productQuantityAlani;

    @FindBy(xpath ="(//*[@class='input-text qty text'])[2]")
    public WebElement productQuantityAlani2;
    @FindBy(xpath ="(//*[@class='product-subtotal'])[2]")
    public WebElement productSubtotalAlani;

    @FindBy(xpath ="(//*[@class='product-subtotal'])[3]")
    public WebElement productSubtotalAlani2;

    @FindBy(xpath ="//input[@id='quantity_635107facf9e1']")
    public WebElement productQuantityBox;

    @FindBy(xpath ="(//*[@class='woocommerce-Price-amount amount'])[22]")
    public WebElement totalLabel;

    @FindBy(xpath ="(//*[@class='woocommerce-shipping-destination'])[1]")
    public WebElement shippingLabel;

    @FindBy(xpath ="//*[@class='cart-empty woocommerce-info']")
    public WebElement cartEmptyLabel;
}
