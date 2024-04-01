package softuni.exam.service;

import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;


@Repository
public interface CountryService {

    boolean areImported();

    String readCountriesFromFile() throws IOException;

    String importCountries() throws IOException;

//    Optional<Country> getCountryById(Long countryId);
//
//    void saveAddedVolcanoInCountry(Country country);
}
