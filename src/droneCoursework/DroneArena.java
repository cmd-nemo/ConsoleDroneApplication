package droneCoursework;
import java.util.ArrayList;
import java.util.Random;


public class DroneArena {
    ArrayList<Drone> drones = new ArrayList<Drone>();
    private int x, y;

    public DroneArena(int xSize, int ySize) {
        this.x = xSize;
        this.y = ySize;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //  int maxPossibleDrones() {
    //    return (this.x - 2) * (this.y - 2);
    //  }


    public static void main(String[] args) {

        DroneArena a = new DroneArena(20, 10);    // create drone arena

        a.addDrone();
        a.addDrone();
        System.out.println(a.toString());    // print where is

    }

    public void addDrone() {
        if (drones.size() < x * y) {
            Random random = new Random();
            int xPosition;
            int yPosition;
            do {
                {
                    xPosition = random.nextInt(x);
                    yPosition = random.nextInt(y);
                }
            } while (getDroneAt(xPosition, yPosition, Direction.randomDir()) != null);
            Direction direction = Direction.randomDir();
            drones.add(new Drone(xPosition, yPosition, drones.size() + 1, direction));
        }
    }
    public void addDrone(int x, int y, Direction d ){
        drones.add(new Drone(x, y, drones.size() + 1, d));
    }

    public Drone getDroneAt(int x, int y, Direction dir) {
        for (Drone d : drones) {
            if (d.isHere(x, y)) {
                return d;
            }
        }
        return null;
    }

    public boolean canMoveHere(int x, int y) {
        if (x < this.x && y < this.y && x!=0 && y!=0) {
            System.out.println("moved");
            return true;
        }else{
            System.out.println("couldnt move");
            return false;
        }
    }

    void moveAll(){
        for (Drone d:drones) {
            d.tryMove(this);
        }
    }


    public String toString() {
        String s = "drones\n";
        for (Drone d : drones) {
            s += d.toString();
            s += "\n";
        }

        return s;

    }

    public void showDrones(ConsoleCanvas c) {
        for (Drone d : drones) {
            d.displayDrone(c);
        }
    }
}