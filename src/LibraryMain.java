
import java.io.File;
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
        ArrayList<Book> readFromFile = FileHandler.readFromFile();

        /*BookCollection bookCollection = new BookCollection();*/


        System.out.println("Welcome to the SJL Library");

        do {
            System.out.println("Would you like to:");
            System.out.println("1. Display the Book Collection");
            System.out.println("2. Search by Title Keyword");
            System.out.println("3. Search by Author");
            System.out.println("4. Check the Status of a book");
            System.out.println("5. Checkout a Book from list");
            System.out.println("6. Return a Book");
            System.out.println("7. Add a Book to the Collection");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                case 1:
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String b = readFromFile.get(i).getName();
                        String a = readFromFile.get(i).getAuthor();
                        System.out.println("\"" + b + "\"" + " by " + a);
                    }
                    FileHandler.readFromFile();
                    System.out.println();
                    break;

                case 2:
                    System.out.println("Enter in an Title keyword: ");
                    String userNameKeyword = scan.nextLine();
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String compareName = readFromFile.get(i).getAuthor();
                        String[] splitter = compareName.split(" ");
                        for (int j = 0; j < splitter.length; j++) {
                            if (userNameKeyword.equalsIgnoreCase(splitter[j]))
                            {
                                System.out.println("You searched " + readFromFile.get(i).getName());
                                System.out.println("Would you like to check it out?");
                            }
                        }
                    }
                    break;

                case 3: // NEEDS TO BE PUT IN A METHOD AND ADD VALIDATION
                    System.out.println("Enter in an Author keyword: ");
                    String userAuthorKeyword = scan.nextLine();
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String compareAuthor = readFromFile.get(i).getAuthor();
                        String[] splitter = compareAuthor.split(" ");
                        for (int j = 0; j < splitter.length; j++) {
                            if (userAuthorKeyword.equalsIgnoreCase(splitter[j]))
                            {
                                System.out.println("You searched " + readFromFile.get(i).getAuthor());
                                System.out.println("Would you like to check it out?");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Choose a book from the list: ");
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String b = readFromFile.get(i).getName();
                        String a = readFromFile.get(i).getAuthor();
                        System.out.println((i + 1) + " \"" + b + "\"" + " by " + a); // everything above this list gives the user a list of numbers to choose from
                    }
                    int userChoice3 = scan.nextInt() - 1;
                    System.out.println("The status of " + readFromFile.get(userChoice3).getName() + " is " + readFromFile.get(userChoice3).getStatus()); // this line will return the status
                    scan.nextLine();
                    break;

                case 5:
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String b = readFromFile.get(i).getName();
                        String a = readFromFile.get(i).getAuthor();
                        System.out.println((i + 1) + " \"" + b + "\"" + " by " + a); //everything above this line gives the user a list
                    }
                    System.out.println("Enter the number of the book you would like to check out: ");
                    int userChoice = scan.nextInt() - 1; // the user selects a number
                    String bookStatus = readFromFile.get(userChoice).getStatus(); // this gets the current status of the book on file
                    if (bookStatus.equalsIgnoreCase("on shelf")) // this compares the status of the book on file with a string. If there is a match, the user checks out the book
                    {
                        System.out.println("You have successfully checked out " + readFromFile.get(userChoice).getName() + "! It will be due back by (DATE)");
                        book.setStatus("checked out"); // this is not functional currently. it will update the status of the book to the opposite of checked ot
                    }
                    else if (bookStatus.equalsIgnoreCase("checked out")) //however, if the book has been checked out, it will return an error message
                    {
                        System.out.println("Sorry, that book has been checked out. It is due back (DATE)");
                    }
                    scan.nextLine();
                    break;

                case 6:
                    readFromFile = FileHandler.readFromFile();
                    for (int i = 0; i < readFromFile.size(); i++) {
                        String b = readFromFile.get(i).getName();
                        String a = readFromFile.get(i).getAuthor();
                        System.out.println((i + 1) + " \"" + b + "\"" + " by " + a); // gives the user a list
                    }
                    System.out.println("Enter the number of the book you would like to return: ");
                    int userChoice1 = scan.nextInt() - 1; // user selects book
                    String bookStatus1 = readFromFile.get(userChoice1).getStatus();
                    if (bookStatus1.equalsIgnoreCase("on shelf")) // if it's already on the shelf, it will give an error saying that the user cannot return it.
                    {
                        System.out.println("Sorry, that book is already on the shelf.");
                    }
                    else if (bookStatus1.equalsIgnoreCase("checked out")) // however, if it is checkedout it will check it back in
                    {
                        System.out.println("You have successfully checked in " + readFromFile.get(userChoice1).getName() + "! Thank you!");
                        book.setStatus("on shelf");
                    }
                    scan.nextLine();
                    break;

                case 7:
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
