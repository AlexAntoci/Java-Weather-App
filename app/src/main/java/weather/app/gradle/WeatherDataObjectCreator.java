package weather.app.gradle;

import java.util.ArrayList;

// ****************************************** Class used to create Weather Objects which contain needed data taken from JSON in order to further be processed. ******************************************

public class WeatherDataObjectCreator {

    public String name;
    public String maxtemp_c;
    public String mintemp_c;
    public String avghumidity;
    public String maxwind_kph;
    public String wind_dir;

    // Object Setter
    public void SetObject(String maxtemp_c, String mintemp_c, String avghumidity, String maxwind_kph, String name,
            String wind_dir) {

        this.name = name;
        this.maxtemp_c = maxtemp_c;
        this.mintemp_c = mintemp_c;
        this.avghumidity = avghumidity;
        this.maxwind_kph = maxwind_kph;
        this.wind_dir = wind_dir;

    }

    // Object Getters

    public String getName() {
        return name;
    }

    public String getMaxTemp() {
        return maxtemp_c;
    }

    public String getMinTemp() {
        return mintemp_c;
    }

    public String getHumidity() {
        return avghumidity;
    }

    public String getWindSpeed() {
        return maxwind_kph;
    }

    public String getWindDirection() {
        return wind_dir;
    }

}
