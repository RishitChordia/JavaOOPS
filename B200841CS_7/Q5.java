import java.util.*;

interface OrderStudents{
    void orderByRollno(ArrayList<Student> list);
    void orderByName(ArrayList<Student> list);
}

class Student implements OrderStudents{
    String name;
    int rollno;
    String address;
    public Student(int rollno , String name , String address){
        this.name = name;
        this.rollno = rollno;
        this.address = address;
    }
    public Student(){
    }
    public void orderByName(ArrayList<Student> list){
        Comparator<Student> Sorter = (o1,o2) -> o1.name.compareTo(o2.name);
        Collections.sort(list,Sorter);
        for (Student s : list) {
            System.out.println(s.rollno + " " + s.name + " " + s.address);
        }
    }
    public void orderByRollno(ArrayList<Student> list){
        Comparator<Student> Sorter = (o1,o2) -> o1.rollno - o2.rollno;
        Collections.sort(list,Sorter);

        for (Student s : list) {
            System.out.println(s.rollno + " " + s.name + " " + s.address);
        }
    }
}

public class Q5 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            String inp[] = s.nextLine().trim().split(" ");
            Student x = new Student(Integer.parseInt(inp[0]) , inp[1] , inp[2]);
            list.add(x);
        }
        Student x = new Student();
        x.orderByRollno(list);
        x.orderByName(list);
        s.close();
    }
}