import java.util.*;


public class Q2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine().trim();
        sc.close();
        String inpSplit[] = inp.split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        Hashtable<Integer,Integer> hash = new Hashtable<>();
        for(String x:inpSplit){
            int y = Integer.parseInt(x);
            arr.add(y);
            hash.put(y,1);
        }
        int n = arr.size();
        int count = 0;
        Collections.sort(arr);
        for(int i = 0 ; i < n ; i++){
            for(int j = i+1 ; j < n ; j++){
                if (hash.get(arr.get(i) + arr.get(j)) == null){
                    continue;
                }
                count += 1;
                // System.out.println(String.valueOf(i) + "   " + String.valueOf(j));
            }
        }
        System.out.println(count);
    }
}
