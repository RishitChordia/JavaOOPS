import java.util.*;

public class Q7 {
    public static Hashtable<String,Integer> createConversionTable(){
        Hashtable<String,Integer> table = new Hashtable<>();
        for (int i = 0; i < 10; i++) {
            table.put(String.valueOf(i) , i);
        }
        for(int i = 0 ; i < 6 ; i++){
            String temp = "";
            temp += (char)('A'+i);
            table.put(temp,10+i);
        }
        return table;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Hashtable<String,Integer> conversionTable = createConversionTable();
        String inp = s.nextLine();
        s.close();
        try {
            int decimal = 0;
            int power = 1;
            String inpSplit[] = inp.split("");
            for (int i = inpSplit.length -1 ; i > -1; i--) {
                decimal += power*conversionTable.get(inpSplit[i]);
                power *= 16;
            }
            System.out.println(decimal);
        } catch (Exception e) {
            System.out.println("InvalidHexadecimal");
        }
    }
    
}
