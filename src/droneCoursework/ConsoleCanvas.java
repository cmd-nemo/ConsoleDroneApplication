package droneCoursework;

/**
 * sets the class for console canvas
 * specifies width and height af arena
 * creates a 2 dimensional array of elements 0,1
 */
public class ConsoleCanvas {
    int width;
    int height;
    char[][] arenaCanvas;

    /**
     * overloaded constructor that takes parameters
     *
     * @param width
     * @param height
     */
    ConsoleCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        clearCanvas(); //clears canvas if text.
    }

    /**
     * method to clear canvas arena, loops through the arena to clear space
     */
    public void clearCanvas() {
        arenaCanvas = new char[width][height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                arenaCanvas[x][y] = ' '; //putting spaces within the arena.
            }
        }
    }

    /**
     * @return builder
     */
    public String toString() { //declares a to string specifier that passes the string to be outputted
        String builder = "";
        for (int x = 0; x < this.width + 2; x++) {
            builder = builder + "#"; //builds the arena walls with #
        }
        builder = builder + "\n"; //building walls of arena
        for (int y = 0; y < this.height; y++) {
            builder = builder + "#";
            for (int x = 0; x < this.width; x++) {
                builder = builder + arenaCanvas[x][y];
            }
            builder = builder + "#\n";
        }
        for (int x = 0; x < this.width + 2; x++) {
            builder = builder + "#";
        }
        builder = builder + "\n";
        return builder;
    }

    /**
     * displays the text within the arena
     *
     * @param x
     * @param y
     * @param c
     */
    public void showIt(int x, int y, char c) {
        arenaCanvas[x][y] = c;
    }

    /**
     * prints out the arena
     *
     * @param args
     */
    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4, 3, 'D');
        System.out.println(c.toString());
    }


}