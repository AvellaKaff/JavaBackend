package lesson3;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;

public class MealPlan extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    void getShoppingListTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .when()
                .request(Method.GET, getBaseUrl() + "/mealplanner/{username}/shopping-list", getUserName())
                .then()
                .statusCode(200);
    }

    @Test
    void deleteFromShoppingListTest() {
        String id = given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .body("{\n"
                        + "\"item\": \"apple\", \n"
                        + "}")
                .when()
                .request(Method.POST, getBaseUrl() + "/mealplanner/{username}/shopping-list/items", getUserName())
                .then()
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("id")
                .toString();

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .when()
                .request(Method.DELETE, getBaseUrl() + "/mealplanner/{username}/shopping-list/items/{id}", getUserName(), id)
                .then()
                .statusCode(200);

        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("hash", getHash())
                .expect()
                .body(not(containsString(id)))
                .when()
                .request(Method.GET, getBaseUrl() + "/mealplanner/{username}/shopping-list", getUserName())
                .then()
                .statusCode(200);
    }
}
