package weather.app.gradle;

// ****************************************** Main App class ******************************************

public class App {

    public static void main(String[] args) {
        ApiUtilities newRequest = new ApiUtilities();
        Object response = newRequest.getRequest("Chisinau", "Forecast", 2);

    }
}
