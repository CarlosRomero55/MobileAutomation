package mobileautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwipePage {

    private AndroidDriver driver;

    // Elementos de la pantalla de Swipe
    private By cardCarousel = By.id("com.wdiodemoapp:id/cardCarousel");

    public SwipePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con los elementos de la pantalla de Swipe
    public void swipeCards() {
        WebElement carousel = driver.findElement(cardCarousel);
        // Aquí puedes agregar el código de deslizar tarjetas según lo que necesites
        // Un ejemplo sería utilizar gestures para deslizar
    }

    public boolean isCarouselDisplayed() {
        return driver.findElement(cardCarousel).isDisplayed();
    }
}
