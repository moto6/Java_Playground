package chp11_enum.ex2;

import java.util.Arrays;
import java.util.Comparator;

enum Direction {
    SOUTH, WEST, EAST, NORTH,
    NORTH_EAST, NORTH_WEST,
    SOUTH_EAST, SOUTH_WEST
}

public class Launcher112 {

    public static void main(String[] args) {
        Direction myDirection = Direction.EAST;
        Integer integer = 112;

        int zero = Direction.SOUTH.ordinal();

        Direction i = Direction.SOUTH_EAST;

        Direction[] directions = Direction.values();
        Direction you = directions[3];

        int c = Direction.SOUTH.compareTo(you);
        boolean b = Direction.SOUTH_EAST.equals(you);

        Arrays.sort(directions, Comparator.naturalOrder());
        System.out.println(Arrays.toString(directions));

        Arrays.sort(directions, Comparator.reverseOrder());
        System.out.println(Arrays.toString(directions));

    }


}
