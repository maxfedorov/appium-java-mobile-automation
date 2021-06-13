package com.github.maxfedorov.wikipedia.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AttachmentHelper {
    private WebDriver driver;

    public AttachmentHelper(WebDriver driver) {
        this.driver = driver;
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachText(String attachName, String message) {
        return message;
    }

    @Attachment(value = "{attachName}", type = "image/png")
    public byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Video", type = "text/html", fileExtension = ".html")
    public String attachVideo() {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
                + getSelenoidVideoUrl()
                + "' type='video/mp4'></video></body></html>";
    }

    private String getSelenoidVideoUrl() {
        try {
            return new URL("https://selenoid.autotests.cloud/video/" + getSessionId() + ".mp4") + "";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getSessionId() {
        return ((RemoteWebDriver) driver).getSessionId().toString();
    }
}
