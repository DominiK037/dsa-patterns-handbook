package array.slidingwindow.leetcode;

public class LeetCode643 {
    /*
     * 643. Maximum Average Subarray I
     * 
     * Why Sliding Window?
     * The problem requires finding a contiguous subarray of fixed size k that has the maximum average.
     * A sliding window approach is ideal for this scenario as it allows us to efficiently
     * maintain the sum of the current subarray of size k while iterating through the array instead of recalculating the sum from
     * scratch for each subarray.
     */
    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = (double) Integer.MIN_VALUE;
        double windowSum = (double) 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            //  add current element to the window sum
            windowSum += nums[windowEnd];
            //  check if we have hit the window size of k
            if (windowEnd >= k - 1) {
                double currentAverage = windowSum / k;
                maxAverage = Math.max(maxAverage, currentAverage);
                //  slide the window forward by removing the element on the left side
                windowSum -= nums[windowStart++];
            }
        }

        return maxAverage;
    }
}
/*
 *  Time Complexity: O(n) - We traverse the array in a single pass.
 *  Space Complexity: O(1) - Because we are not using any extra space that grows with input size.
*/