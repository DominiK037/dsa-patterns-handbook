package binarysearch.leetcode;

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middleIndex = left + (right - left) / 2;
            int middle = nums[middleIndex];

            if (target == middle) {
                return middleIndex;
            } else if (target > middle) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }
        }

        return left;
    }
}

// Problem Link: https://leetcode.com/problems/search-insert-position/description/
// Time Complexity: O(log N)
// Space Complexity: O(1)