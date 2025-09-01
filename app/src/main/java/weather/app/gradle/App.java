package weather.app.gradle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

// ****************************************** Main App class ******************************************

public class App {

        // Method used to create the table by passing all needed City Data arrays
        public static void createTable(ArrayList... array) {

                // Create Table Headers
                String[] headers = { "Cities", "MaxT", "MinT", "Humidity", "Wind Speed", "Wind Direction" };

                // Initialize Table
                Object[][] table = new String[array.length][6];

                for (int i = 0; i < table.length; i++) { // Outer loop for rows
                        for (int j = 0; j < table[i].length; j++) { // Inner loop for columns
                                table[i][j] = array[i].get(j);// Assign a value based on indices
                        }
                }

                // Print header row
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", headers[0], headers[1], headers[2],
                                headers[3],
                                headers[4], headers[5]);
                // Print separator line
                System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", "-----", "-----", "-----", "--------",
                                "-------",
                                "---------");

                // Print data rows
                for (Object[] row : table) {
                        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", row[0], row[1], row[2], row[3],
                                        row[4],
                                        row[5]);
                }
                ;

        }

        public static void main(String[] args) {
                ApiUtilities newRequest = new ApiUtilities();

                ArrayList chisinauData = newRequest.getRequest("Chisinau", "Forecast", 2);
                ArrayList madridData = newRequest.getRequest("Madrid", "Forecast", 2);
                ArrayList kyivData = newRequest.getRequest("Kyiv", "Forecast", 2);
                ArrayList amsterdamData = newRequest.getRequest("Amsterdam", "Forecast", 2);

                createTable(chisinauData, madridData, kyivData, amsterdamData);

        }

}
