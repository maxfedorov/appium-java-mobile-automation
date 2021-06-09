package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class TopReadPage extends ScreenBase {

    private static final By ITEM = MobileBy.id("org.wikipedia.alpha:id/view_list_card_item_title");

    public TopReadPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Check if page is open")
    public boolean isOpen() {
        return true; //todo:
    }

    @Step("Get items list")
    public List<MobileElement> getItemsList() {
        return elements(ITEM);
    }
}
