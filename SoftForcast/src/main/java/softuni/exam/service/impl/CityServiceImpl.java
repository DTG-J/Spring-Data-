package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.dto.CountriesImportDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private static final String FILE_PATH = "src/main/resources/files/json/cities.json";
    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CityServiceImpl(CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.cityRepository.count () > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return new String (Files.readAllBytes(Path.of (FILE_PATH)));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();
        CitySeedDto[] citySeedDtos = this.gson.fromJson (
                new FileReader (FILE_PATH), CitySeedDto[].class);

        for (CitySeedDto citySeedDto : citySeedDtos) {
            Optional<City> optional = this.cityRepository.findByCityName(citySeedDto.getCityName ());
            if (!this.validationUtil.isValid(citySeedDto) || optional.isPresent()) {
                sb.append("Invalid city\n");
                continue;
            }

            City city = this.modelMapper.map (citySeedDto, City.class);
            this.cityRepository.saveAndFlush(city);
            sb.append(String.format("Successfully imported city %s - %s\n", city.getCityName (), city.getPopulation ()));
        }

        return sb.toString();

    }
}
