package array.slidingwindow.leetcode;

public class LeetCode209 {
    /**
     * 209. Minimum Size Subarray Sum
     * 
     * Why Sliding Window?
     * Simply because we are looking for a contiguous subarray for which
     * sliding window is a perfect fit.
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            windowSum += nums[windowEnd];
            //  shrink the window as small as possible while the window's sum is larger than or equal to target
            while (windowSum >= target) {
                //  Updating minLength here because in the last iteration of this while loop, windowStart will be pointing to the first element of the window that makes the windowSum < target.
                minLength = Math.min(minLength, windowEnd - windowStart + 1);
                windowSum -= nums[windowStart++];
            }
        }
        
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
/* Key Takeaway (Line 21): Be careful about where you update your result variable (minLength in this case).
 * 
 * Time Complexity: O(n + n) = O(n), as each element will be visited at most twice,
 * once by windowEnd and once by windowStart, i.e., by the for loop and while loop respectively.
 * 
 * Space Complexity: O(1) as we are using only constant space.
 */