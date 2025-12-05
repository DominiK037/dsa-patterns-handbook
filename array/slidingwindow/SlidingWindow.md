[← Back](/array/Array.md)

# Sliding Window

- Sliding Window is a pattern used when you want to process a **contiguous range** (subarray/subsequence) inside an array or string while scanning it only once.  
- Think of it like a small frame that moves left → right, expanding or shrinking depending on conditions.
- The whole point is:  **Avoid re-computing things again and again. Reuse previous work.**

---

## Why It Exists?

- In brute-force, when you check every subarray, you repeatedly compute sums, counts, frequencies, or conditions.  
- Sliding Window says: *don’t start fresh every time, just update the window while moving.*
- This gives you **O(N)** instead of **O(N²)**.

---

## When to Use It

Use Sliding Window when:

- You need a **continuous** subarray/substring.
- The window grows and shrinks based on a **rule or constraint**.
- Problems involve words like:
  - “longest subarray…”
  - “shortest substring…”
  - “maximum sum…”
  - “at most K…”
  - “no more than K distinct characters…”
  - “contains these characters…”

---

## Two Flavours

### 1. **Fixed Window**

- Window size is known in advance.
- Example: find the max sum of a subarray of size `k`.
- Window flows like a conveyor belt:
  - Add new element entering the right.
  - Remove element exiting the left.

### 2. **Variable Window**

- Window size grows or shrinks based on a condition.  
- Example: longest substring with at most 2 distinct characters.
- Here you:
  - Expand right boundary normally.
  - Shrink left boundary when a condition breaks.

---

## One Simple Example (to lock the intuition)

### Problem (conceptual):  

Find the **maximum sum of any subarray of size 3**.

Array:  
`[2, 1, 5, 1, 3, 2]`

### How the window “slides”

1. `[2, 1, 5]` -> `sum = 8`
2. `[1, 5, 1]` -> `sum = 7`
3. `[5, 1, 3]` -> `sum = 9`
4. `[1, 3, 2]` -> `sum = 6`

Window slides by:

- Removing the leftmost number
- Adding the new rightmost number

You never recompute the full sum again.

This is the essence of sliding window.

---

## Mental Checklist (what you’ll use in every question)

- Do I need **continuous** elements?  
- Can I maintain something (sum, freq, count) while sliding?  
- Is it a **fixed** or **variable** window?  
- When should I expand? When should I shrink?

---

## Template (so you never forget)

### Fixed-size window

```java
    //  I use windowStart as a left side pointer & windowEnd as a right side pointer
    int windowStart = 0;
    int sum = 0;

    for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
        sum += nums[windowEnd];               // include new element

        if (windowEnd - windowStart + 1 == k) {      // reached window size
            // process window result
            sum -= nums[windowStart];            // remove old element
            windowStart++;
        }
    }
```

- **Time complexity:** O(n), because we are visiting each element once.
- **Space complexity:** O(1), because we are not using any extra space

### Dynamic window

```java
    int windowStart = 0;
    Map<Character, Integer> freq = new HashMap<>();

    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        char c = s.charAt(windowEnd);
        freq.put(c, freq.getOrDefault(c, 0) + 1);

        while (/* condition */) {
            char leftChar = s.charAt(windowStart);
            freq.put(leftChar, freq.get(leftChar) - 1);
            if (freq.get(leftChar) == 0) freq.remove(leftChar);
            windowStart++;  // shrink window by moving our left side pointer
        }
    }
```

- **Time complexity:** O(n), because we are visiting each element once.
- **Space complexity:** O(k), k is the size of window, because we are saving k number of elements in a map to track their frequencies

---

## Resources I followed in sequence

1. [Sliding Window Mental Model by Ryan Schachet](https://youtu.be/MK-NZ4hN7rs?si=Qc_G3bCuYifsoLMc) (Thank me later for this one!)
2. [Best sliding window explanation with questions](https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2001%20%3A%20Sliding%20Window.md)(Must visit this repo, and follow along with the questions)
3. | Easy | [Leetcode 643 - Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) | [**Solution**](./leetcode/LeetCode643.java) |
4. | Medium | [Leetcode 209 - Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) | [**Solution**](./leetcode/LeetCode209.java) |
5. | Medium | [Leetcode 340 - Longest Substring with K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/) | [**Solution**](./leetcode/LeetCode340.java) |
6. | Medium | [Leetcode 904 - Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/) | [**Solution**](./leetcode/LeetCode904.java) |
7. | Medium | [Leetcode 03 - Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) | [**Solution**](./leetcode/LeetCode03.java) |
8. | Medium | [Leetcode 424 - Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/) | [**Solution**](./leetcode/LeetCode424.java) |
9. | Medium | [Leetcode 1004 - Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) | [**Solution**](./leetcode/LeetCode1004.java) |
10. | Medium | [Leetcode 567 - Permutation in String](https://leetcode.com/problems/permutation-in-string/) | [**Solution**](./leetcode/LeetCode567.java) |
11. | Medium | [Leetcode 438 - Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) | [**Solution**](./leetcode/LeetCode438.java) |
12. | Hard | [Leetcode 76 - Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/) | [**Solution**](./leetcode/LeetCode76.java) | *Good Question To Revise* |
13. | Hard | [Leetcode 30 - Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) | [**Solution**](./leetcode/LeetCode30.java) |
