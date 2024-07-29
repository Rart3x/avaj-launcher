package avaj;

public class Aircraft extends Flyable {
    protected long          id;
    protected String        name, type;
    protected Coordinates   coordinates;
    protected WeatherTower  weatherTower;

    protected Aircraft(long p_id, String p_name, String p_type, Coordinates p_coordinate)
    {
        this.id = p_id;
        this.name = p_name;
        this.type = p_type;
        this.coordinates = p_coordinate;
    }

    @Override
    public void updateConditions() {}

    public long getId() {
        return this.id;
    }

    public Coordinates getCoordinates() {
        return this.coordinates;
    }

    public String getIdAsString() {
        return Long.toString(this.id);
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public void registerTower(WeatherTower p_weatherTower)
    {
        this.weatherTower = p_weatherTower;
        this.weatherTower.register(this);
    }
}
