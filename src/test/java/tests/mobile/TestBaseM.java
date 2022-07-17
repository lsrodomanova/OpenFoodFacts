package tests.mobile;

import tests.mobile.drivers.BrowserstackMobileDriver;
import tests.mobile.helpers.AllureAttachments;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.mobile.drivers.LocalDriver;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static tests.mobile.helpers.AllureAttachments.sessionId;
import static io.qameta.allure.Allure.step;

public class TestBaseM {
    static String deviceHost = System.getProperty("deviceHost", "local");

    @BeforeAll
    public static void setup() {
        if (Objects.equals(deviceHost, "local")) {
            Configuration.browser = LocalDriver.class.getName();
        } else {
            Configuration.browser = BrowserstackMobileDriver.class.getName();
      }
        Configuration.browserSize = null;
    }

    @BeforeEach
    public void startDriver() {
        addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    public void afterEach() {
        String deviceHost = System.getProperty("deviceHost", "local");

        String sessionId = sessionId();
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();

        step("Close driver", Selenide::closeWebDriver);
        if (Objects.equals(deviceHost, "browserstack")) {
            AllureAttachments.video(sessionId);
        }
    }
}

