import java.util.logging.Logger;

// Class representing a Student
class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    // Basic data types and variable types
    int id;               // Instance variable
    String name;          // Instance variable
    static String school; // Static variable

    // final variable (cannot be changed after initialization)
    final String country = "IND";

    // Constructor to initialize instance variables
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Method to display student details
    void displayDetails() {
        logger.info("ID: " + id);
        logger.info("Name: " + name);
        logger.info("School: " + school);
        logger.info("Country: " + country);
    }
}

public class Basics2 {
    private static final Logger logger = Logger.getLogger(Basics2.class.getName());

    public static void main(String[] args) {
        // Initialize static variable
        Student.school = "Sardar Patel Institute of Technology";

        // Create student objects
        Student student1 = new Student(101, "Satyam");
        Student student2 = new Student(102, "Adarsh");

        // Display student details
        logger.info("Student 1 Details:");
        student1.displayDetails();

        logger.info("Student 2 Details:");
        student2.displayDetails();
    }
}
