import java.io.IOException;
import java.util.logging.*;

class InvalidOrderIdException extends Exception {
    public InvalidOrderIdException(String message) {
        super(message);
    }
}

class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}

public class ExceptionHandling {

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(ExceptionHandling.class.getName());

    public static void main(String[] args) {
        // Set up the FileHandler to write logs to app.log
        try {
            // Create a file handler that writes to app.log
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Handling exceptions with try-catch
        try {
            processOrder(-1, 20);  // Invalid Order ID
        } catch (InvalidOrderIdException e) {
            logger.severe("Error: " + e.getMessage());
        } catch (InsufficientStockException e) {
            logger.severe("Error: " + e.getMessage());
        }

        try {
            processOrder(100, 60);  // Insufficient stock
        } catch (InvalidOrderIdException e) {
            logger.severe("Error: " + e.getMessage());
        } catch (InsufficientStockException e) {
            logger.severe("Error: " + e.getMessage());
        }

        // Using throws to delegate exception handling
        try {
            checkOrderStatus(0);  // Invalid Order ID
        } catch (InvalidOrderIdException e) {
            logger.severe("Error: " + e.getMessage());
        }

        // Demonstrating throw keyword (throwing exception explicitly in a method)
        try {
            checkOrderProcess(0);  // This will throw an exception using 'throw'
        } catch (InvalidOrderIdException e) {
            logger.severe("Error: " + e.getMessage());
        }
    }

    // Method that processes the order and may throw exceptions
    public static void processOrder(int orderId, int quantity) throws InvalidOrderIdException, InsufficientStockException {
        // Simulate an order ID check
        if (orderId <= 0) {
            throw new InvalidOrderIdException("Order ID must be positive.");
        }

        // Simulate a stock check (assuming stock is 50 for simplicity)
        int stock = 50;
        if (quantity > stock) {
            throw new InsufficientStockException("Not enough stock available.");
        }

        // Process the order if no exceptions occurred
        logger.info("Order processed successfully!");
    }

    // Method that checks the order status and throws an exception if orderId is invalid
    public static void checkOrderStatus(int orderId) throws InvalidOrderIdException {
        if (orderId <= 0) {
            throw new InvalidOrderIdException("Invalid Order ID for status check.");
        }

        // Simulate checking order status
        logger.info("Order ID " + orderId + " is being processed.");
    }

    // Method that explicitly throws an exception using 'throw'
    public static void checkOrderProcess(int orderId) throws InvalidOrderIdException {
        if (orderId <= 0) {
            throw new InvalidOrderIdException("Order ID is not valid.");
        }
        logger.info("Order processed.");
    }
}
