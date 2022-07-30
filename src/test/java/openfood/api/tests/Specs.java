package openfood.api.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static org.hamcrest.Matchers.containsString;

public class Specs {
    static String baseUriDev = "https://world.openfoodfacts.org",
            baseUriAuth = "https://off:off@world.openfoodfacts.net";

    public static RequestSpecification requestByBarcode = with()
            .baseUri(baseUriDev)
            .basePath("/api/v2")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification requestByCategory = with()
            .baseUri(baseUriDev)
            .basePath("/cgi")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification requestByProduct = with()
            .baseUri(baseUriDev)
            .basePath("/category")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification requestAuth = with()
            .baseUri(baseUriAuth)
            .basePath("/cgi/")
            .log().all()
            .contentType(ContentType.JSON);

    public static RequestSpecification addProduct = with()
            .baseUri(baseUriAuth)
            .basePath("/cgi")
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification responseBarcode = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("Coca-Cola"))
            .build();

    public static ResponseSpecification responseCategory = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("Shallots"))
            .build();

    public static ResponseSpecification responseProduct = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(containsString("cheeses"))
            .build();

    public static ResponseSpecification responseAuth = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();

    public static ResponseSpecification responseAdd = new ResponseSpecBuilder()
            .expectStatusCode(200)
            //.expectBody(containsString("Missing password"))
            .build();
}
