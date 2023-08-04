
package Q6B;

import Q6A.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class StudentDataExtended extends StudentData{
    private String location;
    public StudentDataExtended(String id , String name , String location){
        super(id,name);
        this.location = location;
    }

    public static void addDetails(ArrayList<StudentDataExtended> list , StudentDataExtended x){
        list.add(x);
    }


    public static void printDetails(ArrayList<StudentDataExtended> list){
        Comparator<StudentDataExtended> Sorter = (o1 , o2) -> o1.studentID().compareTo(o2.studentID());
        Collections.sort(list , Sorter);
        System.out.println("The Student Details are:");
        if (list.size() == 0){
            System.out.println("");
            return;
        }
        for(StudentDataExtended x : list){
            System.out.println(x.studentID() + ' ' + x.studentName() + ' ' + x.location);
        }
    }
    

}