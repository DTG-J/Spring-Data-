package softuni.exam.models.dto.xml;

import org.springframework.format.annotation.DateTimeFormat;
import softuni.exam.models.entity.Star;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;
import java.time.LocalDate;

public class AstronomerSeedDTO implements Serializable {
    @XmlElement(name = "first_name")
    @NotNull
    @Size(min = 2, max = 30, message = "First name must be between 2 and 30 characters")
    private String firstName;

    //@NotBlank(message = "Last name is required")
    @XmlElement(name = "last_name")
    @NotNull
    @Size(min = 2, max = 30, message = "Last name must be between 2 and 30 characters")
    private String lastName;

    @XmlElement
    @DecimalMin(value = "15000.00", message = "Salary must be greater than or equal to 15000.00")
    private Double salary;
    @XmlElement(name = "average_observation_hours")
    @NotNull
    @DecimalMin(value = "500.00", message = "Average observation hours must be greater than or equal to 500.00")
    private Double averageObservationHours;

    @XmlElement
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @XmlElement(name = "observing_star_id")
    private long star;

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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
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

    public long getStar() {
        return star;
    }

    public void setStar(long star) {
        this.star = star;
    }
}

