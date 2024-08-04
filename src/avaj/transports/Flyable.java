package avaj.transports;

import avaj.WeatherTower;

public abstract class Flyable {
    protected WeatherTower weatherTower;
    public boolean      isLanded = false;

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
