package avaj.transports;

import avaj.utils.Coordinates;
import avaj.utils.Utils;

import java.util.List;

public final class AircraftFactory {
    private int id = 0;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        Flyable flyable = null;
        String[] types = {"Baloon", "JetPlane", "Helicopter"};

        if (!List.of(types).contains(p_type))
        {
            Utils.printError("Invalid aircraft type: " + p_type);
            Utils.printInfo("AircraftFactory will return a Baloon by default");
        }

        switch (p_type)
        {
            case "JetPlane":
                flyable = new JetPlane(id, p_name, p_type, p_coordinates);
                break;
            case "Helicopter":
                flyable = new Helicopter(id, p_name, p_type, p_coordinates);
                break;
            default:
                flyable = new Baloon(id, p_name, "Baloon", p_coordinates);
                break;
        }

        id++;

        return flyable;
    }
}
