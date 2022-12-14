
package lesson4.response.ShoppingListGet;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Measures {

    private Original original;
    private Metric metric;
    private Us us;

}
