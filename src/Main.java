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
}
