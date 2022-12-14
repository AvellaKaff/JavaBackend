package lesson3;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AbstractTest {

    static Properties properties = new Properties();
    private static InputStream configFile;
    private static String apiKey;
    private static String complexSearch;
    private static String cuisine;
    private static String baseUrl;
    private static String userName;
    private static String hash;
    protected static ResponseSpecification responseSpecification;
    protected static RequestSpecification requestSpecification;
    protected static RequestSpecification requestSpecificationCuisine;
    protected static RequestSpecification requestSpecificationNutrition;
    protected static RequestSpecification requestSpecificationInformation;
    protected static RequestSpecification requestSpecificationMealPlan;

    @BeforeAll
    static void initTest() throws IOException {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        configFile = new FileInputStream("src/main/resources/my.properties");
        properties.load(configFile);

        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("base_url");
        cuisine = properties.getProperty("cuisine");
        complexSearch = properties.getProperty("complexSearch");
        userName = properties.getProperty("user_name");
        hash = properties.getProperty("hash");

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectStatusLine("HTTP/1.1 200 OK")
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();

        requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .setContentType(ContentType.JSON)
                .build();

        requestSpecificationCuisine = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .setContentType("application/x-www-form-urlencoded")
                .setContentType(ContentType.JSON)
                .build();

        requestSpecificationNutrition = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("addRecipeNutrition", true)
                .setContentType(ContentType.JSON)
                .build();

        requestSpecificationInformation = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("addRecipeInformation", true)
                .setContentType(ContentType.JSON)
                .build();

        requestSpecificationMealPlan = new RequestSpecBuilder()
                .addQueryParam("apiKey", apiKey)
                .addQueryParam("hash", hash)
                .setContentType(ContentType.JSON)
                .build();


        RestAssured.requestSpecification = requestSpecification;
        RestAssured.responseSpecification = responseSpecification;

    }

    public static String getApiKey() {
        return apiKey;
    }

    public static String getBaseUrl() {
        return baseUrl;
    }

    public static String getComplexSearch() {
        return complexSearch;
    }

    public static String getCuisine() {
        return cuisine;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getHash() {
        return hash;
    }
}
