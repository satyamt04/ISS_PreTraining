import java.io.IOException;
import java.util.logging.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class MyThread extends Thread {
    private static final Logger logger = Logger.getLogger(MyThread.class.getName());

    public void run() {
        logger.info("Thread running: " + Thread.currentThread().getName());
    }
}

class Task implements Runnable {
    private static final Logger logger = Logger.getLogger(Task.class.getName());
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        logger.info(taskName + " is running on " + Thread.currentThread().getName());
    }
}

class VolatileExample {
    private static volatile boolean flag = false;
    private static final Logger logger = Logger.getLogger(VolatileExample.class.getName());

    public static void main(String[] args) throws InterruptedException {
        Thread writerThread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulating some work
                flag = true; // Modify the flag
                logger.info("Flag updated to true");
            } catch (InterruptedException e) {
                logger.warning("Writer thread interrupted: " + e.getMessage());
            }
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {
                // Looping until flag is true
            }
            logger.info("Flag is true, exiting loop");
        });

        writerThread.start();
        readerThread.start();

        writerThread.join();
        readerThread.join();
    }
}

class Counter {
    private int count = 0;
    // private static final Logger logger = Logger.getLogger(Counter.class.getName());

    // Synchronized method ensures thread safety for instance variable
    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

public class Multithreading {
    private static final Logger logger = Logger.getLogger(Multithreading.class.getName());

    public static void main(String[] args) throws InterruptedException, IOException {
        // Configuring the logger to write to a file
        FileHandler fileHandler = new FileHandler("app.log", true); // true for appending logs
        fileHandler.setFormatter(new SimpleFormatter()); // Setting log format
        logger.addHandler(fileHandler); // Add file handler to logger

        // Task using ThreadPoolExecutor
        executorServiceExample();

        // Volatile Example
        logger.info("Starting Volatile Example...");
        VolatileExample.main(args);

        // Synchronized Example with Counter
        logger.info("Starting synchronized counter example...");
        Counter counter = new Counter();

        // Create two threads that increment the counter
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Wait for both threads to finish
        thread1.join();
        thread2.join();

        // Final count
        logger.info("Final count: " + counter.getCount());

        // Close the file handler to release resources
        fileHandler.close();
    }

    private static void executorServiceExample() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Task("Task1"));
        executorService.submit(new Task("Task2"));
        executorService.submit(new Task("Task3"));
        executorService.shutdown();
    }
}
