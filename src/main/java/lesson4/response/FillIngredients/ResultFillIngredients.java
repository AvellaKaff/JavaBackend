package lesson4.response.FillIngredients;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResultFillIngredients {
    private Integer id;
    private Integer usedIngredientCount;
    private Integer missedIngredientCount;
    private List<MissedIngredient> missedIngredients = null;
    private Integer likes;
    private List<Object> usedIngredients = null;
    private List<Object> unusedIngredients = null;
    private String title;
    private String image;
    private String imageType;
}
