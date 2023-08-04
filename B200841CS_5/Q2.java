import java.text.DecimalFormat;
import java.util.*;
// import java.math.*;

public class Q2 {
    public static void area(int r){
        DecimalFormat d = new DecimalFormat("###############0.00");
        double x = 3.14159265358;
        String a = d.format(x*r*r);
        System.out.println(a);
    }
    public static void area(int l , int b){
        DecimalFormat d = new DecimalFormat("###############0.00");
        String a = d.format(l*b);
        System.out.println(a);
    }
    public static void area(int a , int b , int c){
        DecimalFormat d = new DecimalFormat("###############0.00");
        double s = (a+b+c)/2;
        double f = Math.sqrt(s*(s-a)*(s-b)*(s-c));
        String ff = d.format(f);
        System.out.println(ff);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp[] = s.nextLine().trim().split(" ");
        if (inp.length == 1){
            area(Integer.parseInt(inp[0]));
        }
        if (inp.length == 2){
            area(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]));
        }
        if (inp.length == 3){
            area(Integer.parseInt(inp[0]),Integer.parseInt(inp[1]),Integer.parseInt(inp[2]));
        }
        s.close();
    }
}
