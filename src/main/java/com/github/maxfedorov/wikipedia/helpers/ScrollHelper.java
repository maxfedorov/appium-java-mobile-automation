package com.github.maxfedorov.wikipedia.helpers;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import static java.lang.String.format;

public class ScrollHelper {
    public ScrollHelper(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private AndroidDriver<MobileElement> driver;

    public void scrollToElementById(String elemId) {
        String using = "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().resourceId(" + elemId + ").instance(0))";
        scrollToElement(using);
    }

    public void scrollToElementByText(String text) {
        String using = format("new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
                ".scrollIntoView(new UiSelector().textStartsWith(\"%s\").instance(0))", text);
        scrollToElement(using);
    }

    public void scrollToElement(String using) {
        try {
            driver.findElementByAndroidUIAutomator(using);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
