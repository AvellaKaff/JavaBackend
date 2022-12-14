package lesson4.response.AddRecipeNutrition;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Properties {
    private String name;
    private Double amount;
    private String unit;
}
