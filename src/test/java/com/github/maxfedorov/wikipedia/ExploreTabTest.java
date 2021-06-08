package com.github.maxfedorov.wikipedia;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Start screen")
public class ExploreTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open 'Today on Wikipedia'")
    void todayOnWikipediaTest() {
        step("Open 'Today on Wikipedia' link", () -> {
        });
        step("Check that wikipedia page is shown", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open 'More top read'")
    void moreTopReadTest() {
        step("Open 'More top read' link", () -> {
        });
        step("Check that Top read page is shown", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Open Picture of the day")
    void pictureOfTheDayTest() {
        step("Tap on picture in 'Picture of the day' card", () -> {
        });
        step("Check that media page is shown", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide Card by card more menu")
    void hideCardByCardMoreMenuTest() {
        step("Open more menu in 'Featured article' card", () -> {
        });
        step("Tap Hide this card", () -> {
        });
        step("Check that 'Featured article' card is not shown", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Explore tab")
    @DisplayName("Hide all Cards customize menu")
    void hideAllCardsCustomizeMenuTest() {
        step("Open more menu in 'Featured article' card", () -> {
        });
        step("Tap Customize the feed", () -> {
        });
        step("Open more menu", () -> {
        });
        step("Tap Hide all", () -> {
        });
        step("Navigate back", () -> {
        });
        step("Check that all cards are not shown", () -> {
        });
    }
}
