import java.net.http.*;
import java.net.URI;
import org.json.JSONObject;

public class RestApi
 {
    public static void main(String[] args) {
        try {
            String city = "London";
            String apiKey = "YOUR_API_KEY"; 
            String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey + "&units=metric";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject json = new JSONObject(response.body());

            String cityName = json.getString("name");
            double temp = json.getJSONObject("main").getDouble("temp");
            String weather = json.getJSONArray("weather").getJSONObject(0).getString("description");

            System.out.println("Weather in " + cityName + ":");
            System.out.println("Temperature: " + temp + "°C");
            System.out.println("Condition: " + weather);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}