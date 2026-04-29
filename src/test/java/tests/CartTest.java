package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static user.UserFactory.withAdminPermission;

public class CartTest extends BaseTest {
    final String goodsName = "Sauce Labs Backpack";

    @Severity(SeverityLevel.BLOCKER)
    @Story("Переход в корзину")
    @Test(description = "Проверка перехода на страницу корзины", priority = 1)
    public void checkMoveToCart() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.goToCart();
        assertTrue(cartPage.pageCartTitleDisplayed());
        assertEquals(cartPage.getCartTitle(), "Your Cart");
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Добавление товаров в корзину")
    @Test(description = "Проверка отображения добавленного товара в корзине", priority = 2)
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
