package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BasePage {

    public AuthPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public AuthPage login(String userName, String userPassword) {
        fillInput(userNameInput, userName);
        fillInput(userPasswordInput, userPassword);
        clickBtn(loginButton);
        return this;
    }

    @FindBy(css = "[id='user-name']")
    WebElement userNameInput;

    @FindBy(css = "[id='password']")
    WebElement userPasswordInput;

    @FindBy(css = "[id='login-button']")
    WebElement loginButton;
}
