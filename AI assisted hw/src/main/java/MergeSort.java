/**
 * The MergeSort class implements the SortingStrategy interface and provides
 * the merge sort algorithm for sorting an array of integers.
 */
public class MergeSort implements SortingStrategy {

    /**
     * Sorts the given array using the merge sort algorithm.
     *
     * @param arr the array to be sorted
     * @return the sorted array
     */
    @Override
    public int[] sort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
        return arr;
    }

    /**
     * Recursively performs merge sort on the array.
     *
     * @param arr  the array to be sorted
     * @param low  the index of the lower bound
     * @param high the index of the upper bound
     */
    private void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high - low) / 2;

            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);

            merge(arr, low, mid, high);
        }
    }

    /**
     * Merges two sorted subarrays into a single sorted subarray.
     *
     * @param arr  the array containing the subarrays
     * @param low  the index of the lower bound
     * @param mid  the index of the middle element
     * @param high the index of the upper bound
     */
    private void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        System.arraycopy(arr, low, left, 0, n1);
        System.arraycopy(arr, mid + 1, right, 0, n2);

        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < n1) {
            arr[k++] = left[i++];
        }

        while (j < n2) {
            arr[k++] = right[j++];
        }
    }
}
