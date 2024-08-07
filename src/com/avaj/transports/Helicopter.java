package com.avaj.transports;

import com.avaj.WeatherProvider;

public class Helicopter extends Aircraft {

    public Helicopter(long p_id, String p_name, String p_type, int p_longitude, int p_latitude, int p_height) throws Exception {
        super(p_id, p_name, p_type, p_longitude, p_latitude, p_height);
    }

    @Override
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
                coordinates.setLongitude(coordinates.getLongitude() + 5);
                break;
            case "FOG":
                coordinates.setLongitude(coordinates.getLongitude() + 1);
                break;
            case "SNOW":
                coordinates.setHeight(coordinates.getHeight() - 12);
                break;
        }
    }
}