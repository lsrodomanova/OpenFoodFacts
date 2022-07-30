package openfood.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static openfood.api.tests.Specs.*;

@Tag("api")
public class SearchTests {

    String productName = "/cheese";

    @Test
    @DisplayName("Поиск продуктов по баркоду")
    public void getProductByBarcode() {
        given()
                .spec(requestByBarcode)
                .when()
                .get("/product/04963406")
                .then()
                .spec(responseBarcode)
                .log().body()
                .extract().response();
    }

    @Test
    @DisplayName("Поиск категорий продуктов по алфавиту")
    void firstLetterSearchCategory() {
        given()
                .spec(requestByCategory)
                .when()
                .get("/suggest.pl?tagtype=categories&term=sh")
                .then()
                .spec(responseCategory)
                .log().body();
    }

    @Test
    @DisplayName("Поиск продуктов по названию")
    public void getByProduct() {
        given()
                .spec(requestByProduct)
                .get(productName)
                .then()
                .spec(responseProduct)
                .log().body()
                .extract().response();
    }
}
