package Q6A;

public class StudentData{
    private String id;
    private String name;
    public StudentData (String id, String name){
        this.id = id;
        this.name = name;
    }
    public String studentID(){
        return this.id;
    }
    public String studentName(){
        return this.name;
    }
}
