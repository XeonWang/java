package xeon.tank.vehicle;

/**
 * User: xeon
 * Date: 12/31/12
 * Time: 8:13 PM
 */
public enum Direction {

    NORTH(0), SOUTH(180), WEST(270), EAST(90);

    private int rotation;

    private Direction(int rotation) {
        this.rotation = rotation;
    }

    public int getValue() {
        return rotation;
    }
}
