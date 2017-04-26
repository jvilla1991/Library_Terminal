
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.reflect.Array;

import java.util.ArrayList;

import java.util.Scanner;

/**
 * Created by Admin on 4/25/2017.
 */
public class LibraryMain {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int choice = 1;
        String choice1 = "yes";
        Book book = new Book("name", "author", true);

        BookCollection bookCollection = new BookCollection();


        System.out.println("Welcome to the SJL Library");

        do {
            System.out.println("Would you like to:");
            System.out.println("1. Display the Book Collection");
            System.out.println("2. Search by Title Keyword");
            System.out.println("3. Search by Author");
            System.out.println("4. Checkout a Book");
            System.out.println("5. Return a Book");
            System.out.println("6. Add a Book to the Collection");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    File.readFromFile();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    bookCollection.changeStatus("book", "author", false);
                    break;
                case 5:
                    bookCollection.changeStatus("book", "author", true);
                    break;
                case 6:
                    bookCollection.addToList("name", "author", true);
                    break;
            }

            System.out.println("Would you like to continue?");
            choice1 = scan.nextLine();
        } while (choice1.equalsIgnoreCase("yes"));
        System.out.println("Thank you. Please come again!");
    }



}
