package lesson4.response.FillIngredients;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ComplexSearchFillIngredientsResponse {

    private List<ResultFillIngredients> results = null;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
}
