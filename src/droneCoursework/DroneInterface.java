package droneCoursework;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * class for drone interface
 * scanner for user input
 * drone storage specifier ds
 * specifies size x,y
 */
public class DroneInterface {
    private Scanner s;                                // scanner used for input from user
    private DroneArena myArena;                // arena in which drones are shown
    DroneStorage ds;
    private int xSize, ySize;
    private Direction d;

    /**
     * constructor for DroneInterface
     * sets up scanner used for input and the arena
     * then has main loop allowing user to enter commands
     */
    public DroneInterface() throws InterruptedException, IOException {
        s = new Scanner(System.in);            // set up scanner for user input
        myArena = new DroneArena(20, 20);    // create arena of size 20*6
        ds = new DroneStorage();

        char ch = ' '; //adds a space
        do {
            System.out.print("Enter (A)dd drone, get (I)nformation , (D)isplay arena, (M)ove drones, (B)uild arena, L(O)ad arena, Sa(V)e to file or e(X)it > "); //string

            ch = s.next().charAt(0);
            s.nextLine();
            switch (ch) {
                case 'A':
                case 'a':
                    myArena.addDrone();    // add a new drone to arena
                    break;
                case 'I':
                case 'i':
                    System.out.print(myArena.toString());
                    break;
                case 'x':
                    ch = 'X';                // when X detected program ends
                    break;
                case 'D':
                case 'd': //displays drone arena by calling method do display
                    doDisplay();
                    break;
                case 'M':
                case 'm':
                    moveAllDrones(10); //when m , calls method move all drones
                    break;
                case 'B':
                case 'b':
                    newArena(); //when b, calls method new Arena, takes in size x and y
                    break;
                case 'O':
                case 'o':
                    openFile(); // when o, loads the file
                    break;
                case 'V':
                case 'v': //saves the file as txt
                    try {
                        ds.Save(ds.objectToString(myArena)); //saves

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } while (ch != 'X');                        // test if end

        s.close();                                    // close scanner
    }

    /**
     * method to load arena from file
     */
    void loadArenaFromFile() {
        String str = ds.objectToString(myArena);

        ds.stringToObject(str); //
    }

    /**
     * loads a methid from the string
     */
    void loadFileFromString() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter the name for the arena: ");
        String params = sc.nextLine();

    }

    /**
     * method to move all the drones 10 times
     *
     * @param nTimes
     * @throws InterruptedException
     */
    public void moveAllDrones(int nTimes) throws InterruptedException {

        for (int i = 0; i < nTimes; i++) {
            myArena.moveAll();
            doDisplay();
            Thread.sleep(200);
        }

    }

    /**
     * creates a newArena within a class of droneArena
     *
     * @return myArena
     */
    public DroneArena newArena() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter x,y for new Arena size (x,y): ");
        String params = sc.nextLine();  // Read user input
        try {
            String[] p1 = params.split(","); //splits the string through commas
            int x = Integer.parseInt(p1[0].trim());
            int y = Integer.parseInt(p1[1].trim());
            if (x < 3 || y < 3) {
                throw new Exception("Needs to be 3,3 or larger");
            }
            this.myArena = new DroneArena(x, y);
            return myArena;
        } catch (Exception ex) {
            System.out.println("value entered incorrectly, creating default size");
            this.myArena = new DroneArena(20, 20);
            return myArena;
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     * @throws IOException
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        DroneInterface r = new DroneInterface();
        // just call the interface
    }

    /**
     * method displays the drones within arena
     */
    void doDisplay() {
        ConsoleCanvas c = new ConsoleCanvas(myArena.getX(), myArena.getY());
        myArena.showDrones(c);
        System.out.println(c.toString());
    }

    /**
     * @throws IOException
     */
    public void openFile() throws IOException {
        JFileChooser chooser = new JFileChooser(); //  creates File Chooser
        int returnVal = chooser.showOpenDialog(null); // opens OPEN dialog

        String line;

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File selFile = chooser.getSelectedFile();
            BufferedReader fileReader = new BufferedReader(new FileReader(selFile)); //Opens file

            line = fileReader.readLine(); // reads first line from array

            String[] infoLine = line.split(","); // Creates array of arena info

            this.xSize = Integer.parseInt(infoLine[0]); // assigns width
            this.ySize = Integer.parseInt(infoLine[1]); // assigns height
            myArena = new DroneArena(xSize, ySize); // creates arena of size decided by file


            while ((line = fileReader.readLine()) != null) // end when the line is blank
            {
                infoLine = line.split(","); // separate onto different drones arguments
                System.out.println(Arrays.toString(infoLine));
                int x = Integer.parseInt(infoLine[0]); //deriving coordinate x
                int y = Integer.parseInt(infoLine[1]); //deriving coordinate y
                String dir = infoLine[2]; //deriving direction

                d = d.valueOf(dir);
                myArena.addDrone(x, y, d); // creates drone from data
            }
            fileReader.close();
        }

    }
}
