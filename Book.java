public class Book {

    // Attributes
    private int bookId;
    private String title;
    private String author;
    private String category;
    private String isbn;
    private int quantity;
    private int availableQuantity;

    // Default Constructor
    public Book() {
    }

    // Parameterized Constructor
    public Book(int bookId, String title, String author,
                String category, String isbn,
                int quantity, int availableQuantity) {

        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isbn = isbn;
        this.quantity = quantity;
        this.availableQuantity = availableQuantity;
    }

    // Getters

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    // Setters

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    // Display Book Details

    public void displayBook() {

        System.out.println("-------------------------------------------");
        System.out.println("Book ID            : " + bookId);
        System.out.println("Title              : " + title);
        System.out.println("Author             : " + author);
        System.out.println("Category           : " + category);
        System.out.println("ISBN               : " + isbn);
        System.out.println("Total Quantity     : " + quantity);
        System.out.println("Available Quantity : " + availableQuantity);
        System.out.println("-------------------------------------------");
    }

    // Save Book in File Format

    @Override
    public String toString() {

        return bookId + "," +
                title + "," +
                author + "," +
                category + "," +
                isbn + "," +
                quantity + "," +
                availableQuantity;
    }
}
