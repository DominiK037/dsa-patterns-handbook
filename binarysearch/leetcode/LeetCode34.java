package binarysearch.leetcode;

public final class LeetCode34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[] { -1, -1 };
        //  We are guaranteed to get the first occurrence of the target, by allowing our binary search to the left half of the target.
        result[0] = findOccurrence(nums, target, false);

        //  If the first occurrence is found, find the last occurrence of the target by allowing our binary search to the right half of the target.
        if (result[0] != -1) {
            result[1] = findOccurrence(nums, target, true);
        }

        return result;
    }

    private static int findOccurrence(int[] nums, int target, boolean findLast) {
        int start = 0;
        int end = nums.length - 1;
        int targetIndex = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = nums[mid];

            if (target < midValue) {
                end = mid - 1;
            } else if (target > midValue) {
                start = mid + 1;
            } else {
                //  Here we would get the target, so we just store the index.
                targetIndex = mid;  
                //  The fact that we are in this else{}, means we already have the target,  just need to play in left & right halves based on whether we need first or last occurrence as below!
                if (findLast) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return targetIndex;
    }
}
//  Problem Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
//  Time Complexity: O(log N) where N is the number of elements in the array.
//  Space Complexity: O(1) as we are not using any extra space, apart from a few variables which are also considered constant space.