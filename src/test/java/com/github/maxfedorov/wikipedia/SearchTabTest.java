package com.github.maxfedorov.wikipedia;

import Screens.SearchTab;
import Screens.TabsBottomPanel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Start screen")



public class SearchTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Search article")
    void searchTest() {
        SearchTab searchTab = new TabsBottomPanel(driver)
                .tapSearch()
                .search("Appium");
        Assertions.assertThat(searchTab.searchResults().size()).isGreaterThan(0);
    }

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Check that opened article appears in history")
    void historyTest() {
        step("Open first article in 'Top read card'", () -> {
        });
        step("Navigate back", () -> {
        });
        step("Open Search tab", () -> {
        });
        step("Check that history contains one link", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Clear history")
    void clearHistoryTest() {
        step("Open first article in 'Top read card'", () -> {
        });
        step("Navigate back", () -> {
        });
        step("Open Search tab", () -> {
        });
        step("Type Delete button and confirm", () -> {
        });
        step("Check that history does not contain links", () -> {
        });
    }
}
