package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class SearchTab extends ScreenBase {
    private static final By HISTORY_ITEM = MobileBy.id("org.wikipedia.alpha:id/page_list_item_title");
    private static final By CLEAR_BUTTON = MobileBy.id("org.wikipedia.alpha:id/history_delete");
    private static final By CONFIRM_BUTTON = MobileBy.id("android:id/button1");
    private static final By SEARCH_WIKIPEDIA_BUTTON = MobileBy.AccessibilityId("Search Wikipedia");
    private static final By SEARCH_FIELD = MobileBy.id("org.wikipedia.alpha:id/search_src_text");
    private static final By SEARCH_RESULT = MobileBy.id("org.wikipedia.alpha:id/page_list_item_title");
    private static final By SEARCH_HEADER = MobileBy.xpath("//*[@resource-id='org.wikipedia.alpha:id/main_toolbar']/*[@text='Search']");

    public SearchTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Search {text}")
    public void search(String text) {
        element(SEARCH_WIKIPEDIA_BUTTON).click();
        element(SEARCH_FIELD).sendKeys(text);
    }

    @Step("Get search results list")
    public List<MobileElement> searchResults() {
        return elements(SEARCH_RESULT);
    }

    @Step("Check if page is open")
    public boolean isOpen() {
        return !elements(SEARCH_HEADER).isEmpty();
    }

    @Step("Get history items")
    public List<MobileElement> getHistoryItems() {
        return elements(HISTORY_ITEM);
    }

    @Step("Clear history")
    public void clearHistory() {
        element(CLEAR_BUTTON).click();
    }

    @Step("Click yes button")
    public void confirm() {
        element(CONFIRM_BUTTON).click();
    }
}
