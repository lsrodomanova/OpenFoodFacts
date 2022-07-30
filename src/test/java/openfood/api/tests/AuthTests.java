package openfood.api.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static openfood.api.tests.Specs.*;

@Tag("api")
public class AuthTests {

    String body = "{\"user_id\": \"lrodomanova\"," +
            "\"password\": \"Qwerty\"}";

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
}
