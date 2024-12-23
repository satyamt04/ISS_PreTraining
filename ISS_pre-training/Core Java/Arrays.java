import java.util.logging.Logger;

public class Arrays {
    private static final Logger logger = Logger.getLogger(Arrays.class.getName());

    public static void main(String[] args) {
        // Array of book titles
        String[] books = { "Java Fundamentals", "Python Basics", "Effective C++", "Clean Code", "Algorithms Unlocked" };

        // String operations
        String searchQuery = "Clean Code";

        logger.info("Library Books:");
        for (String book : books) {
            logger.info(book);
        }

        logger.info("\nSearch for a Book:");

        // Check if the book is in the library
        boolean found = false;
        for (String book : books) {
            if (book.equalsIgnoreCase(searchQuery)) {
                logger.info("Book found: " + book);
                found = true;
                break;
            }
        }
        if (!found) {
            logger.info("Book not found.");
        }

        logger.info("\nString and Array Operations:");

        // Modify and display book titles
        for (int i = 0; i < books.length; i++) {
            // Convert each title to uppercase and display
            books[i] = books[i].toUpperCase();
            logger.info("Uppercase: " + books[i]);
        }

        // String length and substring
        String firstBook = books[0];
        logger.info("First Book: " + firstBook);
        logger.info("Length: " + firstBook.length());
        logger.info("Substring (0-4): " + firstBook.substring(0, 4));

        // Array operations
        logger.info("\nArray Length: " + books.length);

        logger.info("\nBooks Starting with 'A':");
        for (String book : books) {
            if (book.startsWith("A")) {
                logger.info(book);
            }
        }
    }
}
