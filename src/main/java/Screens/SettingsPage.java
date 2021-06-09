package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

public class SettingsPage extends ScreenBase {

    private static final By WIKIPEDIA_LANGUAGES = MobileBy.xpath(".//android.widget.TextView[@text='Wikipedia languages']");
    private static final By ADD_LANGUAGE_BUTTON = MobileBy.xpath(".//android.widget.TextView[@text='Add lanuage']");
    private static final By LANGUAGE_ITEM = MobileBy.id("org.wikipedia.alpha:id/wiki_language_title");
    private static final String LANGUAGE_BUTTON = ".//android.widget.TextView[@text='%s']";

    public SettingsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click wikipedia languages")
    public void wikipediaLanguages() {
        element(WIKIPEDIA_LANGUAGES).click();
    }

    @Step("Click add language")
    public void addLanguage() {
        element(ADD_LANGUAGE_BUTTON).click();
    }

    @Step("Click language {language}")
    public void clickLanguage(String language) {
        element(MobileBy.xpath(String.format(LANGUAGE_BUTTON, language))).click();
    }

    @Step("Get languages list")
    public List<MobileElement> getLanguagesList() {
        return elements(LANGUAGE_ITEM);
    }
}
