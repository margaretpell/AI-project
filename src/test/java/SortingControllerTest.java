import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for SortingController class.
 */
class SortingControllerTest {
    private SortingController controller;

    @BeforeEach
    void setUp() {
        controller = new SortingController(null);
    }

    @Test
    void testGetSortingAlgorithm_ValidDiceRoll() {
        // Test valid dice rolls for each algorithm
        String algorithm1 = controller.getSortingAlgorithm(1);
        String algorithm2 = controller.getSortingAlgorithm(2);
        String algorithm3 = controller.getSortingAlgorithm(3);
        String algorithm4 = controller.getSortingAlgorithm(4);
        String algorithm5 = controller.getSortingAlgorithm(5);
        String algorithm6 = controller.getSortingAlgorithm(6);

        // Assert expected algorithm names
        assertEquals("Bubble Sort", algorithm1);
        assertEquals("Insertion Sort", algorithm2);
        assertEquals("Merge Sort", algorithm3);
        assertEquals("Quick Sort", algorithm4);
        assertEquals("Selection Sort", algorithm5);
        assertNotNull(algorithm6); // Random algorithm
    }

    @Test
    void testGetSortingAlgorithm_InvalidDiceRoll() {
        // Test invalid dice rolls
        String unknownAlgorithm1 = controller.getSortingAlgorithm(0);
        String unknownAlgorithm2 = controller.getSortingAlgorithm(7);

        // Assert unknown sorting algorithm
        assertEquals("Unknown Sorting Algorithm", unknownAlgorithm1);
        assertEquals("Unknown Sorting Algorithm", unknownAlgorithm2);
    }

    @Test
    void testGetSortingStrategy_ValidSortMethod() {
        // Test valid sort methods for each algorithm
        SortingStrategy strategy1 = controller.getSortingStrategy("Bubble Sort");
        SortingStrategy strategy2 = controller.getSortingStrategy("Insertion Sort");
        SortingStrategy strategy3 = controller.getSortingStrategy("Merge Sort");
        SortingStrategy strategy4 = controller.getSortingStrategy("Quick Sort");
        SortingStrategy strategy5 = controller.getSortingStrategy("Selection Sort");

        // Assert strategies are not null
        assertNotNull(strategy1);
        assertNotNull(strategy2);
        assertNotNull(strategy3);
        assertNotNull(strategy4);
        assertNotNull(strategy5);
    }

    @Test
    void testGetSortingStrategy_InvalidSortMethod() {
        // Test invalid sort method
        SortingStrategy strategy = controller.getSortingStrategy("Invalid Sort Method");

        // Assert strategy is null
        assertNull(strategy);
    }

    @Test
    void testSortArray_ValidInput() {
        // Test sorting the array using various strategies
        int[] arr = {5, 3, 2, 1, 4};
        SortingStrategy strategy1 = new BubbleSort();
        SortingStrategy strategy2 = new InsertionSort();
        SortingStrategy strategy3 = new MergeSort();
        SortingStrategy strategy4 = new QuickSort();
        SortingStrategy strategy5 = new SelectionSort();

        // Assert sorted arrays match the expected result
        int[] sortedArray1 = controller.sortArray(arr, strategy1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray1);

        int[] sortedArray2 = controller.sortArray(arr, strategy2);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray2);

        int[] sortedArray3 = controller.sortArray(arr, strategy3);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray3);

        int[] sortedArray4 = controller.sortArray(arr, strategy4);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray4);

        int[] sortedArray5 = controller.sortArray(arr, strategy5);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray5);
    }

    @Test
    void testSortArray_NullArray() {
        // Test sorting a null array
        SortingStrategy strategy = new MergeSort();
        int[] sortedArray = controller.sortArray(null, strategy);

        // Assert empty array is returned
        assertArrayEquals(new int[0], sortedArray);
    }

    @Test
    void testSortArray_EmptyArray() {
        // Test sorting an empty array
        int[] arr = {};
        SortingStrategy strategy = new QuickSort();
        int[] sortedArray = controller.sortArray(arr, strategy);

        // Assert empty array is returned
        assertArrayEquals(new int[0], sortedArray);
    }

    @Test
    void testSortArray_NullStrategy() {
        // Test sorting with a null strategy
        int[] arr = {5, 3, 2, 1, 4};
        int[] sortedArray = controller.sortArray(arr, null);

        // Assert empty array is returned
        assertArrayEquals(new int[0], sortedArray);
    }

    @Test
    void testParseInputArray_ValidInput() {
        // Test parsing a valid input array
        String input = "5 3 2 1 4";
        int[] arr = controller.parseInputArray(input);

        // Assert parsed array matches the expected result
        assertArrayEquals(new int[]{5, 3, 2, 1, 4}, arr);
    }

    @Test
    void testParseInputArray_InvalidInput() {
        // Test parsing an invalid input array
        String input = "5 3 a 1 4";
        int[] arr = controller.parseInputArray(input);

        // Assert parsed array is null
        assertNull(arr);
    }
}
