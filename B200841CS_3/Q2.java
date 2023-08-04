import java.util.Hashtable;
import java.util.Scanner;

class Inventory{
    int id;
    String name;
    int unitPrice;
    
    public Inventory(int id , String name , int unitPrice){
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }
}

public class Q2 {
    public static void main(String[] args) {
        Hashtable<Integer,Inventory> table = new Hashtable<>();
        System.out.println("Enter the available Inventory items line by line, type OKAY at the end of the list:");
        Scanner sc=new Scanner(System.in);

        while (true){
            String inp = sc.nextLine().trim();
            String inpSplit[] = inp.split(" ");
            if (inpSplit[0].equals("OKAY")){
                break;
            }
            Inventory x = new Inventory(Integer.parseInt(inpSplit[0]), inpSplit[1].trim(), Integer.parseInt(inpSplit[2]));
            table.put(x.id , x);
        }
        int total = 0;
        String out = "****INVOICE****";
        while(true){
            System.out.println("1.Add invoice\n2.Exit\nChoice : ");
            int choice = Integer.parseInt(sc.nextLine().trim());
            if (choice == 2){
                sc.close();
                break;
            }
            System.out.println("Add Invoice Item(Y/N)");
            char addItem = sc.nextLine().charAt(0);
            if(addItem == 'N'){
                continue;
            }
            else if (addItem == 'Y'){
                System.out.println("Enter Inventory ID and Quantity line by line, type OKAY at the end of the list");
                while (true){
                    String inp = sc.nextLine().trim();
                    String inpSplit[] = inp.split(" ");
                    if(inpSplit[0].equals("OKAY")){
                        System.out.println(out);
                        System.out.print("Total:");
                        System.out.println(total);
                        System.out.println("********");
                        total = 0;
                        out = "****INVOICE****";
                        break;
                    }
                    int id = Integer.parseInt(inpSplit[0]);
                    int quantity = Integer.parseInt(inpSplit[1]);
                    Inventory x = table.get(id);
                    out += '\n'+ String.valueOf(id) + ',' + x.name + ',' + String.valueOf(x.unitPrice) + ',' + String.valueOf(quantity);
                    total += x.unitPrice*quantity;
                }
            }
        }
    }
}