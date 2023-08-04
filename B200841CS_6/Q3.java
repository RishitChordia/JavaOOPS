import java.util.*;

class Rectangle{
    int length;
    int breadth;
    public Rectangle(int length , int breadth){
        this.breadth = breadth;
        this.length = length;
    }
    int Area(){
        return this.breadth*this.length;
    }
    int Perimeter(){
        return this.length*2 + this.breadth*2;
    }
}

class Square extends Rectangle{
    public Square(int side){
        super(side,side);
    }
}

public class Q3 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        String inp[] = s.nextLine().trim().split(" ");
        s.close();
        if(inp.length == 1){
            Square x = new Square(Integer.parseInt(inp[0]));
            System.out.println("Square Perimeter " + x.Perimeter() + "\nSquare Area " + x.Area());
        }
        if(inp.length == 2){
            Rectangle x = new Rectangle(Integer.parseInt(inp[0]) , Integer.parseInt(inp[1]));
            System.out.println("Rectangle Perimeter " + x.Perimeter() + "\nRectangle Area " + x.Area());
        }
    }
}
