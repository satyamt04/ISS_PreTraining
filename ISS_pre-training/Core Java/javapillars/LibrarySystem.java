package javapillars;

public class LibrarySystem {
    public static void main(String[] args) {
        // Polymorphism: Base class reference, derived class objects
        Book ebook = new Ebook("Digital Fortress", "Dan Brown", 2.5);
        Book physicalBook = new Physicalbook("Inferno", "Dan Brown", 480);

        // Display details (method overriding in action)
        ebook.displayDetails();
        physicalBook.displayDetails();

        // Lending books
        if (ebook instanceof Lendable) {
            ((Lendable) ebook).lend("Alice");
        }
        if (physicalBook instanceof Lendable) {
            ((Lendable) physicalBook).lend("Bob");
        }
    }
}
