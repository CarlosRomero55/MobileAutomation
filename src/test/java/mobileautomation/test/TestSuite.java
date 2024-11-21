package mobileautomation.test;

import mobileautomation.pages.LoginPage;
import mobileautomation.pages.HomePage;
import mobileautomation.pages.SignUpPage;
import mobileautomation.pages.SwipePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class TestSuite {

    private AndroidDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private SignUpPage signUpPage;
    private SwipePage swipePage;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Configuración de las opciones de Appium directamente en la prueba
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setPlatformVersion("15")  // Asegúrate de tener la versión correcta
                .setDeviceName("emulator-5554")  // O el dispositivo que estés usando
                .setAutomationName("UiAutomator2")
                .setAppPackage("com.wdiodemoapp")  // El paquete de tu app
                .setAppActivity("com.wdiodemoapp.MainActivity")  // La actividad principal
                .setApp("apps/android.wdio.native.app.v1.0.8.apk")  // Ruta de tu APK
                .setNewCommandTimeout(Duration.ofDays(3600))
                .setNetworkSpeed(String.valueOf(true));

        // Crear el driver de Android
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        // Inicializar las páginas
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        signUpPage = new SignUpPage(driver);
        swipePage = new SwipePage(driver);
    }

    @Test
    public void testLogin() {
        // Usamos los métodos de la página de Login
        loginPage.enterEmail("testuser@mail.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();

        // Verificamos que el login haya sido exitoso
        Assert.assertTrue(loginPage.isHomeButtonDisplayed(), "Login failed");
    }

    @Test
    public void testSignUp() {
        // Usamos los métodos de la página de SignUp
        signUpPage.enterEmail("newuser@mail.com");
        signUpPage.enterPassword("newpassword123");
        signUpPage.clickSignUpButton();

        // Verificamos que el mensaje de éxito esté visible
        Assert.assertTrue(signUpPage.isSuccessMessageDisplayed(), "Sign Up failed");
    }

    @Test
    public void testHomePage() {
        // Usamos los métodos de la página de Home
        homePage.clickSettingsButton();
        homePage.clickSearchButton();

        // Aquí puedes agregar validaciones o verificaciones de la Home
    }

    @Test
    public void testSwipe() {
        // Usamos los métodos de la página de Swipe
        swipePage.swipeCards();
        Assert.assertTrue(swipePage.isCarouselDisplayed(), "Swipe carousel not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Cierra el driver después de las pruebas
        }
    }
}
