package softuni.exam.service.impl;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanoSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.repository.VolcanoRepository;
import softuni.exam.service.VolcanoService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VolcanoServiceImpl implements VolcanoService {
    private final VolcanoRepository volcanoRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private static final String FILE_PATH = "src/main/resources/files/json/volcanoes.json";

    public VolcanoServiceImpl(VolcanoRepository volcanoRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.volcanoRepository = volcanoRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.volcanoRepository.count () > 0;
    }

    @Override
    public String readVolcanoesFileContent() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importVolcanoes() throws IOException {
        StringBuilder sb = new StringBuilder();
        VolcanoSeedDto[] volcanoSeedDtos = this.gson.fromJson(
                new FileReader (FILE_PATH), VolcanoSeedDto[].class);

        for (VolcanoSeedDto volcanoSeedDto : volcanoSeedDtos) {
            Optional<Volcano> optional = this.volcanoRepository.findByName(volcanoSeedDto.getName());
            if (!this.validationUtil.isValid(volcanoSeedDto) || optional.isPresent()) {
                sb.append("Invalid volcano\n");
                continue;
            }

            Volcano volcano = this.modelMapper.map(volcanoSeedDto, Volcano.class);
            this.volcanoRepository.saveAndFlush(volcano);
            sb.append(String.format("Successfully imported volcano %s of type %s\n", volcano.getName (), volcano.getVolcanoType ()));
        }

        return sb.toString();
    }

    @Override
    public String exportVolcanoes() {
        return null;
    }
}
