package com.github.maxfedorov.wikipedia;

import com.github.maxfedorov.wikipedia.Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.Screens.ExploreTab;
import com.github.maxfedorov.wikipedia.Screens.SearchTab;
import com.github.maxfedorov.wikipedia.Screens.TabsBottomPanel;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Start screen")
public class SearchTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Search article")
    void searchTest() {
        SearchTab searchTab = new TabsBottomPanel(driver).tapSearch();
        searchTab.search("Appium");
        Allure.step("Verify that search results contains results", () -> {
            Assertions.assertThat(searchTab.searchResults()).isNotEmpty();
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Check that opened article appears in history")
    void historyTest() {
        new ExploreTab(driver).card("Top read").clickInnerItemByNumber(1);
        new CommonSteps(driver).back();
        SearchTab searchTab = new TabsBottomPanel(driver).tapSearch();
        Allure.step("Verify that search tab history contains 1 item", () -> {
            Assertions.assertThat(searchTab.getHistoryItems()).hasSize(1);
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Search tab")
    @DisplayName("Clear history")
    void clearHistoryTest() {
        new ExploreTab(driver).card("Top read").clickInnerItemByNumber(1);
        new CommonSteps(driver).back();
        SearchTab searchTab = new TabsBottomPanel(driver).tapSearch();
        searchTab.clearHistory();
        searchTab.confirm();
        Allure.step("Verify that search tab history is empty", () -> {
            Assertions.assertThat(searchTab.getHistoryItems()).isEmpty();
        });
    }
}
