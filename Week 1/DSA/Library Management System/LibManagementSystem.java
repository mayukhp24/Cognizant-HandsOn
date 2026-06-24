import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {

    static Book linearSearchByTitle(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    static Book binarySearchByTitle(Book[] sorted, String title) {
        int low = 0;
        int high = sorted.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = sorted[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                return sorted[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "Clean Code", "Robert Martin"),
            new Book(2, "The Pragmatic Programmer", "Andrew Hunt"),
            new Book(3, "Effective Java", "Joshua Bloch"),
            new Book(4, "Refactoring", "Martin Fowler")
        };

        Book b = linearSearchByTitle(books, "Effective Java");
        System.out.println("Linear: " + (b != null ? b.author : "not found"));

        Book[] sorted = books.clone();
        Arrays.sort(sorted, Comparator.comparing(x -> x.title.toLowerCase()));

        Book b2 = binarySearchByTitle(sorted, "Refactoring");
        System.out.println("Binary: " + (b2 != null ? b2.author : "not found"));
    }
}
