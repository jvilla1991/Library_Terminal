import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Admin on 4/25/2017.
 */
public class File {

    public static ArrayList<Book> readFromFile() {
        ArrayList<Book> catalog = new ArrayList<Book>(); // new array list
        Path filePath = Paths.get("books.txt");
        java.io.File textFile = filePath.toFile();
        try {
            FileReader r = new FileReader(textFile);
            BufferedReader reader = new BufferedReader(r);
            try {
                String line = reader.readLine();

                while (line != null) { // loop through each line
                    String[] currentLine = line.split(","); //  populates an array with a string that splits each line in file by comma
                    catalog.add(new Book(currentLine[0], currentLine[1], Boolean.parseBoolean(currentLine[2]))); // creates and adds book object to catalog
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
        scnr.nextLine();
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
