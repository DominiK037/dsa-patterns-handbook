# Sorting

## What Sorting Is?

- Sorting is arranging or re-arranging an elements of a **similar data type** in a given collection (List, Array, Set and so on) **by some property**, usually in ascending or descending order.

- We can call a sorted collection a **permutation** of the given collection itself.

- We can only sort a collection in which all the items/elements are of the same type.

## Why Is Sorting Important?

- Sorting makes certain dataset easier to read for us humans.
- Sorting makes it easier to implement search algorithms.
- Imagine you’re trying to find a number between 1 and 100. 

    Would it be faster to find it in a random list of numbers or in an ordered list from 1 to 100?

    That’s why we sort, to make searching quicker and easier.

## Factors To Consider While Choosing Sorting Algorithm

- **Time complexity:** How much time it takes to find an element, with respect to it's input size. (Always consider a **worst case**)
- **Space complexity:** Extra memory needed for the algorithm to sort an given input.
    - **in-place O(1):** We sort an given input by changing input itself.
    - **out-of-place O(n):** We sort an given input without changing input itself by using extra space.
- **Stability:** Algorithm which preserves the relative order (order in an input) of the duplicate elements.
- **Internal vs External:** 
    - **Internal Sorting:** Data needed to be sorted can be kept in **in-memory(RAM)**
    - **External Sorting:** Data needed to be sorted should be placed in a **Disk** or **Tape(Outside RAM)** because RAM is not sufficient.
- **Recursive or Non-Recursive:** Simple as the name says it **recursive sorting (Divide & Conquer)** & **non-recursive sorting (Most sortings are non-recursive/iterative)**


## Common Sorting Algorithms

- High ROI
    - **[Merge Sort](#merge-sort)**
    - **Quick Sort**
    - **Heap Sort**
    - **Counting Sort**
    - **Radix Sort**

- Low ROI
    - Bubble Sort
    - Selection Sort
    - Insertion Sort


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

- [LeetCode | 912 | Sort an array | Medium |](https://leetcode.com/problems/sort-an-array/description/)


## Always Dry Run These Cases

- No elements
- One element
- Two elements
- Duplicate elements


## Resources I Followed:
1. [Understand Sorting](https://medium.com/basecs/sorting-out-the-basics-behind-sorting-algorithms-b0a032873add)
2. [Explore Sorting Types & Edge Cases](https://www.techinterviewhandbook.org/algorithms/sorting-searching/)
3. Solve recursion based sorting LeetCode questions & understand them inside and out!