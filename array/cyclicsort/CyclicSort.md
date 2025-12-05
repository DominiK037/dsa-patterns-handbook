[← Back](/array/Array.md)

-----

# Pattern: Cyclic Sort

**This is a niche hack, but it is the only way to solve specific problems in $O(N)$ time without extra space.** Use this *only* when you are given an array containing numbers within a specific range (like $1$ to $N$ or $0$ to $N$). If you see a problem asking to "find the missing number" or "find the duplicate" in a range, and you use a standard $O(N \log N)$ sort or a Hash Map ($O(N)$ space), you are suboptimal. Cyclic sort maps the value to the index.

-----

## The Core Concept

The pattern exploits the relationship between the **value** of the data and its **index**.
If you have numbers $1$ to $N$ in an array of size $N$, the number `1` belongs at index `0`, `2` belongs at index `1`, and so on.

You don't need a complex sorting algorithm. You just need to put each pigeon in its specific pigeonhole.

### Why it works

We iterate through the array. If a number is not in its correct spot, we swap it with the number that *is* currently sitting in that correct spot. We repeat this until the current position holds the correct number.

-----

## The Logic (Step-by-Step)

1. **Iterate:** Start a pointer `i` at the beginning of the array.
2. **Check Condition:**
    * Calculate the **correct index** for the value at `arr[i]`.
    * If range is $0 \dots N$, `correct_index = arr[i]`.
    * If range is $1 \dots N$, `correct_index = arr[i] - 1`.
3. **Action:**
    * **Case 1: Correctly Placed.** If `arr[i]` is already at `correct_index`, move `i` forward (`i++`).
    * **Case 2: Misplaced.** If `arr[i]` is NOT at `correct_index`, **swap** `arr[i]` with `arr[correct_index]`.
    * **CRITICAL STEP:** Do **not** increment `i` after a swap. You must re-check the new value that just landed in your current position `i` because it might also be in the wrong place.
4. **Stop:** When `i` reaches the end of the array.

**Visual:**
Range: 1 to 5.

```text
Input: [3, 1, 5, 4, 2]

Index 0: Value is 3. Correct index is 2.
         Swap index 0 and index 2 (Swap 3 and 5).
         Array: [5, 1, 3, 4, 2]

Index 0: Value is 5. Correct index is 4.
         Swap index 0 and index 4 (Swap 5 and 2).
         Array: [2, 1, 3, 4, 5]

Index 0: Value is 2. Correct index is 1.
         Swap index 0 and index 1 (Swap 2 and 1).
         Array: [1, 2, 3, 4, 5]

Index 0: Value is 1. Correct index is 0. Matches!
         Increment i.

Index 1: Value is 2. Matches! Increment i.
Index 2: Value is 3. Matches! Increment i.
...
Sorted: [1, 2, 3, 4, 5]
```

-----

## When to Use

This pattern is extremely specific. Only use it if:

1. **Fixed Range:** The problem states the input is an array containing numbers from $1$ to $N$ (or $0$ to $N$).
2. **Constraint:** Time complexity must be $O(N)$ and Space must be $O(1)$.
3. **Keywords:** "Find the missing number," "Find the duplicate number," "Find the smallest missing positive integer."

-----

## Complexity Analysis

* **Time Complexity:** $O(N)$
  * *Reason:* It looks like a loop within a loop (or recursive re-checking), but it isn't $O(N^2)$. Each number is swapped at most once to place it in its correct position. Across the entire execution, there are at most $N$ swaps.
* **Space Complexity:** $O(1)$
  * *Reason:* All operations are done in-place using swaps.

-----

## Common Pitfalls

* **The Infinite Loop (Duplicate Handling):** If the array contains duplicates (e.g., `[1, 4, 4, 3]`), your logic will try to swap the `4` at index 1 with the `4` at index 3 repeatedly if you aren't careful.
  * *Fix:* Before swapping, check if `arr[i] == arr[correct_index]`. If they are equal, you found a duplicate—skip the swap and move `i` forward (or handle the duplicate according to problem requirements).
* **0-based vs 1-based indexing:** This is the most common bug.
  * If numbers are $1 \dots N$: Correct index is `value - 1`.
  * If numbers are $0 \dots N$: Correct index is `value`.
  * Mixing these up causes `ArrayIndexOutOfBoundsException`.
* **Not a General Sort:** Do not try to use this on general arrays (e.g., `[100, 2, 50]`). It only works on dense sequences where indices map directly to values.

-----

## Resources I followed

* First I learned this from [Chanda Abdul's GitHub repo](https://github.com/Chanda-Abdul/Interview-Preparation) suggested by my mentor [Rishi Prakash](https://www.linkedin.com/in/rishi-prakash-developer/)
* I then small dry runs on a notebook to internalize the swapping logic.
* I will add questions and solutions here as I solve them again for a revision.
