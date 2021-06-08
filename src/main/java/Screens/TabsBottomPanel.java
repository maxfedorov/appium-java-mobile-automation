package Screens;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class TabsBottomPanel extends ScreenBase {
    public TabsBottomPanel(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap Saved")
    public SavedTab tapSaved() {
        tapTab("Saved");
        return new SavedTab(driver);
    }

    @Step("Tap Search")
    public SearchTab tapSearch() {
        tapTab("Search");
        return new SearchTab(driver);
    }

    @Step("Tap More")
    public MoreTab tapMore() {
        tapTab("More");
        return new MoreTab(driver);
    }

    private void tapTab(String tab) {
        element(xpath(format("//android.widget.FrameLayout[@content-desc='%s']", tab))).click();
    }
}
