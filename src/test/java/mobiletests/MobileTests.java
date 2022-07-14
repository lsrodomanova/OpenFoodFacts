package mobiletests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import config.LocalConfig;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Tag("android")
public class MobileTests extends TestBase {
    String login = mobConfig.login(),
            password = mobConfig.password();

    @Test
    void onBoardingTest() {

        step("Первая страница", () -> {
            Selenide.sleep(10000);
            $(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.xpath("//android.widget.TextView[2]")).
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

    @Test
    void mainScreen() {
        step("Открыть главную страницу", () -> {
            Selenide.sleep(10000);
            $(AppiumBy.id("android:id/aerr_wait")).click();
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
    @Test
    void auth() {
        step("Открыть меню авторизации", () -> {
            Selenide.sleep(10000);
            $(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Open\"]")).click();
            $(AppiumBy.xpath("//android.view.ViewGroup[9]/android.widget.TextView")).click();
        });
        step("Ввести логин и пароль", () -> {
            //$(AppiumBy.xpath("//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.EditText")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/loginInput")).sendKeys(login);
            $(AppiumBy.id("org.openfoodfacts.scanner:id/pass_input")).sendKeys(password);
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_login")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/tvDailyFoodFact"))
                    .shouldHave(text("Survey: tell Open Food Facts what to build next"));
        });
    }
    @Test
    void searchProductByName() {
        step("Открыть меню поиска", () -> {
            Selenide.sleep(10000);
            $(AppiumBy.id("android:id/aerr_wait")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("org.openfoodfacts.scanner:id/btn_next")).click();
            $(AppiumBy.id("android:id/search_button")).click();
        });
        step("Найти продукт по названию", () -> {
            $(AppiumBy.id("android:id/search_src_text")).sendKeys("macaron");
            $(AppiumBy.id("org.openfoodfacts.scanner:id/textCountProduct")).shouldHave(text("Number of results:"));
            $(AppiumBy.className("android.widget.TextView")).shouldHave(text("Macaron:"));;
        });
    }
}
