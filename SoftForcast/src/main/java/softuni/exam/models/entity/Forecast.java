package softuni.exam.models.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Time;
@Entity
@Table(name = "forecasts")
public class Forecast extends BaseEntity{
    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;
    @Column(name = "max_temperature", nullable = false)
    private double maxTemperature;
    @Column(name = "min_temperature", nullable = false)
    private double minTemperature;
    private Time sunrise;
    private Time sunset;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
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
}
