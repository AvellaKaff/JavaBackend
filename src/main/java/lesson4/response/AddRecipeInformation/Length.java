
package lesson4.response.AddRecipeInformation;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Length {

    private Integer number;
    private String unit;

}
