
package lesson4.response.ShoppingListGet;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Item {

    private Integer id;
    private String name;
    private Measures measures;
    private List<Object> usages = null;
    private List<Object> usageRecipeIds = null;
    private Boolean pantryItem;
    private String aisle;
    private Double cost;
    private Integer ingredientId;

}
