import java.util.*;

public class Q3 {
    public static void main(String[] args){
        try{
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int arr[] = new int[n]; 
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        s.nextLine();
        String indices[] = s.nextLine().trim().split(" ");
        int sum = 0;
        for (String index : indices) {
            sum += arr[Integer.parseInt(index)];
        }
        System.out.println(sum);
        s.close();

        } catch(ArrayIndexOutOfBoundsException e){
            Exception r = new ArrayIndexOutOfBoundsException("Enter valid index.");
            System.out.println(r.toString().replaceAll("java.lang.", ""));
        }
    }
    
}
