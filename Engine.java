public class Engine {

    private FuelType fuel;
    private Double currentFuelLevel;
    private Double maxFuelLevel; 

    public Engine(FuelType fuel, Double maxFuelLevel) {
        this.fuel = fuel;
        this.maxFuelLevel = maxFuelLevel;
        this.currentFuelLevel = this.maxFuelLevel;

    } 

    /** Getter/accessor for currentFuelLevel **/
    public Double get_currentFuelLevel() {
        return this.currentFuelLevel;
    }

     /** Getter/accessor for maxFuelLevel **/
     public Double get_maxFuelLevel() {
        return this.maxFuelLevel;
    }

    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel; 
    }
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

