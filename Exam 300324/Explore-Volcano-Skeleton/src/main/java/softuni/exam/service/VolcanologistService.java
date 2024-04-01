package softuni.exam.service;

import org.springframework.stereotype.Repository;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Repository
public interface VolcanologistService {

    boolean areImported();

    String readVolcanologistsFromFile() throws IOException;

	String importVolcanologists() throws IOException, JAXBException;

}
