// The binary search algorithm splits the array into halves in each recursive call.
// The maximum number of splits required to find the target or determine its absence is log2(n), where n is the number of elements in the array.
// Therefore, the time complexity is O(log n).
// The space complexity of a recursive algorithm includes the space required by the recursive call stack.
// For each recursive call, a new stack frame is created, and the maximum depth of the recursive call stack is equal to the number of times the array is split, which is log2(n).
// Therefore, the space complexity due to the call stack is O(log n).

public class BinarySearch {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 5;

        int result = binarySearch(sortedArray, target, 0, sortedArray.length - 1);

        if (result == -1) {
            System.out.println("Element not present in the array.");
        } else {
            System.out.println("Element found at index: " + result);
        }
    }

    public static int binarySearch(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        // Check if the target is present at mid
        if (array[mid] == target) {
            return mid;
        }

        // If target is smaller, search the left subarray
        if (array[mid] > target) {
            return binarySearch(array, target, left, mid - 1);
        }

        // If target is larger, search the right subarray
        return binarySearch(array, target, mid + 1, right);
    }
}
