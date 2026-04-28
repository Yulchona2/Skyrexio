package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {
    private final By checkoutTitle = By.cssSelector(DATA_TEST_PATTERN.formatted("title"));

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutTitleDisplayed() {
        return driver.findElement(checkoutTitle).isDisplayed();
    }

    public String getCheckoutTitle() {
        return driver.findElement(checkoutTitle).getText();
    }
}
