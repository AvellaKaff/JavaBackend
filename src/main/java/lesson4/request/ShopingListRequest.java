package lesson4.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class ShopingListRequest {

    private String item;
    private String aisle;
    private Boolean parse;


    public ShopingListRequest() {
    }

    public ShopingListRequest(String item) {
        this.item = item;
    }

    public ShopingListRequest(String item, String aisle) {
        this.item = item;
        this.aisle = aisle;
    }

    public ShopingListRequest(String item, String aisle, Boolean parse) {
        this.item = item;
        this.aisle = aisle;
        this.parse = parse;
    }

    @Override
    public String toString() {
        return "{" +
                "item='" + item + '\'' +
                ", aisle='" + aisle + '\'' +
                ", parse=" + parse +
                '}';
    }
}


