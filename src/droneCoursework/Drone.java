package droneCoursework;

public class Drone {
    int xPos;
    int yPos;
    int iD;
    Direction dir;


    public Drone(int i, int j,Direction direction) {
        this.xPos = i;
        this.yPos = j;
        this.dir = direction;
    }

    public boolean isHere(int sx, int sy) {

        if (this.xPos == sx && this.yPos == sy) { //if drone we are looking at is in the set position
            return true;
        }
        return false;
    }

    public static void main(String[]args){
        //Drone d = new Drone(5, 3);        // create drone
        //System.out.println(d.toString());    // print where is
    }

    public String toString() {
        return "your drone is at " + this.xPos + "," + this.yPos;
    }
    public void displayDrone(ConsoleCanvas c){
        c.showIt(xPos,yPos,this.dir.toString().charAt(0));

    }
}
