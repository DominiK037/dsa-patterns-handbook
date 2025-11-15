package binarysearch;

public class BinarySearch {

    public static int getIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            //  (right - left) is to prevent integer overflow
            int middleIndex = left + (right - left) / 2;
            int middle = arr[middleIndex];

            if (target == middle) {
                return middleIndex;
            } else if (target > middle) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }

        return -1; // Target not found
    }

    //  Test the binary search implementation
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int target = 7;
        int index = getIndex(arr, target);
        if (index != -1) {
            System.out.println("Target " + target + " found at index: " + index);
        } else {
            System.out.println("Target " + target + " not found in the array.");
        }
    }
}