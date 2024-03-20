package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StorePage extends BasePage {

    public StorePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void addItemsToCart(WebElement... element) {
        for (WebElement e : element) {
            clickBtn(e);
        }
    }

    public void goToCart() {
        clickBtn(cartBtn);
    }

    @Getter
    @FindBy(css = "[id='add-to-cart-sauce-labs-backpack']")
    WebElement addBackpackItemBtn;

    @Getter
    @FindBy(css = "[id='add-to-cart-sauce-labs-fleece-jacket']")
    WebElement addFleeceJacketItemBtn;

    @Getter
    @FindBy(css = "[id='add-to-cart-sauce-labs-onesie']")
    WebElement addOnesieItemBtn;

    @FindBy(css = "[id='shopping_cart_container']")
    WebElement cartBtn;
}
