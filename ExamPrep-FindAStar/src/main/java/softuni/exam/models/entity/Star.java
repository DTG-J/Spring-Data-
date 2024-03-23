package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.websocket.Encoder;
/*import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.math.BigInteger;*/
import java.util.HashSet;
//import java.util.List;
import java.util.Set;


@Entity
@Table(name = "stars")
public class Star extends BaseEntity{

    //@NotBlank(message = "Name is required")
    //@Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(unique = true, nullable = false)
    private String name;
    @Column(name = "light_years", nullable = false)
    //@Positive(message = "Light years must be a positive number")
    private Double lightYears;

    @Lob
    @NotBlank(message = "Description is required")
    @Column(nullable = false, columnDefinition = "TEXT")
    //@Size(min = 6, message = "Description must be at least 6 characters long")
    private String description;



    @Column(name = "star_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private StarType starType;

    @OneToMany(mappedBy = "observingStar")
    private Set<Astronomer> observers = new HashSet<> ();

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;


    // Constructors, getters, and setters

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

    public Set<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(Set<Astronomer> observers) {
        this.observers = observers;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }
}



