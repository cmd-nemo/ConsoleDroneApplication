package droneCoursework;
import java.util.ArrayList;
import java.util.Random;


public class DroneArena {
    int totAreaX;
    int totAreaY;

    ArrayList<Drone> drones = new ArrayList<Drone>();

    private Drone d1;

    public DroneArena(int a, int b) {
        this.totAreaX = a;
        this.totAreaY = b;
    }

    int getDronesCount() {
        return drones.size();
    }

    int maxPossibleDrones() {
        return (this.totAreaX - 2) * (this.totAreaY - 2);
    }

    boolean canAddDrone() {
        if (getDronesCount() < maxPossibleDrones()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        DroneArena a = new DroneArena(200, 100);    // create drone arena
        a.addDrone(3, 5);
        a.addDrone(3, 5);
        a.addDrone();
        System.out.println(a.toString());    // print where is

    }

    private void addDrone(int x1, int y1) {
        Drone d1 = new Drone(x1, y1,Direction.randomDir());

        if (getDroneAt(x1, y1) == null) {
            drones.add(d1);
        } else {
            System.out.println("drone already here");
        }
    }

    public Drone getDroneAt(int x, int y) {
        for (Drone d : drones) {
            if (d.isHere(x, y)) {
                return d;
            }
        }
        return null;
    }

    public void addDrone() {

        int run = 1;
        while (run == 1) {
            Random r1 = new Random();

            int x = r1.nextInt(this.totAreaX - 1);
            int y = r1.nextInt(this.totAreaY - 1);
            if (getDroneAt(x, y) == null) {
                addDrone(x, y);
                run = 0; //break
            } else {
                System.out.println("drone is already here try again");

                if (canAddDrone() == false) {
                    run = 0;
                    System.out.println("You have reached maximum drone capacity of " + maxPossibleDrones());
                }
            }
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
public void showDrones(ConsoleCanvas c){
        for(Drone d : drones) {
            d.displayDrone(c);
        }
}
}
