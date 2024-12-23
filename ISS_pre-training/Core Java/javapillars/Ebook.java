package javapillars;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// EBook inherits Book and implements Lendable
public class Ebook extends Book implements Lendable {
    private double fileSize; // Additional property

    // Logger instance
    private static final Logger logger = Logger.getLogger(Ebook.class.getName());

    // Constructor
    public Ebook(String title, String author, double fileSize) {
        super(title, author);
        this.fileSize = fileSize;

        // Set up the logger to log to app.log file
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter for fileSize
    public double getFileSize() {
        return fileSize;
    }

    // Overridden method from Book
    @Override
    public void displayDetails() {
        logger.info("E-Book: " + getTitle() + " by " + getAuthor());
        logger.info("File Size: " + fileSize + " MB");
    }

    // Implementation of Lendable
    @Override
    public void lend(String borrower) {
        logger.info("E-Book \"" + getTitle() + "\" lent to " + borrower + ".");
    }
}
