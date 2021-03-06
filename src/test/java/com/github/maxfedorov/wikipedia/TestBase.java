package com.github.maxfedorov.wikipedia;

import com.github.maxfedorov.wikipedia.Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.drivers.DriverFactory;
import com.github.maxfedorov.wikipedia.helpers.AttachmentHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    protected AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void startDriver() {
        driver = DriverFactory.getDriver();
        new CommonSteps(driver).back();
    }

    @AfterEach
    public void afterEach() {
        AttachmentHelper attachmentHelper = new AttachmentHelper(driver);
        String sessionId = attachmentHelper.getSessionId();
        attachmentHelper.screenshotAs("After test screenshot");
        driver.quit();
        if (!System.getProperty("driver").equals("local")) {
            attachmentHelper.attachVideo(sessionId);
        }
    }
}
