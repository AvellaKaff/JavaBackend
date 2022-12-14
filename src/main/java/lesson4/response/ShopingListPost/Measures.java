
package lesson4.response.ShopingListPost;

import com.fasterxml.jackson.annotation.JsonInclude;
import lesson4.response.ShoppingListGet.Metric;
import lesson4.response.ShoppingListGet.Original;
import lesson4.response.ShoppingListGet.Us;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Measures {

    private Original original;
    private Metric metric;
    private Us us;

}
