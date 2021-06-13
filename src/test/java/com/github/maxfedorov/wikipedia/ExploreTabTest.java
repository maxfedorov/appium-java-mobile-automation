package com.github.maxfedorov.wikipedia;

import com.github.maxfedorov.wikipedia.Screens.ArticlePage;
import com.github.maxfedorov.wikipedia.Screens.CommonSteps;
import com.github.maxfedorov.wikipedia.Screens.ExploreTab;
import com.github.maxfedorov.wikipedia.Screens.TopReadPage;
import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Start screen")
public class ExploreTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open 'Today on Wikipedia'")
    void todayOnWikipediaTest() {
        new ExploreTab(driver).clickCategoryLink("Today on Wikipedia");
        Allure.step("Verify that article is shown", () -> {
            Assertions.assertThat(new ArticlePage(driver).isOpen())
                    .as("Article page should be shown, but it is not")
                    .isTrue();
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open 'More top read'")
    void moreTopReadTest() {
        new ExploreTab(driver).clickCategoryLink("More top read");
        TopReadPage topReadPage = new TopReadPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        Allure.step("Verify that article is shown", () -> {
            softAssertions.assertThat(topReadPage.isOpen())
                    .as("Article page should be shown, but it is not")
                    .isTrue();
        });
        Allure.step("Verify that there are articles on the page", () -> {
            softAssertions.assertThat(topReadPage.getItemsList()).isNotEmpty();
        });

        softAssertions.assertAll();
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide Card by card more menu")
    void hideCardByCardMoreMenuTest() {
        ExploreTab exploreTab = new ExploreTab(driver);
        exploreTab.card("Featured article").hide();
        Allure.step("Verify that Featured article card is visible", () -> {
            Assertions.assertThat(exploreTab.card("Featured article").isVisible())
                    .as("Card Featured article should be invisible, but it is visible")
                    .isFalse();
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide all Cards customize menu")
    void hideAllCardsCustomizeMenuTest() {
        ExploreTab exploreTab = new ExploreTab(driver);
        exploreTab.gotIt();
        exploreTab.card("Featured article").customizeTheFeed();
        exploreTab.customizeScreen().hideAll();
        new CommonSteps(driver).back();
        Allure.step("Verify that all cards are hidden", () -> {
            Assertions.assertThat(exploreTab.getCardsTitles()).isEmpty();
        });
    }
}
