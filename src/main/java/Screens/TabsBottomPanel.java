package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class TabsBottomPanel extends ScreenBase {
    private static final String TAB = "//android.widget.FrameLayout[@content-desc='%s']";

    public TabsBottomPanel(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    public SavedTab tapSaved() {
        tapTab("Saved");
        return new SavedTab(driver);
    }

    public SearchTab tapSearch() {
        tapTab("Search");
        return new SearchTab(driver);
    }

    public MoreTab tapMore() {
        tapTab("More");
        return new MoreTab(driver);
    }

    @Step("Tap tab {tab}")
    private void tapTab(String tab) {
        element(xpath(format(TAB, tab))).click();
    }
}
