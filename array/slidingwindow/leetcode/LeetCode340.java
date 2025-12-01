package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode340 {
    /*
     * 340. Longest Substring with At Most K Distinct Characters (PREMIUM)
     *
     * Question:
     * Given a string s and an integer k, return the length of the longest substring
     * that contains at most k distinct characters.
     *
     * Why Sliding Window?
     * Because we are looking for a contiguous substring that satisfies a certain
     * condition (having at most k distinct characters). Sliding window allows us
     * to efficiently explore all possible substrings without having to generate
     * them explicitly.
     *
     * Examples:
     * 1) s = "eceba",  k = 2 -> 3   // "ece"
     * 2) s = "aa",     k = 1 -> 2   // "aa"
     * 3) s = "abaccc", k = 2 -> 4   // "accc"
     *
     * Credits: Problem and examples from LeetCode.
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength = 0;
        int windowStart = 0;
        int n = s.length();
        //  Instead of an array, we use a HashMap to store character frequencies because the input string can contain any Unicode characters, not just lowercase English letters. Even so if it were of size 26, we would have to iterate n * 26.
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);

            // Shrink the sliding window, as long as we have more than 'k' distinct characters in the charFrequencyMap
            while (charFrequencyMap.size() > k) {
                char leftChar = s.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);

                // Remove the character from the map if its frequency becomes zero, because map size should reflect the number of distinct characters.
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++;
            }

            // At this point we will have the valid window, so we can update the maximum length if its size is larger than previous maximum length.
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
/* 
 * Key Takeaway (Line 43): When occurrences are zero, that means that character is no longer in the current window, so we must remove it from the map to keep the size accurate. 
 *
 * Time Complexity: O(n + n) = O(n) - The outer for loop runs for all characters, 
 * and the inner while loop processes each character at most once.
 * 
 * Space Complexity: O(k) - The HashMap stores at most 'k' characters.
 */