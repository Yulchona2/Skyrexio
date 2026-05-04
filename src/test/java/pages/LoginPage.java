package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import user.User;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("#user-name");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("#login-button");
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие сайта")
    public LoginPage open() {
        driver.get(BASE_URL);

        return this;
    }

    @Step("Логинимся под кредами пользователя, нажимаем кнопку Login")
    public LoginPage login(User user) {
        driver.findElement(userField).sendKeys(user.getLogin());
        driver.findElement(passwordField).sendKeys(user.getPassword());
        driver.findElement(submitButton).click();

        return this;
    }

    @Step("Проверка отображения сообщения об ошибке")
    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    @Step("Получение текста сообщения об ошибке")
    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
