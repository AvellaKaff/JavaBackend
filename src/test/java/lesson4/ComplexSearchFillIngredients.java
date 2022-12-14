package lesson4;

import io.restassured.http.Method;
import lesson3.AbstractTest;
import lesson4.response.FillIngredients.ComplexSearchFillIngredientsResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ComplexSearchFillIngredients extends AbstractTest {


    @Test
    void getSearchFillIngredientsTest() {
        ComplexSearchFillIngredientsResponse complexSearchFillIngredientsResponse =
                given()
                        .queryParam("fillIngredients", true)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchFillIngredientsResponse.class);
        assertThat(complexSearchFillIngredientsResponse.getResults().get(0).getMissedIngredients().get(0).getAmount(), greaterThanOrEqualTo(1.0));
    }
}
