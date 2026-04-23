package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Backpack";

    @Test
    public void checkMoveToCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.goToCart();
        assertTrue(cartPage.pageCartTitleDisplayed());
        assertEquals(cartPage.getCartTitle(), "Your Cart");
    }

    @Test
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart(goodsName);
        productsPage.goToCart();
        assertFalse(cartPage.getProductsNamesInTheCart().isEmpty());
        assertEquals(cartPage.getProductsNamesInTheCart().size(), 1);
        assertTrue(cartPage.getProductsNamesInTheCart().contains(goodsName));
    }
}
