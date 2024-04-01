package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "volcanologists")
public class Volcanologist extends BaseEntity{

     @Column(name = "first_name", unique = true, nullable = false)
    private String firstName;
    @Column(name = "last_name", unique = true, nullable = false)
    private String lastName;
    @Column(nullable = false)
    private double salary;
    @Column(nullable = false)
    private int age;
    @Column(name = "exploring_from")
    private String exploringFrom;
    @Column
    @ManyToOne
    @JoinColumn(name = "exploring_volcano_id", referencedColumnName = "id")
    private Volcano exploringVolcano;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getExploringFrom() {
        return exploringFrom;
    }

    public void setExploringFrom(String exploringFrom) {
        this.exploringFrom = exploringFrom;
    }

    public Volcano getExploringVolcano() {
        return exploringVolcano;
    }

    public void setExploringVolcano(Volcano exploringVolcano) {
        this.exploringVolcano = exploringVolcano;
    }
}