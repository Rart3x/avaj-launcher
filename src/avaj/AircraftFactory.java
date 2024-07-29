package avaj;

import java.util.List;

public final class AircraftFactory {
    private int id = 0;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        Flyable flyable = null;
        String[] types = {"Baloon", "JetPlane", "Helicopter"};

        if (!List.of(types).contains(p_type))
        {
            Utils.printError("Invalid flyable type: " + p_type);
            return null;
        }

        switch (p_type)
        {
            case "Baloon":
                flyable = new Baloon(id, p_name, p_type, p_coordinates);
                break;
            case "JetPlane":
                flyable = new JetPlane(id, p_name, p_type, p_coordinates);
                break;
            case "Helicopter":
                flyable = new Helicopter(id, p_name, p_type, p_coordinates);
                break;
        }

        id++;

        return flyable;
    }
}
