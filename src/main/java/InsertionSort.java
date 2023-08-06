/**
 * Implementation of the Insertion Sort algorithm for sorting an integer array in ascending order.
 */
public class InsertionSort implements SortingStrategy {

    /**
     * Sorts the given array using the Insertion Sort algorithm.
     *
     * @param arr the array to be sorted
     * @return the sorted array in ascending order
     */
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
