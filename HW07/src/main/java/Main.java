import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println(WeatherResponse.sendTempRequest(WeatherResponse.sendCityIdRequest("Minsk")));

    }
}
