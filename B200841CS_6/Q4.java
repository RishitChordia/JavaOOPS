import java.util.*;

abstract class Addition{
    abstract int add();
}

class IntegerAddition extends Addition{
    int a;
    int b;
    public IntegerAddition(int a , int b){
        this.a = a;
        this.b = b;
    }
    int add(){
        System.out.println((this.a+this.b));
        return this.a+this.b;
    }
}

class FractionAddition extends Addition{
    int an;
    int bn;
    int ad;
    int bd;
    public FractionAddition(int an , int ad , int bn , int bd){
        this.an = an;
        this.bn = bn;
        this.ad = ad;
        this.bd = bd;
    }
    public static int gcd(int a , int b){
        if(a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        if(b == 0){
            return a;
        }
        return gcd(b, a%b);
    }
    int add(){
        int gcd = gcd((this.an*this.bd + this.bn*this.ad), (this.ad*this.bd));
        System.out.println( (this.an*this.bd + this.bn*this.ad)/gcd + " / " + (this.ad*this.bd)/gcd);
        return (this.an*this.bd + this.bn*this.ad)/(this.ad*this.bd);
    }
}


public class Q4 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp1[] = s.nextLine().trim().split(" ");
        IntegerAddition x1 = new IntegerAddition(Integer.parseInt(inp1[0]), Integer.parseInt(inp1[1]));
        x1.add();
        String inp2[] = s.nextLine().trim().split(" ");
        FractionAddition x2 = new FractionAddition(Integer.parseInt(inp2[0]), Integer.parseInt(inp2[1]), Integer.parseInt(inp2[2]), Integer.parseInt(inp2[3]));
        x2.add();
        s.close();
    }
}
