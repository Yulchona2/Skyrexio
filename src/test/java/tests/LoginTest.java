package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNamesOfPages.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("UI Testing")
@Feature("Авторизация пользователя")
public class LoginTest extends BaseTest {

    @Severity(SeverityLevel.BLOCKER)
    @Story("Успешная авторизация")
    @Owner("Егорова Юлия yulchona2@yandex.ru")
    @TmsLink("1dMvboNtiXtS38Cp69TsJCcyMm2VZqQ4MRFbUW9SrEWc/edit?gid=0#gid=0")
    @Issue("1B5jSrRs6uC2hTebxb7ko4pdqN36uEke6pUl0Kvs4_-c/edit?gid=0#gid=0")
    @Test(description = "Проверка корректный логин", priority = 1)
    public void checkLogin() {
        loginPage.open();
        loginPage.login(withAdminPermission());
        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Негативные сценарии авторизации")
    @Test(dataProvider = "loginData", priority = 2)
    public void checkIncorrectLogin(User user, String errorMessage) {
        loginPage
                .open()
                .login(user);
        assertTrue(loginPage.isErrorMsgDisplayed(), "The error message fails to appear");
        assertEquals(loginPage.getErrorMsg(), errorMessage);
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {withEmptyLoginPermission(), "Epic sadface: Username is required"},
                {withEmptyPasswordPermission(), "Epic sadface: Password is required"},
                {withIncorrectlyWrittenPermission(), "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
