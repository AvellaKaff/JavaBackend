package lesson6;

import lesson5.api.ProductService;
import lesson5.dto.Product;
import lesson5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.InputStream;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ReturnsIDProductTest {

    static ProductService productService;
    static db.dao.ProductsMapper productsMapper;
    static db.model.ProductsExample example;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @SneakyThrows
    @BeforeEach
    void setUp() {
        SqlSession session;
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new
                SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
        productsMapper = session.getMapper(db.dao.ProductsMapper.class);
        example = new db.model.ProductsExample();
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

        example.createCriteria().andIdEqualTo(1);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.get(0).getId(),equalTo(1));
        assertThat(list.get(0).getTitle(), equalTo("Milk"));
        assertThat(list.get(0).getPrice(), equalTo(95));
        assertThat(list.get(0).getCategory_id(), equalTo(1));
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

        example.createCriteria().andIdEqualTo(4);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.get(0).getId(),equalTo(4));
        assertThat(list.get(0).getTitle(), equalTo("Samsung Watch X1000"));
        assertThat(list.get(0).getPrice(), equalTo(20000));
        assertThat(list.get(0).getCategory_id(), equalTo(2));
    }

    @SneakyThrows
    @Test
    void getIDNegativeTest() {
        Response<Product> response = productService.getProductById(6).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));

        example.createCriteria().andIdEqualTo(6);
        List<db.model.Products> list = productsMapper.selectByExample(example);
        assertThat(list.size(), equalTo(0));
    }
}
