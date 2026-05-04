package tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    List<String> goodsList = List.of("Sauce Labs Fleece Jacket", "Sauce Labs Onesie", "Sauce Labs Bolt T-Shirt");

    @Severity(SeverityLevel.CRITICAL)
    @Story("Добавление товаров в корзину и проверка счетчика")
    @Test(description = "Проверка добавления нескольких товаров в корзину;отображения счетчика и его цвета",
            priority = 1)
    public void checkGoodsAdded() {
        loginPage
                .open()
                .login(withAdminPermission());
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
