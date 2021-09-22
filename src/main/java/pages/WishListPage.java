package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends BasePage {
    @FindBy(xpath = "//ol//div[contains(@class,\"progressIndicatorWrapper\")]")
    private List<WebElement> listItemsInWishList;
    @FindBy(xpath = "//button[@aria-label=\"Delete\"]")
    private WebElement iconDeleteItemsFromWishList;
    @FindBy(xpath = "//h2[contains(@class, \"noItemsPrompt\")]")
    private WebElement messageYouHaveNoSavedItems;


    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public int checkPresentItemInWishList() {
        return listItemsInWishList.size();
    }

    public void clickOnIconDeleteItemsFromWishList() {
        iconDeleteItemsFromWishList.click();
    }

    public String getEmptyWishListMessage() {
        return messageYouHaveNoSavedItems.getText();
    }
}
