import java.util.*;

class Student{
    String studentName;
    int rollNo;
    int englishScore;
    int hindiScore;
    int mathsScore;
    int scienceScore;
    int ssScore;

    public Student(String studentName , int rollNo,int englishScore,int hindiScore,int mathsScore,int scienceScore,int ssScore){
        this.studentName = studentName;
        this.rollNo = rollNo;
        this.englishScore = englishScore;
        this.hindiScore = hindiScore;
        this.mathsScore = mathsScore;
        this.scienceScore = scienceScore;
        this.ssScore = ssScore;
    }

    public static void addStudent(ArrayList<Student> list , Scanner s){
        String inp[] = s.nextLine().trim().split(" ");
        Student x = new Student(inp[0] , Integer.parseInt(inp[1]) ,Integer.parseInt(inp[2]) ,Integer.parseInt(inp[3]) ,Integer.parseInt(inp[4]) ,Integer.parseInt(inp[5]) ,Integer.parseInt(inp[6]));
        list.add(x);
    }

    public static void subjectTopper(ArrayList<Student> list , Scanner s){
        int subjectCode = Integer.parseInt(s.nextLine().trim());
        int maxScore = 0;
        ArrayList<Student> toppers = new ArrayList<>();
        for (Student x : list) {
            if (getScore(x, subjectCode) == maxScore){
                toppers.add(x);
                continue;
            }
            if (getScore(x, subjectCode) > maxScore){
                maxScore = getScore(x, subjectCode);
                toppers.clear();
                toppers.add(x);
                continue;
            }
        }
        for(Student x:toppers){
            System.out.println(x.studentName + ' ' + String.valueOf(x.rollNo));
        }
    }

    public static void classTopper(ArrayList<Student> list){
        int maxScore = 0;
        ArrayList<Student> toppers = new ArrayList<>();
        for (Student x : list) {
            if (getScore(x, 0) == maxScore){
                toppers.add(x);
                continue;
            }
            if (getScore(x, 0) > maxScore){
                maxScore = getScore(x, 0);
                toppers.clear();
                toppers.add(x);
                continue;
            }
        }
        for(Student x:toppers){
            System.out.println(x.studentName + ' ' + String.valueOf(x.rollNo));
        }
    }


    public static int getScore(Student a , int subjectCode){
        if (subjectCode == 101){
            return a.englishScore;
        }
        if (subjectCode == 102){
            return a.hindiScore;
        }
        if (subjectCode == 103){
            return a.mathsScore;
        }
        if (subjectCode == 104){
            return a.scienceScore;
        }
        if (subjectCode == 105){
            return a.ssScore;
        }
        else {
            return a.englishScore+a.hindiScore+a.mathsScore+a.scienceScore+a.ssScore;
        }
    }
}

public class Q8 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        String inp = s.nextLine().trim();
        while(!inp.equals("t")){
            if (inp.equals("a")){
                Student.addStudent(list , s);
            }
            if (inp.equals("s")){
                Student.subjectTopper(list, s);
            }
            if (inp.equals("c")){
                Student.classTopper(list);
            }
            inp = s.nextLine().trim();
        }
        s.close();
    }
}
