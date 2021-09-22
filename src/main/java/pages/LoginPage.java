package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "EmailAddress")
    private WebElement emailAddressField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(id = "signin")
    private WebElement buttonSignIn;
    @FindBy(id = "loginErrorMessage")
    private WebElement loginErrorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillEmailAddress(String email) {
        emailAddressField.sendKeys(email);
    }

    public void fillPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        buttonSignIn.click();
    }

    public String getLoginErrorMessage() {
        return loginErrorMessage.getText();
    }
}
