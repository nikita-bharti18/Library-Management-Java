import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private final String BOOK_FILE = "data/books.txt";
    private final String MEMBER_FILE = "data/members.txt";

    // ==========================
    // SAVE BOOKS
    // ==========================

    public void saveBooks(ArrayList<Book> books) {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(BOOK_FILE));

            for(Book book : books){

                writer.write(book.toString());

                writer.newLine();
            }

            writer.close();

        }

        catch(IOException e){

            System.out.println("Error Saving Books");
        }

    }

    // ==========================
    // LOAD BOOKS
    // ==========================

    public ArrayList<Book> loadBooks(){

        ArrayList<Book> books =
                new ArrayList<>();

        File file = new File(BOOK_FILE);

        if(!file.exists())
            return books;

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while((line=reader.readLine())!=null){

                String[] data=line.split(",");

                Book book=new Book(

                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Integer.parseInt(data[6])
                );

                books.add(book);

            }

            reader.close();

        }

        catch(IOException e){

            System.out.println("Error Loading Books");

        }

        return books;

    }

    // ==========================
    // SAVE MEMBERS
    // ==========================

    public void saveMembers(ArrayList<Member> members){

        try{

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter(MEMBER_FILE));

            for(Member member:members){

                writer.write(member.toString());

                writer.newLine();

            }

            writer.close();

        }

        catch(IOException e){

            System.out.println("Error Saving Members");
        }

    }

    // ==========================
    // LOAD MEMBERS
    // ==========================

    public ArrayList<Member> loadMembers(){

        ArrayList<Member> members =
                new ArrayList<>();

        File file=new File(MEMBER_FILE);

        if(!file.exists())
            return members;

        try{

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while((line=reader.readLine())!=null){

                String[] data=line.split(",");

                Member member=new Member(

                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4])
                );

                members.add(member);

            }

            reader.close();

        }

        catch(IOException e){

            System.out.println("Error Loading Members");

        }

        return members;

    }

}
