package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import softuni.exam.models.dto.jsons.ConstellationSeedDTO;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ConstellationServiceImpl implements ConstellationService {
    private static final String FILE_PATH = "src/main/resources/files/json/constellations.json";

    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.constellationRepository.count () > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return new String (Files.readAllBytes (Path.of (FILE_PATH)));
    }

    @Override
    public String importConstellations() throws IOException {
        StringBuilder sb = new StringBuilder ();

        ConstellationSeedDTO[] constellationSeedDtos = this.gson.fromJson
                (new FileReader (FILE_PATH), ConstellationSeedDTO[].class);
        
        for (ConstellationSeedDTO constellationSeedDto : constellationSeedDtos) {
            if (!this.validationUtil.isValid (constellationSeedDto)){

            }
        }
        return sb.toString ();
    }
}
