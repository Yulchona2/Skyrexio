package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By checkoutTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения заголовка страницы 'Checkout: Overview'")
    public boolean checkoutTitleDisplayed() {
        return driver.findElement(checkoutTitle).isDisplayed();
    }

    @Step("Получение текста заголовка страницы подтверждения заказа")
    public String getCheckoutTitle() {
        return driver.findElement(checkoutTitle).getText();
    }
}
