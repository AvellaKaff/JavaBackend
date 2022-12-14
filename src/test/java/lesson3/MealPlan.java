package lesson3;

import io.restassured.http.Method;
import lesson4.request.ShopingListRequest;
import lesson4.response.ShopingListPost.PostShopingListResponse;
import lesson4.response.ShoppingListGet.GetShopingListResponse;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealPlan extends AbstractTest {


    @Test
    void getShoppingListTest() {
        given()
                .spec(requestSpecificationMealPlan)
                .when()
                .request(Method.GET, getBaseUrl() + "/mealplanner/{username}/shopping-list", getUserName());
    }

    @Test
    void deleteFromShoppingListTest() {
        ShopingListRequest shopingListRequest = new ShopingListRequest("apple");
        PostShopingListResponse postShopingListResponse =
                given()
                        .spec(requestSpecificationMealPlan)
                        .body(shopingListRequest)
                        .when()
                        .request(Method.POST, getBaseUrl() + "/mealplanner/{username}/shopping-list/items", getUserName())
                        .then()
                        .extract()
                        .body()
                        .as(PostShopingListResponse.class);

        String id = postShopingListResponse.getId().toString();

        given()
                .spec(requestSpecificationMealPlan)
                .when()
                .request(Method.DELETE, getBaseUrl() + "/mealplanner/{username}/shopping-list/items/{id}", getUserName(), id);

        given()
                .spec(requestSpecificationMealPlan)
                .expect()
                .body(not(containsString(id)))
                .when()
                .request(Method.GET, getBaseUrl() + "/mealplanner/{username}/shopping-list", getUserName());
    }

    @Test
    void getShoppingListAisleTest() {
        ShopingListRequest shopingListRequest = new ShopingListRequest("5 eggs");
        PostShopingListResponse postShopingListResponse =
                given()
                        .spec(requestSpecificationMealPlan)
                        .body(shopingListRequest)
                        .when()
                        .request(Method.POST, getBaseUrl() + "/mealplanner/{username}/shopping-list/items", getUserName())
                        .then()
                        .extract()
                        .body()
                        .as(PostShopingListResponse.class);

        String id = postShopingListResponse.getId().toString();

        GetShopingListResponse getShopingListResponse =
        given()
                .spec(requestSpecificationMealPlan)
                .when()
                .request(Method.GET, getBaseUrl() + "/mealplanner/{username}/shopping-list", getUserName())
                .then()
                .extract()
                .body()
                .as(GetShopingListResponse.class);
        assertThat(getShopingListResponse.getAisles().get(0).getItems().get(0).getAisle(), containsString("Milk, Eggs, Other Dairy"));

        given()
                .spec(requestSpecificationMealPlan)
                .when()
                .request(Method.DELETE, getBaseUrl() + "/mealplanner/{username}/shopping-list/items/{id}", getUserName(), id);
    }


    @Test
    void postShoppingListUnitTest() {
        ShopingListRequest shopingListRequest = new ShopingListRequest("3 kg blueberries", "Fruits", true);
        PostShopingListResponse postShopingListResponse =
                given()
                        .spec(requestSpecificationMealPlan)
                        .body(shopingListRequest)
                        .when()
                        .request(Method.POST, getBaseUrl() + "/mealplanner/{username}/shopping-list/items", getUserName())
                        .then()
                        .extract()
                        .body()
                        .as(PostShopingListResponse.class);
        assertThat(postShopingListResponse.getMeasures().getOriginal().getUnit(), containsString("kg"));
        assertThat(postShopingListResponse.getMeasures().getOriginal().getAmount(), equalTo(3.0));

        String id = postShopingListResponse.getId().toString();

        given()
                .spec(requestSpecificationMealPlan)
                .when()
                .request(Method.DELETE, getBaseUrl() + "/mealplanner/{username}/shopping-list/items/{id}", getUserName(), id);
    }

}
