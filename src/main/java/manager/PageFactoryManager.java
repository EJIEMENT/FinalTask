package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage geTHomePage() {
        return new HomePage(driver);
    }

    public ProductListPage getProductListPage() {
        return new ProductListPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public TopMenuPage getTopMenuPage() {
        return new TopMenuPage(driver);
    }

    public WishListPage getWishListPage() {
        return new WishListPage(driver);
    }

    public CheckoutPage getCheckoutPage() {
        return new CheckoutPage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public JoinNewUserPage getJoinNewUserPage() {
        return new JoinNewUserPage(driver);
    }
}
