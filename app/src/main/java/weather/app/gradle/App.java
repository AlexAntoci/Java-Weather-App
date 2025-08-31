package weather.app.gradle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

// ****************************************** Main App class ******************************************

public class App {

    public static void main(String[] args) {
        ApiUtilities newRequest = new ApiUtilities();

        ArrayList chisinauData = newRequest.getRequest("Chisinau", "Forecast", 2);
        ArrayList madridData = newRequest.getRequest("Madrid", "Forecast", 2);
        ArrayList kyivData = newRequest.getRequest("Kyiv", "Forecast", 2);
        ArrayList amsterdamData = newRequest.getRequest("Amsterdam", "Forecast", 2);

        System.out.println(chisinauData);
        System.out.println(madridData);
        System.out.println(kyivData);
        System.out.println(amsterdamData);

    }

}
