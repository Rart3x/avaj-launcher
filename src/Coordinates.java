public class Coordinates {
    private int longitude, latitude, height;

    public enum vars
    {
        MIN(0),
        MAX_HEIGHT(100);

        vars(int i) {}
    }

    public Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        this.longitude = p_longitude;
        this.latitude = p_latitude;
        this.height = p_height;
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setLongitude(int p_longitude)
    {
        if (p_longitude < vars.MIN.ordinal())
            p_longitude = vars.MIN.ordinal();
        else
            longitude = p_longitude;
    }

    public void setLatitude(int p_latitude)
    {
        if (p_latitude < vars.MIN.ordinal())
            p_latitude = vars.MIN.ordinal();
        else
            latitude = p_latitude;
    }

    public void setHeight(int p_height)
    {
        if (p_height < vars.MIN.ordinal())
            p_height = vars.MIN.ordinal();
        else if (p_height > vars.MAX_HEIGHT.ordinal())
            p_height = vars.MAX_HEIGHT.ordinal();
        else
            height = p_height;
    }
}
