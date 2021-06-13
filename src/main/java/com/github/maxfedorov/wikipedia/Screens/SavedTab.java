package com.github.maxfedorov.wikipedia.Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SavedTab extends ScreenBase {

    private static final By MENU_BUTTON = MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button");
    private static final By CREATE_NEW_LIST_BUTTON = MobileBy.id("org.wikipedia.alpha:id/reading_lists_overflow_create_new_list");
    private static final By NAME_FIELD = MobileBy.xpath("(.//*[@resource-id='android:id/content']//*[@resource-id='org.wikipedia.alpha:id/text_input'])[1]");
    private static final By DESCRIPTION_FIELD = MobileBy.id("org.wikipedia.alpha:id/secondary_text_input");
    private static final By OK_BUTTON = MobileBy.xpath(".//android.widget.Button[@text='OK']");
    private static final By LIST_ELEMENT = MobileBy.id("org.wikipedia.alpha:id/item_title");
    private static final By DELETE_LIST_BUTTON = MobileBy.xpath(".//android.widget.TextView[@text='Delete list']");
    private static final By EDIT_LIST_BUTTON = MobileBy.xpath(".//android.widget.TextView[@text='Edit name/description']");
    private static final String LIST_BY_NAME = ".//*[@resource-id='org.wikipedia.alpha:id/item_title' and @text='%s']";

    public SavedTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Create new list")
    public void createNewList() {
        openMenu();
        element(CREATE_NEW_LIST_BUTTON).click();
    }

    @Step("Open menu")
    private void openMenu() {
        element(MENU_BUTTON).click();
    }

    @Step("Type name {name}")
    public void typeName(String name) {
        MobileElement element = element(NAME_FIELD);
        element.clear();
        element.sendKeys(name);
    }

    @Step("Type description {description}")
    public void typeDescription(String description) {
        MobileElement element = element(DESCRIPTION_FIELD);
        element.clear();
        element.sendKeys(description);
    }

    @Step("Click OK in create list popup")
    public void clickOkInCreateListPopup() {
        element(OK_BUTTON).click();
    }

    @Step("Get lists")
    public List<MobileElement> getLists() {
        return elements(LIST_ELEMENT);
    }

    @Step("Get lists names")
    public List<String> getListsNames() {
        return getLists()
                .stream()
                .map(RemoteWebElement::getText)
                .collect(Collectors.toList());
    }

    @Step("Delete list {name}")
    public void deleteList(String name) {
        longTapOnList(name);
        element(DELETE_LIST_BUTTON).click();
    }

    @Step("Edit list {name}")
    public void editList(String name) {
        longTapOnList(name);
        element(EDIT_LIST_BUTTON).click();
    }

    @Step("Long tap on list {name}")
    private void longTapOnList(String name) {
        new TouchAction(driver)
                .longPress(LongPressOptions.longPressOptions()
                        .withElement(ElementOption.element(element(MobileBy.xpath(String.format(LIST_BY_NAME, name))))))
                .perform();
    }
}
