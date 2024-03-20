package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void fillCheckoutFirstStep(String firstName, String lastName, String postalCode) {
        fillInput(firstNameInput, firstName);
        fillInput(lastNameInput, lastName);
        fillInput(postalCodeInput, postalCode);
        clickBtn(continueBtn);
    }

    public Double getItemTotalSum() {
        return Double.valueOf(getTextValueFromElement(itemTotalPrice).replaceAll("Item total: \\$", ""));
    }

    public void completeOrder() {
        clickBtn(finishBtn);
    }

    public String getCompletedOrderMsg() {
        return getTextValueFromElement(completeText);
    }

    @FindBy(css = "[id='first-name']")
    WebElement firstNameInput;

    @FindBy(css = "[id='last-name']")
    WebElement lastNameInput;

    @FindBy(css = "[id='postal-code']")
    WebElement postalCodeInput;

    @FindBy(css = "[id='continue']")
    WebElement continueBtn;

    @FindBy(css = "[class='summary_subtotal_label']")
    WebElement itemTotalPrice;

    @FindBy(css = "[id='finish']")
    WebElement finishBtn;

    @FindBy(css = "[class='complete-header']")
    WebElement completeText;
}
