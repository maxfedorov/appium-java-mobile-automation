package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import java.util.List;

public class SearchTab extends ScreenBase {
    public SearchTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Search {text}")
    public SearchTab search(String text) {
        element(MobileBy.AccessibilityId("Search Wikipedia")).click();
        element(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys(text);
        return this;
    }

    @Step("Get search results list")
    public List<MobileElement> searchResults() {
        return elements(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title"));
    }

}
