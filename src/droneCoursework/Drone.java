package droneCoursework;

/**
 * class to store drone information and add drone functionality
 */
public class Drone {
    int xPos; //xPos
    int yPos; //yPos
    private static int ID; //ID for the drone, static as its shared between all the classes, means the value is shared between all instances of the class Drone
    Direction direction;

    /**
     * getter for direction
     *
     * @return direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param i
     * @param j
     * @param id
     * @param direction
     */
    public Drone(int i, int j, int id, Direction direction) {
        this.xPos = i;
        this.yPos = j;
        this.ID = id;
        this.direction = direction;
    }

    /**
     * gets position x
     *
     * @return xPos
     */
    public int getPositionX() {
        return xPos;
    }

    /**
     * gets position y
     *
     * @return yPos
     */
    public int getPositionY() {
        return yPos;
    }

    /**
     * checks if drone is in stated position
     *
     * @param sx
     * @param sy
     * @return true or false
     */
    public boolean isHere(int sx, int sy) { //boolean type

        if (this.xPos == sx && this.yPos == sy) { //if drone we are looking at is in the set position
            return true;
        }
        return false;
    }

    /**
     * main function to test class Drone
     *
     * @param args
     */
    public static void main(String[] args) {
        Drone d = new Drone(5, 3, 0, Direction.randomDir());        // create drone
        System.out.println(d.toString());    // print where is
    }

    /**
     * specifies drone coordinates and direction
     *
     * @return string
     */
    public String toString() {
        return "your drone is at " + this.xPos + "," + this.yPos + " " + direction.toString();
    }

    /**
     * displays drone, by parses through the console canvas
     *
     * @param c
     */
    public void displayDrone(ConsoleCanvas c) {
        c.showIt(xPos, yPos, 'D'); //displays drones

    }

    /**
     * tries to move the drone based on directions
     *
     * @param Arena
     * @return false
     */
    public boolean tryMove(DroneArena Arena) {
        int newXPos = this.getPositionX();
        int newYPos = this.getPositionY(); //sets the local variables which will then be used on testing of the interface
        if (this.direction == Direction.South) {
            newYPos--;
        } else if (this.direction == Direction.North) {
            newYPos++;
        } else if (this.direction == Direction.East) {
            newXPos++;
        } else if (this.direction == Direction.West) {
            newXPos--;
        }
        if (Arena.canMoveHere(newXPos, newYPos)) {
            System.out.println("moved");
            this.xPos = newXPos;
            this.yPos = newYPos;
            return true;
        } else {
            System.out.println("didnt move");
            this.direction = direction.nextDir();

            return false;
        }
    }
}

