
import java.util.Scanner;

class Node{
    char value;
    Node next;

    public Node(char x){
        this.value = x;
        // this.next = null;
    }
}

class LinkedList{
    Node head;

    public LinkedList(){
        this.head = null;
    }
    public static void insert(char x , LinkedList list){
        if (list.head == null){
            list.head = new Node(x);
            return;
        }
        else{
            Node temp = list.head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = new Node(x);
        }
    }
    public static Node reverseList(Node head){
        if (head == null){
            return head;
        }
        if (head.next == null){
            return head;
        }
        Node temp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

    public static void printList(Node head){
        if (head == null){
            return;
        }
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println(temp.value);
    }

}

public class Q1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("Enter the number of nodes: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 1 ; i <= n ; i++){
            System.out.print("Enter the data in Node" + i + " : ");
            char x = sc.nextLine().trim().charAt(0);
            LinkedList.insert(x , list);
        }
        sc.close();
        list.head = LinkedList.reverseList(list.head);
        System.out.println("The reversed list is:");
        LinkedList.printList(list.head);
    }
}