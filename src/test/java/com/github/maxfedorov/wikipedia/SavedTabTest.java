package com.github.maxfedorov.wikipedia;

import Screens.SavedTab;
import Screens.TabsBottomPanel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("Start screen")
public class SavedTabTest extends TestBase {

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Create list")
    void createListTest() {
        SavedTab savedTab = new TabsBottomPanel(driver).tapSaved();
        savedTab.createNewList();
        savedTab.typeName("NewList");
        savedTab.typeDescription("Test description");
        savedTab.clickOkInCreateListPopup();
        Assertions.assertThat(savedTab.getLists()).hasSize(2);
    }

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Delete list")
    void deleteListTest() {
        SavedTab savedTab = new TabsBottomPanel(driver).tapSaved();
        savedTab.deleteList("Saved");
        savedTab.clickOkInCreateListPopup();
        Assertions.assertThat(savedTab.getLists()).isEmpty();
    }

    @Test
    @Feature("Start screen")
    @Story("Saved tab")
    @DisplayName("Edit list")
    void editListTest() {
        SavedTab savedTab = new TabsBottomPanel(driver).tapSaved();
        savedTab.editList("Saved");
        savedTab.typeName("NewList");
        savedTab.clickOkInCreateListPopup();
        SoftAssertions softAssertions = new SoftAssertions();
        List<String> list = savedTab.getListsNames();
        softAssertions.assertThat(list).hasSize(1);
        softAssertions.assertThat(list.get(0)).isEqualTo("NewList");
        softAssertions.assertAll();
    }
}
