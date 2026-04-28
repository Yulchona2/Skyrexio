package pages;

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

    public boolean pageInformationTitleDisplayed() {
        return driver.findElement(pageInformationTitle).isDisplayed();
    }

    public String getInformationTitle() {
        return driver.findElement(pageInformationTitle).getText();
    }

    public void enterInformation(String firstName, String lastName, String postalCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickBtnGoToCheckoutOverview() {
        driver.findElement(continueButton).click();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
