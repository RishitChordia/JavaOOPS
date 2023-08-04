import java.util.Scanner;
import java.util.ArrayList;

import Q6B.*;

public class Q6 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of students : ");
        ArrayList<StudentDataExtended> list = new ArrayList<>();
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 1 ; i <= n ; i++){
            System.out.println("Enter the details of Student " + i + " (id, name, location):");
            String inp = sc.nextLine().trim();
            String inpSplit[] = inp.split(" ");
            StudentDataExtended x = new StudentDataExtended(inpSplit[0], inpSplit[1], inpSplit[2]);
            StudentDataExtended.addDetails(list, x);
        }
        sc.close();
        System.out.println("");
        StudentDataExtended.printDetails(list);
    }
}
