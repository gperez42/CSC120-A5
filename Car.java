import java.util.ArrayList;
/**
 * Holds the Car class and initializes values
 */
public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    /**
     * Takes in value for attribute maxCapacity and sets up new ArrayList to store all passengers in a car
     * @param maxCapacity: takes in car's maximum capacity of passengers
     */
    public Car(int maxCapacity) {
        this.passengersOnboard = new ArrayList<Passenger>(maxCapacity);
        this.maxCapacity = maxCapacity; 

    }
    /**
     * Getter/setter for maxCapacity
     * @return int: the maximum capacity of passengers the car can hold
     */
    public int getCapacity() {
        return maxCapacity;
    }
    /**
     * Getter/setter for remaining seats after all passengersOnboard are accounted for
     * @return int: the number of seats that remain available in a car
     */
    public int seatsRemaining() {
        return this.maxCapacity - this.passengersOnboard.size(); // subtract the num of pass from max capacity 

    }
    /**
     * Adds a passenger to the car
     * @param p: takes in each passenger that will be added to the car
     */
    public void addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            this.passengersOnboard.add(p);
        }
        else {
            throw new RuntimeException("Sorry, there are no seats available.");

        }

    }
    /**
    * Removes a passenger from the car, or throws an exception if the passenger cannot be found onboard
    * @param p: takes in each passenger that will be removed from the car
    */
    public void removePassenger(Passenger p) {
        if (passengersOnboard.contains(p)) {
            this.passengersOnboard.remove(p);

        }
        else {
            throw new RuntimeException("This passenger is not on board.");
        }
    }
    /**
     * Prints a list of all passengers onboard or a predetermined statement if car is empty
     */
    public void printManifest() {
        if (this.passengersOnboard.size() > 0) {
            for (int i = 0; i < this.passengersOnboard.size(); i++) {
                System.out.println(this.passengersOnboard.get(i).getName());

            }
        }
        else {
            System.out.println("This car is empty.");
        }
    }
    /**
     * Tests methods found in Car class by creating a new Car called myCar
     * @param args: The command line arguments
     */
    public static void main(String[] args) {
        Car myCar = new Car(50);
        Passenger h = new Passenger("Henry");
        myCar.addPassenger(h);
        Passenger b = new Passenger("Bob");
        myCar.addPassenger(b);
        System.out.println(myCar.seatsRemaining());
        myCar.printManifest();

        // myCar.removePassenger(h);
        // System.out.println(myCar.seatsRemaining());
        
        // try {
        //     while (true) {
        //         myCar.addPassenger(h);
        //         System.out.println("Added passenger successfully!");
        //     }
        // } catch (Exception a) {
        //     System.err.println(a.getMessage()); // No seats available
        // }
        // try {
        //     while (true) {
        //         myCar.removePassenger(p);
        //         System.out.println("Removed passenger succesfully!");
        //     }
        // } catch (Exception r) {
        //     System.err.println(r.getMessage()); // Passenger not on board
        // }
   
    }

}
