package lesson3;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.lessThan;

public class Cuisine extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    void postEnchiladaCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Enchilada")
                .expect()
                .body(containsString("Mexican"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postSushiCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Sushi")
                .expect()
                .body(containsString("Japanese"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postHamburgerCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","hamburger")
                .expect()
                .body(containsString("American"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postSconeCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Scone")
                .expect()
                .body(containsString("European"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postHotdogCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Hotdog")
                .expect()
                .body(containsString("American"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postChipsCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Chips")
                .expect()
                .body(containsString("American"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postNachosCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Nachos")
                .expect()
                .body(containsString("Mexican"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postCornichePastyCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Corniche pasty")
                .expect()
                .body(containsString("European"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postFalafelCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Falafel")
                .expect()
                .body(containsString("Middle Eastern"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postEmpanadasCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Empanadas")
                .expect()
                .body(containsString("European"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void postHummusCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Hummus")
                .expect()
                .body(containsString("Middle Eastern"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }
    @Test
    void postTabboulehCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Tabbouleh")
                .expect()
                .body(containsString("Middle Eastern"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }
    @Test
    void postFattoushCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Fattoush")
                .expect()
                .body(containsString("Middle Eastern"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }
    @Test
    void postSalsaCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Salsa")
                .expect()
                .body(containsString("Mexican"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }
    @Test
    void postGuacamoleCuisineClassifyTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .contentType("application/x-www-form-urlencoded")
                .formParam("title","Guacamole")
                .expect()
                .body(containsString("Mexican"))
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .prettyPeek()
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

}
