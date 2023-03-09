/**
 * Holds the Engine class and initializes values
 */

public class Engine {

    private FuelType fuel;
    private Double currentFuelLevel;
    private Double maxFuelLevel; 

    /**
     * Sets up the constructor, which provides initial values for class attributes
     * @param fuel: takes in the FuelType
     * @param maxFuelLevel: takes in maximum fuel level tolerated by engine
     */
    public Engine(FuelType fuel, Double maxFuelLevel) {
        this.fuel = fuel;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = this.maxFuelLevel;

    } 

    /** 
     * Getter/accessor for currentFuelLevel 
     * */
    public Double get_currentFuelLevel() {
        return this.currentFuelLevel;
    }

     /** 
      * Getter/accessor for maxFuelLevel
      */
     public Double get_maxFuelLevel() {
        return this.maxFuelLevel;
    }
    /**
     * Resets the Engine's current fuel level to the maximum capacity it can hold
     */
    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel; 
    }
    /**
     * Reports fuel level, allowing it to decrease, if train is running and has fuel and throws exception if train is out of fuel
    */
    public void go() {
        if (this.currentFuelLevel > 0) {
            System.out.println("Remaining Fuel Level: " + this.currentFuelLevel);
            this.currentFuelLevel = this.currentFuelLevel - 0.1*this.maxFuelLevel; 
        }
        else {
            // RuntimeException e = new RuntimeException();
             throw new RuntimeException ("The engine is out of fuel."); 
        }
    }


    // FOR TESTING

    /**
     * Tests methods created for Engine class by creating a new Engine called myEngine
     * @param args: The command line arguments
     */
    public static void main(String[] args) {
        Engine myEngine = new Engine(FuelType.ELECTRIC, 100.0);
        System.out.println(myEngine.currentFuelLevel);
        try {
            while (true) {
                myEngine.go();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage()); // Out of fuel
        }
    }
}

