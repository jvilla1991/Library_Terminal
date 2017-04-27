
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
        Book book = new Book("name", "author", "status");

        /*BookCollection bookCollection = new BookCollection();*/


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
                    ArrayList<Book> readFromFile = FileHandler.readFromFile();
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String b = readFromFile.get(i).getName();
                        String a = readFromFile.get(i).getAuthor();
                        System.out.println("\"" + b + "\"" + " by " + a);
                    }
                    FileHandler.readFromFile();
                    System.out.println();
                    break;
                case 2:
                    break;
                case 3: // NEEDS TO BE PUT IN A METHOD AND ADD VALIDATION
                    readFromFile = FileHandler.readFromFile();
                    System.out.println("Enter in an Author keyword: ");
                    String userKeyword = scan.nextLine();
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String compareAuthor = readFromFile.get(i).getAuthor();
                        String[] splitter = compareAuthor.split(" ");
                        for (int j = 0; j < splitter.length; j++) {
                            if (userKeyword.equalsIgnoreCase(splitter[j]))
                            {
                                System.out.println("You searched " + readFromFile.get(i).getName());
                                System.out.println("Would you like to check it out?");
                            }
                        }
                    }
                    break;
                case 4:
                    /*bookCollection.changeStatus("book", "author", false);*/
                    break;
                case 5:
                    /*bookCollection.changeStatus("book", "author", true);*/
                    break;
                case 6:
                    FileHandler.writeToFile(scan);
                    break;
            }

            System.out.println("Would you like to continue?");
            choice1 = scan.nextLine();
        } while (choice1.equalsIgnoreCase("yes"));
        System.out.println("Thank you. Please come again!");
    }

    /*public static void searchAuthor(ArrayList<Book> readFromFile, userKeyword) {
    }
*/

}
