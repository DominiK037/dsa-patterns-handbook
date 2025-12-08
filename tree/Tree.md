# Tree Fundamentals

**A Tree is a graph without cycles.** Unlike Arrays or Linked Lists (linear), Trees are hierarchical. This means you cannot iterate through them easily with a simple `for` loop.

* **Recursion is King:** Since every node is the "root" of its own subtree, $99\%$ of tree solutions use recursion.
* **Binary Trees Rule:** In interviews, you will almost exclusively deal with **Binary Trees** (max 2 children).

-----

## The Anatomy (Key Terminology)

You must speak the language of trees fluently. Mixing up "Height" and "Depth" suggests you don't understand the structure.

| Term | Definition | Visual / Note |
| :--- | :--- | :--- |
| **Root** | The top-most node. No parent. | The entry point of the tree. |
| **Leaf** | A node with NO children. | The "bottom" of the tree. |
| **Sibling** | Nodes that share the same Parent. | `Left` and `Right` children are siblings. |
| **Ancestor** | Any node "above" the current node. | Parent, Grandparent, etc. |
| **Descendant** | Any node "below" the current node. | Child, Grandchild, etc. |
| **Depth** | Distance from **Root $\to$ Node**. | Top-down. Root is Depth 0. |
| **Height** | Distance from **Node $\to$ Deepest Leaf**. | Bottom-up. Leaf is Height 0. |

### Visualization

```text
       A (Root, Depth: 0)
      / \
     B   C  (Siblings)
    / \   \
   D   E   F (Leaves, Height: 0)
```

* **Subtree:** Node `B` is the root of the subtree `B-D-E`.
* **Path:** There is exactly **one** unique path between any two nodes (e.g., $D \to B \to A \to C$).

-----

## The Variants (Binary Trees)

A **Binary Tree** enforces one rule: **Max 2 children per node.** However, the *arrangement* of nodes determines performance.

### 1. Complete Binary Tree

**Logic:** Think "Tetris." You fill every level completely. The last level must be filled strictly **Left to Right**.

* **Why it matters:** This structure is mandatory for **Heaps** (Priority Queues). It ensures the tree is compact and array-mappable.

### 2. Balanced Binary Tree

**Logic:** The "Ideal" Tree. The height difference between Left and Right subtrees is $\le 1$ for *every* node.

* **Why it matters:** Ensures $O(\log N)$ search/insert/delete. If a tree is balanced, you discard half the nodes at every step of a search.

### 3. Skewed Binary Tree (The Trap)

**Logic:** The "Worst" Tree. Every node has only one child (all left or all right).

* **Why it matters:** Structurally, this is a **Linked List**. All tree advantages are lost. Complexity degrades to $O(N)$.

-----

## Complexity Analysis (The Trade-offs)

| Operation | Balanced (Best Case) | Skewed (Worst Case) | Why? |
| :--- | :--- | :--- | :--- |
| **Search** | $O(\log N)$ | $O(N)$ | Balanced cuts search space in half. Skewed checks every node. |
| **Insertion** | $O(\log N)$ | $O(N)$ | You must find the correct spot, which takes Height time. |
| **Deletion** | $O(\log N)$ | $O(N)$ | Same as search; depends on tree height. |
| **Traversal** | $O(N)$ | $O(N)$ | You must visit every node to print/process it, regardless of shape. |

-----

## Common Pitfalls

* **The "Null" Edge Case:** A tree can be empty (`root == null`). A tree can have one node. Your code **must** handle `if (root == null)` immediately, or you will get a NullPointerException.
  * **Confusing Binary Tree vs. BST:**
    * **Binary Tree:** Just a shape. Data can be random ($5, 100, 2$).
    * **Binary Search Tree (BST):** Sorted data. Left $<$ Root $<$ Right.
    * *Warning:* Never assume a tree is sorted unless the problem explicitly says "BST".
  * **Height vs. Depth Confusion:**
    * Calculate **Depth** by passing `depth + 1` *down* into the recursive call.
    * Calculate **Height** by returning `max(left, right) + 1` *up* from the recursive call.

-----

## Patterns

1. [DFS Traversal (Preorder, Inorder, Postorder)](./dfs/DepthFirstSearch.md)
2. [BFS Traversal (Level Order)](./bfs/BreadthFirstSearch.md)
