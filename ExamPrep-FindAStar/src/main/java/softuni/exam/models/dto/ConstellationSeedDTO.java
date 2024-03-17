package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.BaseEntity;
import softuni.exam.models.entity.Star;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class ConstellationSeedDTO {

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
