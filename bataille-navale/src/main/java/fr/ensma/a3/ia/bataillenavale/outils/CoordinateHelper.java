package fr.ensma.a3.ia.bataillenavale.outils;

public class CoordinateHelper {
    /**
     * Transforms a "letter" coordinate by its equivalent "number"
     *
     * @param String coordinate : the coordinate to transform
     * 
     * @return String
     */
    public static String letterCoordinateToNumber(String coordinate) {
        return String.valueOf(new String("ABCDEFGHIJ").indexOf(coordinate));
    }

    /**
     * Checks if the coordinate don't go out of the board
     *
     * @param int x
     * @param int y
     * 
     * @return boolean
     */
    public static boolean isValid(int x, int y) {
        return (x >= 0 && x <= 9 && y >= 0 && y <= 9);
    }
}