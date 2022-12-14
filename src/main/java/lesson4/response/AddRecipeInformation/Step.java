
package lesson4.response.AddRecipeInformation;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Step {

    private Integer number;
    private String step;
    private List<Ingredient> ingredients = null;
    private List<Equipment> equipment = null;
    private Length length;

}
