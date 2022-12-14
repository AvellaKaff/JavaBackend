
package lesson4.response.AddRecipeInformation;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AnalyzedInstruction {

    private String name;
    private List<Step> steps = null;
}
