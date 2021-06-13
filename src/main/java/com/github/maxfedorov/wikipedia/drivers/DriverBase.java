package com.github.maxfedorov.wikipedia.drivers;

import com.github.maxfedorov.wikipedia.config.AppConfig;
import com.github.maxfedorov.wikipedia.config.DriverConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverBase {
    static DriverConfig driverConfig = ConfigFactory.create(DriverConfig.class);
    static AppConfig appConfig = ConfigFactory.create(AppConfig.class);

    protected URL apkUrl() {
        try {
            return new URL(appConfig.appPath());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
