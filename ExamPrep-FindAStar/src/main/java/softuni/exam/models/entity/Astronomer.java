package softuni.exam.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
/*import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigInteger;*/
import java.time.LocalDate;
//import java.util.Date;
//import java.util.List;


@Entity
@Table(name = "astronomers")
public class Astronomer extends BaseEntity {

    //@NotBlank(message = "First name is required")
    @Column(name = "first_name", nullable = false)
    //@Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String firstName;

    //@NotBlank(message = "Last name is required")
    @Column(name = "last_name", nullable = false)
    //@Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    @Column
    //@DecimalMin(value = "15000.00", message = "Salary must be greater than or equal to 15000.00")
    private double salary;
    @Column(name = "average_observation_hours", nullable = false)
    //@DecimalMin(value = "500.00", message = "Average observation hours must be greater than or equal to 500.00")
    private Double averageObservationHours;

    @Column
    //@Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ManyToOne
    @JoinColumn(name = "observing_star_id", nullable = false)
    private Star observingStar;

    // Constructors, getters, and setters

    // Getters and setters


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(Double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Star getObservingStar() {
        return observingStar;
    }

    public void setObservingStar(Star observingStar) {
        this.observingStar = observingStar;
    }
}