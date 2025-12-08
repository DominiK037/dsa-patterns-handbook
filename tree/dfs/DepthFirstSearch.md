[← Back to Tree Overview](../Tree.md)

-----

# Pattern: Depth First Search (DFS)

**DFS is the default strategy for 90% of tree problems.** If you are asked to validate a tree, count nodes, find a path, or calculate height, you use DFS. It is simply **recursion** applied to a tree. You dive as deep as possible into one branch before backtracking. If you try to do this iteratively (using a generic Stack) without a good reason, you are just writing more code to achieve the same result as the Call Stack.

-----

## The Core Concept

DFS explores a tree by going **deep** before going **wide**. It visits a node, then recursively visits its children until it hits a leaf (or `null`), then backtracks to the parent to explore the other sibling.

### Why it works

Since trees are defined recursively (A node contains a reference to `left` and `right` subtrees), DFS naturally aligns with the data structure. It uses the system's **Call Stack** to keep track of where it is, eliminating the need for manual state management in most cases.

-----

## The Variants (The "Order" Matters)

Knowing *where* to place your logic (before, between, or after the recursive calls) determines the type of traversal.

### 1. Pre-order (Root $\to$ Left $\to$ Right)

**Logic:** Process the `Current` node **before** visiting children.

* **Use Case:** Cloning a tree, Serialization (saving structure to a file/string), Prefix expression evaluation.
* **Code:** `print(root); dfs(root.left); dfs(root.right);`

### 2. In-order (Left $\to$ Root $\to$ Right)

**Logic:** Visit `Left` child, process `Current` node, then visit `Right` child.

* **Use Case:** **Binary Search Trees (BST)**. This is the **only** traversal that retrieves data from a BST in **sorted order**.
* **Code:** `dfs(root.left); print(root); dfs(root.right);`

### 3. Post-order (Left $\to$ Right $\to$ Root)

**Logic:** Visit both children first, then process the `Current` node.

* **Use Case:** Deleting a tree (delete children before parent), Postfix evaluation, **Calculations involving children** (Height, Diameter). You cannot know the height of a parent until you know the height of its children.
* **Code:** `dfs(root.left); dfs(root.right); print(root);`

-----

## The Logic (Recursive Skeleton)

Know this pattern inside out. This is the template for almost every DFS solution.

```java
// Standard DFS Skeleton (Java)
public int dfs(TreeNode root) {
    // 1. Base Case: The stop condition (usually null or leaf)
    if (root == null) {
        return 0; // Return neutral value (0, null, false, etc.)
    }

    // 2. Recursive Step: Dive down
    // (This example uses Post-order logic: get answers from bottom first)
    int leftResult = dfs(root.left);
    int rightResult = dfs(root.right);

    // 3. Business Logic: Combine results for current node
    // Example: Calculate Height
    return Math.max(leftResult, rightResult) + 1;
}
```

-----

## When to Use (The Checklist)

Use DFS immediately if the problem asks for:

1. **Path Finding:** "Does a path exist with sum X?"
2. **Exhaustive Search:** "Count all nodes," "Find max value."
3. **BST Operations:** "Find Kth smallest element," "Validate BST." (Strictly In-order).
4. **Tree Properties:** "Height," "Diameter," "Lowest Common Ancestor." (Strictly Post-order).

-----

## Complexity Analysis

* **Time Complexity:** $O(N)$
  * *Reason:* You visit every node exactly once.
* **Space Complexity:** $O(H)$ (where $H$ is Height).
  * *Reason:* In the worst case (skewed tree), the recursion stack grows to $O(N)$. In a balanced tree, it is $O(\log N)$.

-----

## Common Pitfalls

* **Missing Base Case:** If you forget `if (root == null)`, your code crashes with a `StackOverflowError` immediately.
* **Choosing the Wrong Order:**
  * If you validate a BST using Pre-order, you will fail. (You must check strict sorting, which requires In-order).
  * If you calculate Height using Pre-order, you will fail. (You need child data first, which requires Post-order).
* **Global Variables:** Stop using static/global variables (like `count = 0`) to aggregate results. It makes your code thread-unsafe and messy. Instead, pass the accumulator as a parameter or return the value up the recursion chain.

-----
