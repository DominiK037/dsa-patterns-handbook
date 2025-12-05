[← Back](/array/Array.md)

# Pattern: Merge Intervals

**If you are dealing with ranges, time slots, or scheduling, you must sort first.** Without sorting, you are stuck comparing every interval against every other interval, resulting in an unacceptable $O(N^2)$ complexity. The Merge Intervals pattern is about establishing order so you can process linear data in a single pass. It is strictly a geometry problem on a 1D line.

-----

## The Core Concept

The entire efficiency of this pattern relies on one fact: **Data must be sorted by Start Time.**

Once sorted, you guarantee that for any two intervals $A$ and $B$ (where $A$ comes before $B$), $A.start \le B.start$. This eliminates half the complexity. You no longer care about $B$ starting before $A$. You only need to check if $A$ ends *after* $B$ starts to determine an overlap.

### Why it works

By processing intervals in sorted order, you can maintain a "running merged interval." You either **extend** the current interval or **close** it and start a new one. You never have to look backward.

-----

## The Logic (Step-by-Step)

1. **Sort:** Sort the list of intervals on the **start time** (ascending).
2. **Initialize:** Create a `result` list. Add the first interval to it.
3. **Iterate:** Loop through the remaining intervals from the input.
      * Let `last_merged` be the last interval in your `result` list.
      * Let `current` be the interval you are currently visiting.
4. **Compare:**
      * **Case 1: Overlap.** If `current.start` $\le$ `last_merged.end`:
          * They overlap (or touch).
          * **Action:** Merge them. Update `last_merged.end` to be the maximum of both end times: `max(last_merged.end, current.end)`.
      * **Case 2: No Overlap.** If `current.start` $>$ `last_merged.end`:
          * They are disjoint.
          * **Action:** Add `current` to the `result` list. It becomes the new `last_merged`.

**Visual:**

```text
Sorted Input: [[1, 4], [2, 5], [7, 9]]

Step 1: Initialize result with [1, 4]

Step 2: Compare [1, 4] with [2, 5]
        2 <= 4 (Overlap!)
        New End = max(4, 5) -> 5
        Result is now [[1, 5]]

Step 3: Compare [1, 5] with [7, 9]
        7 > 5 (No Overlap)
        Push [7, 9] to result
        Result is now [[1, 5], [7, 9]]
```

-----

## When to Use

Apply this immediately if the problem mentions:

1. **Overlapping Items:** "Merge overlapping intervals," "Insert a new interval," "Find mutual free time."
2. **Scheduling/Events:** "Minimum meeting rooms required," "Maximum CPU load."
3. **Disjoint Sets:** "Find the union of these ranges."

-----

## Complexity Analysis

* **Time Complexity:** $O(N \log N)$
  * *Reason:* The logic itself is linear $O(N)$, but you cannot skip the sorting step which costs $O(N \log N)$. If the input is already sorted, it is $O(N)$.

* **Space Complexity:** $O(N)$
  * *Reason:* In the worst case (no overlaps), your output list will store all original intervals.

-----

## Common Pitfalls

* **The "Touching" Edge Case:** Does $[1, 2]$ and $[2, 3]$ overlap? In 99% of interview questions, **yes**. Your condition must use `<=` (less than or equal to), not just `<`. If you miss this, you fail the test cases.
* **Forgetting to Update End Time Correctly:** When merging, we often just set `end = current.end`. **Wrong.** You must take `max(last.end, current.end)` because the first interval might completely engulf the second (e.g., $[1, 10]$ and $[2, 3]$ merges to $[1, 10]$, not $[1, 3]$).
* **Modifying Input:** Clarify if you can sort the input array in-place. If the interviewer says the input is "read-only" or part of a stream, you must create a copy before sorting, increasing space complexity.

-----

## Resources I followed

* I learned this pattern from [Chanda-Abdul's Repository](https://github.com/Chanda-Abdul/Interview-Preparation) suggested by my mentor [Rishi Prakash](https://www.linkedin.com/in/rishi-prakash-developer/)

* I will add questions with answers as I solve them again!
