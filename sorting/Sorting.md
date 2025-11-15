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
    - **[Merge Sort](/sorting/mergesort/MergeSort.md)**
    - **Quick Sort**
    - **Heap Sort**
    - **Counting Sort**
    - **Radix Sort**

- Low ROI
    - Bubble Sort
    - Selection Sort
    - Insertion Sort


## Always Dry Run These Cases

- No elements
- One element
- Two elements
- Duplicate elements


## Resources I Followed:
1. [Understand Sorting](https://medium.com/basecs/sorting-out-the-basics-behind-sorting-algorithms-b0a032873add)
2. [Explore Sorting Types & Edge Cases](https://www.techinterviewhandbook.org/algorithms/sorting-searching/)
3. Solve recursion based sorting LeetCode questions & understand them inside and out!