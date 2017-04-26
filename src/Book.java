/**
 * Created by Saritha on 4/25/2017.
 */
public class Book {
    private String name;
    private String author;
    private boolean status;


    public Book(String name, String author, boolean status) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //overriding

    @Override
    public String toString() {
        return name + "," + author + "," + status;
    }

    //status()

    public boolean status() {
        if (status == true) {
            System.out.println("Due Date");

        } else if (status != true) {
            System.out.println("Stays on Shelf");
        }

        return status;
    }



}


