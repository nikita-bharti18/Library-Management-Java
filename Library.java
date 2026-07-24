import java.util.ArrayList;

public class Library {

    // Store all books
    private ArrayList<Book> books;

    // Store all members
    private ArrayList<Member> members;

    // Constructor
    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    // -----------------------------
    // BOOK OPERATIONS
    // -----------------------------

    // Add Book
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // View All Books
    public void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Search Book by ID
    public Book searchBook(int id) {

        for (Book book : books) {

            if (book.getBookId() == id) {
                return book;
            }
        }

        return null;
    }

    // Delete Book
    public boolean deleteBook(int id) {

        Book book = searchBook(id);

        if (book != null) {
            books.remove(book);
            return true;
        }

        return false;
    }

    // -----------------------------
    // MEMBER OPERATIONS
    // -----------------------------

    // Add Member
    public void addMember(Member member) {

        members.add(member);

        System.out.println("Member added successfully!");
    }

    // View Members
    public void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member member : members) {
            member.displayMember();
        }
    }

    // Search Member
    public Member searchMember(int id) {

        for (Member member : members) {

            if (member.getMemberId() == id) {
                return member;
            }
        }

        return null;
    }

    // Delete Member
    public boolean deleteMember(int id) {

        Member member = searchMember(id);

        if (member != null) {
            members.remove(member);
            return true;
        }

        return false;
    }

    // -----------------------------
    // GETTERS
    // -----------------------------

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }
}
