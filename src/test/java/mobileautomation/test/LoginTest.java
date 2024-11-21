package mobileautomation.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Configurar las opciones de Appium
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("15")
                .setDeviceName("emulator-5554")
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity")
                .setApp("C:\\Users\\carlo\\Documents\\MobileAutomation\\apps\\android.wdio.native.app.v1.0.8.apk")
                .setNewCommandTimeout(Duration.ofDays(3600))
                .setNetworkSpeed(String.valueOf(true));

        URL serverUrl = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(serverUrl, options);
    }

    @Test
    public void testLogin() {
        // Navegar a la sección de Login
        WebElement loginButton = driver.findElement(By.id("com.wdiodemoapp:id/login"));
        loginButton.click();

        // Completar los datos del login
        WebElement emailField = driver.findElement(By.id("com.wdiodemoapp:id/email"));
        emailField.sendKeys("testuser@mail.com");

        WebElement passwordField = driver.findElement(By.id("com.wdiodemoapp:id/password"));
        passwordField.sendKeys("password123");

        WebElement loginSubmitButton = driver.findElement(By.id("com.wdiodemoapp:id/loginSubmit"));
        loginSubmitButton.click();

        // Verificar si el login fue exitoso
        Assert.assertTrue(driver.findElement(By.id("com.wdiodemoapp:id/home")).isDisplayed(), "Login failed");

        // Finalizar la prueba y cerrar el driver
        driver.quit();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Asegúrate de cerrar el driver después de la prueba
        }
    }
}
