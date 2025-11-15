[← Go back](/sorting/Sorting.md)

## Merge Sort

- It splits the collection into **two halves**, **sorts** each half using **recursion**, and then **merges** the two sorted halves to form one **fully sorted collection.**

- Hence it comes under a pattern known as **Divide & Conquer**.

- Steps by step explanation **(Must know recursion)**:

    Let’s take an Input example: `[6, 2, 8, 4, 1, 7]`

    1. **Divide the Collection**

        - We split the entire list into **two halves**:
            - Left half: `[6, 2, 8]`
            - Right half: `[4, 1, 7]`

        - Merge Sort works on the Divide and Conquer principle, so each half will again be divided until every sublist contains a **single element.**


    2. **Keep Dividing (Recursion)**

        - We now recursively divide each half:
            - Left half (left's last recursion stack)  `[6, 2, 8]` → `[6]`, `[2]`, `[8]`
            - Right half (right's last recursion stack) `[4, 1, 7]` → `[4]`, `[1]`, `[7]`

        - Now every sublist has just one element — this is our base case.

    3. **Start Merging Sorted Sublists**

        - Now we start merging step-by-step while keeping the lists sorted:
            - Merge `[6]` and `[2]` → `[2, 6]`
            - Merge `[2, 6]` and `[8]` → `[2, 6, 8]`

        - Left side is now sorted.

    4. **Sort the Right Half Similarly**
        - Merge `[4]` and `[1]` → `[1, 4]`
        - Merge `[1, 4]` and `[7]` → `[1, 4, 7]`

        - Right side is now sorted.

    5. **Final Merge**
        - Finally, merge the two sorted halves: `[2, 6, 8]` + `[1, 4, 7]` = `[1, 2, 4, 6, 7, 8]`

- **Time Complexity:** Merge Sort divides the list into halves (log n levels) and merges elements at each level (n work per level). So total time = **O(n log n)**.

- **Space Complexity:** It needs extra space to store temporary arrays during merging, roughly equal to the input size. So space = **O(n)**.

- **Factors:** Stable, Recursive, Out-of-Place

- Only [Merge Sort Explanation](https://www.youtube.com/watch?v=3j0SWDX4AtU) you are seeking.

- LeetCode | [Sort an array (912) ](https://leetcode.com/problems/sort-an-array/description/)| Medium | [Solution](/sorting/mergesort/LeetCode912.java) |