package droneCoursework;

import java.util.Scanner;

public class DroneInterface {
    private Scanner s;                                // scanner used for input from user
    private DroneArena myArena;                // arena in which drones are sho




    /**
     * constructor for DroneInterface
     * sets up scanner used for input and the arena
     * then has main loop allowing user to enter commands
     */
    public DroneInterface() {
        s = new Scanner(System.in);            // set up scanner for user input
        myArena = new DroneArena(10, 10);    // create arena of size 20*6

        char ch = ' ';
        do {
            System.out.print("Enter (A)dd drone, get (I)nformation , (D)isplay, or e(X)it > ");
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
                case 'd':
                    doDisplay();
            }
        } while (ch != 'X');                        // test if end

        s.close();                                    // close scanner
    }

    public static void main(String[] args) {
        DroneInterface r = new DroneInterface();
        // just call the interface
    }
    void doDisplay(){
        ConsoleCanvas c = new ConsoleCanvas(myArena.totAreaX, myArena.totAreaY);
        myArena.showDrones(c);
        System.out.println(c.toString());

    }
}
