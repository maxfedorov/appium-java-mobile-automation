package com.github.maxfedorov.wikipedia;

import Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.config.DriverConfig;
import com.github.maxfedorov.wikipedia.drivers.DriverFactory;
import com.github.maxfedorov.wikipedia.helpers.AttachmentHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected AndroidDriver<MobileElement> driver;
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);

    @BeforeEach
    public void startDriver() {
        driver = DriverFactory.getDriver();
        new CommonSteps(driver).back();
    }

    @AfterEach
    public void afterEach() {
        AttachmentHelper attachmentHelper = new AttachmentHelper(driver);
        attachmentHelper.screenshotAs("After test screenshot");
        if (!driverConfig.driver().equals("local")) {
            attachmentHelper.attachVideo();
        }
        driver.quit();
    }
}
