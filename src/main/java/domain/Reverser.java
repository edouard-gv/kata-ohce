package domain;

public class Reverser {
    public static String reverse(String flip) {
        char[] flipArray = flip.toCharArray();
        StringBuilder flippedBuffer = new StringBuilder();
        for (int pos = flipArray.length -1 ; pos >= 0; pos--) {
            flippedBuffer.append(flipArray[pos]);
        }
        return flippedBuffer.toString();
    }
}
