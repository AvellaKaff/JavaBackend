package lesson3;

import io.restassured.http.Method;
import lesson4.response.ComplexSearch.ComplexSearchResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ComplexSearch extends AbstractTest {
    @Test
    void getSearchTest() {
        ComplexSearchResponse complexSearch =
                given()
                        .queryParam("query", "pancake")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchResponse.class);
        assertThat(complexSearch.getResults().get(0).getTitle(), containsString("Pancake"));
    }

    @Test
    void getSearchTitleMatchTest() {
        ComplexSearchResponse complexSearch =
                given()
                        .queryParam("titleMatch", "Crock Pot")
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchResponse.class);
        assertThat(complexSearch.getResults().get(0).getTitle(), containsString("Crock Pot"));
    }

    @Test
    void getSearchNumberTest() {
        ComplexSearchResponse complexSearch =
                given()
                        .queryParam("number", 1)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchResponse.class);
        assertThat(complexSearch.getNumber(), equalTo(1));
    }

    @Test
    void getSearchOffsetTest() {
        ComplexSearchResponse complexSearch =
                given()
                        .queryParam("offset", 10)
                        .when()
                        .request(Method.GET, getBaseUrl() + getComplexSearch())
                        .then()
                        .extract()
                        .body()
                        .as(ComplexSearchResponse.class);
        assertThat(complexSearch.getOffset(), equalTo(10));
    }
}
