package com.avaj.transports;


import com.avaj.utils.Exceptions;

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

    Coordinates(int p_longitude, int p_latitude, int p_height) throws Exception
    {
        if (p_longitude < Limits.MIN.getValue())
            throw new Exceptions.InvalidLongitude();

        if (p_latitude < Limits.MIN.getValue())
            throw new Exceptions.InvalidLatitude();

        if (p_height < Limits.MIN.getValue())
            throw new Exceptions.InvalidHeightMin();

        if (p_height > Limits.MAX_HEIGHT.getValue())
            throw new Exceptions.InvalidHeightMax();

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
            longitude = Limits.MIN.getValue();
        else
            longitude = p_longitude;
    }

    public void setLatitude(int p_latitude)
    {
        if (p_latitude < Limits.MIN.getValue())
            latitude = Limits.MIN.getValue();
        else
            latitude = p_latitude;
    }

    public void setHeight(int p_height)
    {
        if (p_height < Limits.MIN.getValue())
            height = Limits.MIN.getValue();
        else if (p_height > Limits.MAX_HEIGHT.getValue())
            height = Limits.MAX_HEIGHT.getValue();
        else
            height = p_height;
    }
}
