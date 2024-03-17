package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.StarType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

public class StarSeedDTO {
    //@NotBlank(message = "Name is required")

    @Expose
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    private String name;
    @Expose
    @Positive(message = "Light years must be a positive number")
    private Double lightYears;

    @Expose
    @NotBlank(message = "Description is required")
    @Size(min = 6, message = "Description must be at least 6 characters long")
    private String description;

    @Expose
    @Enumerated(EnumType.STRING)
    private StarType starType;

    @Expose
    private Long constellation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLightYears() {
        return lightYears;
    }

    public void setLightYears(Double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Long getConstellation() {
        return constellation;
    }

    public void setConstellation(Long constellation) {
        this.constellation = constellation;
    }
}
