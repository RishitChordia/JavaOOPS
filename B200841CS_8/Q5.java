import java.util.*;

public class Q5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int i = s.nextInt() , j = s.nextInt();
        int n = s.nextInt();
        s.nextLine();
        for (int k = 0; k < n; k++) {
            String inp = s.next().trim();
            if(inp.toLowerCase().equals("up")){
                i -= s.nextInt();
            }
            else if(inp.toLowerCase().equals("down")){
                i += s.nextInt();
            }
            else if(inp.toLowerCase().equals("left")){
                j -= s.nextInt();
            }
            else if(inp.toLowerCase().equals("right")){
                j += s.nextInt();
            }
            s.nextLine();
        }
        if(i>0 && i<9 && j>0 && j<9){
            System.out.println("[" + i + "," + j + "]");
        }
        else{
            System.out.println("Overflow");
        }
        s.close();
    }
}
