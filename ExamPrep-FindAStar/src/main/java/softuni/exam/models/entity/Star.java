package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.List;


@Entity
@Table(name = "stars")
public class Star {
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

    @ManyToMany(mappedBy = "stars")
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
}



