package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class ScreenBase {
    protected AndroidDriver<MobileElement> driver;

    public ScreenBase(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected MobileElement element(By selector) {
        new WebDriverWait(driver, 10).until(visibilityOfElementLocated(selector));
        return driver.findElement(selector);
    }

    protected List<MobileElement> elements(By selector) {
        return driver.findElements(selector);
    }

}
