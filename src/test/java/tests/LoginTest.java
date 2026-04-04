package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        String title = driver.findElement(By.cssSelector("[data-test='title']")).getText();

        assertEquals(title, "Products");
    }

    @Test
    public void checkIncorrectLogin() {

        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();
        boolean isErrorMsgDisplayed = driver.findElement(By.xpath("//*[@data-test='error']")).isDisplayed();
        String errorMessage = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertTrue(isErrorMsgDisplayed, "The error message fails to appear");
        assertEquals(errorMessage, "Epic sadface: Sorry, this user has been locked out.");
    }
}

