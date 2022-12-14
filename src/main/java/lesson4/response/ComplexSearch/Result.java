package lesson4.response.ComplexSearch;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {
    private Integer id;
    private String title;
    private String image;
    private String imageType;
}
