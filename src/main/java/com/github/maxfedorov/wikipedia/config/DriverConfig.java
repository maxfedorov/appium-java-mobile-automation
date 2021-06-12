package com.github.maxfedorov.wikipedia.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:driver.properties"
})
public interface DriverConfig extends Config {

    @Key("platformName")
    @DefaultValue("Android")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("locale")
    @DefaultValue("en")
    String locale();

    @Key("language")
    @DefaultValue("en")
    String language();

    @Key("appPackage")
    @DefaultValue("org.wikipedia.alpha")
    String appPackage();

    @Key("appActivity")
    @DefaultValue("org.wikipedia.main.MainActivity")
    String appActivity();

    @Key("appPath")
    @DefaultValue("app-alpha-universal-release.apk")
    String appPath();

    @Key("url")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL url();
}
