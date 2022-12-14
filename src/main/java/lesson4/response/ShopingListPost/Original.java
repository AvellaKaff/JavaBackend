
package lesson4.response.ShopingListPost;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Original {

    private Double amount;
    private String unit;

}
