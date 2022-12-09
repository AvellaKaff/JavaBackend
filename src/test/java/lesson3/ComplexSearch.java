package lesson3;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ComplexSearch extends AbstractTest {

    @BeforeAll
    static void setUp() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }


    @Test
    void getSearchTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("query", "pancake")
                .expect()
                .body(containsString("Pancake"))
                .when()
                .get(getBaseUrl() + getComplexSearch())
                .then()
                .time(lessThan(2000L))
                .statusCode(200);
    }

    @Test
    void getSearchItalianCuisineTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("cuisine", "italian")
                .expect()
                .body(containsString("Italian"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchExcludeCuisineTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("excludeCuisine", "italian")
                .expect()
                .body(not(containsString("Italian")))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchVegetarianDietTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("diet", "vegetarian")
                .queryParam("addRecipeInformation", true)
                .queryParam("number", 1)
                .expect()
                .body("results[0].vegetarian", is(true))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .time(lessThan(2000L))
                .statusCode(200);
    }

    @Test
    void getSearchIncludeIngredientsTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("includeIngredients", "Gnocchi")
                .expect()
                .body(containsString("Gnocchi"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchExcludeIngredientsTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("excludeIngredients", "Cauliflower")
                .expect()
                .body(not(containsString("Cauliflower")))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchTypeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("type", "dessert")
                .expect()
                .body(containsString("Cake"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchFillIngredientsTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("fillIngredients", true)
                .expect()
                .body(containsString("amount"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchAuthorTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("author", "coffeebean")
                .queryParam("addRecipeInformation", true)
                .expect()
                .body(containsString("coffeebean"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchTitleMatchTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("titleMatch", "Crock Pot")
                .expect()
                .body(containsString("Crock Pot"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchMaxReadyTimeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxReadyTime", 20)
                .queryParam("addRecipeInformation", true)
                .expect()
                .body("results[0].readyInMinutes", lessThan(21))
                .body("results[1].readyInMinutes", lessThan(21))
                .body("results[2].readyInMinutes", lessThan(21))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchNumberTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("number", 1)
                .expect()
                .body("number", is(1))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchOffsetTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("offset", 10)
                .expect()
                .body("offset", is(10))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchGlutenFreeTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("intolerances", "gluten")
                .queryParam("addRecipeInformation", true)
                .expect()
                .body("results[0].glutenFree", is(true))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchEquipmentTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("equipment", "blender")
                .queryParam("addRecipeInformation", true)
                .queryParam("number", 1)
                .expect()
                .body(containsString("blender"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchAddRecipeNutritionTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("addRecipeNutrition", true)
                .expect()
                .body(containsString("nutrition"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchAddRecipeInformationTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("addRecipeInformation", true)
                .expect()
                .body(containsString("summary"))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchMinCaloriesTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("minCalories", 1000)
                .queryParam("addRecipeNutrition", true)
                .queryParam("number", 1)
                .expect()
                .body("results[0].nutrition.nutrients[0].amount", greaterThan(1000F))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchMinVitaminDTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("minVitaminD", 75)
                .queryParam("addRecipeNutrition", true)
                .expect()
                .body("results[0].nutrition.nutrients[9].amount", greaterThan(74F))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchMaxSugarTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxSugar", 5)
                .queryParam("addRecipeNutrition", true)
                .expect()
                .body("results[0].nutrition.nutrients[5].amount", lessThan(5F))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

    @Test
    void getSearchMaxFatTest() {
        given()
                .queryParam("apiKey", getApiKey())
                .queryParam("maxFat", 4)
                .queryParam("addRecipeNutrition", true)
                .queryParam("number", 1)
                .expect()
                .body("results[0].nutrition.nutrients[1].amount", lessThan(4F))
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .statusCode(200)
                .time(lessThan(2000L));
    }

}
