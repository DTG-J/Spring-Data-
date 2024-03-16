package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity{

    @Column
    private String description;
    @Column(unique = true)
    private String name;
  @OneToMany(mappedBy = "star")
   private Set<Star> stars;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
