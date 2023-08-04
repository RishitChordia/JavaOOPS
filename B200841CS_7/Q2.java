import java.util.Scanner;

interface ICICI{
    int transaction(int cost , int bankBalance);
}

interface HDFC{
    int transaction(int cost , int bankBalance);
}

class Flipkart implements HDFC,ICICI{
    int balance;
    public Flipkart(){
        this.balance = 0;
    }
    public int transaction(int cost , int bankBalance){
        this.balance += cost;
        return bankBalance - cost;
    }

}



public class Q2 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        Flipkart f = new Flipkart();
        for (int i = 0 ; i < n ; i+=1){
            String inp[] = s.nextLine().trim().split(" ");
            int oustandingBalance = f.transaction(Integer.parseInt(inp[2]), Integer.parseInt(inp[1]));
            System.out.println(f.balance + " " + oustandingBalance);
        }
        s.close();

    }
}
