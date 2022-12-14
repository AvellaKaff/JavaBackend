package lesson4;

import io.restassured.http.Method;
import lesson3.AbstractTest;
import lesson4.response.AddRecipeInformation.ComplexSearchAddRecipeInformationResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ComplexSearchAddRecipeInformation extends AbstractTest {

    @Test
    void getSearchAddRecipeInformationTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .expect()
                        .body(containsString("summary"))
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getSummary(), containsString("href"));
    }

    @Test
    void getSearchItalianCuisineTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("cuisine", "mediterranean")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getCuisines().get(0), containsString("Mediterranean"));
    }

    @Test
    void getSearchExcludeCuisineTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("excludeCuisine", "italian")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getCuisines().get(0), not(containsString("Italian")));
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getCuisines().get(1), not(containsString("Italian")));
    }

    @Test
    void getSearchVegetarianDietTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("diet", "vegetarian")
                        .queryParam("number", 1)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getVegetarian(), is(true));
    }

    @Test
    void getSearchAuthorTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("author", "coffeebean")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getAuthor(), containsString("coffeebean"));
    }

    @Test
    void getSearchMaxReadyTimeTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("maxReadyTime", 20)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getReadyInMinutes(), lessThan(21));
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(1).getReadyInMinutes(), lessThan(21));
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(2).getReadyInMinutes(), lessThan(21));
    }

    @Test
    void getSearchEquipmentTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("equipment", "blender")
                        .queryParam("number", 1)
                        .expect()
                        .body(containsString("blender"))
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getAnalyzedInstructions().get(0).getSteps().get(0).getEquipment().get(0).getName(), containsString("blender"));
    }

    @Test
    void getSearchIncludeIngredientsTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("includeIngredients", "Gnocchi")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getTitle(), containsString("Gnocchi"));
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(1).getTitle(), containsString("Gnocchi"));

    }

    @Test
    void getSearchTypeTest() {
        ComplexSearchAddRecipeInformationResponse complexSearchAddRecipeInformationResponse =
                given()
                        .spec(requestSpecificationInformation)
                        .queryParam("type", "dessert")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchAddRecipeInformationResponse.class);
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(0).getDishTypes().get(0), containsString("dessert"));
        assertThat(complexSearchAddRecipeInformationResponse.getResults().get(1).getDishTypes().get(0), containsString("dessert"));
    }
}
