public class Passenger {
    
    private String name;

    public Passenger(String name) {
        this.name = name;
    }
    public void boardCar(Car c) {
        try {
            c.addPassenger(this);
            
        } catch (Exception e) {
            // if car is full
            System.out.println("This car is full, this passenger cannot board."); 
        }
    }
    public void getOffCar(Car c) {
        try {
            c.removePassenger(this);
     
        } catch (Exception e) {
            // if passenger is not on board
            System.out.println("This passenger is not on board."); 
        }

    }
    /**
     * Accessor/getter for passenger's name
     */
    public String getName() {
        return this.name;
    }
    

}

