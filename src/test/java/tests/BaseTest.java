package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.TestListener;

import java.time.Duration;

@Listeners({AllureTestNg.class, TestListener.class})
public class BaseTest {
    public WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutInformationPage checkoutInformationPage;
    CheckoutOverviewPage checkoutOverviewPage;

    @Parameters({"browser"})
    @Step("Запуск браузера")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            options.addArguments("guest");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            options.addArguments("start-maximized");
            options.addArguments("headless");
            options.addArguments("guest");
            driver = new EdgeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("-width=1920");
            options.addArguments("-height=1080");
            options.addArguments("-headless");
            driver = new FirefoxDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutInformationPage = new CheckoutInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
    }

    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
