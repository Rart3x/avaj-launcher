package avaj;

import avaj.utils.Coordinates;

public final class WeatherProvider {
    private final String[] weather;
    private static WeatherProvider weatherProvider;

    private WeatherProvider()
    {
        weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        return weather[(p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4];
    }
}
