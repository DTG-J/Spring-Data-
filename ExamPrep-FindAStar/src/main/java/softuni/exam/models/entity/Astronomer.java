package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Size;

public class Astronomer extends BaseEntity{

   /* •	id - accepts integer values, a primary identification field, an auto incremented field.
•	first name - accepts char sequence (between 2 to 30 inclusive).
            •	last name - accepts char sequence (between 2 to 30 inclusive).
            •	salary - accepts number values that are more than or equal to 15000.00.
            •	averageObservationHours - accepts number values that are more than 500.00.
            •	birthday - a date in the "yyyy-MM-dd" format. Can be nullable.
•	observing star - the current star that the astronomer is studying.
            •	Constraint: The astronomers table has a relation with stars table.*/
    @Column(name = "first_name")
    @Size(min = 2, max = 30)
    private String firsName;
    @Column(name = "last_name")
    @Size(min = 2, max = 30)
    private String lastName;
    @Column
    @DecimalMin(value = "15000.00")
    private double salary;

}
