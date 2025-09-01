package weather.app.gradle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonPrimitive;

import java.util.ArrayList;
import java.util.Arrays;

// ****************************************** Class used for building API related tools ******************************************

public class ApiUtilities {

    // Method used for creating full URL with all needed parameters.

    private String createURL(String q, String function, String days, String baseURL) {
        String fullQuery = baseURL + "/" + function + "?q=" + q + "&days=" + days;
        return fullQuery;
    }

    // Method used for building, sending and receving data from GET requests.

    public ArrayList getRequest(String q, String function, int days) {

        HttpClient client = HttpClient.newHttpClient();

        String baseURL = "http://api.weatherapi.com/v1";
        String apiKEY = "70e1dce4e28e4cf2ad572400252708";
        String stringifiedDays = String.valueOf(days);

        String functionParam = "";

        String result = "";

        if (function == "Current Weather") {
            result = "34";
            // This one needs to be implemented, however not needed for the task. Just
            // decided to add this so the method can support more query types if needed to
            // be added in the future.

        } else if (function == "Forecast") {
            try {

                // Building and sending API GET request

                functionParam = "forecast.json";
                String newApiURL = createURL(q, functionParam, stringifiedDays, baseURL);

                URI uri = URI.create(newApiURL);

                HttpRequest request = HttpRequest.newBuilder(uri)
                        .header("key", apiKEY)
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                result = response.body();

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        // Parsing JSON into a smaller Token to make deserialization easier with GSON

        // This parse gets MaxTemp, MinTemp, Humidity, WindSpeed
        JsonParser jsonParser = new JsonParser();
        JsonElement forecast = jsonParser.parse(result).getAsJsonObject().getAsJsonObject("forecast")
                .getAsJsonArray("forecastday").get(1).getAsJsonObject().getAsJsonObject("day");

        // This parse gets City Name
        JsonParser jsonParser2 = new JsonParser();
        JsonElement forecast2 = jsonParser2.parse(result).getAsJsonObject().getAsJsonObject("location")
                .getAsJsonPrimitive("name");

        // This parse gets WindDirection
        JsonParser jsonParser3 = new JsonParser();
        JsonElement forecast3 = jsonParser3.parse(result).getAsJsonObject().getAsJsonObject("forecast")
                .getAsJsonArray("forecastday").get(1).getAsJsonObject().getAsJsonArray("hour").get(1).getAsJsonObject()
                .getAsJsonPrimitive("wind_dir");

        // Performing JSON conversion to Object format

        Gson gson = new Gson();

        WeatherDataObjectCreator weatherObject = gson.fromJson(forecast, WeatherDataObjectCreator.class);

        ArrayList<String> dataSet = new ArrayList<String>();

        dataSet.add(forecast2.toString());
        dataSet.add(weatherObject.maxtemp_c);
        dataSet.add(weatherObject.mintemp_c);
        dataSet.add(weatherObject.avghumidity);
        dataSet.add(weatherObject.maxwind_kph);
        dataSet.add(forecast3.toString());

        return dataSet;
    }

}
