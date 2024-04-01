package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.VolcanologistRootDto;
import softuni.exam.models.dto.VolcanologistXmlSeedDto;
import softuni.exam.models.entity.Volcano;
import softuni.exam.models.entity.Volcanologist;
import softuni.exam.repository.VolcanologistRepository;
import softuni.exam.service.VolcanologistService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class VolcanologistServiceImpl implements VolcanologistService {
    private static final String FILE_PATH = "src/main/resources/files/xml/volcanologists.xml";
    private final VolcanologistRepository volcanologistRepository;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public VolcanologistServiceImpl(VolcanologistRepository volcanologistRepository, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.volcanologistRepository = volcanologistRepository;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return this.volcanologistRepository.count () > 0;
    }

    @Override
    public String readVolcanologistsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importVolcanologists() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        JAXBContext jaxbContext = JAXBContext.newInstance(VolcanologistRootDto.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        VolcanologistRootDto volcanologistRootDto = (VolcanologistRootDto) unmarshaller.unmarshal(new File (FILE_PATH));

        for (VolcanologistXmlSeedDto volcanologistXmlSeedDto : volcanologistRootDto.getVolcanologistXmlSeedDtos ()) {
            Optional<Volcanologist> optionalVolcanologist = this.volcanologistRepository
                    .findByFirstNameAndLastName(volcanologistXmlSeedDto.getFirstName(), volcanologistXmlSeedDto.getLastName());
           // Optional<Volcano> optionalVolcano = this.volcanologistRepository.findById(volcanologistXmlSeedDto.getExploringVolcano ());
            if (!this.validationUtil.isValid(volcanologistXmlSeedDto) || optionalVolcanologist.isPresent() //|| optionalVolcano.isEmpty()) {
                sb.append("Invalid volcanologist\n");
                continue;
            }

            Volcanologist volcanologist = this.modelMapper.map(volcanologistXmlSeedDto, Volcanologist.class);
           // volcanologist.setExploringVolcano (optionalVolcano.get());
            this.volcanologistRepository.saveAndFlush(volcanologist);

            sb.append(String.format("Successfully imported volcanologist %s %s\n",
                    volcanologist.getFirstName(), volcanologist.getLastName()));
        }


        return sb.toString();
    }
}
