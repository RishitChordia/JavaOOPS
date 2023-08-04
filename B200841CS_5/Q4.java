import java.text.DecimalFormat;
import java.util.*;

class Customer{
    String customerName;
    String accountNo;
    long currBalance;
    public Customer(String customerName , String accountNo , long currBalance){
        this.customerName = customerName;
        this.accountNo = accountNo;
        this.currBalance = currBalance;
    }
    public static void readCustomer(Scanner s , ArrayList<Customer> list){
        String inp[] = s.nextLine().trim().split(":");
        Customer x = new Customer(inp[0], inp[1], Long.parseLong(inp[2]));
        list.add(x);
    }
    public void availableBalance(Customer x){
        System.out.println(x.customerName + ':' + x.currBalance);
    }
}

class SilverCustomer extends Customer{
    double interestRate;
    public SilverCustomer(Customer x){
        super(x.customerName, x.accountNo, x.currBalance);
        this.interestRate = 1.05;
    }
    public void availableBalance(SilverCustomer x){
        double futureBalance = x.currBalance*x.interestRate;
        DecimalFormat d = new DecimalFormat("################");
        String a = d.format(futureBalance);
        System.out.println(x.customerName + ':' + x.currBalance + ":Silver:" + a);
    }
}
class GoldCustomer extends Customer{
    double interestRate;
    public GoldCustomer(Customer x){
        super(x.customerName, x.accountNo, x.currBalance);
        this.interestRate = 1.10;
    }
    public void availableBalance(GoldCustomer x){
        double futureBalance = x.currBalance*x.interestRate;
        DecimalFormat d = new DecimalFormat("################");
        String a = d.format(futureBalance);
        System.out.println(x.customerName + ':' + x.currBalance + ":Gold:" + a);
    }
}
class PlatinumCustomer extends Customer{
    double interestRate;
    public PlatinumCustomer(Customer x){
        super(x.customerName, x.accountNo, x.currBalance);
        this.interestRate = 1.15;
    }
    public void availableBalance(PlatinumCustomer x){
        double futureBalance = x.currBalance*x.interestRate;
        DecimalFormat d = new DecimalFormat("################");
        String a = d.format(futureBalance);
        System.out.println(x.customerName + ':' + x.currBalance + ":Platinum:" + a);
    }
}

public class Q4 {
    public static void displayAll(ArrayList<Customer> list){
        for (Customer x : list) {
            if (x.currBalance <= 100000){
                SilverCustomer temp = new SilverCustomer(x);
                temp.availableBalance(temp);
            }
            else if (x.currBalance <= 1000000){
                GoldCustomer temp = new GoldCustomer(x);
                temp.availableBalance(temp);
            }
            else{
                PlatinumCustomer temp = new PlatinumCustomer(x);
                temp.availableBalance(temp);
            }
        }
    }
    public static void main(String[] args){
        ArrayList<Customer> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        for(int i = 0 ; i < n ; i++){
            Customer.readCustomer(s,list);
        }
        displayAll(list);
    }
}
