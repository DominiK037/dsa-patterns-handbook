package array.slidingwindow.leetcode;

import java.util.Arrays;

public class LeetCode567 {

    public static boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length();
        int s2Length = s2.length();

        // s1 cannot be a permutation of s2 if it's longer
        if (s1Length > s2Length) {
            return false;
        }

        // Frequency arrays for characters 'a' to 'z'
        int[] s1CharCount = new int[26];
        int[] s2CharCount = new int[26];

        // Build frequency map for s1
        for (int i = 0; i < s1Length; i++) {
            s1CharCount[s1.charAt(i) - 'a']++;
        }

        // Sliding window over s2
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s2Length; windowEnd++) {
            // Add character to window
            char endChar = s2.charAt(windowEnd);
            s2CharCount[endChar - 'a']++;

            // Shrink window if it exceeds s1 length
            while (windowEnd - windowStart + 1 > s1Length) {
                char startChar = s2.charAt(windowStart++);
                s2CharCount[startChar - 'a']--;
            }

            // Check if current window matches s1 permutation
            if (Arrays.equals(s1CharCount, s2CharCount)) {
                return true;
            }
        }

        return false;
    }
}
/*
 * Time Complexity: O(n) where n is the length of s2. We traverse s2 with the sliding window. We are using Arrays.equals which takes O(26) = O(1) time for each window position.
 * Space Complexity: O(1) since the character count arrays have a fixed size of 26.
 */