import java.util.*;

class Customer{
    String name;
    String phoneNo;
    public Customer(String name , String phoneNo){
        this.name = name;
        this.phoneNo = phoneNo;
    }
    int discount(int totalAmount){
        return 0;
    }
}

class PremiumCustomer extends Customer{
    public PremiumCustomer(String name , String phoneNo){
        super(name, phoneNo);
    }

    int discount(int totalAmount){
        return totalAmount/5;
    }
}

class GoldCustomer extends Customer{
    public GoldCustomer(String name , String phoneNo){
        super(name, phoneNo);
    }

    int discount(int totalAmount){
        return totalAmount*15/100;
    }
}

class SilverCustomer extends Customer{
    public SilverCustomer(String name , String phoneNo){
        super(name, phoneNo);
    }

    int discount(int totalAmount){
        return totalAmount/10;
    }
}

class Service{
    String name;
    int price;
    public Service(String name , int price){
        this.name = name;
        this.price = price;
    }
}


public class Q6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Customer Details:");
        System.out.print("Name:");
        String name = s.nextLine().trim();
        System.out.print("Mobile:");
        String phoneNo = s.nextLine().trim();
        System.out.print("Membership:");
        String membership = s.nextLine().trim();
        Customer x;
        if (membership.toLowerCase().equals("premium")){
            x = new PremiumCustomer(name, phoneNo);
        }
        else if (membership.toLowerCase().equals("gold")){
            x = new GoldCustomer(name, phoneNo);
        }
        else if (membership.toLowerCase().equals("silver")){
            x = new SilverCustomer(name, phoneNo);
        }
        else {
            x = new Customer(name, phoneNo);
        }
        ArrayList<Service> list = new ArrayList<>();
        int total = 0;
        System.out.print("\nAdd Service(Y/N):");
        char inp = s.nextLine().trim().charAt(0);
        while(inp != 'N'){
            if(inp == 'Y'){
                System.out.print("ServiceName:");
                String serviceName = s.nextLine().trim();
                System.out.print("Rate:");
                int price = Integer.parseInt(s.nextLine().trim());
                Service y = new Service(serviceName, price);
                list.add(y);
                total += price;
            }
            // if someone entered a letter other than Y or N, they enter again without taking input
            System.out.print("\nAdd Service(Y/N):");
            inp = s.nextLine().trim().charAt(0);
        }
        System.out.println("*****BILL*****");
        System.out.println(x.name + "\t" + x.phoneNo + "\t" + membership);
        int i = 1;
        String format = "%-15s %s%n";
        // if >15 characters then print a space bw name and rate
        for(Service z: list){
            String temp = String.valueOf(i) + ". " + z.name;
            String temp2 = String.valueOf(z.price);
            System.out.printf(format, temp, temp2);
            i++;
        }
        System.out.println("Total: " + total + "-" + x.discount(total));
        System.out.println("Please Pay: " + (total - x.discount(total)));
        // System.out.println(total);
        s.close();

    }
}
