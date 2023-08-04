import java.util.*;

class Person{
    String personName;
    int age;
    public Person(String personName , int age){
        this.personName = personName;
        this.age = age;
    }
}

class Student extends Person{
    String rollNumber;
    int percentageOfMarks;
    public Student(String personName , int age , String rollNumber , int percentageOfMarks){
        super(personName, age);
        this.rollNumber = rollNumber;
        this.percentageOfMarks = percentageOfMarks;
    }
    public Student(String personName , int age , int percentageOfMarks){
        super(personName, age);
        this.rollNumber = "";
        this.percentageOfMarks = percentageOfMarks;
    }
}

class PGStudent extends Student{
    String elective;
    int numberOfSubjects;
    public PGStudent(String personName , int age , String rollNumber , int percentageOfMarks , String elective , int numberOfSubjects){
        super(personName, age, rollNumber, percentageOfMarks);
        this.elective = elective;
        this.numberOfSubjects = numberOfSubjects;
    } 
    public PGStudent(String personName , int age , int percentageOfMarks , String elective ){
        super(personName, age, percentageOfMarks);
        this.elective = elective;
        this.numberOfSubjects = 0;
    }
    public static void readPGStudent(Scanner s, ArrayList<PGStudent> list){
        String inp[] = s.nextLine().trim().split(":");
        PGStudent x = new PGStudent(inp[0], Integer.parseInt(inp[1].trim()), Integer.parseInt(inp[3].trim()), inp[2]);
        list.add(x);
    }
}



public class Q7 {
    public static void main(String[] args){
        ArrayList<PGStudent> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        for(int i = 0 ; i < n ; i++){
            PGStudent.readPGStudent(s, list);
        }
        s.close();
        Comparator<PGStudent> Sorter = (o1,o2) -> o2.percentageOfMarks-o1.percentageOfMarks;
        Collections.sort(list , Sorter);
        for (PGStudent x : list) {
            System.out.println(x.personName);
        }
    }
}
