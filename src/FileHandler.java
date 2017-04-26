import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 4/26/2017.
 */
public class FileHandler {
    // private static final String SEP = ",";
    Book book;
    public static ArrayList<Book> readFromFile() {

        ArrayList<Book> catalog = new ArrayList<Book>(); // new array list
        //Book book = null;
        Path filePath = Paths.get("books.txt");
        File textFile = filePath.toFile();
        try {
            FileReader r = new FileReader(textFile);
            BufferedReader reader = new BufferedReader(r);
            try {
                String line = reader.readLine();

                while (line != null) { // loop through each line
                    String[] currentLine = line.split(","); //  populates an array with a string that splits each line in file by comma

                    catalog.add(new Book(currentLine[0], currentLine[1], true)); // creates and adds book object to catalog
                    //String title = currentLine[0];
                    //String author = currentLine[1];
                    //       boolean status = Boolean.parseBoolean(currentLine[2]);

                    //book = new Book(title, author,true);
                    //catalog.add(book);
                    for (int i = 0; i < catalog.size(); i++) {
                        Book b = catalog.get(i);
                        //System.out.println(b);
                    }
                    line = reader.readLine(); // reads next line and restarts the loop if occupied
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return catalog;
    }

    public static void writeToFile(Scanner scnr) {
        System.out.println("Please enter a book name: ");
        String bookTitle = scnr.nextLine();
        System.out.println("Please enter the book's author: ");
        String bookAuthor = scnr.nextLine();
        Book book = new Book(bookTitle, bookAuthor, true);
        Path writePath = Paths.get("books.txt");
        java.io.File bookFiles = writePath.toFile();

        try {
            PrintWriter out = new PrintWriter(new FileOutputStream(bookFiles, true));
            out.println(book);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
