import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;

import java.io.IOException;

public class WeatherResponse {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final String apiKey = "VTPiDR8iTAXjS1Yow1x9ld3Vfdpjm3UA";

    //http://dataservice.accuweather.com/locations/v1/cities/search
    static public String sendCityIdRequest(String cityName) throws IOException {
        String cityId;

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("locations")
                .addPathSegment("v1")
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", apiKey)
                .addQueryParameter("q", cityName)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();

        JsonNode cityIdNode = objectMapper
                .readTree(responseJson)
                .at("/0/Key");
        cityId = cityIdNode.asText();
        System.out.print("В городе " + cityName + " ");

        return cityId;
    }

    //http://dataservice.accuweather.com/forecasts/v1/daily/5day/{locationKey}
    static public String sendTempRequest(String cityId) throws IOException {

        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("http")
                .host("dataservice.accuweather.com")
                .addPathSegment("forecasts")
                .addPathSegment("v1")
                .addPathSegment("daily")
                .addPathSegment("5day")
                .addPathSegment(cityId)  //{locationKey} = cityId
                .addQueryParameter("apikey", apiKey)
                .build();

        Request request = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(httpUrl)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        String responseJson = response.body().string();

        //распарсим запрос:
        JsonNode weatherNodeData = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Date");
        String weatherData = weatherNodeData.asText();

        JsonNode weatherNodeText = objectMapper
                .readTree(responseJson)
                .at("/Headline/Text");
        String weatherText = weatherNodeText.asText();

        JsonNode weatherNodeTemperatureMax = objectMapper
                .readTree(responseJson)
                .at("/DailyForecasts/0/Temperature/Maximum/Value");

        //(32 °F − 32) × 5/9 = 0 °C
        String weatherMax = weatherNodeTemperatureMax.asText();
        double temperatureMax = Double.parseDouble(weatherMax);
        double convert = ((temperatureMax - 32) * 5) / 9;
        int weatherTemperatureMax = (int) Math.round(convert);

        return "на дату " + weatherData + "\n" + " ожидается: " + weatherText + "\n" +
                " температура до " + weatherTemperatureMax + " градусов Цельсия.";

    }

}
