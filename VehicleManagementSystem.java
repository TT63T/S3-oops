import java.time.Year;


class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double basePrice;

    public Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    public void displayInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: ₹" + basePrice);
    }

    public double calculateResaleValue() {
        int currentYear = Year.now().getValue();
        int age = currentYear - year;
        return basePrice * Math.pow(0.85, age);
    }
}


class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, String model, int year, double basePrice, int numberOfDoors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    public double calculateInsurance() {
        return 5000 + (1000 * numberOfDoors);
    }

    public double calculateMaintenanceCost() {
        return 3000 + (500 * numberOfDoors);
    }

   
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance Cost: ₹" + calculateInsurance());
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
        System.out.println("Resale Value: ₹" + String.format("%.2f", calculateResaleValue()));
        System.out.println("---------------------------------------------------");
    }
}


class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    public double calculateInsurance() {
        return 2500 + (hasSidecar ? 1500 : 0);
    }

    public double calculateMaintenanceCost() {
        return 2000 + (hasSidecar ? 1000 : 0);
    }


    public void displayInfo() {
        super.displayInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance Cost: ₹" + calculateInsurance());
        System.out.println("Maintenance Cost: ₹" + calculateMaintenanceCost());
        System.out.println("Resale Value: ₹" + String.format("%.2f", calculateResaleValue()));
        System.out.println("---------------------------------------------------");
    }
}


public class VehicleManagementSystem {
    public static void main(String[] args) {
       
        Car myCar = new Car("Toyota", "Camry", 2020, 1200000, 4);
        System.out.println("CAR DETAILS:");
        myCar.displayInfo();

       
        Motorcycle myMotorcycle = new Motorcycle("Royal Enfield", "Classic 350", 2021, 180000, true);
        System.out.println("MOTORCYCLE DETAILS:");
        myMotorcycle.displayInfo();
    }
}
