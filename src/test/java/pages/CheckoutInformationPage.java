package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutInformationPage extends BasePage {
    private final By pageInformationTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By firstNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastNameField = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCodeField = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueButton = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));
    private final By errorMsg = By.cssSelector(DATA_TEST_PATTERN.formatted("error"));

    public CheckoutInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения заголовка страницы 'Checkout: Your Information'")
    public boolean pageInformationTitleDisplayed() {
        return driver.findElement(pageInformationTitle).isDisplayed();
    }

    @Step("Получение текста заголовка страницы оформления заказа")
    public String getInformationTitle() {
        return driver.findElement(pageInformationTitle).getText();
    }

    @Step("Заполнение информации о покупателе")
    public CheckoutInformationPage enterInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);

        return this;
    }

    @Step("Нажатие кнопки 'Continue' для перехода к CheckoutOverview")
    public CheckoutInformationPage clickBtnGoToCheckoutOverview() {
        driver.findElement(continueButton).click();

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
