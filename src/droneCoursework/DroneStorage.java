package droneCoursework;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DroneStorage {

    String objectToString(DroneArena a) {
        String s = "";
        s += a.getX() + "," + a.getY() + "\n";

        for (Drone d : a.drones) {
            s += d.xPos + "," + d.yPos + "," + d.direction.toString() + "\n";
        }

        return s;
    }

    DroneArena stringToObject(String s) {
        String[] arr = s.split("\n");
        DroneArena dA = null; //object of the class
        boolean create = true;
        for (String st : arr) {
            if (create) {
                String[] arr1 = st.split(",");
                int x = Integer.parseInt(arr1[0]);
                int y = Integer.parseInt(arr1[1]);
                dA = new DroneArena(x, y);
                create = false;
            } else {
                String[] arr2 = st.split(",");
                int droneX = Integer.parseInt(arr2[0]);
                int droneY = Integer.parseInt(arr2[1]);
                Direction dir = Direction.fromString(arr2[2]);
                dA.drones.add(new Drone(droneX, droneY, dA.drones.size() + 1, dir));

            }
        }
        System.out.println(dA.toString());
        return dA;
    }

    void Save(String s) throws IOException {
        File f = new File("file.txt");
        FileWriter fw = new FileWriter(f);
        fw.write(s);
        fw.close();
    }


}