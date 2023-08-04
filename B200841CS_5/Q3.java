import java.util.*;

class Student{
    String name;
    String rollNo;
    int height;
    public Student(Scanner s , ArrayList<Student> list){
        String inp[] = s.nextLine().trim().split(",");
        this.name = inp[0].substring(1,inp[0].length());
        this.rollNo = inp[1];
        this.height = Integer.parseInt(inp[2].substring(0,inp[2].length()-1));
        list.add(this);
    }
}


public class Q3 {
    public static void selectStudents(ArrayList<Student> list){
        if(list.size() == 0){
            System.out.println("0");
            return;
        }
        int prevHeight = 0 , count = 0 , currHeight = 2000000000;
        boolean flag = true;
        Student currMin = list.get(0);
        ArrayList<Student> printList = new ArrayList<>();
        while(flag){
            flag = false;
            currHeight = 2000000000;
            for(Student x : list){
                if (x.height > prevHeight){
                    flag = true;
                    if (x.height < currHeight){
                        currHeight = x.height;
                        currMin = x;
                        continue;
                    }
                    if (x.height == currHeight){
                        if (x.name.compareTo(currMin.name) < 0){
                            currMin = x;
                            continue;
                        }
                    }
                }
            }
            if (flag){
                printList.add(currMin);
                prevHeight = currHeight;
                count++;
            }
        }
        System.out.println(count);
        System.out.print(printList.get(0).name);
        for(Student x : printList.subList(1, printList.size())){
            System.out.print(',' + x.name);
        }
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        ArrayList<Student> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            new Student(s,list);
        }
        s.close();
        selectStudents(list);
    }
}
