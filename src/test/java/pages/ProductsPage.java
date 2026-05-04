package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART_PATTERN = "//div[text()='%s']//" + "ancestor::div[@class='inventory_item']//child::button[text()='Add to cart']";
    private final By pageTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");
    private final By cartLink = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By cartBadge = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получение заголовка страницы товаров")
    public String getTitle() {
        return driver.findElement(pageTitle).getText();
    }

    @Step("Добавление первого товара в корзину")
    public ProductsPage addToCart() {
        driver.findElements(addToCartBtn).getFirst().click();

        return this;
    }

    @Step("Подсчет количества товаров на странице")
    public int getGoodsQuantity() {
        return driver.findElements(addToCartBtn).size();
    }

    @Step("Добавление товара '{goodsName}' в корзину")
    public ProductsPage addToCart(final String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();

        return this;
    }

    @Step("Проверка отображения заголовка страницы товаров")
    public boolean pageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    @Step("Получение значения счетчика товаров в корзине")
    public String checkCounterValue() {
        return driver.findElement(cartBadge).getText();
    }

    @Step("Получение цвета счетчика товаров в корзине")
    public String checkCounterColor() {
        return driver.findElement(cartBadge).getCssValue("background-color");
    }

    @Step("Переход в корзину")
    public ProductsPage goToCart() {
        driver.findElement(cartLink).click();

        return this;
    }
}
