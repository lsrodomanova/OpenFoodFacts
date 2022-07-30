package openfood.mobile.tests;

import com.codeborne.selenide.Selenide;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class OnboardingTest extends MobileTestBase {

    @Test
    @DisplayName("Тест onboarding")
    void onBoardingTest() {

        step("Первая страница", () -> {
            Selenide.sleep(10000);
            //$(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.xpath("//android.widget.RelativeLayout/android.widget.TextView[2]")).
                    shouldHave(text("Scan products, take them in picture, make food transparency happen"));
        });
        step("Вторая страница", () -> {
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/slide_2_desc"))
                    .shouldHave(text("Extensive information about the product you've scanned, deciphered for you"));
        });
        step("Третья страница", () -> {
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/slide_3_desc"))
                    .shouldHave(text("A synthetic view of the nutritional properties of your favorite food products"));
        });
        step("Четвертая страница", () -> {
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/slide_4_desc"))
                    .shouldHave(text("You can add new products, even if you don't have an Internet connection right now"));
        });
    }
}
