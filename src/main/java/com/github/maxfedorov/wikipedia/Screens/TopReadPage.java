package com.github.maxfedorov.wikipedia.Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class TopReadPage extends ScreenBase {

    private static final By ITEM = MobileBy.id("org.wikipedia.alpha:id/view_list_card_item_title");
    private static final By TOP_READ_HEADER = MobileBy.xpath("//*[@resource-id='org.wikipedia.alpha:id/action_bar']/*[starts-with(@text, 'Top read on ')]");

    public TopReadPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check if page is open")
    public boolean isOpen() {
        return !elements(TOP_READ_HEADER).isEmpty();
    }

    @Step("Get items list")
    public List<MobileElement> getItemsList() {
        return elements(ITEM);
    }
}
