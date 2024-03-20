package softuni.exam.service.impl;

import softuni.exam.repository.AstronomerRepository;
import softuni.exam.service.AstronomerService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AstronomerServiceImpl implements AstronomerService {

    private final AstronomerRepository astronomerRepository;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository) {
        this.astronomerRepository = astronomerRepository;
    }

    @Override
    public boolean areImported() {
        return this.astronomerRepository.count () > 0;
    }
private static final String FILE_PATH = "src/main/resources/files/xml/astronomers.xml";
    @Override
    public String readAstronomersFromFile() throws IOException {
        return new String (Files.readAllBytes (Path.of (FILE_PATH)));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {
        return null;
    }
}
