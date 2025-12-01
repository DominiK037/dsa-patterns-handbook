package array.slidingwindow.leetcode;

import java.util.*;

public class LeetCode904 {
    /*
     * 904. Fruit Into Baskets
     * Why Sliding Window?
     * Problem says we have to pick fruits such that we can only have at most 2 different types of fruits in our baskets.
     * A sliding window approach is suitable here as it allows us to dynamically adjust the window size
     * while keeping track of the count of different fruit types within the window. To be specific,
     * we can expand the window by adding fruits until we exceed 2 types, and then shrink the window from the start
     * until we are back to having at most 2 types. This way, we can efficiently find the maximum number of fruits we can collect.
     */
    public static int totalFruit(int[] fruits) {
        int maxFruits = 0;
        int windowStart = 0;
        Map<Integer, Integer> fruitCountMap = new HashMap<>();

        for (int windowEnd = 0; windowEnd < fruits.length; windowEnd++) {
            //  Integer::sum is used here to increment the count of the fruit type based on its current count in the map.
            //  Integer::sum(oldValue, newValue) -> oldValue + newValue
            fruitCountMap.merge(fruits[windowEnd], 1, Integer::sum);

            //  shrink the window until we have at most 2 distinct fruits
            while (fruitCountMap.size() > 2) {
                int count = fruitCountMap.get(fruits[windowStart]) - 1;
                if (count == 0) {
                    fruitCountMap.remove(fruits[windowStart]);
                } else {
                    fruitCountMap.put(fruits[windowStart], count);
                }
                windowStart++;
            }

            maxFruits = Math.max(maxFruits, windowEnd - windowStart + 1);
        }

        return maxFruits;
    }
}
/**
 * Key Takeaways (Line 23): Map's merge function is a concise way to update counts in the map.
 * It handles both the case where the key is already present and where it is not, simplifying the code.
 *
 * Time Complexity: O(n + n) = O(n) - We traverse the array once with the windowEnd pointer 
 * and at most once with the windowStart pointer.
 *
 * Space Complexity: O(1) - The size of the fruitCountMap is at most 3 (since we only allow 
 * 2 types of fruits, and we may temporarily have a third type before shrinking the window).
 */