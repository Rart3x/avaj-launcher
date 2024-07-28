package avaj;

public class JetPlane extends Aircraft {

    public JetPlane(long p_id, String p_name, String p_type, Coordinates p_coordinates) {
        super(p_id, p_name, p_type, p_coordinates);
    }

    public void updateConditions()
    {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

        switch (weather)
        {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 10);
                coordinates.setHeight(coordinates.getHeight() + 2);
                break;
            case "RAIN":
                coordinates.setLatitude(coordinates.getLatitude() + 5);
                break;
            case "FOG":
                coordinates.setLatitude(coordinates.getLatitude() + 1);
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 7);
                break;
        }
    }
}
