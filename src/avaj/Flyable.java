package avaj;

public abstract class Flyable {
    protected WeatherTower weatherTower;

    public abstract void updateConditions();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }

    public abstract long        getId();
    public abstract Coordinates getCoordinates();
    public abstract String      getIdAsString();
    public abstract String      getName();
    public abstract String      getType();
}
