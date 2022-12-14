
package lesson4.response.AddRecipeInformation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result {

    private Boolean vegetarian;
    private Boolean vegan;
    private Boolean glutenFree;
    private Boolean dairyFree;
    private Boolean veryHealthy;
    private Boolean cheap;
    private Boolean veryPopular;
    private Boolean sustainable;
    private Boolean lowFodmap;
    private Integer weightWatcherSmartPoints;
    private String gaps;
    private Integer preparationMinutes;
    private Integer cookingMinutes;
    private Integer aggregateLikes;
    private Integer healthScore;
    private String creditsText;
    private String license;
    private String sourceName;
    private Double pricePerServing;
    private Integer id;
    private String title;
    private String author;
    private Integer readyInMinutes;
    private Integer servings;
    private String sourceUrl;
    private String image;
    private String imageType;
    private String summary;
    private List<String> cuisines = null;
    private List<String> dishTypes = null;
    private List<String> diets = null;
    private List<Object> occasions = null;
//    @JsonIgnore
    private List<AnalyzedInstruction> analyzedInstructions = null;
    private String spoonacularSourceUrl;
   }
