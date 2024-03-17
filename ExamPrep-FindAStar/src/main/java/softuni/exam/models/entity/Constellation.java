package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity{
    //@NotBlank(message = "Name is required")
    @Column(unique = true,nullable = false)
    //@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
    private String name;
    @Column(nullable = false)
   // @NotBlank(message = "Description is required")
    //@Size(min = 5, message = "Description must be at least 5 characters long")
    private String description;

    // Define the relationship with stars
    @OneToMany(mappedBy = "constellation",  fetch = FetchType.EAGER)
    private Set<Star> stars = new HashSet<> ();

        // Getters and setters


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

    public Set<Star> getStars() {
        return stars;
    }

    public void setStars(Set<Star> stars) {
        this.stars = stars;
    }
}

