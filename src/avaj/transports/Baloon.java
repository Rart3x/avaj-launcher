package avaj.transports;

import avaj.WeatherProvider;

public class Baloon extends Aircraft {

    public Baloon(long p_id, String p_name, String p_type, int p_longitude, int p_latitude, int p_height) throws Exception {
        super(p_id, p_name, p_type, p_longitude, p_latitude, p_height);
    }

    @Override
    public void updateConditions()
    {
        String weather = WeatherProvider.getProvider().getCurrentWeather(coordinates);

        switch (weather)
        {
            case "SUN":
                coordinates.setLongitude(coordinates.getLongitude() + 2);
                coordinates.setHeight(coordinates.getHeight() + 4);
                break;
            case "RAIN":
                coordinates.setHeight(coordinates.getHeight() - 5);
                break;
            case "FOG":
                coordinates.setHeight(coordinates.getHeight() - 3);
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 15);
                break;
        }
    }
}
