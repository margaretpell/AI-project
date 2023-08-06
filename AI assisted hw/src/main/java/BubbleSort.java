/**
 * Implementation of the Bubble Sort algorithm.
 */
public class BubbleSort implements SortingStrategy {

    /**
     * Sorts an array of integers using the Bubble Sort algorithm.
     *
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
}
