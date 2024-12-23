package javapillars;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

// PhysicalBook inherits Book and implements Lendable
public class Physicalbook extends Book implements Lendable {
    private int pages;

    // Logger instance
    private static final Logger logger = Logger.getLogger(Physicalbook.class.getName());

    // Constructor
    public Physicalbook(String title, String author, int pages) {
        super(title, author);
        this.pages = pages;

        // Set up the logger to log to app.log file
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Getter for pages
    public int getPages() {
        return pages;
    }

    // Overridden method from Book
    @Override
    public void displayDetails() {
        logger.info("Physical Book: " + getTitle() + " by " + getAuthor());
        logger.info("Pages: " + pages);
    }

    // Implementation of Lendable
    @Override
    public void lend(String borrower) {
        logger.info("Physical Book \"" + getTitle() + "\" lent to " + borrower + ".");
    }
}
