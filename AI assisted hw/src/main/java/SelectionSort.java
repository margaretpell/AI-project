/**
 * SelectionSort is a sorting strategy that implements the SortingStrategy interface.
 * It sorts an array of integers using the selection sort algorithm.
 */
public class SelectionSort implements SortingStrategy {

    /**
     * Sorts the given array using the selection sort algorithm.
     *
     * @param arr the array of integers to be sorted
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                swap(arr, i, minIndex);
            }
        }

        return arr;
    }

    /**
     * Swaps two elements in the given array.
     *
     * @param arr the array
     * @param i   the index of the first element
     * @param j   the index of the second element
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
