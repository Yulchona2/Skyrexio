package pages;

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

    public boolean pageCartTitleDisplayed() {
        return driver.findElement(pageCartTitle).isDisplayed();
    }

    public String getCartTitle() {
        return driver.findElement(pageCartTitle).getText();
    }

    public ArrayList<String> getProductsNamesInTheCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping));
        List<WebElement> allProducts = driver.findElements(product);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }

    public void goToCheckoutYourInformation() {
        driver.findElement(checkout).click();
    }
}
