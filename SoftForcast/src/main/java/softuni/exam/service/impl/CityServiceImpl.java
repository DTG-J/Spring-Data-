package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CityService;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {
    private static final String FILE_PATH = "src/main/resources/files/json/cities.json";
    private final CityRepository cityRepository;
    private final CountryRepository countryRepository;
    private final CountryService countryService;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CityServiceImpl(CityRepository cityRepository, CountryRepository countryRepository, CountryService countryService, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
        this.countryService = countryService;
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

   /* @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();
        CitySeedDto[] citySeedDtos = this.gson.fromJson (
                new FileReader (FILE_PATH), CitySeedDto[].class);

        for (CitySeedDto citySeedDto : citySeedDtos) {
            Optional<City> optionalCity = this.cityRepository.findByCityName(citySeedDto.getCityName ());
            Optional<Country> optionalCountry = this.countryRepository.findById(citySeedDto.getCountry ());
            if (!this.validationUtil.isValid(citySeedDto) || optionalCity.isPresent() || !optionalCountry.isPresent ())  {
                sb.append("Invalid city\n");
                continue;
            }

            City city = this.modelMapper.map (citySeedDto, City.class);
                  city.setCountry(optionalCountry.get());
            this.cityRepository.saveAndFlush(city);
            sb.append(String.format("Successfully imported city %s - %s\n", city.getCityName (), city.getPopulation ()));
        }

        return sb.toString();

    }*/
    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readCitiesFileContent(), CitySeedDto[].class))
                .filter(citySeedDto -> {
                    boolean isValid = validationUtil.isValid(citySeedDto);

                    Optional<City> byCityName = cityRepository.findByCityName(citySeedDto.getCityName());
                    if (byCityName.isPresent()) {
                        isValid = false;
                    }

                    sb.append(isValid
                                    ? String.format("Successfully imported city %s - %d", citySeedDto.getCityName()
                                    , citySeedDto.getPopulation())
                                    : "Invalid city")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(citySeedDto -> {
                    City city = modelMapper.map(citySeedDto, City.class);

                    Optional<Country> countryById = countryService.getCountryById(citySeedDto.getCountry());
                    if (countryById.isEmpty()) {
                        System.out.println("ERROR:  " + citySeedDto.getCityName());
                        return city;
                    }

                    city.setCountry(countryById.get());
                    return city;
                })
                .forEach(cityRepository::save);

        return sb.toString();
    }

}
