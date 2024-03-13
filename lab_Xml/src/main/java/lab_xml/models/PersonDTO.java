package lab_xml.models;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PersonDTO {
    private String firstName;
    private String lastName;
    private int age;

    public PersonDTO(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
}
