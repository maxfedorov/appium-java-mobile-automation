package com.github.maxfedorov.wikipedia.Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ArticlePage extends ScreenBase {

    private static final By WELCOME_TO_WIKIPEDIA = MobileBy.id("mp-welcome");

    public ArticlePage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check if page is open")
    public boolean isOpen() {
        return !elements(WELCOME_TO_WIKIPEDIA).isEmpty();
    }
}
