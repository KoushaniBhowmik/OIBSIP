import java.util.*;

public class Task_five {
    static class Book {
        String id, title, author;
        boolean isIssued;

        Book(String id, String title, String author) {
            this.id = id;
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }
    }

    private static final List<Book> books = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    static void addBook() {
        System.out.print("Enter Book ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Author: ");
        String author = scanner.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        books.removeIf(book -> book.id.equals(id));
        System.out.println("Book deleted if it existed.");
    }

    static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println("ID: " + book.id + ", Title: " + book.title + ", Author: " + book.author + ", Issued: " + book.isIssued);
        }
    }

    static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        String id = scanner.nextLine();
        for (Book book : books) {
            if (book.id.equals(id) && !book.isIssued) {
                book.isIssued = true;
                System.out.println("Book issued successfully!");
                return;
            }
        }
        System.out.println("Book not found or already issued.");
    }

    static void returnBook() {
        System.out.print("Enter Book ID to return: ");
        String id = scanner.nextLine();
        for (Book book : books) {
            if (book.id.equals(id) && book.isIssued) {
                book.isIssued = false;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("Book not found or not issued.");
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\nDigital Library Management System\n");
            System.out.println(" 1. Add Book\n 2. Delete Book\n 3. View Books\n 4. Issue Book\n 5. Return Book\n 6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> viewBooks();
                case 4 -> issueBook();
                case 5 -> returnBook();
                case 6 -> System.out.println("Exiting system...");
                default -> System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 6);
        scanner.close();
    }
}