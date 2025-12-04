package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode438 {
    /*
     * 438. Find All Anagrams in a String
     *
     * Why sliding window?
     * Because we need to find all the start indices of p's anagrams in s. An anagram is a rearrangement of letters, so we can use a sliding window
     * of size equal to p's length to check each substring of s.
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (char c : p.toCharArray()) {
            pCount[c - 'a']++;
        }

        int windowSize = p.length();
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            sCount[s.charAt(windowEnd) - 'a']++;

            //  Shrink the window if its size exceeds the size of window i.e., length of p
            if (windowEnd >= windowSize) {
                sCount[s.charAt(windowStart++) - 'a']--;
            }

            if (Arrays.equals(sCount, pCount)) {
                result.add(windowStart);
            }
        }

        return result;
    }
}
/*
 * Time Complexity: O(n) where n is the length of s. We traverse s with the sliding window. We are using Arrays.equals which takes O(26) = O(1) time for each window position.
 * Space Complexity: O(1) since the character count arrays have a fixed size of 26.
 */