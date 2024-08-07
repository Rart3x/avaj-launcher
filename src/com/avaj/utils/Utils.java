package com.avaj.utils;

import com.avaj.WeatherProvider;
import com.avaj.transports.Flyable;

import java.io.FileWriter;


public class Utils {

    static int i = 0;

    public static String concatString(String... p_strings)
    {
        StringBuilder result = new StringBuilder();

        for (String string : p_strings)
            result.append(string);

        return result.toString();
    }

    public static boolean deleteFile(String p_filePath)
    {
        java.io.File file = new java.io.File(p_filePath);
        return file.delete();
    }

    public static void printDependingOnWeather(Flyable flyable)
    {
        String weather = WeatherProvider.getProvider().getCurrentWeather(flyable.getCoordinates());

        switch (flyable.getType())
        {
            case "Baloon":
                printDependingOnWeatherBaloon(weather, flyable);
                break;

            case "Helicopter":
                printDependingOnWeatherHelicopter(weather, flyable);
                break;

            case "JetPlane":
                printDependingOnWeatherJetPlane(weather, flyable);
                break;
        }
    }

    public static void printDependingOnWeatherBaloon(String weather, Flyable flyable)
    {
        printInFile("Baloon#" + flyable.getName() + "(" + flyable.getIdAsString() + "): ");

        switch (weather)
        {
            case "SUN":
                printInFile("Let's enjoy the good weather and take some pics.\n");
                break;
            case "RAIN":
                printInFile("Damn you rain! You messed up my baloon.\n");
                break;
            case "FOG":
                printInFile("I can't see anything from my Baloon!\n");
                break;
            case "SNOW":
                printInFile("It's snowing. We're gonna crash.\n");
                break;
        }
    }

    public static void printDependingOnWeatherHelicopter(String weather, Flyable flyable)
    {
        printInFile("Helicopter#" + flyable.getName() + "(" + flyable.getIdAsString() + "): ");

        switch (weather)
        {
            case "SUN":
                printInFile("This is hot.\n");
                break;
            case "RAIN":
                printInFile("It's raining. Better watch out for lightings.\n");
                break;
            case "FOG":
                printInFile("I can't see anything from my Helicopter!\n");
                break;
            case "SNOW":
                printInFile("My rotor is going to freeze!\n");
                break;
        }
    }

    public static void printDependingOnWeatherJetPlane(String weather, Flyable flyable)
    {
        printInFile("JetPlane#" + flyable.getName() + "(" + flyable.getIdAsString() + "): ");

        switch (weather)
        {
            case "SUN":
                printInFile("Sky is clear ! Let's go MACH2\n");
                break;
            case "RAIN":
                printInFile("Rainy times, let's dodge stormy clouds\n");
                break;
            case "FOG":
                printInFile("I can't see anything from my JetPlane!\n");
                break;
            case "SNOW":
                printInFile("OMG! Winter is coming!\n");
                break;
        }
    }

    public static void printInFile(String p_string)
    {
        String filePath = "../simulation.txt";

        try
        {
            if (i == 0)
            {
                deleteFile(filePath);
                i++;
            }

            FileWriter fileWriter = new FileWriter(filePath, true);

            fileWriter.write(p_string);
            fileWriter.close();
        }
        catch (Exception e) {
            printError("Could not write to file: " + filePath);
        }
    }

    public static void printError(String p_error)
    {
        System.out.println("\u001B[31mError: " + p_error + "\u001B[0m");
    }
    public static void printInfo(String p_info)
    {
        System.out.println("\u001B[34mInfo: " + p_info + "\u001B[0m");
    }
}
