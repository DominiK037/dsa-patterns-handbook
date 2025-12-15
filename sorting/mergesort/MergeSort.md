[← Go Back To Sorting](/sorting/Sorting.md)

-----

# Merge Sort

**Merge Sort is the definition of consistency.** Unlike Quick Sort, which can degrade to $O(N^2)$ if you are unlucky, Merge Sort guarantees $O(N \log N)$ performance regardless of the input.

* **The Trade-off:** It is **not in-place**. You pay for this consistency with $O(N)$ extra memory.
* **The Niche:** It is the absolute **best** algorithm for sorting **Linked Lists** (because it doesn't require random access) and for **External Sorting** (sorting massive files on disk).

-----

## The Core Concept

Merge Sort uses the **Divide and Conquer** strategy.

1. **Divide:** Cut the array in half repeatedly until you have $N$ sub-arrays of size 1 (An array of 1 element is technically sorted).
2. **Conquer (Merge):** Systematically merge these small sorted sub-arrays back together into larger sorted arrays until the entire array is rebuilt.

### Why it works

The heavy lifting happens during the **Merge** phase. Merging two *already sorted* arrays is extremely fast ($O(N)$) using the **Two Pointers** pattern. You compare the head of both arrays, pick the smaller one, and move on.

-----

## The Logic (Step-by-Step)

1. **Base Case:** If the list has 0 or 1 elements, return it. It is sorted.
2. **Split:** Find the middle index.
      * `Left = mergeSort(0 to middle)`
      * `Right = mergeSort(middle + 1 to end)`
3. **Merge:**
      * Create a temporary array (or list).
      * Use two pointers (`i` for Left, `j` for Right).
      * Compare `Left[i]` and `Right[j]`.
      * Add the smaller value to the result and increment its pointer.
      * **Cleanup:** If one list runs out, copy the remaining elements of the other list to the result.

**Visual:**

```text
Input: [38, 27, 43, 3]

1. Divide: [38, 27] and [43, 3]
2. Divide: [38] [27]   [43] [3]  <-- Base Case Reached

3. Merge (38 vs 27): [27, 38]
4. Merge (43 vs 3):  [3, 43]

5. Final Merge ([27, 38] vs [3, 43]):
   - Compare 27, 3 -> Pick 3
   - Compare 27, 43 -> Pick 27
   - Compare 38, 43 -> Pick 38
   - Left empty, take remaining 43 -> Pick 43
   
Result: [3, 27, 38, 43]
```

-----

## When to Use (The Checklist)

Use Merge Sort if:

1. **Linked Lists:** You are asked to sort a Linked List in $O(N \log N)$. Merge Sort doesn't need to jump around memory (random access), so it outperforms Quick Sort here.
2. **Stability is Critical:** You need to preserve the order of duplicates. Merge Sort is naturally stable.
3. **Predictability:** You cannot afford a "bad pivot" slowing down your system (Quick Sort's worst case).
4. **External Sorting:** The data is too big for RAM. You sort chunks in memory, write to disk, and then merge the files.

-----

## Complexity Analysis

* **Time Complexity:** $O(N \log N)$ (Always)
  * *Reason:* You split the array $\log N$ times (depth of recursion). At every level of the split, you iterate through $N$ elements to merge them. Total = $N \times \log N$.
* **Space Complexity:** $O(N)$
  * *Reason:* You must create temporary arrays to hold the split data before merging. This is its biggest weakness compared to Quick Sort or Heap Sort.

-----

## Common Pitfalls

* **Memory Overhead:** Do not use Merge Sort for simple integer arrays in a memory-constrained embedded system. The $O(N)$ space is expensive. Use Heap Sort or Quick Sort instead.
* **The "In-Place" Myth:** Interviewers might ask "Can you implement in-place Merge Sort?" The answer is technically "Yes," but it is incredibly complex and slow to implement. The standard answer is "No, standard Merge Sort is out-of-place."
* **Small Arrays:** For very small arrays (e.g., size \< 10), the recursion overhead makes Merge Sort slower than simple Insertion Sort. This is why Java's `Timsort` is a hybrid: it uses Merge Sort for big chunks and Insertion Sort for small chunks.

-----

## Resources

* Only [Merge Sort Explanation](https://www.youtube.com/watch?v=3j0SWDX4AtU) you are seeking.
* LeetCode | [Sort an array (912) ](https://leetcode.com/problems/sort-an-array/description/)| Medium | [Solution](/sorting/mergesort/LeetCode912.java) |
