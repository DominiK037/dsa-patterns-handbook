package array.slidingwindow.leetcode;

public class LeetCode424 {
    /* 
     * 424. Longest Repeating Character Replacement
     *
     * Why sliding window?
     * Because we need to find the longest substring that has the same character after performing at most k replacements. 
     * Meaning we can expand and contract our window based on the number of replacements remaining over the max frequency of a original * single character in the window.
     */
    public static int characterReplacement(String s, int k) {
        int windowStart = 0, maxFreq = 0, maxLength = 0;

        //  Using an array instead of a map, because input has only uppercase English letters (A-Z).
        int[] charCount = new int[26];

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char currentChar = s.charAt(windowEnd);
            charCount[currentChar - 'A']++;
            maxFreq = Math.max(maxFreq, charCount[currentChar - 'A']);

            // Shrink the window if the number of characters to change exceeds k
            if (windowEnd - windowStart + 1 - maxFreq > k) {
            char leftChar = s.charAt(windowStart++);
            charCount[leftChar - 'A']--;
            }

            // Update the maxLength for the valid window
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
/*
 * Time Complexity: O(N) where N is the length of the string s. We traverse the string once with the windowEnd pointer.
 * Space Complexity: O(1) because the charCount array has a fixed size of 26, regardless of the input size.
 */