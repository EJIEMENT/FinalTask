package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class StepDefinitions {
    public static final long DEFAULT_TIMEOUT = 10;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Given("User opens {string} page")
    public void userOpensHomePagePage(String url) {
        driver.get(url);
    }

    @And("User click on button Shop The Trend")
    public void userClickOnButtonShopTheTrend() {
        pageFactoryManager.geTHomePage().clickOnButtonShopTheTrend();
    }

    @And("User clicks on first product in list")
    public void userClicksOnFirstProductInList() {
        pageFactoryManager.getProductListPage().clickOnFirstProduct();
    }

    @And("User click on button add to bag")
    public void userClickOnButtonAddToBag() {
        pageFactoryManager.getProductPage().clickOnButtonAddToBag();
    }

    @Then("User checks that error message is {string}")
    public void userChecksThatErrorMessageIsErrorMessage(String errorMessage) {
        pageFactoryManager.getProductPage().getSizeErrorMessage();
        Assert.assertEquals(errorMessage, pageFactoryManager.getProductPage().getSizeErrorMessage());
    }

    @And("User click on button add to wish list")
    public void userClickOnButtonAddToWishList() {
        pageFactoryManager.getProductPage().clickOnSaveButton();
    }

    @And("User click on button wish list in top menu")
    public void userClickOnButtonWishListInTopMenu() {
        pageFactoryManager.getTopMenuPage().clickOnSaveItemButton();
    }

    @Then("User checks availability of the product in the wish list")
    public void userChecksAvailabilityOfTheProductInTheWishList() {
        pageFactoryManager.getWishListPage().checkPresentItemInWishList();
        Assert.assertTrue(pageFactoryManager.getWishListPage().checkPresentItemInWishList() > 0);
    }

    @And("User click on button add to wish list from product list")
    public void userClickOnButtonAddToWishListFromProductList() {
        pageFactoryManager.getProductListPage().clickOnListWishIcons();
    }

    @And("User click on button delete product from wish list")
    public void userClickOnButtonDeleteProductFromWishList() {
        pageFactoryManager.getWishListPage().clickOnIconDeleteItemsFromWishList();
    }

    @Then("User checks wish list is empty")
    public void userChecksWishListIsEmpty() {
        pageFactoryManager.getWishListPage().getEmptyWishListMessage();
        Assert.assertEquals(pageFactoryManager.getWishListPage().getEmptyWishListMessage(), "You have no Saved Items");
    }

    @And("User choose product size in size selector {string}")
    public void userChooseProductSizeInSizeSelectorSize(String size) {
        pageFactoryManager.getProductPage().chooseProductSize(size);
    }

    @And("User click on asos logo")
    public void userClickOnAsosLogo() {
        pageFactoryManager.getTopMenuPage().goOnHomePage();
    }

    @And("User click on button cart logo")
    public void userClickOnButtonCartLogo() {
        pageFactoryManager.getTopMenuPage().clickOnCartLogo();
    }

    @And("User click on button checkout")
    public void userClickOnButtonCheckout() {
        pageFactoryManager.getCheckoutPage().clickOnButtonCheckout();
    }

    @Then("User checks the total product price")
    public void userChecksTheTotalProductPrice() {
        Assert.assertTrue(pageFactoryManager.getCheckoutPage().getPriceFromFieldTotalPrice().matches("^\\£[\\d.]+"));
        Assert.assertTrue(pageFactoryManager.getCheckoutPage().getTextFromFieldTotalToPay());
    }

    @And("User click on button my account")
    public void userClickOnButtonMyAccount() {
        pageFactoryManager.getTopMenuPage().clickOnMyAccountLogo();
    }

    @And("User click on button sign in")
    public void userClickOnButtonSignIn() {
        pageFactoryManager.getTopMenuPage().clickOnButtonSignIn();
    }

    @And("User login to application with {string} and {string}")
    public void userLoginToApplicationWithEmailAndPassword(String email, String password) {
        pageFactoryManager.getLoginPage().fillEmailAddress(email);
        pageFactoryManager.getLoginPage().fillPassword(password);
        pageFactoryManager.getLoginPage().clickOnSignInButton();
    }

    @Then("User checks login error message {string}")
    public void userChecksLoginErrorMessageMessage(String message) {
        Assert.assertEquals(pageFactoryManager.getLoginPage().getLoginErrorMessage(), message);
    }

    @Then("User checks that user is at home page")
    public void userChecksThatUserIsAtHomePage() {
        pageFactoryManager.getTopMenuPage().logoHomePageIsDisplayed();
    }

    @And("User click on button join")
    public void userClickOnButtonJoin() {
        pageFactoryManager.getTopMenuPage().clickOnButtonJoinUp();
    }

    @And("User fill user data without name")
    public void userFillUserDataWithoutName() {
        pageFactoryManager.getJoinNewUserPage().fillJoinNewUserForm("ejiement11@gmail.com", "", "Ivanov", "EJI1189567", "12", "2000", "May");
        pageFactoryManager.getJoinNewUserPage().clickOnRegistrationButton();
    }

    @Then("User checks validation error {string} message")
    public void userChecksValidationErrorMessageMessage(String message) {
        Assert.assertEquals(pageFactoryManager.getJoinNewUserPage().getFirstNameErrorMessage(), message);
    }

    @Then("User checks correct product price")
    public void userChecksCorrectProductPrice() {
        Assert.assertTrue(pageFactoryManager.getProductPage().getProductPrice().matches("^\\£[\\d.]+"));
    }

    @Then("User checks men and woman button tab is present")
    public void userChecksMenAndWomanButtonTabIsPresent() {
        Assert.assertTrue(pageFactoryManager.geTHomePage().tabMenFloorIsDisplayed());
        Assert.assertTrue(pageFactoryManager.geTHomePage().tabWomanFloorIsDisplayed());
    }

    @Then("User checks items in user drop down menu")
    public void userChecksItemsInUserDropDownMenu() {
        Assert.assertEquals(pageFactoryManager.geTHomePage().getMyAccountDropDownItems().size(), 4);
    }
}
