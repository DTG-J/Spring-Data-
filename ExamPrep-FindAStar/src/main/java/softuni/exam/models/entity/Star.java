package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Set;

    enum starType {
        RED_GIANT, WHITE_DWARF, NEUTRON_STAR
    }
    @Entity
    @Table(name = "stars")
    public class Star extends BaseEntity{
        @Column(unique = true)
        @Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
        private String name;
        @Column(name = "light_years")
        private double lightYears;
        @Column
        @Size(min = 6)
        private String description;
        @Column(name = "star_type")
        private String starType;
        @ManyToOne
        private Constellation constellation;

        private Set<Astronomer>observers;
    }


