import java.io.IOException;
import java.util.*;
import java.util.logging.*;

// Custom object Student with ID and Name
class Student implements Comparable<Student> {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter and Setter for id and name
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Implementing Comparable for sorting by ID (natural sorting)
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id); // Sorting by ID
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

// Comparator for custom sorting by name (alternative to Comparable)
class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        return s1.getName().compareTo(s2.getName()); // Sorting by Name
    }
}

public class SortingObjects {
    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(SortingObjects.class.getName());

    public static void main(String[] args) {
        // Set up the FileHandler to write logs to app.log
        try {
            FileHandler fileHandler = new FileHandler("app.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // List of Students (Custom Objects)
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(3, "Charlie"));
        studentList.add(new Student(1, "Alice"));
        studentList.add(new Student(2, "Bob"));

        // Sorting List using Comparable (Natural Order by ID)
        Collections.sort(studentList);
        logger.info("Sorted by ID (using Comparable):");
        for (Student student : studentList) {
            logger.info(student.toString());
        }

        // Sorting List using Comparator (Sorting by Name)
        Collections.sort(studentList, new StudentNameComparator());
        logger.info("\nSorted by Name (using Comparator):");
        for (Student student : studentList) {
            logger.info(student.toString());
        }

        // List of Primitives (e.g., Integer values)
        List<Integer> intList = new ArrayList<>();
        intList.add(5);
        intList.add(3);
        intList.add(8);
        intList.add(1);

        // Sorting List of Primitives (Integers)
        Collections.sort(intList);
        logger.info("\nSorted List of Integers:");
        for (Integer num : intList) {
            logger.info(num.toString());
        }
    }
}
