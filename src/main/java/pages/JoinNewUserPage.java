package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JoinNewUserPage extends BasePage {
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(id = "FirstName")
    private WebElement firstNameField;
    @FindBy(id = "LastName")
    private WebElement lastNameField;
    @FindBy(id = "Password")
    private WebElement passwordField;
    @FindBy(id = "BirthDay")
    private WebElement birthDayField;
    @FindBy(id = "BirthMonth")
    private WebElement birthMonthField;
    @FindBy(id = "BirthYear")
    private WebElement birthYearField;
    @FindBy(id = "register")
    private WebElement registrationButton;
    @FindBy(id = "FirstName-error")
    private WebElement firstNameErrorMessage;

    public JoinNewUserPage(WebDriver driver) {
        super(driver);
    }

    public void fillJoinNewUserForm(String email, String name, String lastName, String password, String day, String year, String month) {
        emailField.sendKeys(email);
        firstNameField.sendKeys(name);
        lastNameField.sendKeys(lastName);
        passwordField.sendKeys(password);
        birthDayField.sendKeys(day);
        birthMonthField.sendKeys(month);
        birthYearField.sendKeys(year);
    }

    public void clickOnRegistrationButton() {
        registrationButton.click();
    }

    public String getFirstNameErrorMessage() {
        return firstNameErrorMessage.getText();
    }

}
