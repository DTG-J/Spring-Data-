package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "constellations")
public class Constellation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    @Column(unique = true)
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;

    // Define the relationship with stars
    @OneToMany(mappedBy = "constellation", cascade = CascadeType.ALL)
    private List<Star> stars;

    // Constructors, getters, and setters
    public Constellation() {
    }

    public Constellation(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Star> getStars() {
        return stars;
    }

    public void setStars(List<Star> stars) {
        this.stars = stars;
    }
}

