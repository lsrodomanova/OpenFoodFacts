package openfood.web.tests;

import openfood.web.pages.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("web")
public class SearchTests extends TestBase {

    String country = "France",
            country2 = "Russia",
            product = "barilla",
            barcode = "5449000000996",
            list = "List of countries - World",
            productCountry = "Products sold in France",
            checkText = "Open Food Facts - Россия",
            productName = "Barilla",
            checkBarcode = "Coca-Cola - 33cl",
            url="https://world.openfoodfacts.org/";

    @Test
    @DisplayName("Поиск продуктов из списка стран")
    void searchTest() {
        pages
                .openUrl(url)
                .searchByCountry(list)
                .chooseCountry(country)
                .checkText(productCountry);
    }

    @Test
    @DisplayName("Изменить страну")
    void changeCountry() {
        pages
                .openUrl(url)
                .changeCountry(country2)
                .checkCountry(checkText);
    }

    @Test
    @DisplayName("Найти продукт по названию")
    void findProductByName() {

        pages
                .openUrl(url)
                .printProduct(product)
                .checkList(productName);
    }

    @Test
    @DisplayName("Найти продукт по баркоду")
    void findProductByCode() {

        pages
                .openUrl(url)
                .printBarcode(barcode)
                .checkBarcodeList(checkBarcode);
    }
}