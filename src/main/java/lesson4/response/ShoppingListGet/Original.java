
package lesson4.response.ShoppingListGet;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Original {

    private Double amount;
    private String unit;

}
