package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends BasePage {
    @FindBy(xpath = "//div[@data-auto-id=\"productList\"]//article")
    private List<WebElement> listProductList;
    @FindBy(xpath = "//button[@data-auto-id=\"saveForLater\"]")
    private List<WebElement> listWishIcons;

    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnFirstProduct() {
        listProductList.stream().findFirst().get().click();
    }

    public void clickOnListWishIcons() {
        listWishIcons.stream().findFirst().get().click();
    }
}
