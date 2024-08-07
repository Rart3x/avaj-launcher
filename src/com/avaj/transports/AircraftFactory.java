package com.avaj.transports;

import com.avaj.utils.Utils;

import java.util.List;

public final class AircraftFactory {
    private static AircraftFactory  instance = null;
    private int                     id = 0;

    private AircraftFactory() {}

    public static AircraftFactory getInstance()
    {
        if (instance == null)
            instance = new AircraftFactory();
        return instance;
    }

    public Flyable newAircraft(String p_type, String p_name, int p_longitude, int p_latitude, int p_height) throws Exception {
        Flyable flyable;
        String[] types = {"Baloon", "JetPlane", "Helicopter"};

        if (!List.of(types).contains(p_type))
        {
            Utils.printError("Invalid aircraft type: " + p_type);
            Utils.printInfo("AircraftFactory will return a Baloon by default");
        }

        switch (p_type)
        {
            case "JetPlane":
                flyable = new JetPlane(id, p_name, p_type, p_longitude, p_latitude, p_height);
                break;
            case "Helicopter":
                flyable = new Helicopter(id, p_name, p_type, p_longitude, p_latitude, p_height);
                break;
            default:
                flyable = new Baloon(id, p_name, "Baloon", p_longitude, p_latitude, p_height);
                break;
        }

        id++;

        return flyable;
    }
}
