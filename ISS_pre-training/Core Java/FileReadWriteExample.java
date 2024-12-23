import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.*;

public class FileReadWriteExample {

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(FileReadWriteExample.class.getName());

    public static void main(String[] args) {
        String fileName = "example.txt";

        // Set up the FileHandler to write logs to app.log
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Writing to a file using FileWriter
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write("Hello, this is a sample text file.\n");
            fileWriter.write("Java File I/O is fun!");
            logger.info("Writing to file is completed.");
        } catch (IOException e) {
            logger.severe("Error while writing to the file: " + e.getMessage());
        }

        // Reading from a file using FileReader
        try (FileReader fileReader = new FileReader(fileName)) {
            int character;
            while ((character = fileReader.read()) != -1) {
                System.out.print((char) character); // You may want to log this as well
                logger.info("Read character: " + (char) character); // Log each character read
            }
        } catch (IOException e) {
            logger.severe("Error while reading from the file: " + e.getMessage());
        }
    }
}
