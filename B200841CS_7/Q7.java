import java.text.DecimalFormat;
import java.util.*;

interface TaxCalculatable{
    double calculateTax();
}

class Vehicle implements TaxCalculatable{
    String modelNumer;
    long rateBought;
    String fuelType;
    int numberOfWheels;

    void displayVehicle(){
        DecimalFormat d = new DecimalFormat("###############.##");
        System.out.println(this.modelNumer + " " + this.fuelType + " " + d.format(this.calculateTax()));
    }
    public double calculateTax(){
        return 0;
    }
}

class Car extends Vehicle{
    int numberOfPassengers;
    public Car(String modelNumber , long rateBought , String fuelType , int numberOfPassengers){
        this.fuelType = fuelType;
        this.modelNumer = modelNumber;
        this.numberOfPassengers = numberOfPassengers;
        this.rateBought = rateBought;
        this.numberOfWheels = 4;
    }
    public double calculateTax(){
        if (this.fuelType.equals("petrol")){
            return 0.05*(double)(this.rateBought*this.numberOfPassengers);
        }
        if(this.fuelType.equals("diesel")){
            return 0.04*(double)(this.rateBought*this.numberOfPassengers);
        }
        return 0;
    }
}

class Truck extends Vehicle{
    int loadLimit;
    public Truck(String modelNumber , long rateBought , String fuelType , int loadLimit){
        this.fuelType = fuelType;
        this.modelNumer = modelNumber;
        this.loadLimit = loadLimit;
        this.rateBought = rateBought;
        this.numberOfWheels = 6;
    }
    public double calculateTax(){
        if (this.fuelType.equals("petrol")){
            return 0.0002*0.5*(double)(this.rateBought*this.loadLimit);
        }
        if(this.fuelType.equals("diesel")){
            return 0.0002*0.4*(double)(this.rateBought*this.loadLimit);
        }
        return 0;
    }
}
public class Q7 {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        ArrayList<Vehicle> list = new ArrayList<>();
        while(true){
            System.out.print("1. Add Vehicle\n2. Display Vehicles\n3. Exit\nEnter your choice:");
            int inpChoice = Integer.parseInt(s.nextLine().trim());
            if (inpChoice == 1) {
                System.out.print("a.Car\nb.Truck\nEnter your choice:");
                char vehicleChoice = s.nextLine().trim().charAt(0);
                if(vehicleChoice == 'a'){
                    System.out.print("ModelNumber:");
                    String modelNumber = s.nextLine().trim();
                    System.out.print("Rate:");
                    Long rate = Long.parseLong(s.nextLine().trim());
                    System.out.print("FuelType(petrol/diesel):");
                    String fuelType = s.nextLine().trim().toLowerCase();
                    System.out.print("Passengers:");
                    int passengers = Integer.parseInt(s.nextLine().trim());
                    Car c = new Car(modelNumber , rate , fuelType , passengers);
                    list.add(c);
                }
                if (vehicleChoice == 'b') {
                    System.out.print("ModelNumber:");
                    String modelNumber = s.nextLine().trim();
                    System.out.print("Rate:");
                    Long rate = Long.parseLong(s.nextLine().trim());
                    System.out.print("FuelType(petrol/diesel):");
                    String fuelType = s.nextLine().trim().toLowerCase();
                    System.out.print("LoadLimit:");
                    int loadLimit = Integer.parseInt(s.nextLine().trim());
                    Truck t = new Truck(modelNumber , rate , fuelType , loadLimit);
                    list.add(t);
                }
            }
            if (inpChoice == 2) {
                Comparator<Vehicle> Sorter = (o1,o2) -> (int)(o2.calculateTax() - o1.calculateTax());
                Collections.sort(list , Sorter);
                for (Vehicle v : list) {
                    v.displayVehicle();
                }
            }
            if(inpChoice == 3){
                break;
            }
        }
        s.close();
    }
}
