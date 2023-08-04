import java.util.*;

public class Q1 {
    public static void display(char a , int n){
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < i ; j++){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
    public static void display(int n){
        System.out.println((n*(n+1))/2);
    }
    public static void display(int a , int b){
        System.out.println(a*a+b*b);
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp[] = s.nextLine().trim().split(" ");
        s.close();
        if(inp[0].charAt(0) >= '0' && inp[0].charAt(0) <= '9'){
            if(inp.length == 1){
                display(Integer.parseInt(inp[0]));
            }
            else if (inp.length == 2){
                display(Integer.parseInt(inp[0]) , Integer.parseInt(inp[1]));
            }
        }
        else{
            display(inp[0].charAt(0) , Integer.parseInt(inp[1]));
        }
    }    
}
