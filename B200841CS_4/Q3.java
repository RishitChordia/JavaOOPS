import java.util.*;

class IntegerArray{
    int data[];
    public IntegerArray(){
        this.data = new int[5];
    }
    public static boolean inputData(IntegerArray list){
        Scanner sc = new Scanner(System.in);
        String inp[] = sc.nextLine().trim().split(" ");
        sc.close();
        for(int i = 0; i < 5 ; i++){
            int y = Integer.parseInt(inp[i]);
            list.data[i] = y;
            for(int j = 0 ; j < i ; j++){
                if (list.data[j] == y){
                    return false;
                }
            }
        }
        return true;
    }
    public static void bubSort(IntegerArray list){
        if (inputData(list)){
            for(int i = 0 ; i < 5 ; i++){
                for(int j = i+1 ; j < 5 ; j++){
                    if (list.data[j] < list.data[i]){
                        int temp = list.data[j];
                        list.data[j] = list.data[i];
                        list.data[i] = temp;
                    }
                }
            }
            for(int i = 0 ; i < 5 ; i++){
                System.out.print(String.valueOf(list.data[i]) + ' ');
            }
        }
        else{
            System.out.println("INVALID INPUT");
        }
    }
}

public class Q3 {
    public static void main(String[] args){
        IntegerArray list = new IntegerArray();
        IntegerArray.bubSort(list);
        
    }
}
