package droneCoursework;

import java.util.Random;

/**
 * enum class for direction
 */
public enum Direction {
    North, East, South, West; //directions

    /**
     * @param s
     * @return d
     */
    public static Direction fromString(String s) { // converts a String to a direction class
        Direction d = Direction.valueOf(Direction.class, s);
        return d;
    }

    /**
     * @return direction
     */
    public Direction nextDir() {

        return values()[(this.ordinal() + 1) % values().length];
    }

    /**
     * @return random direction
     */
    public static Direction randomDir() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}