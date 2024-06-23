// Quick Sort is a highly efficient sorting algorithm in practice, especially when implemented with optimizations like choosing a better pivot (e.g., median-of-three) and using iterative approaches to reduce the call stack depth.

// Time Complexity:

// Best Case: O(n log n)
// This occurs when the pivot divides the array into two nearly equal halves at each step.
// The recurrence relation is T(n) = 2T(n/2) + O(n), which solves to O(n log n).

// Average Case: O(n log n)
// On average, the pivot will divide the array into reasonably balanced partitions.
// The recurrence relation remains similar to the best case, leading to O(n log n) complexity.

// Worst Case: O(n^2)
// This occurs when the pivot is the smallest or largest element each time, resulting in highly unbalanced partitions.
// The recurrence relation becomes T(n) = T(n-1) + O(n), which solves to O(n^2).
// This can happen if the array is already sorted or if all elements are identical.

// Space Complexity: O(n)

// In-Place: Quick Sort is an in-place sorting algorithm, meaning it does not require extra space proportional to the input size.

// Auxiliary Space: The space complexity is primarily due to the recursive call stack.
// In the best and average cases, the depth of the recursive call stack is O(log n), leading to O(log n) auxiliary space.
// In the worst case, the depth of the recursive call stack can be O(n), leading to O(n) auxiliary space.

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        int n = array.length;

        quickSort(array, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (or pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
