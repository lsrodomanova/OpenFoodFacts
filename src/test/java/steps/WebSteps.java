package steps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static io.qameta.allure.Allure.step;

public class WebSteps {
    String country="France",
            country2="Russia",
            product="barilla",
            barcode="5449000000996";

    public WebSteps searchByCountry() {
        step("Выбрать поиск по стране", () -> {
            $x("//button[@class='button dropdown small']").click();
            $(byLinkText("Countries")).click();
            $("#main_column").shouldHave(text("List of countries - World"));
        });
        return this;
    }

    public WebSteps chooseCountry() {
        step("Выбрать страну и проверить", () -> {
            $(byLinkText(country)).click();
            $("#main_column").shouldHave(text("Products sold in France"));
        });
        return this;
    }

    public WebSteps changeCountry() {
        step("Изменить страну", () -> {
            $("[class=select2-selection__arrow]").click();
            $("[class=select2-search__field]").setValue("rus");
            $("[class=select2-results").find(byText(country2)).click();
        });
        return this;
    }

    public WebSteps checkCountry() {
        step("Проверить страну", () -> {
            $("#main_column").shouldHave(text("Open Food Facts - Россия"));
        });
        return this;
    }

    public WebSteps printProduct() {
        step("Ввести продукт в строку поиска", () -> {
            $x("(//input[@type='text'])[1]").setValue(product);
            $x("//button[@title='Search']").click();
        });
        return this;
    }

    public WebSteps checkList() {
        step("Проверить список", () -> {
            $("#products_all").shouldHave(text("Barilla"));
        });
        return this;
    }
    public WebSteps printBarcode() {
        step("Ввести продукт в строку поиска", () -> {
            $x("(//input[@type='text'])[1]").setValue(barcode);
            $x("//button[@title='Search']").click();
        });
        return this;
    }

    public WebSteps checkBarcodeList() {
        step("Проверить список", () -> {
            $x("//div[@itemscope]").shouldHave(text("Coca-Cola - 33cl"));
        });
        return this;
    }
    public WebSteps goToAppstore() {
        step("Перейти в App Store", () -> {
            $(byAttribute("src", "/images/misc/appstore/black/appstore_US.svg")).click();
        });
        return this;
    }
    public WebSteps chekHref() {
        step("Проверить, что открылся AppbStore", () -> {
            webdriver().shouldHave(url("https://apps.apple.com/app/open-food-facts/id588797948"));
        });
        return this;
    }

}
