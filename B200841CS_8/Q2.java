import java.util.*;
import java.io.*;

public class Q2 {
    public static void printString(String st){
        String stSplit[] = st.split("");
        boolean flag = true;
        for (String x : stSplit) {
            if(x.charAt(0) < '0' || x.charAt(0) > '9'){
                flag = false;
                break;
            }
        }
        if(flag){
            System.out.println(st);
        }
        else{
            System.out.println("OtherCharactersFound");
        }
    }
    public static void main(String[] args){
        try{
        Scanner s = new Scanner(System.in);

        String path = "./" + s.nextLine().trim();
        s.close();
        BufferedReader br = new BufferedReader(new FileReader(path));
        String st;
        while ((st = br.readLine()) != null){
            printString(st);
        }
        br.close();

    } catch (Exception e){
        System.out.println(e.toString());
    }


}
}
