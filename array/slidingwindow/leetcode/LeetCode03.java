package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode03 {
    /*
     * 3. Longest Substring Without Repeating Characters
     *  
     * Why use Sliding Window?
     * - We need to find the longest continuous substring where all characters are unique
     * - Sliding window lets us check substrings efficiently by:
     *   1. Expanding the window (add new characters)
     *   2. Shrinking the window (remove characters when duplicates are found)
     * - This avoids checking every possible substring separately
     */
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int windowStart = 0;
        int n = s.length();
        
        // Using a HashMap to store character frequencies because the input string can contain any Unicode characters, not just lowercase English letters.
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < n; windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            // If the character is already in the map, move the start of the window
            if (charIndexMap.containsKey(rightChar)) {
                // Be aware of cases like "abba", when windowStart is pointing to 'a' and windowEnd is pointing to second 'b'. We should update windowStart to the index after the first 'b' (i.e., index 2) and not to index 1. That's why we use Math.max here to ensure windowStart only moves forward.
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar) + 1);
            }

            // Update or add the character's latest index
            charIndexMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
/*
 * Key Takeaways (Line 30): windowStart should only move forward to avoid shrinking the window incorrectly. 
 * Dry run with examples like "abba", "abcabcbb" to understand this behavior.
 *
 * Time Complexity: O(n + n) = O(n) - The outer for loop runs for all characters, 
 * and the inner operations (map lookups and updates) are O(1).
 * 
 * Space Complexity: O(min(m, n)) - The HashMap stores at most 'min(m, n)' characters, 
 * where 'm' is the size of the character set and 'n' is the length of the string.
 */