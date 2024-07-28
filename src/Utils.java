import java.io.FileWriter;


public class Utils {

    public static String concatString(String... p_strings)
    {
        StringBuilder result = new StringBuilder();

        for (String string : p_strings)
            result.append(string);

        return result.toString();
    }

    public static void printInFile(String p_string)
    {
        String filePath = "simulation.txt";

        try
        {
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

    public static void printSuccess(String p_success)
    {
        System.out.println("\u001B[32mSuccess: " + p_success + "\u001B[0m");
    }

    public static void printWarning(String p_warning)
    {
        System.out.println("\u001B[33mWarning: " + p_warning + "\u001B[0m");
    }
}
