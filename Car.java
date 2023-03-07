import java.util.ArrayList;

public class Car {

    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

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

    public int seatsRemaining() {
        return this.maxCapacity - this.passengersOnboard.size(); // subtract the num of pass from max capacity 

    }
    public void addPassenger(Passenger p) {
        if (seatsRemaining() > 0) {
            this.passengersOnboard.add(p);
        }
        else {
            throw new RuntimeException("Sorry, there are no seats available.");

        }

    }
    public void removePassenger(Passenger p) {
        if (passengersOnboard.contains(p)) {
            this.passengersOnboard.remove(p);

        }
        else {
            throw new RuntimeException("This passenger is not on board.");
        }
    }
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
