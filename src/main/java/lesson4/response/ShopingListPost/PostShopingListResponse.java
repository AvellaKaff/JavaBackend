
package lesson4.response.ShopingListPost;

import com.fasterxml.jackson.annotation.JsonInclude;
import lesson4.response.ShoppingListGet.Measures;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class PostShopingListResponse {

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
