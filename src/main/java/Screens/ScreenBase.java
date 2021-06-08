package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

import java.util.List;

public class ScreenBase {
    protected AndroidDriver<MobileElement> driver;

    public ScreenBase(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    protected MobileElement element(By selector) {
        return driver.findElement(selector);
    }

    protected List<MobileElement> elements(By selector) {
        return driver.findElements(selector);
    }

}
