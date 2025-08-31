package weather.app.gradle;

// ****************************************** Class used to create Weather Objects which contain needed data taken from JSON in order to further be processed. ******************************************

public class WeatherDataObjectCreator {

    private Float maxtemp_c;
    private Float mintemp_c;
    private int avghumidity;

    // Object Setter
    public void SetObject(Float maxtemp_c, Float mintemp_c, int avghumidity) {

        this.maxtemp_c = maxtemp_c;
        this.mintemp_c = mintemp_c;
        this.avghumidity = avghumidity;

    }

    // Object Getters

    public Float getMaxTemp() {
        return maxtemp_c;
    }

    public Float getMinTemp() {
        return mintemp_c;
    }

    public int getHumidity() {
        return avghumidity;
    }

}
