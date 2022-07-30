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
public class PagesTests extends MobileTestBase {

    @Test
    @DisplayName("Проверка перехода на главную страницу")
    void mainScreen() {
        step("Открыть главную страницу", () -> {
            Selenide.sleep(10000);
            //$(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/tvDailyFoodFact"))
                    .shouldHave(text("Survey: tell Open Food Facts what to build next"));
        });
        step("Перейти с главной страницы", () -> {
            $(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"History\"]/android.widget.ImageView")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/empty_history_info"))
                    .shouldHave(text("Your viewed product history will be listed here. This history is for your eyes only and is stored locally."));
        });
        step("Вернуться на главную страницу через меню на таббаре", () -> {
            $(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.ImageView")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/tvDailyFoodFact"))
                    .shouldHave(text("Survey: tell Open Food Facts what to build next"));
        });
    }
}
