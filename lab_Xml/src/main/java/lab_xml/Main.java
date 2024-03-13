package lab_xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lab_xml.models.PersonDTO;
import org.springframework.boot.CommandLineRunner;

public class Main implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        JAXBContext personContext = JAXBContext.newInstance (PersonDTO.class);
        Marshaller personMarshaller = personContext.createMarshaller ();

        PersonDTO person = new PersonDTO ("Pesho", "Todorov", 23);

        personMarshaller.marshal (person, System.out);

    }
}
