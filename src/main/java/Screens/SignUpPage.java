package Screens;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.stream.Collectors;

public class SignUpPage extends ScreenBase {

    private static final By USERNAME_FIELD = MobileBy.xpath(".//android.widget.EditText[@text='Username']");
    private static final By ERROR = MobileBy.id("org.wikipedia.alpha:id/textinput_error");

    public SignUpPage(AndroidDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Type username {user}")
    public void typeUsername(String user) {
        element(USERNAME_FIELD).sendKeys(user);
    }

    @Step("Get errors")
    public List<String> getErrors() {
        return elements(ERROR)
                .stream()
                .map(RemoteWebElement::getText)
                .collect(Collectors.toList());
    }
}
