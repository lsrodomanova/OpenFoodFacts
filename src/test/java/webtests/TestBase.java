package webtests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
//import config.CredentialsConfig;
//import helpers.Attach;
import config.WebConfig;
import helpers.AllureAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.qameta.allure.Allure.step;

public class TestBase {
    static WebConfig config = ConfigFactory.create(WebConfig.class);


    @BeforeAll
    static void setUp() {
        String login = config.login();
       String password = config.password();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://"+login+":"+password+"@"+"selenoid.autotests.cloud/wd/hub";



        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    public void openUrl() {
        step("Открыть главную страницу", () -> {
            Selenide.open("https://world.openfoodfacts.org/");
        });
    }

    @AfterEach
    void addAttachments() {
        AllureAttachments.screenshotAs("Last screenshot");
        AllureAttachments.pageSource();
        //AllureAttachments.browserConsoleLogs();
        //AllureAttachments.addVideo();
    }
}
