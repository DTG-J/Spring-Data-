package softuni.exam.models.dto.jsons;

import com.google.gson.annotations.Expose;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class ConstellationSeedDTO implements Serializable {

    @Expose
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;

    // @NotBlank(message = "Description is required")
    @Expose
    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
