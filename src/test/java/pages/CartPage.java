package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By pageCartTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By product = By.cssSelector(".inventory_item_name");
    private final By continueShopping = By.cssSelector("#continue-shopping");
    private final By checkout = By.cssSelector(DATA_TEST_PATTERN.formatted("checkout"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверка отображения заголовка страницы корзины")
    public boolean pageCartTitleDisplayed() {
        return driver.findElement(pageCartTitle).isDisplayed();
    }

    @Step("Получение текста заголовка страницы корзины")
    public String getCartTitle() {
        return driver.findElement(pageCartTitle).getText();
    }

    @Step("Получение списка названий товаров в корзине")
    public ArrayList<String> getProductsNamesInTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping));
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    @Step("Переход к оформлению заказа")
    public CartPage goToCheckoutYourInformation() {
        driver.findElement(checkout).click();

        return this;
    }
}
