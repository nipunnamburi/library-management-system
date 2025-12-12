import java.util.*;

public class LibraryApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookService bookService = new BookService();
        IssueService issueService = new IssueService();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    bookService.addBook(new Book(title, author));
                    break;

                case 2:
                    bookService.getAllBooks().forEach(b -> {
                        System.out.println(b.getId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | Issued: " + b.isIssued());
                    });
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter user ID: ");
                    int userId = sc.nextInt();
                    issueService.issueBook(bookId, userId);
                    break;

                case 4:
                    System.out.print("Enter book ID: ");
                    int bId = sc.nextInt();
                    issueService.returnBook(bId);
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
