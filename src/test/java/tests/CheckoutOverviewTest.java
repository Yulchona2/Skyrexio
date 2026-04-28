package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class CheckoutOverviewTest extends BaseTest {

    @Test
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
