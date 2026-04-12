package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By userField = By.cssSelector("#user-name");
    private final By passwordField = By.xpath("//*[@placeholder='Password']");
    private final By submitButton = By.cssSelector("#login-button");
    private final By errorMsg = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String login, String password) {
        driver.findElement(userField).sendKeys(login);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    public boolean isErrorMsgDisplayed() {
        return driver.findElement(errorMsg).isDisplayed();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();
    }
}
