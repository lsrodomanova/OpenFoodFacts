package openfood.web.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class Pages {

    @Step("Открыть сайт")
    public Pages openUrl(String url) {
        open(url);
        return this;
    }

    @Step("Выбрать поиск по стране")
    public Pages searchByCountry(String list) {
        $x("//button[@class='button dropdown small']").click();
        $(byLinkText("Countries")).click();
        $("#main_column").shouldHave(text(list));
        return this;
    }

    @Step("Выбрать страну")
    public Pages chooseCountry(String country) {
        $(byLinkText(country)).click();
        return this;
    }

    @Step("Проверить текст")
    public Pages checkText(String productCountry) {
        $("#main_column").shouldHave(text(productCountry));
        return this;
    }

    @Step("Изменить страну")
    public Pages changeCountry(String country2) {
        $("[class=select2-selection__arrow]").click();
        $("[class=select2-search__field]").setValue("rus");
        $("[class=select2-results").find(byText(country2)).click();
        return this;
    }

    @Step("Проверить страну")
    public Pages checkCountry(String checkText) {
        $("#main_column").shouldHave(text(checkText));
        return this;
    }

    @Step("Ввести продукт в строку поиска")
    public Pages printProduct(String product) {
        $x("(//input[@type='text'])[1]").setValue(product);
        $x("//button[@title='Search']").click();
        return this;
    }

    @Step("Проверить список продуктов после поиска")
    public Pages checkList(String productName) {
        $("#products_all").shouldHave(text(productName));
        return this;
    }

    @Step("Ввести баркод продукта в строку поиска")
    public Pages printBarcode(String barcode) {
        $x("(//input[@type='text'])[1]").setValue(barcode);
        $x("//button[@title='Search']").click();
        return this;
    }

    @Step("Проверить список продуктов по баркоду")
    public Pages checkBarcodeList(String checkBarcode) {
        $x("//div[@itemscope]").shouldHave(text(checkBarcode));
        return this;
    }

    @Step("Перейти в App Store")
    public Pages goToAppstore() {
        $(byAttribute("src", "/images/misc/appstore/black/appstore_US.svg")).click();
        return this;
    }

    @Step("Проверить, что открылся AppStore")
    public Pages chekHref() {
        webdriver().shouldHave(url("https://apps.apple.com/app/open-food-facts/id588797948"));
        return this;
    }
}
