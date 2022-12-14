
package lesson4.response.ShoppingListGet;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Aisle {

    private String aisle;
    private List<Item> items = null;

}
