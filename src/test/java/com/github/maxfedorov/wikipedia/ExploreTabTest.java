package com.github.maxfedorov.wikipedia;

import Screens.*;
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
        Assertions.assertThat(new ArticlePage(driver).isOpen())
                .as("Article page should be shown, but it is not")
                .isTrue();
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open 'More top read'")
    void moreTopReadTest() {
        new ExploreTab(driver).clickCategoryLink("More top read");
        TopReadPage topReadPage = new TopReadPage(driver);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(topReadPage.isOpen())
                .as("Article page should be shown, but it is not")
                .isTrue();
        softAssertions.assertThat(topReadPage.getItemsList()).isNotEmpty();
        softAssertions.assertAll();
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open Picture of the day")
    void pictureOfTheDayTest() {
        new ExploreTab(driver).clickCategoryPicture("Picture of the day");
        Assertions.assertThat(new MediaPage(driver).isOpen())
                .as("Media page should be shown, but it is not")
                .isTrue();
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide Card by card more menu")
    void hideCardByCardMoreMenuTest() {
        ExploreTab exploreTab = new ExploreTab(driver);
        exploreTab.card("Featured article").hide();
        Assertions.assertThat(exploreTab.card("Featured article").isVisible())
                .as("Card Featured article should be invisible, but it is visible")
                .isFalse();
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide all Cards customize menu")
    void hideAllCardsCustomizeMenuTest() {
        ExploreTab exploreTab = new ExploreTab(driver);
        exploreTab.card("Featured article").customizeTheFeed();
        exploreTab.customizeScreen().hideAll();
        new CommonSteps(driver).back();
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(exploreTab.card("Featured article").isVisible())
                .as("Card Featured article should be invisible, but it is visible")
                .isFalse();
        softAssertions.assertThat(exploreTab.card("Random article").isVisible())
                .as("Card Random article should be invisible, but it is visible")
                .isFalse();
        softAssertions.assertAll();
    }
}
