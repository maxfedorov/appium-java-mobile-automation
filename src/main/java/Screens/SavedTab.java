package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static io.qameta.allure.Allure.step;

public class SavedTab extends ScreenBase {

    public SavedTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }
}
