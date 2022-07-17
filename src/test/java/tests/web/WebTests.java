package tests.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.web.helper.WebSteps;

@Tag("web")
public class WebTests extends TestBase{

    WebSteps steps = new WebSteps();


    @Test
    @DisplayName("Поиск продуктов из списка стран")
    void searchTest() {
        steps
                .searchByCountry()
                .chooseCountry();
    }

    @Test
    @DisplayName("Изменить страну")
    void changeCountry() {
        steps
                .changeCountry()
                .checkCountry();
    }

    @Test
    @DisplayName("Найти продукт по названию")
    void findProductByName() {

        steps
                .printProduct()
                .checkList();
    }

    @Test
    @DisplayName("Найти продукт по баркоду")
    void findProductByCode() {

        steps
                .printBarcode()
                .checkBarcodeList();
    }

    @Test
    @DisplayName("Перейти в App Store на страницу приложения")
    void findHref() {
        steps
                .goToAppstore()
                .chekHref();
    }
}