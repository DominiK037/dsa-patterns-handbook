# Pattern: Recursion

**Recursion is not magic, it is just a Stack.** A recursive function is simply a function that pauses execution, pushes a new frame onto the system's Call Stack, waits for a result, and then resumes.

* **The Mindset:** You must trust the "Leap of Faith." Assume your function *already works* for a smaller input, and use that result to solve the current input.
* **The Warning:** If you don't have a **Base Case**, you create an infinite loop and crash the program (`StackOverflowError`).

-----

## The Core Concept

Recursion is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem.

### The Anatomy of a Recursive Function

Every valid recursive function has exactly two parts. If you are missing one, it is broken.

1. **The Base Case (The Anchor):** The condition where the recursion stops. This is usually the smallest valid input (e.g., `n == 0`, `node == null`, `list is empty`).
2. **The Recursive Step (The Reduction):** The logic that breaks the problem down into a smaller version and calls the function again.

### Why it works

The Operating System maintains a **Call Stack**. Every time you call a function, its variables and state are pushed onto the stack. When the function returns, that frame is popped off, and the previous function resumes exactly where it left off.

-----

## The Logic (The Skeleton)

```java
ReturnType solve(Input n) {
    // 1. BASE CASE (The Stop Sign)
    // If we are at the bottom, return a concrete answer.
    if (n <= 1) {
        return 1;
    }

    // 2. RECURSIVE STEP (The Leap)
    // Call the function with a SMALLER input.
    // Trust that 'subResult' will hold the correct answer for (n-1).
    ReturnType subResult = solve(n - 1);

    // 3. BUSINESS LOGIC (The Combination)
    // Use the result from the child to solve for the parent.
    return n * subResult;
}
```

-----

## The Execution Flow (Visualizing the Stack)

Let's calculate `solve(3)`:

1. **Push `solve(3)`:** Pauses at `3 * solve(2)`.
2. **Push `solve(2)`:** Pauses at `2 * solve(1)`.
3. **Push `solve(1)`:** **Base Case Hit!** Returns `1`. **Pop.**
4. **Resume `solve(2)`:** Computes `2 * 1 = 2`. Returns `2`. **Pop.**
5. **Resume `solve(3)`:** Computes `3 * 2 = 6`. Returns `6`. **Pop.**
6. **Final Result:** 6.

*Notice:* The work often happens on the way **up** (when returning), not just on the way down.

-----

## When to Use (The Checklist)

Use recursion immediately if:

1. **Tree Traversals:** Trees are naturally recursive (Root + Subtrees). DFS is recursion.
2. **Divide and Conquer:** Merge Sort, Quick Sort. Splitting a problem in half repeatedly.
3. **Backtracking:** "Find all combinations," "Solve Sudoku," "Generate Parentheses." You explore a path, and if it fails, you return (backtrack) to try another.
4. **Graph DFS:** Exploring a maze or network deep-first.

-----

## Complexity Analysis

* **Time Complexity:** $O(\text{Number of Branches}^{\text{Depth}})$
  * *Reason:* Generally, it's the total number of nodes in the recursion tree. For a simple loop replacement (like factorial), it's $O(N)$. For Fibonacci without optimization, it's $O(2^N)$.
* **Space Complexity:** $O(\text{Max Stack Depth})$
  * *Reason:* You pay memory for every active frame on the Call Stack. Even if you don't use extra variables, the stack depth costs memory.

-----

## Brutal Reality Check (Common Pitfalls)

* **Missing the Base Case:** The #1 cause of crashes. You must explicitly handle the smallest unit (0, 1, null, empty string).
* **Stack Overflow:** Even with a correct base case, if the depth is too high (e.g., recursion depth of 100,000), Java/Python will crash. Recursion is not for generic iteration over massive lists; use loops for that.
* **Redundant Calculations (The Fibonacci Trap):**
  * `fib(5)` calls `fib(4)` and `fib(3)`.
  * `fib(4)` calls `fib(3)` and `fib(2)`.
  * Notice `fib(3)` is calculated twice? In large inputs, this explodes to $O(2^N)$.
  * *Fix:* This leads to **Dynamic Programming (Memoization)**. If you see overlapping calls, you must cache the results.

-----
