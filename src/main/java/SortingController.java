import java.util.Random;

/**
 * The SortingController class manages the sorting process and interacts with the GUI.
 */
public class SortingController {
    private SortingAlgorithmsGUI view;

    /**
     * Constructs a SortingController with the specified view.
     *
     * @param view the SortingAlgorithmsGUI view
     */
    public SortingController(SortingAlgorithmsGUI view) {
        this.view = view;
    }

    /**
     * Handles the event when the roll and sort button is clicked.
     *
     * @param input the input array provided by the user
     */
    public void rollAndSortButtonClicked(String input) {
        int[] arr = parseInputArray(input);

        if (arr == null) {
            view.displayErrorMessage("Invalid input array!");
            return;
        }

        Dice dice = new Dice();
        dice.addObserver(view);
        dice.roll();
    }

    /**
     * Parses the input string and converts it into an array of integers.
     *
     * @param input the input string representing the array
     * @return the parsed array of integers, or null if the input is invalid
     */
    public int[] parseInputArray(String input) {
        return ArrayParser.parse(input);
    }

    /**
     * Retrieves the sorting algorithm based on the dice roll.
     * If the dice roll is 6, a random sorting algorithm is selected.
     *
     * @param diceRoll the dice roll value
     * @return the selected sorting algorithm
     */
    public String getSortingAlgorithm(int diceRoll) {
        if (diceRoll == 6) {
            return getRandomSortingAlgorithm();
        } else {
            return SortingMethods.getAlgorithm(diceRoll);
        }
    }

    /**
     * Retrieves a random sorting algorithm from the available sorting methods.
     *
     * @return a random sorting algorithm
     */
    private String getRandomSortingAlgorithm() {
        String[] sortingMethods = SortingMethods.getSortingMethods();
        Random random = new Random();
        int index = random.nextInt(sortingMethods.length);
        return sortingMethods[index];
    }

    /**
     * Retrieves the sorting strategy based on the given sort method.
     *
     * @param sortMethod the sort method to retrieve the strategy for
     * @return the sorting strategy corresponding to the sort method
     */
    public SortingStrategy getSortingStrategy(String sortMethod) {
        switch (sortMethod) {
            case "Bubble Sort":
                return new BubbleSort();
            case "Insertion Sort":
                return new InsertionSort();
            case "Merge Sort":
                return new MergeSort();
            case "Quick Sort":
                return new QuickSort();
            case "Selection Sort":
                return new SelectionSort();
            default:
                return null;
        }
    }

    /**
     * Sorts the given array using the specified strategy.
     *
     * @param arr      the array to be sorted
     * @param strategy the sorting strategy to be used
     * @return the sorted array
     */
    public int[] sortArray(int[] arr, SortingStrategy strategy) {
        if (arr == null || strategy == null) {
            return new int[0]; // Return an empty array if either input is null
        }
        return SortingMethods.sort(arr, strategy);
    }
}
