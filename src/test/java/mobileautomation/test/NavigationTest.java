package mobileautomation.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class NavigationTest {

    private AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Crear las opciones de Appium directamente en el método de prueba
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("15")  // Asegúrate de tener la versión correcta de Android
                .setDeviceName("emulator-5554")  // O el nombre del dispositivo que estés usando
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.wdiodemoapp")  // El paquete de tu aplicación
                .setAppActivity("com.wdiodemoapp.MainActivity")  // La actividad principal
                .setApp("C:\\path\\to\\your\\android.wdio.native.app.v1.0.8.apk")  // Ruta de tu APK
                .setNewCommandTimeout(Duration.ofDays(3600))
                .setNetworkSpeed(String.valueOf(true));

        // Establecer la URL del servidor de Appium
        URL serverUrl = new URL("http://127.0.0.1:4723/wd/hub");

        // Crear el driver directamente en el setUp
        driver = new AndroidDriver(serverUrl, options);
    }

    @Test
    public void testNavigation() throws InterruptedException {
        // Navegar al Home screen
        WebElement homeButton = driver.findElement(By.id("com.wdiodemoapp:id/home"));
        homeButton.click();

        // Verificar la visibilidad del botón 'search'
        WebElement searchButton = driver.findElement(By.id("com.wdiodemoapp:id/search"));
        searchButton.click();
        Assert.assertTrue(driver.findElement(By.id("com.wdiodemoapp:id/searchText")).isDisplayed(), "Search section is not displayed");

        // Navegar a la sección 'Settings'
        WebElement settingsButton = driver.findElement(By.id("com.wdiodemoapp:id/settings"));
        settingsButton.click();
        Assert.assertTrue(driver.findElement(By.id("com.wdiodemoapp:id/settingsTitle")).isDisplayed(), "Settings section is not displayed");

        // Finalizar la prueba y cerrar el driver
        driver.quit();
    }
}
