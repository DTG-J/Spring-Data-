package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;


@Entity
@Table(name = "stars")
public class Star {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 30, message = "Name must be between 2 and 30 characters")
    @Column(unique = true)
    private String name;
    @Column(name = "light_years")
    @Positive(message = "Light years must be a positive number")
    private double lightYears;

    @Column
    @NotBlank(message = "Description is required")
    @Size(min = 6, message = "Description must be at least 6 characters long")
    private String description;

    public enum StarType {
        RED_GIANT, WHITE_DWARF, NEUTRON_STAR
    }

    @Column(name = "star_type")
    @Enumerated(EnumType.STRING)
    private StarType starType;

    @ManyToMany(mappedBy = "observingStar")
    private List<Astronomer> observers;

    @ManyToOne
    @JoinColumn(name = "constellation_id")
    private Constellation constellation;

    // Constructors, getters, and setters
    public Star() {
    }

    public Star(String name, double lightYears, String description, StarType starType) {
        this.name = name;
        this.lightYears = lightYears;
        this.description = description;
        this.starType = starType;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLightYears() {
        return lightYears;
    }

    public void setLightYears(double lightYears) {
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

    public List<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(List<Astronomer> observers) {
        this.observers = observers;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }
}



