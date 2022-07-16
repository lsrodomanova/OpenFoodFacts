package tests.api;

import tests.api.models.RequestCreate;
import tests.api.models.ProductData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static tests.api.Specs.*;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("api")
public class ApiTests {


    String
            body = "{\"user_id\": \"lrodomanova\",\n" +
            "    \"password\": \"Qwerty\"}",
            //body2 ="{\"code\": \"04963406\"}",
            status="1",
            status_verbose="fields saved",
            productName="/cheese",
            code="04963406";


    @Test
    @DisplayName("Поиск продуктов по баркоду")
    public void getByBarcode() {
        given()
                .spec(request)
                .when()
                .get("/product/59032823")
                .then()
                .spec(responseSpec)
                .log().body()
                .extract().response();
    }

    @Test
    @DisplayName("Поиск категорий продуктов по алфавиту")
    void firstLetterSearchCategory() {
        given()
                .spec(requestCategory)
                .when()
                .get("/suggest.pl?tagtype=categories&term=sh")
                .then()
                .spec(responseCategory)
                .log().body()
                ;
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

    @Test
    @DisplayName("Авторизация")
    void authorization() {
        given()
                .spec(requestAuth)
                .body(body)
                .when()
                .post("/user.pl")
                .then()
                .spec(responseAuth)
                .extract().response();

    }

    @Test
    @DisplayName("Добавление продукта")
    void addProduct() {
        RequestCreate requestCreate = new RequestCreate();
        requestCreate.setCode(code);
        //requestCreate.setUser_id("lrodomanova");
        //requestCreate.setPassword("Qwerty");

        ProductData data= given()
                .spec(addProduct)
                .body(requestCreate)
                .when()
                .post("/product_jqm2.pl")
                .then()
                .spec(responseAdd)
                .extract().as(ProductData.class);
        assertEquals(status, data.getStatus());
        assertEquals(status_verbose, data.getStatus_verbose());
    }
}
