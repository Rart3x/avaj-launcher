public final class AircraftFactory {
    private int id = 0;

    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
    {
        Aircraft aircraft = new Aircraft(id, p_name, p_type, p_coordinates);
        id++;

        return aircraft;
    }
}
