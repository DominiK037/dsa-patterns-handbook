[← Back](/array/Array.md)

# Pattern: Two Pointers

**Stop wasting time with nested loops.** If you are iterating through a linear structure (array, string, linked list) and using an $O(N^2)$ brute force approach to find a pair, triplet, or subarray, you are likely failing the interview. The Two-Pointer technique is your primary weapon to optimization, slashing time complexity to $O(N)$ by processing the data in a single pass. It relies on the data being **sorted** or having a specific **structure** (like a cycle) to work. If the data is random and unsorted, this pattern usually fails unless you sort it first.

-----

## The Core Concept

The "Two Pointers" pattern is exactly what it sounds like: using two references (indices or pointers) to traverse a data structure simultaneously. Instead of fixing one element and iterating through all others (nested loops), you move two pointers dynamically based on a condition.

### Why it works

It works because you utilize the **sorted order** or the **structure** of the data to eliminate impossible solutions early. You don't need to check every combination because the logic dictates that moving a pointer in a specific direction *must* increase or decrease the result.

-----

## The Variants

### 1. Opposing Ends (Convergence)

**Use Cases:**

- Finding a pair that sums to a target in a sorted array
- reversing an array
- checking palindromes.

**Logic:**

- Start one pointer at the beginning (`left`) and one at the end (`right`).
- If the current pair satisfies the condition -> **Success**.
- If the current value is *too small* -> Move `left` forward (to increase the sum).
- If the current value is *too large* -> Move `right` backward (to decrease the sum).

**Visual:**

```text
Sorted Array: [1, 3, 5, 8, 12]  Target: 8

Iter 1: L->1, R->12 (Sum 13 > 8)  => Decrement R
Iter 2: L->1, R->8  (Sum 9 > 8)   => Decrement R
Iter 3: L->1, R->5  (Sum 6 < 8)   => Increment L
Iter 4: L->3, R->5  (Sum 8 == 8)  => FOUND
```

### 2. Fast & Slow (Hare & Tortoise)

**Use Case:**

- Cycle detection in Linked Lists or Arrays
- Finding the middle element.

**This pattern is more relevant to the linked list, so we will cover it there!**

### 3. Merging / Parallel Iteration

**Use Case:**

- Merging two sorted arrays
- Finding intersections.

**Logic:**

- One pointer for each array (`p1`, `p2`).
- Compare values at `p1` and `p2`.
- Take the smaller (or larger) value.
- Increment the pointer of the array you took the element from.
- Repeat until one array is exhausted.

-----

## When to Use (The Checklist)

Use this pattern immediately if you see these signs:

1. **Input is Sorted:** This is the biggest giveaway. If the array is sorted, standard loops are often inefficient.
2. **Target is a Pair/Triplet:** You need to find two or three elements that satisfy a constraint (sum, difference, etc.).
3. **In-Place Requirement:** You are asked to modify the array (remove duplicates, reverse) with $O(1)$ space.
4. **Cyclic Dependencies:** Linked lists or arrays where values point to indices.

## Complexity Analysis

- **Time Complexity:** $O(N)$
- *Reason:* In most cases, each element is visited at most once or twice. You avoid the $O(N^2)$ nested loop cost.
- **Space Complexity:** $O(1)$
- *Reason:* You only store two integer variables (`left`, `right` or `slow`, `fast`). No extra hash maps or arrays are created.

-----

## Common Pitfalls

- **Unsorted Input:** If the input isn't sorted, **Variant 1 (Convergence)** will typically fail or require you to sort first ($O(N \log N)$), which might defeat the purpose if a Hash Map solution ($O(N)$) exists.
- **Off-by-One Errors:** In `while(left < right)`, knowing whether to use `<` or `<=` is critical.
  - Use `<` if the pointers should never cross or overlap (e.g., Two Sum).
  - Use `<=` if the pointers can meet at the middle (e.g., Squares of Sorted Array).
- **Infinite Loops:** In Fast & Slow pointers, ensure your `Fast` pointer checks for `null` (or end of bounds) before jumping two steps to avoid crashing.

-----

## Resources I followed

- I learned this pattern from [Chanda-Abdul's Repository](https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2002%3A%20Two%20Pointers.md) suggested by my mentor [Rishi Prakash](https://www.linkedin.com/in/rishi-prakash-developer/)

- I will add questions with answers as I solve them again!
