import java.util.*;

interface Borrowable{
    void checkIn(Scanner s);
    void checkOut(Scanner s);
}

class Book{
    String bookID;
    String title;
    String author;
    public static Book search(ArrayList<Book> list , String id){
        for (Book t : list) {
            if(t.bookID.equals(id)){
                return t;
            }
        }
        return null;
    }
    void displayBook(){}
    void checkIn(Scanner s){}
    void checkOut(Scanner s){}
}

class TextBook extends Book implements Borrowable{
    String status;
    String borrowedUser;
    public TextBook(String bookID , String title , String author){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.status = "Available";
        this.borrowedUser = "";
    }

    public void checkIn(Scanner s){
        this.status = "Available";
        this.borrowedUser = "";
    }
    public void checkOut(Scanner s){
        System.out.print("Enter Username: ");
        String name = s.nextLine().trim();
        this.status = "Borrowed by " + name;
        this.borrowedUser = name;
    }
    void displayBook(){
        System.out.println("TextBook: " + this.bookID + ": " + this.title + ": " + this.author + ": " + this.status);
    }
}


class ReferenceBook extends Book implements Borrowable{
    public ReferenceBook(String bookID , String title , String author){
        this.bookID = bookID;
        this.title = title;
        this.author = author;
    }

    public void checkIn(Scanner s){
        System.out.println("Invalid");
    }
    public void checkOut(Scanner s){
        System.out.println("Cannot be borrowed");
    }
    void displayBook(){
        System.out.println("TextBook: " + this.bookID + ": " + this.title + ": " + this.author);
    }
}

public class Q6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<>();
        System.out.println("1. Add Reference Book\n2. Add Text Book\n3. Check-Out\n4. Check-In\n5. List Books\n6. Exit");
        while (true){
            System.out.print("\nEnter your choice: ");
            int inpChoice = Integer.parseInt(s.nextLine().trim());
            if (inpChoice == 1){
                System.out.println("Enter ID, Title and Author (Line by line)");
                String id = s.nextLine().trim();
                String title = s.nextLine().trim();
                String author = s.nextLine().trim();
                ReferenceBook r = new ReferenceBook(id, title, author);
                list.add(r);
            }            
            if (inpChoice == 2){
                System.out.println("Enter ID, Title and Author (Line by line)");
                String id = s.nextLine().trim();
                String title = s.nextLine().trim();
                String author = s.nextLine().trim();
                TextBook r = new TextBook(id, title, author);
                list.add(r);
            }
            if(inpChoice == 3){
                System.out.print("Enter Book ID: ");
                Book.search(list, s.nextLine().trim()).checkOut(s);
            }
            if(inpChoice == 4){
                System.out.print("Enter Book ID: ");
                Book.search(list, s.nextLine().trim()).checkIn(s);
            }
            if(inpChoice == 5){
                for (Book b : list) {
                    b.displayBook();
                }
            }
            if(inpChoice == 6){
                break;
            }

        }
        s.close();
    }    
}
