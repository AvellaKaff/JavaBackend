package lesson4.response.ComplexSearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ComplexSearchResponse {

    private List<Result> results = null;
    private Integer offset;
    private Integer number;
    private Integer totalResults;
}