package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountriesImportDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
@Service
public class CountryServiceImpl implements CountryService {
    private static final String FILE_PATH = "src/main/resources/files/json/countries.json";
    private final CountryRepository countryRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public CountryServiceImpl(CountryRepository countryRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.countryRepository = countryRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {

     return this.countryRepository.count () > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();
        CountriesImportDto[] countriesImportDtos = this.gson.fromJson (
                new FileReader (FILE_PATH), CountriesImportDto[].class);

        for (CountriesImportDto countriesImportDto : countriesImportDtos) {
            Optional<Country> optional = this.countryRepository.findByCountryName(countriesImportDto.getCountryName ());
            if (!this.validationUtil.isValid(countriesImportDto) || optional.isPresent()) {
                sb.append("Invalid country\n");
                continue;
            }

            Country country = this.modelMapper.map (countriesImportDto, Country.class);
            this.countryRepository.saveAndFlush(country);
            sb.append(String.format("Successfully imported country %s - %s\n", country.getCountryName (), country.getCurrency ()));
        }

        return sb.toString();
    }

    @Override
    public Optional<Country> getCountryById(Long countryId) {
        return countryRepository.findById(countryId);
    }
}
