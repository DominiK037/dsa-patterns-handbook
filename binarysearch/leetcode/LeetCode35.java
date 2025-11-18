package binarysearch.leetcode;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middleIndex = start + (end - start) / 2;
            int middle = nums[middleIndex];

            if (target == middle) {
                return middleIndex;
            } else if (target > middle) {
                start = middleIndex + 1;
            } else {
                end = middleIndex - 1;
            }
        }

        return start;
    }
}

// Problem Link: https://leetcode.com/problems/search-insert-position/description/
// Time Complexity: O(log N)
// Space Complexity: O(1)