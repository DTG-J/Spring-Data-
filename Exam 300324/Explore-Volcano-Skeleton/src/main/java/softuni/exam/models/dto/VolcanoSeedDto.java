package softuni.exam.models.dto;

import com.google.gson.annotations.Expose;
import jdk.jfr.BooleanFlag;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.exam.models.enums.VolcanoType;

import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class VolcanoSeedDto implements Serializable {
    @Expose
    @Size(min = 2, max = 30)
    @NotNull
    private String name;
    @Expose
    @Positive
    @NotNull
    private int elevation;
    @Expose
    @Enumerated
    private VolcanoType volcanoType;
    @Expose
    @BooleanFlag
    private boolean isActive;
    @Expose
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String lastEruption;
    @Expose
    private int country;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public VolcanoType getVolcanoType() {
        return volcanoType;
    }

    public void setVolcanoType(VolcanoType volcanoType) {
        this.volcanoType = volcanoType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(String lastEruption) {
        this.lastEruption = lastEruption;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }
}
