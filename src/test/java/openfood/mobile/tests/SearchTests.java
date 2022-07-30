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
public class SearchTests extends MobileTestBase {

    String product = "cola";

    @Test
    @DisplayName("Поиск продукта по названию")
    void searchProductByName() {
        step("Открыть меню поиска", () -> {
            Selenide.sleep(10000);
            //$(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("android:id/search_button")).click();
        });
        step("Найти продукт по названию", () -> {
            $(AppiumBy.id("android:id/search_src_text")).sendKeys(product+"\\n");
            $(AppiumBy.id("org.openfoodfacts.scanner:id/textCountProduct")).shouldHave(text("Number of results:"));
            $(AppiumBy.xpath("//android.widget.TextView[1]")).shouldHave(text(product));;
        });
    }
}
