package avaj;

import static avaj.Utils.*;

public class Coordinates {
    private int longitude, latitude, height;

    public enum Limits {
        MIN(0),
        MAX_HEIGHT(100);

        private final int value;

        Limits(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public Coordinates(int p_longitude, int p_latitude, int p_height)
    {
        if (p_longitude < Limits.MIN.getValue() || p_latitude < Limits.MIN.getValue() || p_height < Limits.MIN.getValue())
        {
            printError("Longitude, Latitude, Height cannot be less than " + Limits.MIN.getValue());
            return;
        }
        else if (p_height > Limits.MAX_HEIGHT.getValue())
        {
            printError("Height cannot be more than " + Limits.MAX_HEIGHT);
            return;
        }

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
        if (p_longitude < Limits.MIN.getValue())
            p_longitude = Limits.MIN.getValue();
        else
            longitude = p_longitude;
    }

    public void setLatitude(int p_latitude)
    {
        if (p_latitude < Limits.MIN.getValue())
            p_latitude = Limits.MIN.getValue();
        else
            latitude = p_latitude;
    }

    public void setHeight(int p_height)
    {
        if (p_height < Limits.MIN.getValue())
            p_height = Limits.MIN.getValue();
        else if (p_height > Limits.MAX_HEIGHT.getValue())
            p_height = Limits.MAX_HEIGHT.getValue();
        else
            height = p_height;
    }
}
