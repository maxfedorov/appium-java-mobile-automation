package com.github.maxfedorov.wikipedia;

import Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.helpers.AttachmentHelper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static java.util.concurrent.TimeUnit.SECONDS;

public class TestBase {
    protected AndroidDriver<MobileElement> driver;

    @BeforeEach
    public void startDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "35dba4c47d33");
        capabilities.setCapability("version", "6.0");
        capabilities.setCapability("locale", "en");
        capabilities.setCapability("language", "en");
        capabilities.setCapability("appPackage", "org.wikipedia.alpha");
        capabilities.setCapability("appActivity", "org.wikipedia.main.MainActivity");
        capabilities.setCapability("app", new File("src/test/resources/app-alpha-universal-release.apk").getAbsolutePath());
        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        new CommonSteps(driver).back();
    }

    @AfterEach
    public void afterEach() {
        new AttachmentHelper(driver).screenshotAs("After test screenshot");
        driver.quit();
    }
}
