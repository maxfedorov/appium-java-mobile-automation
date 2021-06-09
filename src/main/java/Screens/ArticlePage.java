package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

public class ArticlePage extends ScreenBase {

    public ArticlePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check if page is open") //todo
    public boolean isOpen() { //todo:
        return true;
    }
}
