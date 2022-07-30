package openfood.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import openfood.api.models.ProductData;
import openfood.api.models.RequestCreate;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static openfood.api.tests.Specs.*;

@Tag("api")
public class AddProductTests {

    String status = "1",
            statusVerbose = "fields saved",
            code = "04963406";

    @Test
    @DisplayName("Добавление продукта")
    void addProduct() {
        RequestCreate requestCreate = new RequestCreate();
        requestCreate.setCode(code);
        ProductData data= given()
                .spec(addProduct)
                .body(requestCreate)
                .when()
                .post("/product_jqm2.pl")
                .then()
                .spec(responseAdd)
                .extract().as(ProductData.class);
        assertEquals(status, data.getStatus());
        assertEquals(statusVerbose, data.getStatusVerbose());
    }
}
