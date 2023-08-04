import java.text.DecimalFormat;
import java.util.Scanner;

interface ShapeArea{
    double area(int a);
}

class Circle implements ShapeArea{
    public double area(int radius){
        return 3.14*(double)(radius*radius);
    }
}

class Square implements ShapeArea{
    public double area(int side){
        return side*side;
    }
}

public class Q3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String shape = s.nextLine().trim();
        if(shape.toLowerCase().equals("circle")){
            Circle c = new Circle();
            int radius = Integer.parseInt(s.nextLine().trim());
            DecimalFormat d = new DecimalFormat("################.##");
            System.out.println(d.format(c.area(radius)));
        }
        if(shape.toLowerCase().equals("square")){
            Square c = new Square();
            int side = Integer.parseInt(s.nextLine().trim());
            DecimalFormat d = new DecimalFormat("################.##");
            System.out.println(d.format(c.area(side)));
        }
        s.close();
    }
}
