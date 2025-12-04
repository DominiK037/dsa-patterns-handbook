package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode76 {
    /**
     * 76. Minimum Window Substring
     *
     * Why sliding window?
     * We can make a substring by creating a window. We can keep searching for the valid substring by expanding the window, and when we get the valid substring then we can start making substring smaller by shrinking the window.
     * Example: s = "ADOBECODEBANC", t = "ABC" Output: "BANC"
     */
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // Build frequency map of characters needed from t
        Map<Character, Integer> neededCharMap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            neededCharMap.merge(ch, 1, Integer::sum);
        }

        int neededCharCount = neededCharMap.size();
        int formedCharCount = 0;

        // Sliding window variables
        Map<Character, Integer> windowCharMap = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int minWindowLength = Integer.MAX_VALUE;
        int substringStart = 0;
        
        while (windowEnd < s.length()) {
            // Expand window by adding current character
            char currentChar = s.charAt(windowEnd);
            windowCharMap.merge(currentChar, 1, Integer::sum);

            // Check if current character completes a needed character count
            if (neededCharMap.containsKey(currentChar) && 
                windowCharMap.get(currentChar).intValue() == neededCharMap.get(currentChar).intValue()) {
                formedCharCount++;
            }

            // Shrink window while all characters are present
            while (windowStart <= windowEnd && neededCharCount == formedCharCount) {
                // Update minimum window if current window is smaller
                if (windowEnd - windowStart + 1 < minWindowLength) {
                    minWindowLength = windowEnd - windowStart + 1;
                    substringStart = windowStart;
                }

                // Remove leftmost character and shrink window
                char leftChar = s.charAt(windowStart);
                windowCharMap.merge(leftChar, -1, Integer::sum);

                // Check if removing leftChar breaks the valid window
                if (neededCharMap.containsKey(leftChar) && 
                    windowCharMap.get(leftChar).intValue() < neededCharMap.get(leftChar).intValue()) {
                    formedCharCount--;
                }

                windowStart++;
            }
            
            windowEnd++;
        }
        
        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(substringStart, substringStart + minWindowLength);
    }
}
/*
 * Key Takeaways:
 *  Critical Detail During Shrinking:
 *    - When removing a character from the left, check if it's a "needed" character.
 *    - If the character's count in the window equals the needed count, removing it breaks validity.
 *    - If the character's count exceeds the needed count, we can safely remove it without 
 *      affecting the window's validity (extra occurrences don't matter).
 * 
 * Time Complexity: O(N + M) where N = length of s, M = length of t
 *    - O(M) to build the frequency map from string t
 *    - O(2N) to traverse string s with the sliding window (each character visited at most twice)
 *    - Overall: O(2N + M) which simplifies to O(N) when N >> M
 * 
 * Space Complexity: O(N + M) where N = unique characters in s, M = unique characters in t
 *    - neededCharMap stores unique characters from t: O(M)
 *    - windowCharMap stores unique characters from current window: O(min(N, window_size))
 *    - In worst case, if all characters are unique: O(N + M)
 *    - Overall: O(N + M) which is linear space complexity
 */