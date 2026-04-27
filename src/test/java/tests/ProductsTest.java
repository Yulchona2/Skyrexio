package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList = List.of("Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Sauce Labs Bolt T-Shirt");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertTrue(productsPage.pageTitleDisplayed());
        assertEquals(productsPage.getGoodsQuantity(), 6);
        productsPage.addToCart();
        for (String goods : goodsList) {
            productsPage.addToCart(goods);
        }
        assertEquals(productsPage.checkCounterValue(), "4");
        String actualColor = productsPage.checkCounterColor();
        assertTrue(actualColor.equals("rgba(226, 35, 26, 1)") || actualColor.equals("rgb(226, 35, 26)"));
    }
}
