package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastRootDto implements Serializable {
    public List<ForecastSeedXmlDto> ForecastSeedXmlDtos;

    public List<ForecastSeedXmlDto> getForecastSeedXmlDtos() {
        return ForecastSeedXmlDtos;
    }

    public void setForecastSeedXmlDtos(List<ForecastSeedXmlDto> forecastSeedXmlDtos) {
        ForecastSeedXmlDtos = forecastSeedXmlDtos;
    }
}
