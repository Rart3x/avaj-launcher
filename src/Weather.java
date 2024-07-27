public class Weather {

    public enum Weathers {
        FOG,
        RAIN,
        SNOW,
        SUN
    }

    public static Weathers generateWeather(int l, int L, int h)
    {
        int key = l * L * h;

        return switch (key % 4) {
            case 0 -> Weathers.FOG;
            case 1 -> Weathers.RAIN;
            case 2 -> Weathers.SNOW;
            default -> Weathers.SUN;
        };
    }
}
