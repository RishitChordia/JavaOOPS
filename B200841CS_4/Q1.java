import java.util.Scanner;

public class Q1{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine().trim();
        int n = inp.length();
        sc.close();
        // ArrayList<Integer> arr = new ArrayList<>();
        int arr[] = new int[26];

        for(int i = 0 ; i < n ; i++){
            arr[inp.charAt(i) - 'a'] += 1;
        }
        arr['a' - 'a'] = 0;
        arr['e' - 'a'] = 0;
        arr['i' - 'a'] = 0;
        arr['o' - 'a'] = 0;
        arr['u' - 'a'] = 0;

        String out = "";
        for(int i = 0 ; i < 26 ; i++){
            if (arr[i] > 0){
                out += (char)(i + 'a');
            }
        }
        System.out.println(out);
    }
}