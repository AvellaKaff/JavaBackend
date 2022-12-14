
package lesson4.response.AddRecipeInformation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Equipment {

    private Integer id;
    private String name;
    private String localizedName;
    private String image;
    @JsonIgnore
    private List<Temperature> temperature = null;

}
