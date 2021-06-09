package com.github.maxfedorov.wikipedia;

import Screens.SavedTab;
import Screens.TabsBottomPanel;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThat(savedTab.getLists()).hasSize(0);
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
        Assertions.assertThat(savedTab.getListsNames().get(0)).isEqualTo("NewList");
    }
}
