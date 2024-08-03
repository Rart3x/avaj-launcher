package avaj;

import avaj.transports.AircraftFactory;
import avaj.transports.Coordinates;
import avaj.transports.Flyable;
import avaj.utils.Exceptions;
import avaj.utils.Utils;

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
        try
        {
            if (!checkArgs(args))
                return;
            mainLoop();
        }
        catch (Exception e) {
            Utils.printError(e.getMessage());
        }
    }

    public static void mainLoop() throws Exception
    {
        AircraftFactory aircraftFactory = AircraftFactory.getInstance();
        WeatherTower tower = new WeatherTower();

        for (int i = 0; i < types.length; i++)
        {
            Coordinates coordinates = new Coordinates(longitudes[i], latitudes[i], heights[i]);
            Flyable flyable = aircraftFactory.newAircraft(types[i], names[i], coordinates);
            tower.register(flyable);
        }

        for (int j = 0; j < nLoop; j++)
            tower.conditionChanged();

        tower.unregisterAll();
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

        try
        {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine())
                lines.add(scanner.nextLine());

            scanner.close();

            dataset = lines.toArray(new String[0]);
        }
        catch (FileNotFoundException e) {
            throw new Exceptions.InvalidFile(filename);
        }
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
            throw new Exceptions.EmptyFile();

        for (String data : dataset)
        {
            if (i != 0)
            {
                if (data.split(" ").length != 5)
                    throw new Exceptions.InvalidNumberOfLines();

                if (!existentTypes.contains(data.split(" ")[0]))
                    throw new Exceptions.InvalidType();

                types[i - 1] =  data.split(" ")[0];
                names[i - 1] = data.split(" ")[1];
                longitudes[i - 1] = Integer.parseInt(data.split(" ")[2]);
                latitudes[i - 1] = Integer.parseInt(data.split(" ")[3]);

                if (Integer.parseInt(data.split(" ")[4]) < 0)
                    throw new Exceptions.InvalidHeightMin();
                if (Integer.parseInt(data.split(" ")[4]) > 100)
                    throw new Exceptions.InvalidHeightMax();

                heights[i - 1] = Integer.parseInt(data.split(" ")[4]);
            }
            else
            {
                if (Integer.parseInt(data) < 0)
                    throw new Exceptions.InvalidNumberLoop();

                nLoop = Integer.parseInt(data);
            }
            i++;
        }


    }
}
