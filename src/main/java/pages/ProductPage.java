package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//button[@data-test-id='add-button']")
    private WebElement buttonAddToBag;
    @FindBy(id = "selectSizeError")
    private WebElement sizeErrorMessage;
    @FindBy(xpath = "//button[@class = 'save-button']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@data-id=\"sizeSelect\"]")
    private WebElement sizeSelector;
    @FindBy(xpath = "//span[@data-id=\"current-price\"]")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonAddToBag() {
        buttonAddToBag.click();
    }

    public String getSizeErrorMessage() {
        return sizeErrorMessage.getText();
    }

    public void clickOnSaveButton() {
        saveButton.click();
    }

    public void chooseProductSize(String size) {
        sizeSelector.sendKeys(size);
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}
