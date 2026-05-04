package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static enums.TitleNamesOfPages.CHECKOUT_INFORMATION;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

@Feature("Оформление заказа")
public class CheckoutInformationTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Story("Переход на страницу ввода данных")
    @Test(description = "Проверка перехода на страницу Checkout: Your Information", priority = 1)
    public void checkGoToInformationPage() {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage
                .addToCart()
                .goToCart();
        cartPage
                .goToCheckoutYourInformation();
        assertTrue(checkoutInformationPage.pageInformationTitleDisplayed());
        assertEquals(checkoutInformationPage.getInformationTitle(), CHECKOUT_INFORMATION.getDisplayName());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Валидация формы ввода данных")
    @Test(dataProvider = "informationData", description = "Проверка ошибок при неверном заполнении формы", priority = 2)
    public void checkEnterInCorrectInformation(String firstName, String lastName, String postalCode, String errorMessage) {
        loginPage
                .open()
                .login(withAdminPermission());
        productsPage
                .addToCart()
                .goToCart();
        cartPage
                .goToCheckoutYourInformation();
        checkoutInformationPage
                .enterInformation(firstName, lastName, postalCode)
                .clickBtnGoToCheckoutOverview();
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
