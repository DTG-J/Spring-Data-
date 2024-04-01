package softuni.exam.models.entity;

import softuni.exam.models.enums.VolcanoType;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "volcanoes")
public class Volcano extends BaseEntity{
    //Volcano
    //•	id – accepts integer values, a primary identification field, an auto incremented field.
    //•	name - accepts char sequence (between 2 to 30 both inclusive). The values are unique in the database. It cannot be nullable.
    //•	elevation - The highest point of the volcano. Accepts only positive numbers. It cannot be nullable.
    //•	volcano type - categorization of the volcanoes. String enumeration, one of the following – CINDER_CONE, STRATOVOLCANO, SHIELD_VOLCANO, LAVA_DOME, CALDERA. It can be nullable.
    //•	is active – accepts a true or false, representing whether the volcano is active or not. It cannot be nullable.
    //•	last eruption – indicates when the last eruption occurred. It can be nullable.
    //•	Constraint: The volcanoes table has a relation with the countries table. It can be nullable.
    @Column(nullable = false)
    private String name;
    @Column
    private int elevation;
    @Column(name = "volcano_type")
    private VolcanoType volcanoType;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "last_eruption")
    private java.sql.Date lastEruption;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "id")
    private Country country;

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

    public Date getLastEruption() {
        return lastEruption;
    }

    public void setLastEruption(java.sql.Date lastEruption) {
        this.lastEruption = lastEruption;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
