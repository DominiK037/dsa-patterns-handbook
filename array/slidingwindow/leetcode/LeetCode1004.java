package array.slidingwindow.leetcode;

public class LeetCode1004 {
    /*
     * 1004. Max Consecutive Ones III
     *
     * Why sliding window?
     * Because we need to find the longest contiguous subarray that contains only 1s even after replacing at most k 0s with 1s.
     * This means we can expand and contract our window based on the number of 0s in the current window.
     */
    public static int longestOnes(int[] nums, int k) {
        int windowStart = 0, maxLength = 0, zerosCount = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            if (nums[windowEnd] == 0) {
            zerosCount++;
            }

            while (zerosCount > k) {
            if (nums[windowStart++] == 0) {
                zerosCount--;
            }
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
/*
 * Time Complexity: O(N) where N is the length of the array nums. We traverse the array once with the windowEnd pointer & we may move the windowStart pointer at most N times inside the while loop.
 *
 * Space Complexity: O(1) because we are using only a constant amount of extra space.
 */