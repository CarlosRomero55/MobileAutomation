package mobileautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {

    private AndroidDriver driver;

    // Elementos de la pantalla de Login
    private By emailField = By.id("com.wdiodemoapp:id/email");
    private By passwordField = By.id("com.wdiodemoapp:id/password");
    private By loginButton = By.id("com.wdiodemoapp:id/loginSubmit");
    private By homeButton = By.id("com.wdiodemoapp:id/home");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con los elementos de la pantalla de Login
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isHomeButtonDisplayed() {
        return driver.findElement(homeButton).isDisplayed();
    }
}
