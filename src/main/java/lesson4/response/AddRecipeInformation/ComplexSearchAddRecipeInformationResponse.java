
package lesson4.response.AddRecipeInformation;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ComplexSearchAddRecipeInformationResponse {

    private List<Result> results = null;
    private Integer offset;
    private Integer number;
    private Integer totalResults;

}
