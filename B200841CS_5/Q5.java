import java.text.DecimalFormat;
import java.util.*;


class Car{
    String modelName;
    String engineNo;
    int basePrice;
    int additionalCharge;
    public Car(String modelName, String engineNo, int basePrice, int additionalCharge){
        this.modelName = modelName;
        this.engineNo = engineNo;
        this.basePrice = basePrice;
        this.additionalCharge = additionalCharge;
    }
    // public Car(Scanner s , ArrayList<Car> list){
    //     String inp[] = s.nextLine().trim().split(" ");
    //     this.modelName = inp[0];
    //     this.engineNo = inp[1];
    //     this.basePrice = Integer.parseInt(inp[2]);
    //     this.additionalCharge = Integer.parseInt(inp[3]);
    // }
    public static int totalPrice(Car x){
        return x.basePrice + x.additionalCharge;
    }
}

class Dealer{
    String dealerName;
    float discountPercentage;
    Car car;
    public Dealer(Scanner s , ArrayList<Dealer> list){
        String inp[] = s.nextLine().trim().split(" ");
        this.car = new Car(inp[0] , inp[1] , Integer.parseInt(inp[2]) , Integer.parseInt(inp[3]));
        this.dealerName = inp[4];
        this.discountPercentage = Float.parseFloat(inp[5]);
        list.add(this);
    }
    public static float onRoadPrice(Dealer x){
        float a = Car.totalPrice(x.car)*(100-x.discountPercentage)/100;
        return a;
    }
    
}

public class Q5 {
    public static void main(String[] args){
        ArrayList<Dealer> list = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine().trim());
        for(int i = 0 ; i < n ; i++){
            new Dealer(s, list);
        }
        DecimalFormat d = new DecimalFormat("###############0");
        for(Dealer x : list){
            System.out.println(x.car.modelName + ' ' + Car.totalPrice(x.car) + ' ' + d.format(Dealer.onRoadPrice(x)));
        }

    }   
    
}
