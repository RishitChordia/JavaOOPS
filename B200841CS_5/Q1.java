import java.util.*;

public class Q1 {
    public static int bitwiseAnd(int a , int b){
        return a&b;
    }
    public static int bitwiseAnd(int a , int b , int c){
        return a&b&c;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp[] = s.nextLine().trim().split(" ");
        if (inp.length == 3){
            System.out.println(bitwiseAnd(Integer.parseInt(inp[0]) , Integer.parseInt(inp[1]) , Integer.parseInt(inp[2])));
        }
        if (inp.length == 2){
            System.out.println(bitwiseAnd(Integer.parseInt(inp[0]) , Integer.parseInt(inp[1])));
        }
        s.close();
    }
}
