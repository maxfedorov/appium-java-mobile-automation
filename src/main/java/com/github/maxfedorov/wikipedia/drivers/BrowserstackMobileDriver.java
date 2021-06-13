package com.github.maxfedorov.wikipedia.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserstackMobileDriver extends DriverBase {
    public AndroidDriver<MobileElement> getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserstack.user", driverConfig.browserstackUser());
        capabilities.setCapability("browserstack.key", driverConfig.browserstackKey());
        capabilities.setCapability("app", appConfig.appPath());
        capabilities.setCapability("device", driverConfig.deviceName());
        capabilities.setCapability("os_version", driverConfig.version());
        capabilities.setCapability("project", driverConfig.browserstackProject());
        capabilities.setCapability("build", driverConfig.browserstackBuild());
        capabilities.setCapability("name", driverConfig.browserstackName());
        return new AndroidDriver<>(driverConfig.url(), capabilities);
    }
}
