import java.util.Scanner;

interface BankInterface{
    int convertRupees(int a);
    int convertDollars(int a);
    int convertPounds(int a);
}

class Bank implements BankInterface{
    public int convertRupees(int a){
        return a;
    }
    public int convertDollars(int a){
        return a*70;
    }
    public int convertPounds(int a){
        return a*100;
    }
}

public class Q1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int balance = Integer.parseInt(s.nextLine().trim());
        String inp[] = s.nextLine().trim().split(" ");
        int a = Integer.parseInt(inp[0]);
        int b = Integer.parseInt(inp[1]);
        int c = Integer.parseInt(inp[2]);
        Bank x = new Bank();
        int oustandingBalance = balance - x.convertRupees(a) - x.convertDollars(b) - x.convertPounds(c);
        if(oustandingBalance > 0){
            System.out.println(oustandingBalance);
        }
        else{
            System.out.println("Insufficient balance");
        }
        s.close();
    }
}
