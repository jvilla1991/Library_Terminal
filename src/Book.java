/**
 * Created by Saritha on 4/25/2017.
 */
public class Book {
    private String name;
    private String author;


    public Book(String name, String author, boolean status) {
        this.name = name;
        this.author = author;
        this.status = status;
    }

    //
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
        return author;
    }

    public void setStatus(String author) {
        this.author = author;
    }

    //
    @Override
    public String toString() {
        return name + "," + author + ", " + status;
    }

    //
    boolean status = true;

    public boolean status() {
        if (status == true) {
            System.out.println("Due Date");

        } else if (status != true) {
            System.out.println("Stays on Shelf");
        }

        return status;
    }


    /*public String status(){
        if (status == 1){
           return "On Shelf";
        }else if (status == 2){
            return "Checked Out " + dueDate;
        }
    }*/


}


