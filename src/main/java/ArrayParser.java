/**
 * The ArrayParser class provides a utility method to parse a string representation of an array of integers.
 */
public class ArrayParser {

    /**
     * Parses a string representation of an array of integers into an integer array.
     *
     * @param input the string representation of the array
     * @return the parsed integer array, or null if the input is in an invalid format
     */
    public static int[] parse(String input) {
        String[] stringArray = input.trim().split("\\s+");
        int[] arr = new int[stringArray.length];

        try {
            for (int i = 0; i < stringArray.length; i++) {
                arr[i] = Integer.parseInt(stringArray[i]);
            }
        } catch (NumberFormatException e) {
            // Invalid input format, return null
            return null;
        }

        return arr;
    }
}
