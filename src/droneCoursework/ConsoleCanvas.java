package droneCoursework;

public class ConsoleCanvas {
    int width;
    int height;
    char[][] arenaCanvas;

    ConsoleCanvas(int width, int height) {
        this.width = width;
        this.height = height;
        clearCanvas();
    }

    public void clearCanvas() {
        arenaCanvas = new char[width][height];
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                arenaCanvas[x][y] = ' ';
            }
        }
    }

    public String toString() {
        String builder = "";
        for (int x = 0; x < this.width + 2; x++) {
            builder = builder + "#";
        }
        builder = builder + "\n";
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

    public void showIt(int x, int y, char c) {
        arenaCanvas[x][y] = c;
    }

    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4, 3, 'D');
        System.out.println(c.toString());
    }


}