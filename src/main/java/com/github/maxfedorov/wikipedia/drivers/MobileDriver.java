package com.github.maxfedorov.wikipedia.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MobileDriver extends DriverBase {

    public AndroidDriver<MobileElement> getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", appConfig.platformName());
        capabilities.setCapability("deviceName", driverConfig.deviceName());
        capabilities.setCapability("version", driverConfig.version());
        capabilities.setCapability("locale", appConfig.locale());
        capabilities.setCapability("language", appConfig.language());
        capabilities.setCapability("appPackage", appConfig.appPackage());
        capabilities.setCapability("appActivity", appConfig.appActivity());
        capabilities.setCapability("app", apkUrl());
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(driverConfig.url(), capabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        return driver;
    }
}
