package sorting.mergesort;

public class LeetCode912 {
    //  Test the merge sort implementation
    public static void main(String[] args) {
        int[] nums = {5, 1, 1, 2, 0, 0};
        int[] nums1 = {1};
        int[] nums2 = {3, 2, 1, 5, 6, 4};
        int[] nums3 = {38, 27, 43, 3, 9, 82, 10};
        int[] nums4 = {};

        mergeSort(nums4);

        for (int num : nums4) {
            System.out.print(num + " ");
        }
    }

    private static void mergeSort(int[] nums) {
        int totalLength = nums.length;

        //  Base case: If the array has 0 or 1 element, there's nothing to sort
        if (totalLength <= 1) {
            return;
        }
        
        //  Merge sort utility
        int middle = totalLength / 2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[totalLength - middle];
        //  Separate indices to fill left and right array
        int leftIndex = 0, rightIndex = 0;

        //  Copy the elemennts of the original array into left and right arrays
        for (int i = 0; i < totalLength; i++) {
            if (i < middle) {   //  Fill left array
                leftArray[leftIndex++] = nums[i];
            } else {    //  Fill right array
                rightArray[rightIndex++] = nums[i];
            }
        }

        mergeSort(leftArray);   //  Left half will be sorted first
        mergeSort(rightArray);  //  Then right half will be sorted
        merge(leftArray, rightArray, nums);  //  Finally merge the two sorted halves
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] originalArray) {
        int totalLength = originalArray.length;
        //  Not putting lengths of leftArray and rightArray because each recursion call will have different lengths, hence using totalLength!
        int leftArrayLength = totalLength / 2;
        int rightArrayLength = totalLength - leftArrayLength;

        //  Separate indices to track positions in original, left and right arrays
        int originalIndex = 0, leftIndex = 0, rightIndex = 0;

        //  As long as there are elements in both left & right arrays, we will continue merging
        while (leftIndex < leftArrayLength && rightIndex < rightArrayLength) {
            //  For ease of reading
            int leftElement = leftArray[leftIndex];
            int rightElement = rightArray[rightIndex];

            //  Compare left and right elements then put the smaller one into the original array
            if (leftElement <= rightElement) {  //  Keeping = sign to maintain orginal order for equal elements (stable sort)
                originalArray[originalIndex++] = leftElement;
                leftIndex++;
            } else {
                originalArray[originalIndex++] = rightElement;
                rightIndex++;
            }
        }
        //  If there are remaining elements in left array, add them to original array
        while (leftIndex < leftArrayLength) {
            originalArray[originalIndex++] = leftArray[leftIndex++];
        }
        //  If there are remaining elements in right array, add them to original array
        while (rightIndex < rightArrayLength) {
            originalArray[originalIndex++] = rightArray[rightIndex++];
        }
    }
}
