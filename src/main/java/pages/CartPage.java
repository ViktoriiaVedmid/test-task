package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void removeItemFromCart(WebElement item) {
        clickBtn(item);
    }

    public void clickCheckoutButton() {
        clickBtn(checkoutBtn);
    }

    public Double getItemPricesInCart() {
        List<String> sumValue = priceItems
                .stream()
                .map(v -> getTextValueFromElement(v).replaceAll("\\$", ""))
                .collect(Collectors.toList());
        double sumOfPrices = 0.0;
        for (String amount : sumValue) {
            sumOfPrices = sumOfPrices + Double.valueOf(amount);
        }
        return sumOfPrices;
    }

    @Getter
    @FindBy(css = "[id='remove-sauce-labs-onesie']")
    WebElement removeOnesieItemBtn;

    @Getter
    @FindBy(css = "[id='checkout']")
    WebElement checkoutBtn;

    @Getter
    @FindBy(css = "[class='inventory_item_price']")
    List<WebElement> priceItems;
}
