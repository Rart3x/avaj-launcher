package avaj;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static String[]      dataset, types, names;
    public static int[]         longitudes, latitudes, heights;

    public static int           nLoop;

    public static List<String>  existentTypes = Arrays.asList("Baloon", "JetPlane", "Helicopter");


    public static void main(String[] args)
    {
        AircraftFactory aircraftFactory = new AircraftFactory();
        WeatherTower tower = new WeatherTower();

        Flyable baloon = aircraftFactory.newAircraft("Baloon", "Baloon1", new Coordinates(2, 3, 4));
        Flyable jetPlane = aircraftFactory.newAircraft("JetPlane", "JetPlane1", new Coordinates(5, 6, 7));
        Flyable helicopter = aircraftFactory.newAircraft("Helicopter", "Helicopter1", new Coordinates(8, 9, 10));

        tower.register(baloon);
        tower.register(jetPlane);
        tower.register(helicopter);

        System.out.println(baloon.getCoordinates().getLatitude() + " " + baloon.getCoordinates().getLongitude() + " " + baloon.getCoordinates().getHeight());
        System.out.println(tower.getWeather(baloon.getCoordinates()));
        tower.conditionChanged();
        System.out.println(baloon.getCoordinates().getLatitude() + " " + baloon.getCoordinates().getLongitude() + " " + baloon.getCoordinates().getHeight());
        baloon.getCoordinates().setHeight(0);
        tower.conditionChanged();
//
//        tower.unregister(baloon);
//        tower.unregister(jetPlane);
//        tower.unregister(helicopter);

//        if (!checkArgs(args))
//            return;
    }


    public static boolean checkArgs(String[] args)
    {
        if (args.length != 1)
        {
            Utils.printError("Usage: Java main [filename]");
            return false;
        }

        try
        {
            readFile(args[0]);
            splitLinesByFormat();
        }
        catch (Exception e)
        {
            Utils.printError(e.getMessage());
            return false;
        }
        return true;
    }


    public static void readFile(String filename) throws Exception
    {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        scanner.close();

        dataset = lines.toArray(new String[0]);
    }


    public static void splitLinesByFormat() throws Exception
    {
        int i = 0;

        types = new String[dataset.length - 1];
        names = new String[dataset.length - 1];
        longitudes = new int[dataset.length - 1];
        latitudes = new int[dataset.length - 1];
        heights = new int[dataset.length - 1];

        if (dataset.length < 2)
            throw new Exception("Empty file");

        for (String data : dataset)
        {
            if (i != 0)
            {
                if (data.split(" ").length != 5)
                    throw new Exception("Invalid number of values in line: " + data);

                if (!existentTypes.contains(data.split(" ")[0]))
                    throw new Exception("Type not found: " + data.split(" ")[0]);

                types[i - 1] =  data.split(" ")[0];
                names[i - 1] = data.split(" ")[1];
                longitudes[i - 1] = Integer.parseInt(data.split(" ")[2]);
                latitudes[i - 1] = Integer.parseInt(data.split(" ")[3]);
                heights[i - 1] = Integer.parseInt(data.split(" ")[4]);
            }
            else
                nLoop = Integer.parseInt(data);

            i++;
        }


    }
}
