package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country extends BaseEntity{
    //•	id – accepts integer values, a primary identification field, and an auto incremented field.
    //•	name – accepts char sequence (between 3 to 30 both inclusive). The values are unique in the database. It cannot be nullable.
    //•	capital - accepts char sequence (between 3 to 30 both inclusive). It can be nullable.
    //•	Constraint: The countries table has a relation with the volcanoes table. It can be nullable.•	id – accepts integer values, a primary identification field, and an auto incremented field.
    //•	name – accepts char sequence (between 3 to 30 both inclusive). The values are unique in the database. It cannot be nullable.
    //•	capital - accepts char sequence (between 3 to 30 both inclusive). It can be nullable.
    //•	Constraint: The countries table has a relation with the volcanoes table. It can be nullable.
    @Column(unique = true, nullable = false)
    private String name;
    @Column
    private String capital;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
