# Arrays

## Cache this in Mind

- Arrays hold values of same type.

- Two things we are going to need the most:
    1. Index of an element.
    2. Value of that element.

- Arrays are stored contiguously in a memory.

## Advantages

- We can save a group of multiple values of the same type with single variable name which is a reference to a **Memory Address** of the specific array.

- Since arrays are stored contiguously, accessing an elements with their indices is in constant time `O(1)`

## Disadvantages

- They have fixed size.

- In my opinion, managing elements in an array can be a bit inconvenient because it's size is fixed. Unlike dynamic data structures (like lists), arrays don’t provide built-in methods to add or remove elements. Every insertion or deletion requires writing manual logic to shift elements or update indices, which can be time-consuming & error-prone. This is one of the main disadvantages of using arrays.

## Common terms

- Common Example for all terms

    ````java
        // Index:    0  1  2  3  4
        int[] arr = {1, 2, 3, 4, 5};
    ````

- Subarray: A contiguous subset of an array.
  - **Valid** Subarray: `[1, 2, 3]`
  - **Invalid** Subarray: `[1, 3, 4]`

- Subsequence: A subset of an array in which indices of an each element are in ascending order.
  - Subsequence can be **contiguous** as well as **non-contiguous**.
  - **Valid** Subsequences: `[1, 2, 3], [2, 4, 5]`
  - **Invalid** Subsequences: `[2, 1, 3]`
  - Examples: Pairs, Triplets, Quadruplets etc.

## Time complexities

| Operation | Time Complexity | Notes |
|------------|-----------------|--------|
| **Access (by index)** | `O(1)` | Direct access using index because arrays support random access. |
| **Search (by value)** | `O(n)` | If array is sorted `O(log n)` by value & `O(1)` if index is known |
| **Insert (at end)** | `O(1)` | Only if space is available; otherwise `O(n)` due to resizing or shifting. |
| **Update (by index)** | `O(1)` | Simple overwrite operation. |
| **Traverse entire array** | `O(n)` | Visiting each element once. |
| **Sorting** | `O(n log n)` | In Java, a Dual-Pivot Quicksort is used for primitive types (`int[]`, `double[]`, etc.). |
| **Copy / Clone array** | `O(n)` | Every element must be duplicated to the new array. |
| **Reverse array** | `O(n)` | Requires swapping elements from both ends. |

## Things to look out for during interviews

- Are there duplicate values in the array?
- Is array sorted?
  - Because if the array is sorted interviewer is probably expecting solution faster than `O(n)`.
- Be extra careful for an error `index out of bounds`, make sure to build mental model prior the interview & be careful when playing around indices especially in cyclic sort!

## Corner cases

- I will list them here when I start my revision on the arrays, right now I don't remember corner cases.

## Patterns

1. [Two Pointers](./twopointer/TwoPointer.md)
2. [Sliding Window](./slidingwindow/SlidingWindow.md)
3. Sorting
4. Prefix sum (Precomputations)
5. Hashing (This is more like appying the data structure & less of pattern)
6. [Merge Intervals](mergeintervals/MergeIntervals.md)

---
