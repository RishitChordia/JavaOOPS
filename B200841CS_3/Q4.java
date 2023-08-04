import java.util.Scanner;
import java.util.ArrayList;


class Employee{
    String id;
    String name;
    String department;
    int salary;

    public Employee(String id , String name , String department, int salary){
        this.department = department;
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}

class Manager extends Employee{
    int bonus;
    public Manager(String id , String name , String department , int salary , int bonus){
        super(id, name, department, salary);
        this.bonus = bonus;
    }
}
public class Q4 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        ArrayList<Manager> managers = new ArrayList<>();
        while(n>0){
            n -= 1;
            String inp = sc.nextLine().trim();
            String inpSplit[] = inp.split(" ");
            String id = inpSplit[0];
            String name = inpSplit[1];
            int bonus = Integer.parseInt(inpSplit[inpSplit.length - 1]);
            int salary = Integer.parseInt(inpSplit[inpSplit.length - 2]);
            String department = "";
            for (int i = 2 ; i < inpSplit.length - 2 ; i++){
                department += inpSplit[i]+' ';
            }
            Manager x = new Manager(id,name,department,salary,bonus);
            managers.add(x);
        }
        sc.close();

        int current_max = -1;
        ArrayList<Manager> maxSalary = new ArrayList<>();
        for(Manager x:managers){
            if (x.salary+x.bonus == current_max){
                maxSalary.add(x);
                continue;
            }
            if (x.salary+x.bonus > current_max){
                maxSalary.clear();
                maxSalary.add(x);
                current_max = x.salary + x.bonus;
                continue;
            }
        }
        for(Manager x: maxSalary){
            System.out.println(x.id + ' ' + x.name + ' ' + x.department + x.salary + ' ' + x.bonus);
        }
    }
}