
package lesson4.response.AddRecipeInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Ingredient {

    private Integer id;
    private String name;
    private String localizedName;
    private String image;

}
