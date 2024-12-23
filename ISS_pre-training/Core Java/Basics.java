import java.util.logging.Logger;

// Class representing a Book
class Book {
    private static final Logger logger = Logger.getLogger(Book.class.getName());

    // Instance variables
    String title;
    String author;
    double price;
    int pages;

    // Constructor
    public Book(String title, String author, double price, int pages) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.pages = pages;
    }

    // Display book details
    void displayDetails() {
        logger.info("Title: " + title);
        logger.info("Author: " + author);
        logger.info("Price: $" + price);
        logger.info("Pages: " + pages);
    }

    // Calculate discounted price
    double applyDiscount(double discountPercentage) {
        return price - (price * discountPercentage / 100);
    }
}

public class Basics {
    private static final Logger logger = Logger.getLogger(Basics.class.getName());

    public static void main(String[] args) {
        // Create a book object
        Book book1 = new Book("Java Book", "Satyam", 29.99, 420);

        // Display book details
        logger.info("Book Details:");
        book1.displayDetails();

        // Apply discount and log the result
        double discountedPrice = book1.applyDiscount(10);
        logger.info("Discounted Price: $" + discountedPrice);
    }
}
