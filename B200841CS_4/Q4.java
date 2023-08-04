import java.util.*;

class TelephoneCall{
    String phNo;
    String custName;
    int callSlots;
    int totalBill;
    
    public TelephoneCall(){}

    public static void readCustomer(TelephoneCall x){
        Scanner sc = new Scanner(System.in);
        x.custName = sc.nextLine().trim();
        x.phNo = sc.nextLine().trim();
        x.callSlots = Integer.parseInt(sc.nextLine().trim());
        sc.close();
    }

    public static void computeBill(TelephoneCall x){
        if (x.callSlots <= 100){
            x.totalBill = 800;
            System.out.println(String.valueOf(x.totalBill));
        }
        else if(x.callSlots <= 200){
            x.totalBill = 300 + x.callSlots*8;
            System.out.println(String.valueOf(x.totalBill));
        }        
        else if(x.callSlots <= 300){
            x.totalBill = 300 + x.callSlots*10;
            System.out.println(String.valueOf(x.totalBill));
        }       
        else{
            x.totalBill = 300 + x.callSlots*15;
            System.out.println(String.valueOf(x.totalBill));
        }

    }
}

public class Q4 {
    public static void main(String[] args){
        TelephoneCall x = new TelephoneCall();
        TelephoneCall.readCustomer(x);
        TelephoneCall.computeBill(x);
    }
}
