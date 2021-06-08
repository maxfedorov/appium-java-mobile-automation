package com.github.maxfedorov.wikipedia.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

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

}
