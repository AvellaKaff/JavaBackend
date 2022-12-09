package lesson3;

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

    @BeforeAll
    static void initTest() throws IOException {
        configFile = new FileInputStream("src/main/resources/my.properties");
        properties.load(configFile);

        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("base_url");
        cuisine = properties.getProperty("cuisine");
        complexSearch = properties.getProperty("complexSearch");
        userName = properties.getProperty("user_name");
        hash = properties.getProperty("hash");
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
