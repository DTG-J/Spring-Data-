package softuni.exam.service.impl;


import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;

    public StarServiceImpl(StarRepository starRepository) {
        this.starRepository = starRepository;
    }
    private static final String FILE_PATH = "src/main/resources/files/json/stars.json";


    @Override
    public boolean areImported() {
        return this.starRepository.count () > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return new String (Files.readAllBytes (Path.of (FILE_PATH)));
    }

    @Override
    public String importStars() throws IOException {
        return null;
    }

    @Override
    public String exportStars() {
        return null;
    }
}
