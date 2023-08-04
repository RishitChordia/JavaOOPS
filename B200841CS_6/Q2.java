import java.util.*;

class Bank{
    String bankName;
    public Bank(String bankName){
        this.bankName = bankName;
    }
    public static int getInterest(){
        return 0;
    }
}

class SBI extends Bank{
    int interestRate;
    public SBI(){
        super("SBI");
        this.interestRate = 5;
    }
    int getInterest(SBI y , int x){
        return x*y.interestRate/100;
    }
}
class ICICI extends Bank{
    int interestRate;
    public ICICI(){
        super("ICICI");
        this.interestRate = 6;
    }
    int getInterest(ICICI y , int x){
        return x*y.interestRate/100;
    }
}

class AXIS extends Bank{
    int interestRate;
    public AXIS(){
        super("AXIS");
        this.interestRate = 7;
    }
    int getInterest(AXIS y , int x){
        return x*y.interestRate/100;
    }
}

public class Q2 {
    public static void func(int x){
        SBI bank1 = new SBI();
        ICICI bank2 = new ICICI();
        AXIS bank3 = new AXIS();
        System.out.println(bank1.bankName + " interest is : " + bank1.getInterest(bank1,x));
        System.out.println(bank2.bankName + " interest is : " + bank2.getInterest(bank2,x));
        System.out.println(bank3.bankName + " interest is : " + bank3.getInterest(bank3,x));
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int x = Integer.parseInt(s.nextLine().trim());
        func(x);
        s.close();
    }
}
