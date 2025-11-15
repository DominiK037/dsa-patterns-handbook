[← Go back](/sorting/Sorting.md)

# Quick Sort

### Pivot Selection

- Quicksort needs one element as the pivot.

- **Options:** first, middle, or last element.

- Most examples use the **last element** as the pivot because the logic stays simple.


### Partition Goal

- We want to place the pivot at its final sorted position.

- After partitioning:
    - Left side → all values are smaller than pivot
    - Right side → all values are greater or equal to pivot

- These two halves will be sorted again using **recursion**.


### Iteration Steps

- Let the last element be the `pivot`

- Use two pointers:
    - `i` → index of the “boundary” for smaller elements (starts at -1)
    - `j` → iterator that scans the array (starts at 0)

- As `j` moves forward:

    - If `array[j] < pivot`
        - Increase `i`
        - Swap `array[i]` 🔄 `array[j]` using temporary variable `temp`

    - If `array[j] >= pivot`
        - Do nothing, just move `j`

- When `j` finishes scanning and reaches the `pivot`:
    - Place `pivot` in the correct position by swapping: `swap(array[i + 1], pivot)`
    - `pivot` is now at index `i + 1` which is called as a **Resting Position**


### Why this works

- All elements before `i` are guaranteed smaller than pivot.

- All elements after `pivot` are guaranteed greater or equal.

- No ordering is needed inside these halves, recursion handles that later.


### Recursive Functioning

- Left part: `0` → `pivotIndex - 1`

- Right part: `pivotIndex + 1` → `end`

- Apply the same quicksort logic on both halves.

- **Base case:** sub-array of size `0` or `1` → because they are already sorted.


### Time & Space Complexity of Quicksort

- Time Complexity: 
    - Average -> `O(n log n)`, because Random inputs typically behave close to balanced splits.
    - Worst -> `O(n²)`, because of unbalanced partitions. For example, in a sorted array, if the first or last element is always chosen as the pivot, one partition will have `(n - 1)` elements and the other will have `(0)` elements, leading to a degenerate recursion tree. Recursion will look more like a linked list, aka **skew tree**.

- Space Complexity:
    - Average -> `O(log n)`, because the pivot selection results in a nearly balanced tree.
    - Worst -> `O(n)`, call stack grows as deep as the number of elements.
