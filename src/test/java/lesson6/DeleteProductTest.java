package lesson6;

import com.github.javafaker.Faker;
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

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class DeleteProductTest {

    static ProductService productService;
    static db.dao.ProductsMapper productsMapper;
    static db.model.ProductsExample example;
    static SqlSession session;
    Product product = null;
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

        Response<Product> response = productService.createProduct(product).execute();
        id = response.body().getId();
    }

    @SneakyThrows
    @Test
    void deleteProductPositiveTest() {
        Response<ResponseBody> response = productService.deleteProduct(id).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));

        example.createCriteria().andIdEqualTo(id);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.size(), equalTo(0));
    }

    @SneakyThrows
    @Test
    void deleteProductNegativeTest() {
        Response<ResponseBody> response = productService.deleteProduct(100).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));

        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.size(), equalTo(6));
    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        productsMapper.deleteByPrimaryKey(id);
        session.commit();

        session.close();
    }
}
