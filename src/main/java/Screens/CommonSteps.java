package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.qameta.allure.Step;

public class CommonSteps extends ScreenBase {

    public CommonSteps(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Skip start message")
    public void back() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }
}