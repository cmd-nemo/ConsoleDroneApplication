package droneCoursework;

public class ConsoleCanvas {
    char[][] arenaCanvas;

    ConsoleCanvas(int x, int y) {
        arenaCanvas = new char[x][y];

        for(int i = 0; i < arenaCanvas.length; i++) {
            for(int j = 0; j < arenaCanvas[i].length; j++) {
                if(i==0 || j==0 || i==arenaCanvas.length-1 || j==arenaCanvas[i].length-1) {
                    arenaCanvas[i][j] = '#';
                }
                else {
                    arenaCanvas[i][j] = ' ';
                }
            }
        }
    }
    public String toString() {
        String builder = "";
        for(int i = 0; i < arenaCanvas.length; i++) {
            for(int j = 0; j < arenaCanvas[i].length; j++) {
                builder+=arenaCanvas[i][j];
            }
            builder+="\n";
        }
        return builder;
    }

    public void showIt(int x, int y, char c) {
        arenaCanvas[x][y] = c;
    }
    public static void main(String[] args) {
        ConsoleCanvas c = new ConsoleCanvas(10, 5);
        c.showIt(4,3,'D');
        System.out.println(c.toString());
    }
}
