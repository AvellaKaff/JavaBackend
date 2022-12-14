package lesson4.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuisineResponse {

    private String cuisine;
    private List<String> cuisines = null;
    private Double confidence;
}

