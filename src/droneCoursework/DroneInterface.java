package droneCoursework;

import java.io.IOException;
import java.util.Scanner;

public class DroneInterface {
    private Scanner s;                                // scanner used for input from user
    private DroneArena myArena;                // arena in which drones are sho
    DroneStorage ds;


    /**
     * constructor for DroneInterface
     * sets up scanner used for input and the arena
     * then has main loop allowing user to enter commands
     */
    public DroneInterface() throws InterruptedException {
        s = new Scanner(System.in);            // set up scanner for user input
        myArena = new DroneArena(20, 20);    // create arena of size 20*6
        ds = new DroneStorage();

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd drone, get (I)nformation , (D)isplay, (M)ove, (B)uild or e(X)it > ");

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
                case 'd':
                    doDisplay();
                    break;
                case 'M':
                case 'm':
                    moveAllDrones(10);
                    break;
                case 'B':
                case 'b':
                    newArena();
                    break;
                case 'v':
                    try{
                        ds.Save(ds.objectToString(myArena)); //saves

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } while (ch != 'X');                        // test if end

        s.close();                                    // close scanner
    }

    void loadArenaFromFile(){
        String str = ds.objectToString(myArena);

        ds.stringToObject(str); //
    }

    public void moveAllDrones(int nTimes) throws InterruptedException {

        for (int i = 0; i < nTimes; i++) {
            myArena.moveAll();
            doDisplay();
            Thread.sleep(200);
        }

    }

    public DroneArena newArena() {
        Scanner sc = new Scanner(System.in);  // Create a Scanner object
        System.out.print("Enter x,y for new Arena size (x,y): ");
        String params = sc.nextLine();  // Read user input
        try {
            String[] p1 = params.split(",");
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

    public static void main(String[] args) throws InterruptedException {
        DroneInterface r = new DroneInterface();
        // just call the interface
    }

    void doDisplay() {
        ConsoleCanvas c = new ConsoleCanvas(myArena.getX(), myArena.getY());
        myArena.showDrones(c);
        System.out.println(c.toString());
    }
}