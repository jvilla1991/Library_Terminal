import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by Admin on 4/25/2017.
 */
public class File {

    public static void readFromFile() {
        Path filePath = Paths.get("books.txt");
        java.io.File textFile = filePath.toFile();
        try {
            FileReader r = new FileReader(textFile);
            BufferedReader reader = new BufferedReader(r);
            try {
                String line = reader.readLine();

                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(Scanner scnr) {
        scnr.nextLine();
        System.out.println("Please enter a book name: ");
        String book = scnr.nextLine();
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
