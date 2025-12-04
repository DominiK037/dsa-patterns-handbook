package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode30 {
    /* 
        * 30. Substring with Concatenation of All Words [Low ROI]
        * Why sliding window?
        * To understand why sliding window is applicable here we need to lean into the depth first.
        * Any substring(of 's') must be a concatenation(combination) of all the words in a given input array: words[].
        *   About words[]:
        *   1. All words are of the same length.
        *   2. There can be duplicate words in words[].
        *   3. The sequence which, words have in array words[], does not have to be the same in the substring(of 's').
        * 
        * Core Algorithm:
        * 1. Hash the frequency of words in words[]. Map would be the best data structure for hashing because of O(1) access time.
        * 2. Let's check substrings in s starting from each character index till word length.
        * 3. For each character index, we will try to find the valid substring by sliding the window from left to right.
        * 4. The window will be slid word by word (i.e by word length) instead of character by character.
        * 5. For each word in the window, we will check if it is present in the words frequency map.
        *       - If present, we will update the visited words frequency map and check if we have a valid substring.
        *       - If not present, we will reset the visited words frequency map and move the window start to the next word.
        * 6. If we have a valid substring, we will add the starting index of the substring to the result list.
        * 7. Finally, we will return the result list containing all starting indices of valid substrings.
    */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indexList = new ArrayList<>();

        int wordSize = words[0].length();
        int totalWords = words.length;
        int sLen = s.length();

        HashMap<String, Integer> wordFreqMap = new HashMap<>();
        //  1. Build frequency map of words
        for (String word : words) {
            wordFreqMap.merge(word, 1, Integer::sum);
        }
        //  2. For each character in s, try to find the valid substring
        for (int charIndex = 0; charIndex < wordSize; charIndex++) {
            HashMap<String, Integer> visitedWordFreqMap = new HashMap<>();

            int subStringStart = charIndex;
            int validWordCount = 0;

            //  Slide window from charIndex by wordSize i.e by 3 indices in a single iteration
            for (int wordStart = charIndex; wordStart + wordSize <= sLen; wordStart += wordSize) {
                String currWord = s.substring(wordStart, wordStart + wordSize);

                // When the word is valid
                if (wordFreqMap.containsKey(currWord)) {
                    visitedWordFreqMap.merge(currWord, 1, Integer::sum);
                    validWordCount++;

                    //  Shrink window/substring from left side while updating occurrences of words, by jumping word by word
                    while (visitedWordFreqMap.get(currWord) > wordFreqMap.get(currWord)) {
                        String tempWordStart = s.substring(subStringStart, subStringStart + wordSize);
                        visitedWordFreqMap.merge(tempWordStart, -1, Integer::sum);

                        //  Update left pointer (windowStart)
                        subStringStart += wordSize;
                        //  Because we are removing words from left side, counter needs to be updated
                        validWordCount--;
                    }

                    if (validWordCount == totalWords) {
                        indexList.add(subStringStart);
                    }

                } else {    // Word does not exist in words[]
                    validWordCount = 0;
                    subStringStart = wordStart + wordSize;
                    visitedWordFreqMap.clear();
                }
            }

        }
        return indexList;
    }
}
/*
 * Time Complexity: O(N * M) where N is the length of string s and M is the number of words in the words array.
 *   - We are iterating over wordSize (which is constant for all words) and for each character index, we are sliding the window across the string s.
 * 
 * Space Complexity: O(M) where M is the number of words in the words array.
 *   - We are using two hash maps to store the frequency of words, one for the original words array and another for the visited words in the current window. Since returning the result list does not count towards extra space, we do not consider it in space complexity.
 */