package weather.app.gradle;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.http.HttpClient;

// ****************************************** Class used for building API related tools ******************************************

public class ApiUtilities {

    // Method used for creating full URL with all needed parameters.

    private String createURL(String q, String function, String days, String baseURL) {
        String fullQuery = baseURL + "/" + function + "?q=" + q + "&days=" + days;
        return fullQuery;
    }

    // Method used for building, sending and receving data from GET requests.

    public Object getRequest(String q, String function, int days) {

        HttpClient client = HttpClient.newHttpClient();

        String baseURL = "http://api.weatherapi.com/v1";
        String apiKEY = "70e1dce4e28e4cf2ad572400252708";
        String stringifiedDays = String.valueOf(days);

        String functionParam = "";

        String result = "";

        if (function == "Current Weather") {
            result = "34";
        } else if (function == "Forecast") {
            try {

                functionParam = "forecast.json";
                String newApiURL = createURL(q, functionParam, stringifiedDays, baseURL);

                URI uri = URI.create(newApiURL);

                HttpRequest request = HttpRequest.newBuilder(uri)
                        .header("key", apiKEY)
                        .GET()
                        .build();

                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                System.out.println(response.statusCode());
                System.out.println(response.body());

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return "";
    }

}
