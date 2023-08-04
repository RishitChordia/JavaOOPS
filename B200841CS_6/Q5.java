import java.util.*;

abstract class Student{
    String name;
    String rollNumber;
    String course;
    int fee;
    abstract void setFeeDetails(int fee);
    abstract int getFeeDetails();
}

class UG extends Student{
    public UG(String name , String rollNumber , String course){
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }
    void setFeeDetails(int fee) {
        this.fee = fee;
    }
    int getFeeDetails(){
        return this.fee;
    }
}

class PG extends Student{
    public PG(String name , String rollNumber , String course){
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }
    void setFeeDetails(int fee) {
        this.fee = fee;
    }
    int getFeeDetails(){
        return this.fee;
    }
}



public class Q5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Hashtable<String,Student> table = new Hashtable<>();
        String fee[] = s.nextLine().trim().split(" ");
        int UGFee = Integer.parseInt(fee[0]);
        int PGFee = Integer.parseInt(fee[1]);
        int n = Integer.parseInt(s.nextLine().trim());
        for(int i = 0 ; i < n ; i++){
            String inp[] = s.nextLine().trim().split(" ");
            if(inp[2].equals("UG")){
                UG x = new UG(inp[0], inp[1], inp[2]);
                x.setFeeDetails(UGFee);
                table.put(inp[1],x);
            }
            if(inp[2].equals("PG")){
                PG x = new PG(inp[0], inp[1], inp[2]);
                x.setFeeDetails(PGFee);
                table.put(inp[1],x);
            }
        }
        System.out.println(table.get(s.nextLine().trim()).getFeeDetails());
        s.close();
    }
}
