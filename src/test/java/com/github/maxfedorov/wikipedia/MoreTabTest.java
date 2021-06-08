package com.github.maxfedorov.wikipedia;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Start screen")
public class MoreTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Open history")
    void OpenHistoryTest() {
        step("Open More tab", () -> {
        });
        step("Tap history", () -> {
        });
        step("Check that search tab is open", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Create account with non available user")
    void CreateAccountWithNonAvailableUserTest() {
        step("Open More tab", () -> {
        });
        step("Tap 'Log in / Join Wikipedia'", () -> {
        });
        step("Type username 'user'", () -> {
        });
        step("Check that Error message is shown", () -> {
        });
        step("Check that Next button is disabled", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("More tab")
    @DisplayName("Add language")
    void AddLanguageTest() {
        step("Open More tab", () -> {
        });
        step("Open Setting", () -> {
        });
        step("Open Wikipedia languages", () -> {
        });
        step("Tap add language", () -> {
        });
        step("Add first language", () -> {
        });
        step("Check that there are two languages in the list", () -> {
        });
    }
}
