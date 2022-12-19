package lesson5;

import com.github.javafaker.Faker;
import lesson5.api.ProductService;
import lesson5.dto.Product;
import lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReturnsIDProductTest {

    static ProductService productService;

    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @Test
    void getIDFoodPositiveTest() {
        Response<Product> response = productService.getProductById(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Milk"));
        assertThat(response.body().getPrice(), equalTo(95));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));
    }

    @SneakyThrows
    @Test
    void getIDElectronicPositiveTest() {
        Response<Product> response = productService.getProductById(4).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(4));
        assertThat(response.body().getTitle(), equalTo("Samsung Watch X1000"));
        assertThat(response.body().getPrice(), equalTo(20000));
        assertThat(response.body().getCategoryTitle(), equalTo("Electronic"));
    }

    @SneakyThrows
    @Test
    void getIDNegativeTest() {
        Response<Product> response = productService.getProductById(6).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
    }
}
