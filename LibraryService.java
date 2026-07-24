public class LibraryService {

    private Library library;

    // Constructor
    public LibraryService(Library library) {
        this.library = library;
    }

    // ===========================
    // Issue Book
    // ===========================

    public void issueBook(int bookId, int memberId) {

        Book book = library.searchBook(bookId);
        Member member = library.searchMember(memberId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        if (book.getAvailableQuantity() == 0) {
            System.out.println("Book is not available.");
            return;
        }

        book.setAvailableQuantity(
                book.getAvailableQuantity() - 1
        );

        member.issueBook();

        System.out.println("Book issued successfully!");
    }

    // ===========================
    // Return Book
    // ===========================

    public void returnBook(int bookId, int memberId) {

        Book book = library.searchBook(bookId);
        Member member = library.searchMember(memberId);

        if (book == null || member == null) {
            System.out.println("Invalid Book ID or Member ID.");
            return;
        }

        book.setAvailableQuantity(
                book.getAvailableQuantity() + 1
        );

        member.returnBook();

        System.out.println("Book returned successfully!");
    }

    // ===========================
    // Update Book
    // ===========================

    public void updateBook(int id,
                           String title,
                           String author,
                           String category,
                           String isbn,
                           int quantity) {

        Book book = library.searchBook(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        book.setTitle(title);
        book.setAuthor(author);
        book.setCategory(category);
        book.setIsbn(isbn);
        book.setQuantity(quantity);

        if (book.getAvailableQuantity() > quantity) {
            book.setAvailableQuantity(quantity);
        }

        System.out.println("Book updated successfully!");
    }

    // ===========================
    // Update Member
    // ===========================

    public void updateMember(int id,
                             String name,
                             String email,
                             String phone) {

        Member member = library.searchMember(id);

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        member.setName(name);
        member.setEmail(email);
        member.setPhone(phone);

        System.out.println("Member updated successfully!");
    }

    // ===========================
    // Search Book By Name
    // ===========================

    public void searchBookByTitle(String title) {

        boolean found = false;

        for (Book book : library.getBooks()) {

            if (book.getTitle().equalsIgnoreCase(title)) {

                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching book found.");
        }
    }

    // ===========================
    // Statistics
    // ===========================

    public void showStatistics() {

        int totalBooks = library.getBooks().size();

        int totalMembers = library.getMembers().size();

        int availableBooks = 0;

        for (Book book : library.getBooks()) {

            availableBooks += book.getAvailableQuantity();
        }

        System.out.println("\n========== LIBRARY REPORT ==========");
        System.out.println("Total Book Titles : " + totalBooks);
        System.out.println("Total Members     : " + totalMembers);
        System.out.println("Available Books   : " + availableBooks);
        System.out.println("====================================");
    }

}
