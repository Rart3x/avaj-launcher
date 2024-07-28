package avaj;

import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static String[]  dataset, types, names;
    public static int[]     longitudes, latitudes, heights;

    public static int       nLoop;


    public static void main(String[] args)
    {
        AircraftFactory aircraftFactory = new AircraftFactory();
        Tower tower = new Tower();

        Flyable baloon = aircraftFactory.newAircraft("Baloon", "Baloon1", new Coordinates(2, 3, 4));
        Flyable jetPlane = aircraftFactory.newAircraft("JetPlane", "JetPlane1", new Coordinates(5, 6, 7));
        Flyable helicopter = aircraftFactory.newAircraft("Helicopter", "Helicopter1", new Coordinates(8, 9, 10));

        tower.register(baloon);
        tower.register(jetPlane);
        tower.register(helicopter);

        tower.unregister(baloon);
        tower.unregister(jetPlane);
        tower.unregister(helicopter);

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
            Utils.printError("Error: " + e.getMessage());
            return false;
        }
        return true;
    }


    public static void readFile(String filename) throws FileNotFoundException
    {
        List<String> lines = new ArrayList<>();
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine())
            lines.add(scanner.nextLine());

        scanner.close();

        dataset = lines.toArray(new String[0]);
    }


    public static void splitLinesByFormat() throws NumberFormatException
    {
        int i = 0;

        types = new String[dataset.length - 1];
        names = new String[dataset.length - 1];
        longitudes = new int[dataset.length - 1];
        latitudes = new int[dataset.length - 1];
        heights = new int[dataset.length - 1];

        for (String data : dataset)
        {
            if (i != 0)
            {
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
