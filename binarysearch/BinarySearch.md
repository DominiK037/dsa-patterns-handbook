# Binary Search


## Cache This Into Mind

- We use binary search to find an index of an specific element, check if the element is present or not.

- To apply binary search at a first place, a collection/input needs to be sorted.

- Binary search is way faster than linear search. Instead of checking every element one by one like linear search, binary search divides a search place in half each time.

- How it works?
    - Pick the middle element.
    - If it's equal to the target, you found it.
    - If the target is smaller, search the left half of the middle.
    - If the target is larger, search the right half of the middle.
    - Keep halving until the target is found or the range becomes empty.

- **Time Complexity:** `O(log N)` because we halve the search range each step.

- **Space Complexity:** `O(1)` because we only use a few variables, no extra data structures.

- Resources I followed:
    1. Watch any good tutorial on a YouTube, binary seach is easy to learn!

    2. Basic binary search questions:

        1. [Search Insert Position (35)](https://leetcode.com/problems/search-insert-position/description/) | LeetCode | Easy | [Solution](/binarysearch/leetcode/LeetCode35.java) |

    3. Pattern: [Modified Binary Search](/binarysearch/modifiedbinarysearch/ModifiedBinarySearch.md)