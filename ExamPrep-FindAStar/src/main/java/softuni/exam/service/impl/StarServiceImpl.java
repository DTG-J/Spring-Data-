package softuni.exam.service.impl;


import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.jsons.StarSeedDTO;
import softuni.exam.models.entity.Star;
import softuni.exam.models.entity.StarType;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
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

        StringBuilder sb = new StringBuilder ();

        StarSeedDTO[] starSeedDtos = this.gson.fromJson (readStarsFileContent (), StarSeedDTO[].class);
        for (StarSeedDTO starSeedDto : starSeedDtos) {
            Optional<Star> optional = this.starRepository.findByName(starSeedDto.getName ());
            if (!this.validationUtil.isValid (starSeedDto) || optional.isPresent ()){
                sb.append ("Invalid star\n");
                continue;
            }
            Star star = this.modelMapper.map (starSeedDto, Star.class);
            star.setStarType(StarType.valueOf(String.valueOf (starSeedDto.getStarType())));
            star.setConstellation (this.constellationRepository.findById (starSeedDto. getConstellation ()).get ());
            this.starRepository.saveAndFlush (star);
            sb.append (String.format ("Successfully imported star %s - %.2f light years\n", star.getName (), star.getLightYears ()));
        }
        return sb.toString ();
    }

    @Override
    public String exportStars() {
        return null;
    }
}
