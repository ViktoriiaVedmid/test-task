package selenium;

import config.ApplicationConfig;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import pages.AuthPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.StorePage;
import utils.FrameworkCore;

public class BaseTest {
    WebDriver driver;
    AuthPage authPage;
    CartPage cartPage;
    StorePage storePage;
    CheckoutPage checkoutPage;
    FrameworkCore frameworkCore;


    @BeforeClass
    public void setUpFramework() {
        frameworkCore = new FrameworkCore();
        driver = frameworkCore.getDriver();
        authPage = new AuthPage(driver);
        cartPage = new CartPage(driver);
        storePage = new StorePage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    public void loginUser() {
        frameworkCore.openUrl(ApplicationConfig.BASE_URL);
        authPage.login(ApplicationConfig.USER_LOGIN, ApplicationConfig.USER_PASSWORD);
    }
}

