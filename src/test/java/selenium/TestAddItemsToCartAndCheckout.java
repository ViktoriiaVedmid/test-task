package selenium;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAddItemsToCartAndCheckout extends BaseTest {
    private Double cartTotalSum;
    private final String COMPLETED_ORDER_MSG = "Thank you for your order!";
    private final String FIRST_NAME = "Test_First_Name";
    private final String LAST_NAME = "Test_Last_Name";
    private final String POSTAL_CODE = "3344-220";

    @BeforeClass
    public void start(){
        loginUser();
    }

    @Test
    public void createOrder() {
        storePage.addItemsToCart(storePage.getAddBackpackItemBtn(), storePage.getAddOnesieItemBtn(), storePage.getAddFleeceJacketItemBtn());
        storePage.goToCart();

        cartPage.removeItemFromCart(cartPage.getRemoveOnesieItemBtn());
        cartTotalSum = cartPage.getItemPricesInCart();
        cartPage.clickCheckoutButton();

        checkoutPage.fillCheckoutFirstStep(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        Assert.assertEquals(cartTotalSum, checkoutPage.getItemTotalSum());
        checkoutPage.completeOrder();
        Assert.assertEquals(COMPLETED_ORDER_MSG, checkoutPage.getCompletedOrderMsg());
    }

    @AfterClass
    public void close(){
        frameworkCore.closeBrowser();
    }
}
