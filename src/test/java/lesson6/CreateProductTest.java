package lesson6;

import com.github.javafaker.Faker;
import db.model.Products;
import lesson5.api.ProductService;
import lesson5.dto.Product;
import lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;
import retrofit2.Response;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class CreateProductTest {

    static ProductService productService;
    static db.dao.ProductsMapper productsMapper;
    static db.model.ProductsExample example;
    static SqlSession session;
    Product product = null;
    Product badProduct = null;
    Faker faker = new Faker();
    int id;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @BeforeEach
    void setUp() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        example = new db.model.ProductsExample();

        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));

        badProduct = new Product()
                .withId(100)
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withPrice((int) (Math.random() * 10000));
    }

    @Test
    void createProductInFoodCategoryPositiveTest() throws IOException {
        Response<Product> response = productService.createProduct(product)
                .execute();
        id = response.body().getId();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        example.createCriteria().andIdEqualTo(id);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.get(0).getId(), equalTo(id));
        assertThat(list.get(0).getTitle(), equalTo(product.getTitle()));
        assertThat(list.get(0).getPrice(), equalTo(product.getPrice()));
        assertThat(list.get(0).getCategory_id(), equalTo(1));
    }

    @Test
    void createProductInFoodCategoryNegativeTest() throws IOException {
        Response<Product> response = productService.createProduct(badProduct)
                .execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(400));


        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.size(), equalTo(5));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        productsMapper.deleteByPrimaryKey(id);
        session.commit();

        session.close();
    }

}
