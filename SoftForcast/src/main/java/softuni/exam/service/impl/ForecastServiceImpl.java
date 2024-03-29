package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastRootDto;
import softuni.exam.models.dto.ForecastSeedXmlDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.CityRepository;
import softuni.exam.repository.CountryRepository;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.Set;

@Service
public class ForecastServiceImpl implements ForecastService {
    private static final String FILE_PATH = "src/main/resources/files/xml/forecasts.xml";
    private final ForecastRepository forecastRepository;
    private final CityRepository cityRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ForecastServiceImpl(ForecastRepository forecastRepository, CityRepository cityRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.forecastRepository = forecastRepository;
        this.cityRepository = cityRepository;

        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.forecastRepository.count () > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return new String(Files.readAllBytes(Path.of(FILE_PATH)));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(FORECASTS_FILE_PATH, ForecastSeedRootDto.class)
                .getForecastSeedDtos()
                .stream()
                .filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto);

                    City city = cityService.findCityById(forecastSeedDto.getCity());

                    if (city == null) {
                        isValid = false;
                    }

                    Forecast forecast = forecastRepository.findAllByCityAndDayOfWeek(city, forecastSeedDto.getDayOfWeek()).orElse(null);
                    if (forecast != null) {
                        isValid = false;
                    }

                    sb
                            .append(isValid
                                    ? String.format("Successfully import forecast %s - %.2f",
                                    forecastSeedDto.getDayOfWeek().toString(), forecastSeedDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);

                    City city = cityService.findCityById(forecastSeedDto.getCity());
//
                    forecast.setCity(city);
//                    cityService.addAndSaveAddedForecast(forecast,city);

                    //                    Town townByName = townService.findTownByName(forecastSeedDto.getTown());
//                    apartment.setTown(townByName);

                    return forecast;
                })
                .forEach(forecastRepository::save);

        return sb.toString();
    }

    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        Set<Forecast> allByDayOfWeek_sunday = forecastRepository.findAllByDayOfWeekAndCity_PopulationLessThanOrderByMaxTemperatureDescIdAsc(DaysOfWeek.SUNDAY, 150000);

        allByDayOfWeek_sunday
                .forEach(f -> {
                    sb.append(String.format("City: %s\n" +
                                            "-min temperature: %.2f\n" +
                                            "--max temperature: %.2f\n" +
                                            "---sunrise: %s\n" +
                                            "-----sunset: %s",
                                    f.getCity().getCityName(),
                                    f.getMinTemperature(),
                                    f.getMaxTemperature(),
                                    f.getSunrise(),
                                    f.getSunset()))
                            .append(System.lineSeparator());
                });

        return sb.toString().trim();
    }
    
}
