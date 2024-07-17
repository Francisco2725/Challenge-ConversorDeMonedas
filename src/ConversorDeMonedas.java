import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConversorDeMonedas {

    public static void main(String[] args) {
        String apiKey = "367d3135b639519a38dd00db";
        String baseCurrency = "DOP"; // Moneda base

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingresa la cantidad en " + baseCurrency + ": ");
            double amount = scanner.nextDouble();

            //solicitud a la API
            URL url = new URL("https://api.exchangeratesapi.io/v1/latest?access_key=367d3135b639519a38dd00db");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            //Respuesta JSON
            // EXTRAER MIS TASAS

            // Calcula las conversiones
            double exchangeRateDOP = 1.0; // Tasa de cambio USD (obtenida de la respuesta JSON)
            double convertedToUSD = amount * exchangeRateDOP;
            // Calcula otras conversiones según las tasas de cambio

            System.out.println(amount + " " + baseCurrency + " equivale a:");
            System.out.println(convertedToUSD + " USD");
            // Imprime otras conversiones

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

