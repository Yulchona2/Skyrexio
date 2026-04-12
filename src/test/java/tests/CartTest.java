package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void checkMoveToCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart();
        productsPage.goToCart();
        assertTrue(cartPage.pageCartTitleDisplayed());
        assertEquals(cartPage.getCartTitle(), "Your Cart");
    }
}
