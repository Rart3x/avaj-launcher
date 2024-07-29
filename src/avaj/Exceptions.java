package avaj;

public class Exceptions {
    public static class InvalidHeightMin extends Exception {
        public InvalidHeightMin() {
            super("Height cannot be less than 0");
        }
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
        public InvalidFile(String filename) {
            super(filename + " file not found");
        }
    }

}
