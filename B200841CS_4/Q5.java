import java.util.*;

class Person{
    String name;
    int age;

    public Person(){
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine().trim();
        this.age = Integer.parseInt(sc.nextLine().trim());
        sc.close();
    }

    public static void calculatePension(Person x){
        int pension = 0;
        if (x.age > 65){
            pension += 500;
        }
        if (x.age > 75){
            pension += 100;
        }
        System.out.println(String.valueOf(pension));
    }

}


public class Q5 {
    public static void main(String[] args){
        Person x = new Person();
        Person.calculatePension(x);


    }
    
}
