package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenuPage extends BasePage {

    @FindBy(xpath = "//a[@data-testid=\"asoslogo\"]")
    private WebElement asosLogo;
    @FindBy(xpath = "//a[@data-testid='miniBagIcon']")
    private WebElement cartLogo;
    @FindBy(xpath = "//a[@data-testid=\"savedItemsIcon\"]")
    private WebElement saveItemButton;
    @FindBy(xpath = "//button[@data-testid=\"myAccountIcon\"]")
    private WebElement myAccountLogo;
    @FindBy(xpath = "//a[@data-testid=\"signin-link\"]")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//a[@data-testid=\"signup-link\"]")
    private WebElement buttonJoinUp;


    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnCartLogo() {
        cartLogo.click();
    }

    public void goOnHomePage() {
        asosLogo.click();
    }

    public void logoHomePageIsDisplayed() {
        waitForPageLoadComplete(10);
        asosLogo.isDisplayed();
    }

    public void clickOnSaveItemButton() {
        saveItemButton.click();
    }

    public void clickOnMyAccountLogo() {
        myAccountLogo.click();
    }

    public void clickOnButtonSignIn() {
        buttonSignIn.click();
    }

    public void clickOnButtonJoinUp() {
        buttonJoinUp.click();
    }
}
