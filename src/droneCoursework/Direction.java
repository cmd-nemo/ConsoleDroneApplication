package droneCoursework;

import java.util.Random;

public enum Direction {
    North, East, South, West;
    public static Direction nextDir(Direction oldDirection) {

    int index = Direction.valueOf(oldDirection.toString()).ordinal();
    return Direction.values()[index+1 % Direction.values().length];
    }
    public static Direction randomDir() {
        Random r = new Random();
        return Direction.values()[r.nextInt(Direction.values().length)];
    }
}