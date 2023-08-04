import java.text.DecimalFormat;
import java.util.*;

class Point{
    double abcissa;
    double ordinate;
    public Point(double abcissa , double ordinate){
        this.ordinate = ordinate;
        this.abcissa = abcissa;
    }
    public static Point midPoint(Point point1 , Point point2){
        Point x = new Point((point1.abcissa*0.5 + point2.abcissa*0.5) , (point1.ordinate*0.5 + point2.ordinate*0.5));
        return x;
    }
}



public class Q6 {
    public static boolean intCheck(String inp){
        for (int i = 0 ; i < inp.length() ; i++) {
            if (inp.charAt(i) > '9' || inp.charAt(i) < '0'){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp[] = s.nextLine().trim().split(",");
        Point a,b;
        if (inp.length == 2 && intCheck(inp[0]) && intCheck(inp[1])){
            a = new Point(Double.parseDouble(inp[0]), Double.parseDouble(inp[1]));
        }
        else{
            System.out.println("INVALID INPUT");
            s.close();
            return;
        }
        
        inp = s.nextLine().trim().split(",");
        s.close();
        if (inp.length == 2 && intCheck(inp[0]) && intCheck(inp[1])){
            b = new Point(Double.parseDouble(inp[0]), Double.parseDouble(inp[1]));
        }
        else{
            System.out.println("INVALID INPUT");
            return;
        }

        Point c = Point.midPoint(a, b);
        String format = "#####################.00";
        DecimalFormat df = new DecimalFormat(format);
        System.out.println(df.format(c.abcissa) + ',' + df.format(c.ordinate));
    }
}
