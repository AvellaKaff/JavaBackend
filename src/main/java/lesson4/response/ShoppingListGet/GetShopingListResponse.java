
package lesson4.response.ShoppingListGet;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class GetShopingListResponse {

    private List<Aisle> aisles = null;
    private Double cost;
    private Integer startDate;
    private Integer endDate;

}
