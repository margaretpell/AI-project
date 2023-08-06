import java.util.Arrays;

/**
 * Utility class for sorting methods.
 */
public class SortingMethods {

    private static final String[] sortingMethods = {"Bubble Sort", "Insertion Sort", "Merge Sort", "Quick Sort", "Selection Sort"};

    /**
     * Get the sorting algorithm name based on the dice roll.
     *
     * @param diceRoll the roll of the dice
     * @return the name of the sorting algorithm
     */
    public static String getAlgorithm(int diceRoll) {
        if (diceRoll >= 1 && diceRoll <= sortingMethods.length) {
            return sortingMethods[diceRoll - 1];
        } else {
            return "Unknown Sorting Algorithm";
        }
    }

    /**
     * Sorts the given array using the specified sorting strategy.
     *
     * @param arr      the array to be sorted
     * @param strategy the sorting strategy to be used
     * @return the sorted array
     */
    public static int[] sort(int[] arr, SortingStrategy strategy) {
        if (arr == null || arr.length == 0) {
            return new int[0]; // Return an empty array if input is null or empty
        }
        return strategy.sort(arr);
    }

    /**
     * Get a copy of the available sorting methods.
     *
     * @return an array of sorting method names
     */
    public static String[] getSortingMethods() {
        return Arrays.copyOf(sortingMethods, sortingMethods.length);
    }
}
