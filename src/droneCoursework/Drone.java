package droneCoursework;

public class Drone {
    int xPos;
    int yPos;
    int ID;
    Direction direction;

    public Direction getDirection() {
        return direction;
    }

    public Drone(int i, int j, int id, Direction direction) {
        this.xPos = i;
        this.yPos = j;
        this.ID = id;
        this.direction = direction;
    }

    public int getPositionX() {
        return xPos;
    }

    public int getPositionY() {
        return yPos;
    }

    public boolean isHere(int sx, int sy) {

        if (this.xPos == sx && this.yPos == sy) { //if drone we are looking at is in the set position
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Drone d = new Drone(5, 3, 0, Direction.randomDir());        // create drone
        System.out.println(d.toString());    // print where is
    }

    public String toString() {
        return "your drone is at " + this.xPos + "," + this.yPos + " " + direction.toString();
    }

    public void displayDrone(ConsoleCanvas c) {
        c.showIt(xPos, yPos, 'D'); //displays drones

    }

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

