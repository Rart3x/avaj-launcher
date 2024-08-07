package com.avaj.utils;

public class Exceptions {

    public static class EmptyFile extends Exception {
        public EmptyFile() { super("File is empty"); }
    }


    public static class InvalidNumberOfArgs extends Exception {
        public InvalidNumberOfArgs() { super("Invalid number of arguments"); }
    }

    public static class InvalidType extends Exception {
        public InvalidType() { super("Invalid aircraft type"); }
    }


    public static class InvalidHeightMin extends Exception {
        public InvalidHeightMin() { super("Height cannot be less than 0"); }
    }

    public static class InvalidNumberLoop extends Exception {
        public InvalidNumberLoop() { super("Number of simulations cannot be less than 0"); }
    }

    public static class InvalidHeightMax extends Exception {
        public InvalidHeightMax() {
            super("Height cannot be more than 100");
        }
    }

    public static class InvalidLongitude extends Exception {
        public InvalidLongitude() {
            super("Longitude cannot be less than 0");
        }
    }

    public static class InvalidLatitude extends Exception {
        public InvalidLatitude() {
            super("Latitude cannot be less than 0");
        }
    }

    public static class InvalidFile extends Exception {
        public InvalidFile(String filename) { super(filename + " file not found"); }
    }
}
