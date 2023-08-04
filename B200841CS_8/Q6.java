import java.util.*;

class Node{
    int value;
    Node next;
    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

class LinkedList{
    Node head;
    Node tail;
    public LinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void insert(int value){
        Node x = new Node(value);
        if(this.head == null){
            this.head = x;
            this.tail = x;
            return;
        }
        else{
            this.tail.next = x;
        }
    }
}




class Queue{
    LinkedList list;
    public Queue(){
        this.list = new LinkedList();
    }
    public void enqueue(int value){
        Node x = new Node(value);
        if(this.list.head == null){
            this.list.head = x;
            this.list.tail = this.list.head;
        }
        else{
            this.list.tail.next = x;
            this.list.tail = this.list.tail.next;
        }
        System.out.println("Success");
    }
    public void dequeue(){
        try{
            System.out.println(this.list.head.value);
            this.list.head = this.list.head.next;

        } catch(Exception e){
            System.out.println("EmptyQueue");
            System.exit(0);
        }
    }
    public void display(){
        Node x = this.list.head;
        while(x != null){
            System.out.println(x.value);
            x = x.next;
        }
    }
}

public class Q6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Queue q = new Queue();
        String inp;
        while((inp = s.next()) != null){
            if(inp.equals("E")){
                q.enqueue(s.nextInt());
                s.nextLine();
                continue;
            }
            if (inp.equals("D")) {
                q.dequeue();
                s.nextLine();
                continue;
            }
            // if (inp.equals("Q")) {
            //     q.display();
            //     s.nextLine();
            //     continue;
            // }
        }
        s.close();
    }
}
