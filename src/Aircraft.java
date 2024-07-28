public class Aircraft extends Flyable {
    protected long        id;
    protected String      name, type;
    protected Coordinates coordinates;

    protected Aircraft(long p_id, String p_name, String p_type, Coordinates p_coordinate)
    {
        this.id = p_id;
        this.name = p_name;
        this.type = p_type;
        this.coordinates = p_coordinate;
    }

    public void updateConditions() {}
}
