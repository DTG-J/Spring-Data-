package softuni.exam.models.dto;

import softuni.exam.models.entity.DayOfWeek;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.sql.Time;

@XmlRootElement(name = "forecast")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastSeedXmlDto implements Serializable {
    @XmlElement(name = "day_of_week")
    @NotNull
    private DayOfWeek dayOfWeek;
    @XmlElement(name = "max_temperature")
    @NotNull
    @Size(min = -20, max = 60)
    private Double maxTermperature;
    @NotNull
    @Size(min = -50, max = 40)
    @XmlElement(name = "min_temperature")
    private Double minTermperature;

    @XmlElement
    @NotNull
    private Time sunrise;
    @NotNull
    @XmlElement
    private Time sunset;

    @XmlElement
    private Long city;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Double getMaxTermperature() {
        return maxTermperature;
    }

    public void setMaxTermperature(Double maxTermperature) {
        this.maxTermperature = maxTermperature;
    }

    public Double getMinTermperature() {
        return minTermperature;
    }

    public void setMinTermperature(Double minTermperature) {
        this.minTermperature = minTermperature;
    }

    public Time getSunrise() {
        return sunrise;
    }

    public void setSunrise(Time sunrise) {
        this.sunrise = sunrise;
    }

    public Time getSunset() {
        return sunset;
    }

    public void setSunset(Time sunset) {
        this.sunset = sunset;
    }

    public Long getCity() {
        return city;
    }

    public void setCity(Long city) {
        this.city = city;
    }
}
