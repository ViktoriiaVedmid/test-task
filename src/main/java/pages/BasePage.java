package pages;

import org.openqa.selenium.WebElement;

public class BasePage {

    // wrappers on selenium methods to keep in one place and be flexible in making global changes
    public void clickBtn(WebElement button) {
        button.click();
    }

    public void fillInput(WebElement inputField, String value) {
        inputField.sendKeys(value);
    }

    public String getTextValueFromElement(WebElement element) {
        return element.getText();
    }
}
