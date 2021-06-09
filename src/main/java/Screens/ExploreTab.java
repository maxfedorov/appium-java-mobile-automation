package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ExploreTab extends ScreenBase {

    private static final String CARD = ".//*[resource-id='org.wikipedia.alpha:id/view_card_header_title' and text='%s']/parent::*/parent::*";
    private static final String CATEGORY_LINK = ".//android.widget.Button[@text='%s']";
    private static final String CATEGORY_PICTURE = CARD + "//*[resource-id='org.wikipedia.alpha:id/view_featured_image_card_image']";

    public ExploreTab(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Click category link {name}")
    public void clickCategoryLink(String name) {
        element(MobileBy.xpath(String.format(CATEGORY_LINK, name))).click();
    }

    @Step("Click category picture {name}")
    public void clickCategoryPicture(String name) {
        element(MobileBy.xpath(String.format(CATEGORY_PICTURE, name))).click();
    }

    public Card card(String name) {
        return new Card(name);
    }

    public CustomizeScreen customizeScreen() {
        return new CustomizeScreen();
    }

    public class CustomizeScreen {
        private final By MENU_BUTTON = MobileBy.xpath(".//*[@content-desc='More options']");
        private final By HIDE_ALL_BUTTON = MobileBy.xpath(".//android.widget.TextView[@text='Hide all']");

        @Step("Hide all in customize screen")
        public void hideAll() {
            openMenu();
            element(HIDE_ALL_BUTTON).click();
        }

        @Step("Open menu in customize screen")
        private void openMenu() {
            element(MENU_BUTTON).click();
        }
    }

    public class Card {
        private final String INNER_ITEM = ".//*[@resource-id='org.wikipedia.alpha:id/view_list_card_list']//android.view.ViewGroup[@index='%s']";
        private final By MENU_BUTTON = MobileBy.id("org.wikipedia.alpha:id/view_list_card_header_menu");
        private final By HIDE_THIS_CARD_BUTTON = MobileBy.xpath(".//android.widget.TextView[@text='Hide this card']");
        private final By CUSTOMIZE_THE_FEED = MobileBy.xpath(".//android.widget.TextView[@text='Customize the feed']");
        private final By card;

        public Card(String name) {
            card = MobileBy.xpath(String.format(CARD, name));
        }

        @Step("Hide card")
        public void hide() {
            openMenu();
            element(HIDE_THIS_CARD_BUTTON).click();
        }

        @Step("Customize the feed")
        public void customizeTheFeed() {
            element(CUSTOMIZE_THE_FEED).click();
        }

        @Step("Open menu for card")
        private void openMenu() {
            element(card).findElement(MENU_BUTTON).click();
        }

        @Step("Check if card is visible")
        public boolean isVisible() {
            return !elements(card).isEmpty();
        }

        @Step("Click inner item {number} in card")
        public void clickInnerItemByNumber(int number) {
            element(MobileBy.xpath(String.format(INNER_ITEM, number - 1))).click();
        }
    }
}
