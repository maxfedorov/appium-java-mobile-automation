package com.github.maxfedorov.wikipedia;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

@DisplayName("Start screen")
public class SavedTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Create list")
    void createListTest() {
        step("Open Saved tab", () -> {
        });
        step("Open more menu", () -> {
        });
        step("Tap 'Create new list'", () -> {
        });
        step("Type name and description", () -> {
        });
        step("Tap OK", () -> {
        });
        step("Check that there are two lists on the screen", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Delete list")
    void deleteListTest() {
        step("Open Saved tab", () -> {
        });
        step("Long tap on '' list", () -> {
        });
        step("Tap 'Delete list'", () -> {
        });
        step("Check that there are no lists on the screen", () -> {
        });
    }

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Edit list")
    void editListTest() {
        step("Open Saved tab", () -> {
        });
        step("Long tap on '' list", () -> {
        });
        step("Tap 'Edit name/description'", () -> {
        });
        step("Type name and description", () -> {
        });
        step("Tap OK", () -> {
        });
        step("Check that first list has correct name and description", () -> {
        });
    }
}
