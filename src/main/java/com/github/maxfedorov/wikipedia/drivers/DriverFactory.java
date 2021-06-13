package com.github.maxfedorov.wikipedia.drivers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverFactory extends DriverBase {

    public static AndroidDriver<MobileElement> getDriver() {
        String driver = System.getProperty("driver");
        if (driver.equals("local")) {
            return new MobileDriver().getDriver();
        } else if (driver.equals("selenoid")) {
            return new SelenoidMobileDriver().getDriver();
        } else if (driver.equals("browserstack")) {
            return new BrowserstackMobileDriver().getDriver();
        } else throw new RuntimeException("Unknown driver type. Use: local, selenoid, browserstack");
    }
}
