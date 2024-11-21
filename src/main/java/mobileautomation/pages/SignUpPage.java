package mobileautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class SignUpPage {

    private AndroidDriver driver;

    // Elementos de la pantalla de registro (SignUp)
    private By emailField = By.id("com.wdiodemoapp:id/email");
    private By passwordField = By.id("com.wdiodemoapp:id/password");
    private By signUpSubmitButton = By.id("com.wdiodemoapp:id/signUpSubmit");
    private By successMessage = By.id("com.wdiodemoapp:id/successMessage");

    public SignUpPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con los elementos de la pantalla de SignUp
    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpSubmitButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed();
    }
}
