package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    private final By pageCartTitle = By.cssSelector("[data-test='title']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean pageCartTitleDisplayed() {
        return driver.findElement(pageCartTitle).isDisplayed();
    }

    public String getCartTitle() {
        return driver.findElement(pageCartTitle).getText();
    }
}
