package lesson4.response.AddRecipeNutrition;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Nutrition {

    private List<Nutrient> nutrients = null;
    @JsonIgnore
    private List<Properties> properties = null;
    @JsonIgnore
    private List<Flavonoids> flavonoids = null;
    @JsonIgnore
    private List<Ingredients> ingredients = null;
    @JsonIgnore
    private List<CaloricBreakdown> caloricBreakdown = null;
    @JsonIgnore
    private List<WeightPerServing> weightPerServing = null;

}
