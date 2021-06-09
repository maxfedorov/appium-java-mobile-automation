package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MoreTab extends ScreenBase {
    private static final By HISTORY_BUTTON = MobileBy.id("org.wikipedia.alpha:id/main_drawer_history_container");
    private static final By LOGIN_BUTTON = MobileBy.id("org.wikipedia.alpha:id/main_drawer_login_button");
    private static final By SETTINGS_BUTTON = MobileBy.id("org.wikipedia.alpha:id/main_drawer_settings_container");

    public MoreTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap history")
    public void openHistory() {
        element(HISTORY_BUTTON).click();
    }

    @Step("Tap Log in")
    public SignUpPage logIn() {
        element(LOGIN_BUTTON).click();
        return new SignUpPage(driver);
    }

    @Step("Tap settings")
    public SettingsPage settings() {
        element(SETTINGS_BUTTON).click();
        return new SettingsPage(driver);
    }
}
