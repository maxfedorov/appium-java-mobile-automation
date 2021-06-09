package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class MediaPage extends ScreenBase {

    public MediaPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check if page is open")
    public boolean isOpen() {
        return true; //todo
    }
}
