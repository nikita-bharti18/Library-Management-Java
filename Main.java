import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();
        LibraryService service = new LibraryService(library);
        FileManager fileManager = new FileManager();

        // Load previous data
        library.getBooks().addAll(fileManager.loadBooks());
        library.getMembers().addAll(fileManager.loadMembers());

        while (true) {

            System.out.println("\n=================================");
            System.out.println(" LIBRARY MANAGEMENT SYSTEM ");
            System.out.println("=================================");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Search Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Add Member");
            System.out.println("6. View Members");
            System.out.println("7. Issue Book");
            System.out.println("8. Return Book");
            System.out.println("9. Library Statistics");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Author: ");
                    String author = sc.nextLine();

                    System.out.print("Category: ");
                    String category = sc.nextLine();

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = sc.nextInt();

                    Book book = new Book(
                            bookId,
                            title,
                            author,
                            category,
                            isbn,
                            quantity,
                            quantity
                    );

                    library.addBook(book);

                    break;

                case 2:

                    library.viewBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID: ");

                    int searchId = sc.nextInt();

                    Book found = library.searchBook(searchId);

                    if (found != null)
                        found.displayBook();
                    else
                        System.out.println("Book not found!");

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");

                    int deleteId = sc.nextInt();

                    if (library.deleteBook(deleteId))
                        System.out.println("Book Deleted!");
                    else
                        System.out.println("Book not found!");

                    break;

                case 5:

                    System.out.print("Member ID: ");
                    int memberId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String name = sc.nextLine();

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Phone: ");
                    String phone = sc.nextLine();

                    Member member = new Member(
                            memberId,
                            name,
                            email,
                            phone,
                            0
                    );

                    library.addMember(member);

                    break;

                case 6:

                    library.viewMembers();

                    break;

                case 7:

                    System.out.print("Book ID: ");
                    int issueBookId = sc.nextInt();

                    System.out.print("Member ID: ");
                    int issueMemberId = sc.nextInt();

                    service.issueBook(issueBookId, issueMemberId);

                    break;

                case 8:

                    System.out.print("Book ID: ");
                    int returnBookId = sc.nextInt();

                    System.out.print("Member ID: ");
                    int returnMemberId = sc.nextInt();

                    service.returnBook(returnBookId, returnMemberId);

                    break;

                case 9:

                    service.showStatistics();

                    break;

                case 10:

                    fileManager.saveBooks(library.getBooks());
                    fileManager.saveMembers(library.getMembers());

                    System.out.println("\nData Saved Successfully!");
                    System.out.println("Thank You for Using Library Management System.");

                    sc.close();

                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }

        }

    }

}
