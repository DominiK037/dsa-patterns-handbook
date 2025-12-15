[← Go Back To Sorting](/sorting/Sorting.md)

-----

# Quick Sort

**Quick Sort is the standard for a reason.** It is usually the fastest sorting algorithm in practice because it is cache-friendly and runs **in-place** (saving the $O(N)$ memory cost of [Merge Sort](https://www.google.com/search?q=/sorting/mergesort/MergeSort.md)).

* **The Gamble:** It is **unstable** and has a catastrophic worst-case time complexity of $O(N^2)$ if you pick a bad pivot (e.g., sorting an already sorted array).
* **The Fix:** Randomize your pivot or use "Median-of-Three" to virtually guarantee $O(N \log N)$.

-----

## The Core Concept

Quick Sort works on the **Divide and Conquer** principle, but unlike Merge Sort, the heavy lifting happens *before* the recursion, during the **Partitioning** phase.

1. **Pick a Pivot:** Select one element to be the "judge."
2. **Partition:** Reorder the array so that all elements **smaller** than the pivot are on the left, and all elements **larger** are on the right. The pivot is now in its final, correct sorted position.
3. **Recurse:** Apply the same steps to the left sub-array and the right sub-array.

### Why it works

Once a pivot is placed, it never moves again. You solve the problem by progressively locking elements into their correct indices.

-----

## The Logic (Lomuto Partitioning)

There are two main ways to partition (Lomuto vs. Hoare). Lomuto is easier to implement in interviews but slightly slower (more swaps).

1. **Pivot Selection:** Let's say we pick the **last element** as the pivot.
2. **Pointers:** Start a pointer `i` at `low - 1`. Iterate `j` from `low` to `high - 1`.
3. **Compare:**
      * If `arr[j] < pivot`: Increment `i` and swap `arr[i]` with `arr[j]`. (This moves smaller elements to the "safe zone" on the left).
4. **Final Swap:** After the loop, swap the pivot (`arr[high]`) with `arr[i + 1]`.
5. **Return:** Return the index `i + 1` (the pivot's new location).

**Visual:**

```text
Array: [10, 80, 30, 90, 40]  Pivot: 40 (Last element)

1. Compare 10 vs 40: Smaller. Swap to front.
2. Compare 80 vs 40: Larger. Ignore.
3. Compare 30 vs 40: Smaller. Swap to position after 10.
   Array state: [10, 30, 80, 90, 40]
4. Compare 90 vs 40: Larger. Ignore.

5. Place Pivot: Swap 40 with first larger element (80).
   Final: [10, 30, 40, 90, 80]
           ^       ^
         Left     Right
```

-----

## When to Use (The Checklist)

Use Quick Sort if:

1. **Arrays:** You are sorting arrays in memory (RAM).
2. **Memory is Tight:** You cannot afford the $O(N)$ extra space required by [Merge Sort](/sorting/mergesort/MergeSort.md). Quick Sort is $O(\log N)$ space (stack only).
3. **Stability Doesn't Matter:** You don't care if the relative order of equal elements is lost.

-----

## Complexity Analysis

* **Time Complexity:**
  * **Average Case:** $O(N \log N)$.
  * **Worst Case:** $O(N^2)$. This happens if your pivot is always the smallest or largest element (e.g., sorting `[1, 2, 3, 4, 5]` and picking the last element as pivot).
* **Space Complexity:** $O(\log N)$.
  * *Reason:* It is strictly the recursion stack depth. It does not use an auxiliary array.

-----

## Common Pitfalls

* **The "Sorted Array" Trap:** If you blindly pick the first or last element as a pivot, and the input is *already sorted* (or reverse sorted), Quick Sort degrades to **Bubble Sort** speeds ($O(N^2)$). You will timeout.
  * *Fix:* Pick a random pivot or use the middle element.
* **Stability:** If an interviewer asks to sort a list of `Transactions` by `Date` and then by `Amount` using Quick Sort, you will fail because the second sort might shuffle the dates. Use [Merge Sort](/sorting/mergesort/MergeSort.md) for that.
* **Arrays vs. Linked Lists:** Do not use Quick Sort for Linked Lists. Partitioning a Linked List is awkward and slow compared to Merge Sort's simple pointer manipulation.

-----

### Resources

* [Understand QuickSort inside & out.](https://www.youtube.com/watch?v=Vtckgz38QHs)
* Make sure to create a mental model for worst case too .i.e sorted input.
* [Explained Code](/sorting/quicksort/QuickSort.java)
