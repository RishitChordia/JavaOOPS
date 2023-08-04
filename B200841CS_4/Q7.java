import java.util.*;

class Angle{
    int degrees;
    int minutes;

    public Angle(int degrees , int minutes){
        this.degrees = degrees;
        this.minutes = minutes;
    }

    public static Angle angleSum(Angle angle1 , Angle angle2){
        Angle x = new Angle(angle1.degrees + angle2.degrees + (angle1.minutes + angle2.minutes)/60 , (angle1.minutes + angle2.minutes)%60);
        return x;
    }
}

public class Q7 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String inp1[] = sc.nextLine().trim().split(" ");
        Angle angle1 = new Angle(Integer.parseInt(inp1[0]) , Integer.parseInt(inp1[1]));
        String inp2[] = sc.nextLine().trim().split(" ");
        Angle angle2 = new Angle(Integer.parseInt(inp2[0]) , Integer.parseInt(inp2[1]));
        sc.close();

        Angle result = Angle.angleSum(angle1, angle2);
        System.out.println(String.valueOf(result.degrees) + ' ' + String.valueOf(result.minutes));
    }
}
