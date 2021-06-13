package com.github.maxfedorov.wikipedia;

import Screens.*;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Start screen")
public class MoreTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Open history")
    void OpenHistoryTest() {
        MoreTab moreTab = new TabsBottomPanel(driver).tapMore();
        moreTab.openHistory();
        Allure.step("Verify that search tab is shown", () -> {
            Assertions.assertThat(new SearchTab(driver).isOpen())
                    .as("Search tab should be shown, but it is not")
                    .isTrue();
        });
    }

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Create account with non available user")
    void CreateAccountWithNonAvailableUserTest() {
        MoreTab moreTab = new TabsBottomPanel(driver).tapMore();
        SignUpPage signUpPage = moreTab.logIn();
        signUpPage.typeUsername("user");
        List<String> errors = signUpPage.getErrors();
        String expectedError = "The user name \"user\" is not available. Please choose a different name.";
        SoftAssertions softAssertions = new SoftAssertions();
        Allure.step("Verify that error is shown", () -> {
            softAssertions.assertThat(errors).hasSize(1);
        });
        Allure.step("Verify error text", () -> {
            softAssertions.assertThat(errors.get(0)).isEqualTo(expectedError);
        });
        softAssertions.assertAll();
    }

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Add language")
    void AddLanguageTest() {
        MoreTab moreTab = new TabsBottomPanel(driver).tapMore();
        SettingsPage settingsPage = moreTab.settings();
        settingsPage.wikipediaLanguages();
        settingsPage.addLanguage();
        settingsPage.clickLanguage("Deutsch");
        Allure.step("Verify that language list contains Deutsch", () -> {
            Assertions.assertThat(settingsPage.getLanguagesList()).contains("Deutsch");
        });
    }
}
