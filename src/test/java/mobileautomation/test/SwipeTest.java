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

public class SwipeTest {

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
                .setApp("C:\\path\\to\\your\\android.wdio.native.app.v1.0.8.apk")
                .setNewCommandTimeout(Duration.ofDays(3600))
                .setNetworkSpeed(String.valueOf(true));

        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(serverUrl, options);
    }

    @Test
    public void testSwipe() {
        // Navegar al carrusel de tarjetas
        WebElement cardElement = driver.findElement(By.id("com.wdiodemoapp:id/cardCarousel"));
        // Lógica de swipe (deslizar)
        // Aquí puedes usar un gesto o acción de swipe dependiendo de la aplicación

        Assert.assertTrue(cardElement.isDisplayed(), "Swipe test failed");

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
