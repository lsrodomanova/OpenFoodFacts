package openfood.mobile.tests;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class AuthTests extends MobileTestBase {

    String login = "lrodomanova",
            password = "Qwerty";

    @Test
    @DisplayName("Авторизация")
    void auth() {
        step("Открыть меню авторизации", () -> {
            Selenide.sleep(10000);
            //$(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Open\"]")).click();
            $(AppiumBy.xpath("//android.view.ViewGroup[9]/android.widget.TextView")).click();
        });
        step("Ввести логин и пароль", () -> {
            $(AppiumBy.id("org.openfoodfacts.scanner:id/loginInput")).sendKeys(login);
            $(AppiumBy.id("org.openfoodfacts.scanner:id/pass_input")).sendKeys(password);
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_login")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/tvDailyFoodFact"))
                    .shouldHave(text("Survey: tell Open Food Facts what to build next"));
        });
    }
}
