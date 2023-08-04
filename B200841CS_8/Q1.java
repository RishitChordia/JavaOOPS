import java.util.*;

public class Q1 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int op1=0,op2=0;
        String operator;
        int operation = 0;
        int value = 0;
        try {
            operator = s.nextLine().trim();
            if(operator.equals("+")){
                operation = 1;
            }
            else if(operator.equals("-")){
                operation = 2;
            }
            else if(operator.equals("*")){
                operation = 3;
            }
            else if(operator.equals("/")){
                operation = 4;
            }
            value = 1/operation;
        } catch(Exception e){
            Exception r = new IllegalArgumentException("Enter Valid operator.");
            System.out.println(r.toString().replaceAll("java.lang.", ""));
            System.exit(0);
        }
        try{
            op1 = s.nextInt();
            op2 = s.nextInt();
            if(op1 > 9 || op2 > 9){
                value = 1/0;
            }
        } catch (Exception e) {
            Exception r = new IllegalArgumentException("Enter Valid operands.");
            System.out.println(r.toString().replaceAll("java.lang.", ""));
            System.exit(0);
        }

        try {
            if(operation == 1){
                value = op1+op2;
            }
            else if(operation == 2){
                value = op1-op2;
            }
            else if(operation == 3){
                value = op1*op2;
            }
            else{
                value = op1/op2;
            }
            System.out.println(value);
        } catch (Exception e) {
            Exception r = new ArithmeticException("Division by zero handled. Enter a valid argument.");
            System.out.println(r.toString().replaceAll("java.lang.", ""));
            System.exit(0);
        }
        s.close();
    }
}
