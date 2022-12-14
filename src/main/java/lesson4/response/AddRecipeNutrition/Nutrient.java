package lesson4.response.AddRecipeNutrition;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Nutrient {

    private String name;
    private Double amount;
    private String unit;
    private Double percentOfDailyNeeds;
}
