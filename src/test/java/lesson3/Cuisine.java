package lesson3;

import io.restassured.http.Method;
import lesson4.response.CuisineResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class Cuisine extends AbstractTest {

    String title = "title";

    @Test
    void postEnchiladaCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Enchilada")
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Mexican"));
    }

    @Test
    void postSushiCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Sushi")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine())
                .then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Japanese"));
    }

    @Test
    void postHamburgerCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "hamburger")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("American"));
    }

    @Test
    void postSconeCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Scone")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("European"));
    }

    @Test
    void postHotdogCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Hotdog")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("American"));
    }

    @Test
    void postChipsCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Chips")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("American"));
    }

    @Test
    void postNachosCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Nachos")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Mexican"));
    }

    @Test
    void postCornichePastyCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Corniche pasty")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("European"));
    }

    @Test
    void postFalafelCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Falafel")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Middle Eastern"));
    }

    @Test
    void postEmpanadasCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Empanadas")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("European"));
    }

    @Test
    void postHummusCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Hummus")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Middle Eastern"));
    }

    @Test
    void postTabboulehCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Tabbouleh")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Middle Eastern"));
    }

    @Test
    void postFattoushCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Fattoush")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Middle Eastern"));
    }

    @Test
    void postSalsaCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Salsa")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Mexican"));
    }

    @Test
    void postGuacamoleCuisineClassifyTest() {
        CuisineResponse cuisineResponse =
        given()
                .spec(requestSpecificationCuisine)
                .formParam(title, "Guacamole")
                .expect()
                .when()
                .request(Method.POST, getBaseUrl() + getCuisine()).then()
                .extract()
                .body()
                .as(CuisineResponse.class);
        assertThat(cuisineResponse.getCuisine(), containsString("Mexican"));
    }

}
