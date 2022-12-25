package lesson6;


import lesson5.api.CategoryService;
import lesson5.dto.GetCategoryResponse;
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

public class GetCategoryTest {

    static CategoryService categoryService;
    static db.dao.CategoriesMapper categoriesMapper;
    static db.model.CategoriesExample example;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
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
        categoriesMapper = session.getMapper(db.dao.CategoriesMapper.class);
        example = new db.model.CategoriesExample();
    }

    @SneakyThrows
    @Test
    void getCategoryByIdPositiveTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(1).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Food"));
        response.body().getProducts().forEach(product ->
                assertThat(product.getCategoryTitle(), equalTo("Food")));
        example.createCriteria().andIdEqualTo(1);
        List<db.model.Categories> list = categoriesMapper.selectByExample(example);
        assertThat(list.get(0).getId(), equalTo(1));
        assertThat(list.get(0).getTitle(), equalTo("Food"));
    }

    @SneakyThrows
    @Test
    void getCategoryByIdTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(2).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Electronic"));
        response.body().getProducts().forEach((product ->
                assertThat(product.getCategoryTitle(), equalTo("Electronic"))));

        example.createCriteria().andIdEqualTo(2);
        List<db.model.Categories> list = categoriesMapper.selectByExample(example);
        assertThat(list.get(0).getId(), equalTo(2));
        assertThat(list.get(0).getTitle(), equalTo("Electronic"));
    }

    @SneakyThrows
    @Test
    void getCategoryNegativeTest() {
        Response<GetCategoryResponse> response = categoryService.getCategory(3).execute();

        assertThat(response.isSuccessful(), CoreMatchers.is(false));
        assertThat(response.code(), equalTo(404));
        example.createCriteria().andIdEqualTo(3);
        List<db.model.Categories> list = categoriesMapper.selectByExample(example);
        assertThat(list.size(), equalTo(0));
    }
}
