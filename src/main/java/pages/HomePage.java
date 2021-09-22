package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends BasePage {

    @FindBy(xpath = "//span[@class=\"hero__cta js-buttonHover\"]")
    private WebElement buttonShopTheTrend;
    @FindBy(id = "women-floor")
    private WebElement tabWomanFloor;
    @FindBy(id = "men-floor")
    private WebElement tabMenFloor;
    @FindBy(xpath = "//div[@id=\"myaccount-dropdown\"]//ul/li/a")
    private List<WebElement> myAccountDropDownItems;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonShopTheTrend() {
        waitVisibilityOfElement(20, buttonShopTheTrend);
        buttonShopTheTrend.click();
    }

    public boolean tabWomanFloorIsDisplayed() {
        return tabWomanFloor.isDisplayed();
    }

    public boolean tabMenFloorIsDisplayed() {
        return tabMenFloor.isDisplayed();
    }

    public List<String> getMyAccountDropDownItems() {
        return myAccountDropDownItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

