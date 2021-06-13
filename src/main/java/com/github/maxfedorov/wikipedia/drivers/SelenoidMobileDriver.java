package com.github.maxfedorov.wikipedia.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SelenoidMobileDriver extends DriverBase {

    public AndroidDriver<MobileElement> getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", driverConfig.platformName());
        capabilities.setCapability("deviceName", driverConfig.deviceName());
        capabilities.setCapability("version", driverConfig.version());
        capabilities.setCapability("locale", driverConfig.locale());
        capabilities.setCapability("language", driverConfig.language());
        capabilities.setCapability("enableVNC", driverConfig.enableVNC());
        capabilities.setCapability("enableVideo", driverConfig.enableVideo());
        capabilities.setCapability("appPackage", driverConfig.appPackage());
        capabilities.setCapability("appActivity", driverConfig.appActivity());
        capabilities.setCapability("app", apkUrl());
        AndroidDriver<MobileElement> driver = new AndroidDriver<>(driverConfig.selenoid(), capabilities);
        driver.manage().timeouts().implicitlyWait(5, SECONDS);
        return driver;
    }

}
