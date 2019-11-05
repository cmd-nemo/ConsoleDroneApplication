package droneCoursework; //package for the drones coursework

import java.util.ArrayList;
import java.util.Random;

/**
 * @author neyma
 * A DroneArena class which defines the arena size and stores drones and parses to an array.
 */
public class DroneArena {
    ArrayList<Drone> drones = new ArrayList<Drone>();
    private int x, y; //declaring private variables x and y

    /**
     * Overloaded constructor that defines the arenas height and width.
     *
     * @param xSize
     * @param ySize
     */
    public DroneArena(int xSize, int ySize) {
        this.x = xSize;
        this.y = ySize;
    }

    /**
     * getter value that parses the value X
     *
     * @return x
     */
    public int getX() {
        return x;
    }

    /**
     * getter value that parses the value Y
     *
     * @return y
     */
    public int getY() {
        return y;
    }

    /**
     * main function for test.
     *
     * @param args
     */
    public static void main(String[] args) {

        DroneArena a = new DroneArena(20, 10);    // create drone arena

        a.addDrone(); // adding 2 drones to the arena
        a.addDrone();
        System.out.println(a.toString());    // print where is

    }

    /**
     * method to addDrone
     */
    public void addDrone() {
        if (drones.size() < x * y) { // if statement that parses condition if drones size is less than x * y
            Random random = new Random(); //generates an instance of the class Random
            int xPosition;
            int yPosition;
            do {
                {
                    xPosition = random.nextInt(x); //do loop for randomising x and y position of drone "d"
                    yPosition = random.nextInt(y);
                }
            } while (getDroneAt(xPosition, yPosition, Direction.randomDir()) != null); //queries if a drone is at x,y,direction
            Direction direction = Direction.randomDir(); //generates a random direction within the instance of the class direction
            drones.add(new Drone(xPosition, yPosition, drones.size() + 1, direction)); //adds a new drone at the x and y pos and new direction
        }
    }

    /**
     * @param x
     * @param y
     * @param d
     */
    public void addDrone(int x, int y, Direction d) {
        drones.add(new Drone(x, y, drones.size() + 1, d));
    }

    /**
     * @param x
     * @param y
     * @param dir
     * @return d
     */
    public Drone getDroneAt(int x, int y, Direction dir) {
        for (Drone d : drones) {
            if (d.isHere(x, y)) {
                return d;
            }
        }
        return null;
    }

    /**
     * @param x
     * @param y
     * @return true or false
     */
    public boolean canMoveHere(int x, int y) {  //checks if the drone can move in a given position based on enumeration of the class direction
        if (x < this.x && y < this.y && x != 0 && y != 0) {
            System.out.println("moved"); //tests to see if drone has moved
            return true;
        } else {
            System.out.println("couldnt move"); //tests to see if drone has not moved
            return false;
        }
    }

    /**
     * function to animate movement of drones 10 times within the arena
     */
    void moveAll() {
        for (Drone d : drones) {
            d.tryMove(this); //calls the method tryMove
        }
    }

    /**
     * method to arrange an output to string
     *
     * @return s
     */
    public String toString() {
        String s = "drones\n";
        for (Drone d : drones) {
            s += d.toString();
            s += "\n";
        }

        return s;

    }

    /**
     * calls the method showDrones within console canvas
     *
     * @param c
     */
    public void showDrones(ConsoleCanvas c) {
        for (Drone d : drones) { //for loop that loops through the drones array.
            d.displayDrone(c);
        }
    }
}