package com.github.maxfedorov.wikipedia.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:app.properties"
})
public interface AppConfig extends Config {

    @Key("platformName")
    @DefaultValue("Android")
    String platformName();

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
    @DefaultValue("https://github.com/wikimedia/apps-android-wikipedia/releases/download/latest/app-alpha-universal-release.apk")
    String appPath();
}
