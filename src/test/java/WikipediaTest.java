import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class WikipediaTest extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        step("Type search", () -> {
            driver.findElement(MobileBy.AccessibilityId("Search Wikipedia")).click();
            driver.findElement(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).sendKeys("BrowserStack");
        });
        step("Verify content found", () -> {
            Assertions.assertThat(driver.findElements(MobileBy.id("org.wikipedia.alpha:id/page_list_item_title")).size()).isGreaterThan(0);
        });
    }
}
