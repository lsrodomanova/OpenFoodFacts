package openfood.web.tests;

import openfood.web.pages.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("web")
public class LinkStoresTests extends TestBase {

    String url = "https://world.openfoodfacts.org/";

    @Test
    @DisplayName("Перейти в App Store на страницу приложения")
    void findHref() {
        pages
                .openUrl(url)
                .goToAppstore()
                .chekHref();
    }
}