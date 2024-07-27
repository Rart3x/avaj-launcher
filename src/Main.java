import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static String[]  dataset;
    public static String[]  types, names, longitudes, latitudes, heights;

    public static int       nLoop;


    public static void main(String[] args)
    {
        if (!checkArgs(args))
            return;
        mainLoop();
    }


    public static void mainLoop()
    {
        for (int i = 0; i < nLoop; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                if (types[j].equals("Baloon") || types[j].equals("JetPlane") || types[j].equals("Helicopter"))
                {
                    Weather.Weathers weather = Weather.generateWeather(Integer.parseInt(longitudes[j]), Integer.parseInt(latitudes[j]), Integer.parseInt(heights[j]));
                    updateCoordinates(types[j], j, weather);
                }
            }
        }
    }


    public static boolean checkArgs(String[] args)
    {
        if (args.length != 1)
        {
            System.out.println("\u001B[31mUsage: java Main [filename]\u001B[0m");
            return false;
        }

        try
        {
            readFile(args[0]);
            splitLinesByFormat();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\u001B[31mError: " + e.getMessage() + "\u001B[0m");
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


    public static void splitLinesByFormat()
    {
        int i = 0;

        types = new String[dataset.length - 1];
        names = new String[dataset.length - 1];
        longitudes = new String[dataset.length - 1];
        latitudes = new String[dataset.length - 1];
        heights = new String[dataset.length - 1];

        for (String data : dataset)
        {
            if (i != 0)
            {
                types[i - 1] = data.split(" ")[0];
                names[i - 1] = data.split(" ")[1];
                longitudes[i - 1] = data.split(" ")[2];
                latitudes[i - 1] = data.split(" ")[3];
                heights[i - 1] = data.split(" ")[4];
            }
            i++;
        }
    }


    public static void updateCoordinates(String type, int index, Weather.Weathers weather) {
        switch (type)
        {
            case "Baloon":
                switch (weather)
                {
                    case FOG:
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) - 3);
                        break;
                    case RAIN:
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) - 5);
                        break;
                    case SNOW:
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) - 15);
                        break;
                    case SUN:
                        longitudes[index] = String.valueOf(Integer.parseInt(longitudes[index]) + 2);
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) + 4);
                        break;
                }
                break;

            case "JetPlane":
                switch (weather)
                {
                    case FOG:
                        latitudes[index] = String.valueOf(Integer.parseInt(latitudes[index]) + 1);
                        break;
                    case RAIN:
                        latitudes[index] = String.valueOf(Integer.parseInt(latitudes[index]) + 5);
                        break;
                    case SNOW:
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) - 7);
                        break;
                    case SUN:
                        latitudes[index] = String.valueOf(Integer.parseInt(latitudes[index]) + 10);
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) + 2);
                        break;
                }
                break;

            case "Helicopter":
                switch (weather)
                {
                    case FOG:
                        longitudes[index] = String.valueOf(Integer.parseInt(longitudes[index]) + 1);
                        break;
                    case RAIN:
                        longitudes[index] = String.valueOf(Integer.parseInt(longitudes[index]) + 5);
                        break;
                    case SNOW:
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) - 12);
                        break;
                    case SUN:
                        longitudes[index] = String.valueOf(Integer.parseInt(longitudes[index]) + 10);
                        heights[index] = String.valueOf(Integer.parseInt(heights[index]) + 2);
                        break;
                }

                break;
        }
    }
}
