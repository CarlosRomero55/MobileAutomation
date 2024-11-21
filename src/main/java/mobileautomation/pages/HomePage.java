package mobileautomation.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePage {

    private AndroidDriver driver;

    // Elementos de la pantalla de inicio (Home)
    private By settingsButton = By.id("com.wdiodemoapp:id/settings");
    private By searchButton = By.id("com.wdiodemoapp:id/search");

    public HomePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Métodos para interactuar con los elementos de la pantalla de Home
    public void clickSettingsButton() {
        driver.findElement(settingsButton).click();
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }
}
