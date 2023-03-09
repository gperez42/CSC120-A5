/**
 * Holds the Passenger class and initializes values
 */ 
public class Passenger {
    
    private String name;

    /**
     * Takes in initial value for parameter String name
     * @param name: takes in each passenger's name
     */
    public Passenger(String name) {
        this.name = name;
    }
    /**
     * Allows passenger to board a Car or not if Car is full
     * @param c: takes in a specific Car c
     */
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
            
        } catch (Exception e) {
            // if car is full
            System.out.println("This car is full, this passenger cannot board."); 
        }
    }
    /**
     * Allows passenger to exit a Car or not if the passenger isn't onboard in the first place.
     * @param c: takes in a specific Car c
     */
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
     
        } catch (Exception e) {
            // if passenger is not on board
            System.out.println("This passenger is not onboard."); 
        }

    }
    /**
     * Accessor/getter for passenger's name
     */
    public String getName() {
        return this.name;
    }
    

}

