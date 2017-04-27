//https://codereview.stackexchange.com/questions/33148/book-program-with-arraylist
//http://www.dreamincode.net/forums/topic/208224-java-library-system-implementing-arrays-for-books-and-library-class/
//http://forums.devshed.com/java-help-9/java-library-system-borrow-books-search-books-overdue-books-slight-812178.html
//http://www.cs.colostate.edu/~cs161/Fall12/labs/lab2/libsearch.html

import java.util.ArrayList;

/**
 * Created by Saritha on 4/25/2017.
 */
public class Book {
    private String name;
    private String author;
    private String status;


    public Book(String name, String author, String status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    //getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    //overriding

    @Override
    public String toString() {
        return name + "," + author + "," + status;
    }

    //status()

    public void  status() {
        if (status.equalsIgnoreCase("true")) {
            System.out.println("This book is checked out.The Due Date is: ");

        } else if (status.equalsIgnoreCase("false")) {
            System.out.println("On Shelf! Do you want to check out?: ");
        }


    }

    //finding title of the book

    public ArrayList<Book> findTitle(String title) {
        for (Book b : findTitle("Title")) {
            if (b.getName().equalsIgnoreCase(title)) ;
            return findTitle("Title");
        }
        return null;
    }

//finging author of the book

    public ArrayList<Book> findAuthor(String author) {
        for (Book b : findAuthor("Author")) {
            if (b.getAuthor().equalsIgnoreCase(author)) ;
            return findAuthor("Author");
        }
        return null;
    }





}


