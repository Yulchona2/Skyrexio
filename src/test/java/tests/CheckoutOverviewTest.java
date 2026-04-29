package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Feature("Подтверждение заказа")
public class CheckoutOverviewTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Story("Переход на страницу подтверждения заказа")
    @Test(description = "Проверка перехода на страницу Checkout: Overview", priority = 1)
    public void checkMoveToCheckoutInformation() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage.goToCheckoutYourInformation();
        checkoutInformationPage.enterInformation("Мария", "Иванова", "555");
        checkoutInformationPage.clickBtnGoToCheckoutOverview();
        assertTrue(checkoutOverviewPage.checkoutTitleDisplayed());
        assertEquals(checkoutOverviewPage.getCheckoutTitle(), "Checkout: Overview");
    }
}
