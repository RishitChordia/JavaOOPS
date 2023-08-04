import java.util.*;

class Employee{
    String employeeId;
    String employeeName;
    int salary;
    int type;

    public Employee(String employeeId , String employeeName , int salary , int type){
        this.employeeId = employeeId;
        this.salary = salary;
        this.employeeName = employeeName;
        this.type = type;
    }
    public static int calculateSalary(Employee x){
        return x.salary;
    }
}

class PermanentEmployee extends Employee{
    int basicPay;
    int PFAmount;
    public PermanentEmployee(String employeeId, String employeeName, int salary, int type , int basicPay){
        super(employeeId, employeeName, salary, type);
        this.basicPay = basicPay;
        this.PFAmount = (basicPay*12)/100;
    }
    public static int calculateSalary(PermanentEmployee x){
        return x.basicPay - x.PFAmount;
    }
}

class TemporaryEmployee extends Employee{
    int hoursWorked;
    int hourlyWages;
    public TemporaryEmployee(String employeeId, String employeeName, int salary, int type , int hoursWorked , int hourlyWages){
        super(employeeId, employeeName, salary, type);
        this.hoursWorked = hoursWorked;
        this.hourlyWages = hourlyWages;
    }
    public static int calculateSalary(TemporaryEmployee x){
        return x.hoursWorked*x.hourlyWages;
    }
}

public class Q6 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Hashtable<String,Employee> table = new Hashtable<>();
        Hashtable<String,PermanentEmployee> ptable = new Hashtable<>();
        Hashtable<String,TemporaryEmployee> ttable = new Hashtable<>();
        int n = Integer.parseInt(s.nextLine().trim());
        for(int i = 0 ; i < n ; i++){
            String inp[] = s.nextLine().trim().split(" ");
            int type = Integer.parseInt(inp[0]);
            String employeeId = inp[1];
            String employeeName = inp[2];
            Employee emp = new Employee(employeeId, employeeName, 0, type);
            table.put(employeeId,emp);
            if (type == 1){
                int basicPay = Integer.parseInt(inp[3]);
                PermanentEmployee x = new PermanentEmployee(employeeId, employeeName, 0, type, basicPay);
                ptable.put(employeeId,x);
            }
            if (type == 2){
                int hoursWorked = Integer.parseInt(inp[3]);
                int hourlyWages = Integer.parseInt(inp[4]);
                TemporaryEmployee x = new TemporaryEmployee(employeeId, employeeName, 0, type, hoursWorked , hourlyWages);
                ttable.put(employeeId,x);
            }
        }
        String searchId = s.nextLine().trim();
        s.close();
        if (table.get(searchId) == null){
            System.out.println("-1");
        }
        else{
            if(table.get(searchId).type == 1){
                System.out.println(ptable.get(searchId).employeeId + ' ' + ptable.get(searchId).employeeName + ' ' + PermanentEmployee.calculateSalary(ptable.get(searchId)));
            }
            else if(table.get(searchId).type == 2){
                System.out.println(ttable.get(searchId).employeeId + ' ' + ttable.get(searchId).employeeName + ' ' + TemporaryEmployee.calculateSalary(ttable.get(searchId)));
            }
            else{
                System.out.println("-1");
            }
        }
    }
    
}
