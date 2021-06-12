package com.github.maxfedorov.wikipedia;

import Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.drivers.MobileDriver;
import com.github.maxfedorov.wikipedia.helpers.AttachmentHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void startDriver() {
        driver = new MobileDriver().getDriver();
        new CommonSteps(driver).back();
    }

    @AfterEach
    public void afterEach() {
        new AttachmentHelper(driver).screenshotAs("After test screenshot");
        driver.quit();
    }
}
