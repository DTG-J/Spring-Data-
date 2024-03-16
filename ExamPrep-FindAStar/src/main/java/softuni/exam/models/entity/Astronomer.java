package softuni.exam.models.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Table(name = "astronomers")
public class Astronomer {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    @Column(name = "last_name")
    private String lastName;

    @Column
    @DecimalMin(value = "15000.00", message = "Salary must be greater than or equal to 15000.00")
    private double salary;

    @DecimalMin(value = "500.00", message = "Average observation hours must be greater than or equal to 500.00")
    @Column(name = "average_observation_hours")
    private double averageObservationHours;

    @Column
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @ManyToMany
    @JoinColumn(name = "observing_star_id")
    private List<Star> observingStar;

    // Constructors, getters, and setters
    public Astronomer() {
    }

    public Astronomer(String firstName, String lastName, double salary, double averageObservationHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.averageObservationHours = averageObservationHours;
    }

    // Getters and setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public double getAverageObservationHours() {
        return averageObservationHours;
    }

    public void setAverageObservationHours(double averageObservationHours) {
        this.averageObservationHours = averageObservationHours;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Star getObservingStar() {
        return (Star) observingStar;
    }

    public void setObservingStar(Star observingStar) {
        this.observingStar = (List<Star>) observingStar;
    }
}


