package tests.api;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {
    public static RequestSpecification request = with()
            .baseUri("https://world.openfoodfacts.org")
            .basePath("/tests/api/v2")
            .log().all()
            .contentType(ContentType.JSON)
            ;
    public static RequestSpecification requestCategory = with()
            .baseUri("https://world.openfoodfacts.org")
            .basePath("/cgi")
            .log().all()
            .contentType(ContentType.JSON)
            ;
    public static RequestSpecification requestByProduct = with()
            .baseUri("https://world.openfoodfacts.org")
            .basePath("/category")
            .log().all()
            .contentType(ContentType.JSON)
            ;
    public static RequestSpecification requestAuth = with()
            .baseUri("https://off:off@world.openfoodfacts.net")
            .basePath("/cgi/")
            .log().all()
            .contentType(ContentType.JSON)
            ;
    public static RequestSpecification addProduct = with()
            .baseUri("https://off:off@world.openfoodfacts.net")
            .basePath("/cgi")
            .log().all()
            .contentType(ContentType.JSON)
            ;

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString ("Nutella t630"))
            .build();

    public static ResponseSpecification responseCategory = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString ("Shallots"))
            .build();
    public static ResponseSpecification responseProduct = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString ("cheeses"))
            .build();
    public static ResponseSpecification responseAuth = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    public static ResponseSpecification responseAdd = new ResponseSpecBuilder()
            .expectStatusCode(200)
            //.expectBody(containsString("Missing password"))
            .build();
}
