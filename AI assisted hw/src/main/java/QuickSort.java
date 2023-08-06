/**
 * QuickSort is a class that implements the SortingStrategy interface
 * to provide the quick sort algorithm for sorting an array of integers.
 */
public class QuickSort implements SortingStrategy {
    /**
     * Sorts the given array using the quick sort algorithm.
     *
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Recursive method to perform quick sort on the array.
     *
     * @param arr  the array to be sorted
     * @param low  the starting index of the subarray
     * @param high the ending index of the subarray
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    /**
     * Partitions the array and selects a pivot element.
     * Elements smaller than the pivot are moved to the left side,
     * and elements greater than the pivot are moved to the right side.
     *
     * @param arr  the array to be partitioned
     * @param low  the starting index of the subarray
     * @param high the ending index of the subarray
     * @return the index of the pivot element
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    /**
     * Swaps two elements in the array.
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
