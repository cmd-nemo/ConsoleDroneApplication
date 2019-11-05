package droneCoursework;

import java.awt.print.Printable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * drone storage for file
 */
public class DroneStorage { //drone storage class
    /**
     * @param a
     * @return s
     */
    String objectToString(DroneArena a) { //creates a string to output drone arena information.
        String s = "";
        s += a.getX() + "," + a.getY() + "\n"; //getters for y

        for (Drone d : a.drones) {
            s += d.xPos + "," + d.yPos + "," + d.direction.toString() + "\n";
        }

        return s;
    }

    /**
     * @param s
     * @return dA
     */
    DroneArena stringToObject(String s) {
        String[] arr = s.split("\n");
        DroneArena dA = null; //object of the class
        boolean create = true; //boolean variable to store results of creation
        for (String st : arr) { //string array that parses file through commas
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
                dA.drones.add(new Drone(droneX, droneY, dA.drones.size() + 1, dir)); //loads file

            }
        }

        System.out.println(dA.toString()); //prints it to string
        return dA;
    }

    /**
     * @param s
     * @throws IOException
     */
    void Save(String s) throws IOException {
        File f = new File("file.txt"); //saves file as txt
        FileWriter fw = new FileWriter(f);
        fw.write(s);
        fw.close();
    }

}