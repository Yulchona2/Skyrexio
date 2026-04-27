package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class CheckoutInformationTest extends BaseTest {

    @Test
    public void checkGoToInformationPage() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage.goToCheckoutYourInformation();
        assertTrue(checkoutInformationPage.pageInformationTitleDisplayed());
        assertEquals(checkoutInformationPage.getInformationTitle(), "Checkout: Your Information");
    }

    @Test(dataProvider = "informationData")
    public void checkEnterInCorrectInformation(String firstName, String lastName, String postalCode, String errorMessage) {
        loginPage.open();
        loginPage.login(withAdminPermission());
        productsPage.addToCart();
        productsPage.goToCart();
        cartPage.goToCheckoutYourInformation();
        checkoutInformationPage.enterInformation(firstName, lastName, postalCode);
        checkoutInformationPage.clickBtnGoToCheckoutOverview();
        assertTrue(checkoutInformationPage.isErrorMsgDisplayed());
        assertEquals(checkoutInformationPage.getErrorMsg(), errorMessage);
    }

    @DataProvider
    public Object[][] informationData() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "Иванова", "555", "Error: First Name is required"},
                {"Мария", "", "555", "Error: Last Name is required"},
                {"Мария", "Иванова", "", "Error: Postal Code is required"}};
    }
}
