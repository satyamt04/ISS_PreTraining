import java.io.IOException;
import java.util.*;
import java.util.logging.*;

class Student {
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

    // Override equals and hashCode for Set and Map usage
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Student student = (Student) obj;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return 31 * id + name.hashCode();
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}

public class CollectionsExample {

    // Create a Logger instance
    private static final Logger logger = Logger.getLogger(CollectionsExample.class.getName());

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

        // List<Student> Example
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "Alice"));
        studentList.add(new Student(2, "Bob"));
        studentList.add(new Student(3, "Charlie"));
        studentList.add(new Student(2, "Bob")); // Duplicates allowed in List

        logger.info("List of Students:");
        for (Student student : studentList) {
            logger.info(student.toString());
        }

        studentList.remove(0);
        logger.info("\nAfter removing the first Student from List:");
        for (Student student : studentList) {
            logger.info(student.toString());
        }

        // Set<Student> Example
        Set<Student> studentSet = new HashSet<>();
        studentSet.add(new Student(1, "Alice"));
        studentSet.add(new Student(2, "Bob"));
        studentSet.add(new Student(3, "Charlie"));
        studentSet.add(new Student(2, "Bob")); // Duplicates not allowed in Set

        logger.info("\nSet of Students:");
        for (Student student : studentSet) {
            logger.info(student.toString());
        }

        // Map<Student, Student> Example
        Map<Student, Student> studentMap = new HashMap<>();
        studentMap.put(new Student(1, "Alice"), new Student(1, "Alice"));
        studentMap.put(new Student(2, "Bob"), new Student(2, "Bob"));
        studentMap.put(new Student(3, "Charlie"), new Student(3, "Charlie"));

        logger.info("\nMap of Students:");
        for (Map.Entry<Student, Student> entry : studentMap.entrySet()) {
            logger.info("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }

        studentMap.put(new Student(2, "Bob"), new Student(2, "Bob")); // Duplicate Key not allowed
        logger.info("\nAfter adding a duplicate Student as Key to Map:");
        for (Map.Entry<Student, Student> entry : studentMap.entrySet()) {
            logger.info("Key: " + entry.getKey() + " Value: " + entry.getValue());
        }
    }

    // Placeholder sort method
    public static void sort(List<Student> studentList) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sort'");
    }
}
