package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TarikPage {

    public TarikPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ilkSayfaSignInLink;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement signInMailBox;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement signInPasswordBox;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement signInOnayButton;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOutLink;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerLink;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/store-manager/followers/']")
    public WebElement followersLink;

    @FindBy(xpath = "//*[text()='No data in the table']")
    public WebElement notDataText;

    @FindBy(xpath = "//*[@class='dataTables_wrapper']")
    public WebElement takipciListesiEkranGoruntusu;

    @FindBy(xpath = "//*[@class='dataTables_empty']")
    public WebElement dataTableEmpty;

    @FindBy(xpath = "//*[@href='https://allovercommerce.com/store-manager/reviews/']")
    public WebElement reviewsLink;

    @FindBy(xpath = "(//*[@href='https://allovercommerce.com/store-manager/reports-sales-by-date/'])[1]")
    public WebElement reportsLink;

    @FindBy(xpath = "//*[@class='wcfm-date-range']")
    public WebElement customBox;

    @FindBy(xpath = "//*[@class='date-picker-wrapper no-gap two-months']")
    public WebElement takvim;

    @FindBy(xpath = "//tbody//tr//td")
    public List<WebElement> gunler;

    @FindBy(xpath = "//*[@class='normal-top']")
    public WebElement seciliGunlerText;

    @FindBy(xpath = "//*[text()='Year']")
    public WebElement yearLink;

    @FindBy(xpath = "//*[@class='inside chart-with-sidebar']")
    public WebElement rapor;

    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastMonthLink;

    @FindBy(xpath = "(//*[text()='This Month'])[1]")
    public WebElement thisMonthLink;

    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7DaysLink;

    @FindBy(xpath = "(//*[text()='Product Reviews'])[1]")
    public WebElement productReviewsLink;

    @FindBy(xpath = "//*[@class='wcfmmp-author-meta']")
    public WebElement kullaniciBilgisiText;

    @FindBy(xpath = "//*[@class='wcfmmp-comments-content']")
    public WebElement yorumIcerigiText;

    @FindBy(xpath = "//*[@itemprop='reviewRating']")
    public WebElement ratingText;

    @FindBy(xpath = "//tbody//td[6]")
    public WebElement datedText;




}