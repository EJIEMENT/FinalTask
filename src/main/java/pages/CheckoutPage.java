package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {
    @FindBy(xpath = "//a[@class = \"bag-total-button bag-total-button--checkout bag-total-button--checkout--total\"]")
    private WebElement buttonCheckout;
    @FindBy(xpath = "//div[@data-bind=\"content: 'web_checkout_bagtotals_chkfilename_total_to_pay'\"]")
    private WebElement fieldTotalToPay;
    @FindBy(xpath = "//div[@data-bind=\"currency: total\"]")
    private WebElement fieldTotalPrice;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonCheckout() {
        buttonCheckout.click();
    }

    public boolean getTextFromFieldTotalToPay() {
        return fieldTotalToPay.isDisplayed();
    }

    public String getPriceFromFieldTotalPrice() {
        return fieldTotalPrice.getText();
    }
}
