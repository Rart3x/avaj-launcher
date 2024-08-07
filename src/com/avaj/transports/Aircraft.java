package com.avaj.transports;

import com.avaj.WeatherTower;

public class Aircraft extends Flyable {
    protected long          id;
    protected String        name, type;
    protected Coordinates   coordinates;
    protected WeatherTower  weatherTower;

    protected Aircraft(long p_id, String p_name, String p_type, int p_longitude, int p_latitude, int p_height) throws Exception {
        this.id = p_id;
        this.name = p_name;
        this.type = p_type;
        this.coordinates = new Coordinates(p_longitude, p_latitude, p_height);
    }

    @Override
    public void updateConditions() {}

    public long getId() {
        return this.id;
    }
    public Coordinates getCoordinates() {
        return this.coordinates;
    }
    public String getIdAsString() { return Long.toString(this.id); }
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
