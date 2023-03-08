import java.util.ArrayList;

public class Train {

    private final Engine engine; // word final here establishes a composition relationship between train and engine
    private ArrayList<Car> car;
    private FuelType fuelType;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;

    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.fuelType = fuelType;
        this.car = new ArrayList<Car>(nCars);
        this.fuelCapacity = fuelCapacity; 
        this.nCars = nCars; 
        this.passengerCapacity = passengerCapacity; 
        this.engine = new Engine(fuelType, fuelCapacity);

    }
    public Engine getEngine() {
        return this.engine;
    }
    public Car getCar(int i) {
        return this.car.get(i); 
    }
    public int getMaxCapacity() {
        return nCars * this.passengerCapacity;
    }
    public int seatsRemaining() {
        int numofSeats = 0;
        for(int i = 0; i < this.car.size(); i++) {
            numofSeats = this.car.get(i).seatsRemaining();
        }
        return numofSeats;
         
    }
    public void printManifest() {
        for(int i = 0; i < this.car.size(); i++ ) {
            this.car.get(i).printManifest(); 
        }
    }
    
    public static void main(String[] args) {
        
    }

}
