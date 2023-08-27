import java.time.LocalDateTime;

public class ST500Adapter extends ST500Info implements MeteoSensor {
    @Override
    public int getId() {
        return getData().identifier();
    }

    @Override
    public Float getTemperature() {
        return (float) getData().temperature();
    }

    @Override
    public Float getHumidity() {
        return 22f;
    }

    @Override
    public Float getPressure() {
        return 24.3f;
    }

    @Override
    public LocalDateTime getDateTime() {

        int year = getData().year();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        int hour = getData().second() / 3600;
        int minutes = (getData().second() - (hour * 3600)) / 60;
        int seconds = (getData().second() - (hour * 3600)) - (minutes * 60);
        return LocalDateTime.of(year, month, day, hour, minutes, seconds);
    }

}