package lesson4;

import io.restassured.http.Method;
import lesson3.AbstractTest;
import lesson4.response.AddRecipeNutrition.ComplexSearchAddRecipeNutritionResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ComplexSearchAddRecipeNutrition extends AbstractTest {
    @Test
    void getSearchAddRecipeNutritionTest() {
        ComplexSearchAddRecipeNutritionResponse complexSearchAddRecipeNutritionResponse =
                given()
                        .spec(requestSpecificationNutrition)
                        .expect()
                        .body(containsString("nutrition"))
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeNutritionResponse.class);
             assertThat(complexSearchAddRecipeNutritionResponse.getResults().get(0).getNutrition().getNutrients().get(0).getName(), containsString("Calories"));
    }

    @Test
    void getSearchMinCaloriesTest() {
        ComplexSearchAddRecipeNutritionResponse complexSearchAddRecipeNutritionResponse =
                given()
                        .spec(requestSpecificationNutrition)
                        .queryParam("minCalories", 1000)
                        .queryParam("number", 1)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeNutritionResponse.class);
        assertThat(complexSearchAddRecipeNutritionResponse.getResults().get(0).getNutrition().getNutrients().get(0).getAmount(), greaterThanOrEqualTo(1000.0));
    }

    @Test
    void getSearchMinVitaminDTest() {
        ComplexSearchAddRecipeNutritionResponse complexSearchAddRecipeNutritionResponse =
                given()
                        .spec(requestSpecificationNutrition)
                        .queryParam("minVitaminD", 75)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeNutritionResponse.class);
        assertThat(complexSearchAddRecipeNutritionResponse.getResults().get(0).getNutrition().getNutrients().get(9).getAmount(), greaterThanOrEqualTo(74.0));
    }

    @Test
    void getSearchMaxSugarTest() {
        ComplexSearchAddRecipeNutritionResponse complexSearchAddRecipeNutritionResponse =
                given()
                        .spec(requestSpecificationNutrition)
                        .queryParam("maxSugar", 5)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeNutritionResponse.class);
        assertThat(complexSearchAddRecipeNutritionResponse.getResults().get(0).getNutrition().getNutrients().get(5).getAmount(), lessThanOrEqualTo(5.0));
    }

    @Test
    void getSearchMaxFatTest() {
        ComplexSearchAddRecipeNutritionResponse complexSearchAddRecipeNutritionResponse =
                given()
                .spec(requestSpecificationNutrition)
                .queryParam("maxFat", 4)
                .queryParam("number", 1)
                .when()
                .request(Method.GET, getBaseUrl() + getComplexSearch())
                .then()
                .extract()
                .body()
                .as(ComplexSearchAddRecipeNutritionResponse.class);
        assertThat(complexSearchAddRecipeNutritionResponse.getResults().get(0).getNutrition().getNutrients().get(1).getAmount(), lessThanOrEqualTo(4.0));
    }
}
