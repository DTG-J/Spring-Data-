package softuni.exam.models.entity;

import javax.persistence.*;
import java.math.BigInteger;
@Entity
@Table(name = "constellations")
public class Constellation extends BaseEntity{

    @Column
    private String description;
    @Column
    private String name;
}
