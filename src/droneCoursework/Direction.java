package droneCoursework;

import java.util.Random;

public enum Direction {
    North, East, South, West;

    public static Direction fromString(String s) { // converts a String to a direction class
        Direction d = Direction.valueOf(Direction.class, s);
        return d;
    }


    public Direction nextDir() {

        return values()[(this.ordinal() + 1) % values().length];
    }

    public static Direction randomDir() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}