import java.util.*;


public class Q4 {
    public static char getByteValue(String key , String byteVal){
        int ascii = 0 , power = 1;
        for (int i = 7; i > -1; i--) {
            if(byteVal.charAt(i) != key.charAt(i)){
                ascii += power;
            }
            power *= 2;
        }
        return (char)ascii;
        
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp = s.nextLine().trim();
        ArrayList<String> bytes = new ArrayList<>();
        String firstByte = "";
        try{
            firstByte = inp.substring(0,8);
            int i = 8,j=16;
            while(!(i == inp.length())){
                bytes.add(inp.substring(i,j));
                i+= 8;
                j += 8;
            }
            
        } catch(Exception e){
            System.out.println("Incorrect Input");
            System.exit(0);
        }
        for (String string : bytes) {
            System.out.print(getByteValue(firstByte , string));
        }
        System.out.println();
        s.close();
    }
}
