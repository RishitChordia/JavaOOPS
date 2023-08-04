import java.util.Scanner;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Person{
    String name;
    public Person(String name){
        this.name = name;
    }
}

class Patient extends Person{
    String id;
    public Patient(String id , String name){
        super(name);
        this.id = id;
    }
}

public class Q5{
    public static int compare(Patient o1 , Patient o2){
        int age1 = Integer.parseInt(o1.id.substring(5,8));
        int age2 = Integer.parseInt(o2.id.substring(5,8));
        return (age1-age2)*-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> patients = new ArrayList<>();
        System.out.print("Enter the number of patients: ");
        int n = Integer.parseInt(sc.nextLine().trim());
        int i = 0;
        while(i < n){
            i += 1;
            System.out.print("\nEnter details of patient " + i + ":\nName: ");
            String name = sc.nextLine().trim();
            System.out.print("Patient ID: ");
            String id = sc.nextLine().trim();
            Patient x = new Patient(id,name);
            patients.add(x); 
        }
        sc.close();
        Comparator<Patient> Sorter = (o1, o2) -> compare(o1,o2);
        Collections.sort(patients, Sorter);
        System.out.println("\nList of Patients to be tested are:");
        for(Patient x:patients){
            System.out.println(x.id + " " + x.name);
        }
    }
}