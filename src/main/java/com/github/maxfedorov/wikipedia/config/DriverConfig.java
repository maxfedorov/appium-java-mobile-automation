package com.github.maxfedorov.wikipedia.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${driver}.properties"
})
public interface DriverConfig extends Config {

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("enableVNC")
    @DefaultValue("true")
    boolean enableVNC();

    @Key("enableVideo")
    @DefaultValue("true")
    boolean enableVideo();

    @Key("url")
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL url();

    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("browserstack.project")
    @DefaultValue("Mobile automation")
    String browserstackProject();

    @Key("browserstack.build")
    @DefaultValue("Android")
    String browserstackBuild();

    @Key("browserstack.name")
    @DefaultValue("Wikipedia")
    String browserstackName();
}
