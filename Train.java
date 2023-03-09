import java.util.ArrayList;

/**
 * Holds the Train class and initializes its values
 */
 
public class Train {

    private final Engine engine; // word final here establishes a composition relationship between train and engine
    private ArrayList<Car> car;
    private FuelType fuelType;
    private double fuelCapacity;
    private int nCars;
    private int passengerCapacity;

    /**
     * Takes in value for attributes, setting up a new ArrayList for Car to hold all cars and setting up a new Engine
     * @param fuelType: takes in FuelType
     * @param fuelCapacity: takes in the total fuel capacity of the train
     * @param nCars: takes in the number of cars attached to train
     * @param passengerCapacity: takes in the total number of passengers that the train can hold
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.fuelType = fuelType;
        this.car = new ArrayList<Car>(nCars);
        this.fuelCapacity = fuelCapacity; 
        this.nCars = nCars; 
        this.passengerCapacity = passengerCapacity; 
        this.engine = new Engine(fuelType, fuelCapacity);

    }
    /**
     * Getter/accessor for Engine
     * @return Engine: for the Train to be able to use the Engine
     */
    public Engine getEngine() {
        return this.engine;
    }
    /**
     * Getter/accessor for Car
     * @param i: takes in a specific ith value
     * @return: Car at the ith value
     */
    public Car getCar(int i) {
        return this.car.get(i); 
    }
    /**
     * Getter/accesser for passengerCapacity across all cars
     * @return int: the total number of passengers the trin can hold
     */
    public int getMaxCapacity() {
        return nCars * this.passengerCapacity;
    }
    /**
     * Getter/accessor for seats remaining across all cars 
     * @return int: the total number of seats available in the entire train
     */
    public int seatsRemaining() {
        int numofSeats = 0;
        for(int i = 0; i < this.car.size(); i++) {
            numofSeats = this.car.get(i).seatsRemaining();
        }
        return numofSeats;
         
    }
    /**
     * Prints a list of all of the passengers onboard the train
     */
    public void printManifest() {
        for(int i = 0; i < this.car.size(); i++ ) {
            this.car.get(i).printManifest(); 
        }
    }

    // FOR TESTING

    /**
     * Tests methods found in Train class by creating the a new Train called myTrain
     * @param args: The command line arguments
     */
    public static void main(String[] args) {
        Train myTrain = new Train(FuelType.ELECTRIC, 60, 5, 50);
        myTrain.printManifest();
        myTrain.getMaxCapacity();
    }

}
