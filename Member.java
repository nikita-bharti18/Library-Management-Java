public class Member {

    // Attributes
    private int memberId;
    private String name;
    private String email;
    private String phone;
    private int booksIssued;

    // Default Constructor
    public Member() {
    }

    // Parameterized Constructor
    public Member(int memberId, String name,
                  String email, String phone,
                  int booksIssued) {

        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.booksIssued = booksIssued;
    }

    // Getters

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    // Setters

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBooksIssued(int booksIssued) {
        this.booksIssued = booksIssued;
    }

    // Increase issued book count

    public void issueBook() {
        booksIssued++;
    }

    // Decrease issued book count

    public void returnBook() {

        if (booksIssued > 0) {
            booksIssued--;
        }
    }

    // Display Member Details

    public void displayMember() {

        System.out.println("---------------------------------------");
        System.out.println("Member ID      : " + memberId);
        System.out.println("Name           : " + name);
        System.out.println("Email          : " + email);
        System.out.println("Phone          : " + phone);
        System.out.println("Books Issued   : " + booksIssued);
        System.out.println("---------------------------------------");
    }

    // Save in Text File

    @Override
    public String toString() {

        return memberId + "," +
                name + "," +
                email + "," +
                phone + "," +
                booksIssued;
    }
}
