package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class muhammedPage {

    public muhammedPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='My Account'])[2]")

    public WebElement MyCount;


    @FindBy(xpath = " (//*[@class='woocommerce-Input woocommerce-Input--text input-text'])[1]")

    public WebElement UsernameORemailAddress;

    @FindBy(xpath = "//*[@value='Sign In']")

    public WebElement signinButton;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "(//*[text()='Store Manager'])[1]")

    public WebElement storeManagerText;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")

    public WebElement productLink;

    @FindBy(xpath = "(//*[@class=\"select2-selection__rendered\"])[1]")

    public WebElement showAllProductBrands;

    @FindBy(xpath = "(//*[@class=\"sorting_disabled\"])[3]")

    public WebElement statusText;

    @FindBy(xpath = "(//*[@class=\"sorting_disabled\"])[4]")

    public WebElement stockText;

    @FindBy(xpath = "(//*[@class=\"sorting\"])[2]")

    public WebElement priceText;

    @FindBy(xpath = "(//*[@class=\"sorting\"])[4]")

    public WebElement dateText;


    @FindBy(xpath = "(//*[@class=\"wcfmfa fa-cube\"])[3]")
    public WebElement addNewtLink;

    @FindBy(xpath = "//*[@class=\"wcfm-checkbox wcfm_ele wcfm_half_ele_checkbox simple appointment non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card\"]")
    public WebElement downloadableText;

    @FindBy(xpath = "//*[@class=\"wcfm-checkbox wcfm_ele wcfm_half_ele_checkbox simple appointment non-variable-subscription non-job_package non-resume_package non-redq_rental non-accommodation-booking non-pw-gift-card\"]")
    public WebElement downloadableLink;


    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele wcfm_product_title wcfm_full_ele simple variable external grouped booking']")
    public WebElement productTitleLink;

    @FindBy(xpath = "//*[@class=\"wcfm-checkbox wcfm_ele simple variable manage_stock_ele non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking non-pw-gift-card\"]")
    public WebElement manageStock;

    @FindBy(xpath = "//*[@class='wcfm-text wcfm_ele simple variable non_manage_stock_ele non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking non-accommodation-booking']")
    public WebElement stockQtyLink;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement bigPhotoLink;

    @FindBy(xpath = "//*[@id=\"menu-item-upload\"]")
    public WebElement uploadFilesLInk;

    @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
    public WebElement selectFilesButton;

    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibraryLik;

    @FindBy(xpath = "//*[@class='thumbnail']")
    public WebElement icresimLink;

    @FindBy(xpath = "//*[@class=\"button media-button button-primary button-large media-button-select\"]")
    public WebElement select;

    @FindBy(xpath = "//*[@id=\"featured_img_display\"]")
    public WebElement bigResimIsdisplayText;
    @FindBy(xpath = "(//iframe)[1]")
    public WebElement iframe;


    @FindBy(xpath = "//*[@data-id='excerpt']")
    public WebElement shortdescription;

    @FindBy(xpath = "//*[@data-id='description']")
    public WebElement description;

    @FindBy(xpath = "(//iframe)[2]")
    public WebElement iframedescription;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-edit text_tip'])[1]")
    public WebElement editLink;

    @FindBy(xpath = "//*[text()='+Add new category']")
    public WebElement addNewCatagoryButton;

    @FindBy(xpath = "//*[@id='wcfm_new_cat']")
    public WebElement categoryNameBox;

    @FindBy(xpath = "(//*[text()='Add'])[1]")
    public WebElement addButton;

    @FindBy(xpath = "//*[@data-super_parent='446']")
    public WebElement besinTakviyesiClickButton;

    @FindBy(xpath = "//*[@data-super_parent='225']")
    public WebElement bestsellerClickButton;

    @FindBy(xpath = "//*[@value='230']")
    public WebElement electronicsClickButton;

    @FindBy(xpath = "//*[@data-super_parent='448']")
    public WebElement evYasamButton;

    @FindBy(xpath = "(//*[@value='455'])[1]")
    public WebElement indirimliUrunlerClickButton;

    @FindBy(xpath = "//*[@value='232']")
    public WebElement booksMusicFilmClickButton;

    @FindBy(xpath = "//*[@value='456']")
    public WebElement kozmetikClickButton;

    @FindBy(xpath = "//*[@value='477']")
    public WebElement modaGiyimClickButton;

    @FindBy(xpath = "//*[@value='233']")
    public WebElement oyuncakClickButton;

    @FindBy(xpath = "//*[@value='478']")
    public WebElement takiAksesuarClickButton;

    @FindBy(xpath = "//*[@value='479']")
    public WebElement yeniUrunlerClickButton;




}
