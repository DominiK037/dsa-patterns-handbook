# Trees

- A Tree is a hierarchical data structure made up of a connected nodes.

- It is an undirected, connected and acyclic [graph](/graph/Graph.md), meaning there’s exactly one path between any two nodes. This structure allows natural use of recursion, as each node itself can be treated as the root of it's own subtree.

- **Node Types**

    A node in a tree can be:
    1. **Root Node:** Has no parent, can or can't have children.
    2. **Parent Node:** Has one parent and one or more children.
    3. **Child Node:** Has exactly one parent.

    > Nodes can store any data type: `int`, `String`, or `Node<T>`.

- **Types of Trees**
    1. Binary Trees.
    2. Ternary Trees.
    3. N-Ary Trees (N children).

> As per the [Tech Interview Handbook](https://www.techinterviewhandbook.org/algorithms/tree/), ternary and n-ary trees are not common in interviews. You can explore them further only if you’re personally interested.


## Common terms

- **Edge:** The connection (or link) between two nodes.

- **Neighbour:** A directly connected node — either a parent or a child.

- **Sibling:** Nodes that share the same parent.

- **Ancestor:** Any node that exists one or more levels 'above' the current node.

- **Descendant:** Any node that exists one or more levels 'below' the current node.

- **Subtree:** A smaller tree formed by any node and all its descendants.

- **Depth/Levels/Height (Vertical View):** Number of edges from the root node to the target node.

- **Width (Horizontal View):** Number of nodes present on a particular level.

### Visualization:

````
       A (Root)
      / \
     B   C
    / \   \
   D   E   F
````

- Root: `A`

- Leaves: `D`, `E`, `F`

- Siblings: `B` and `C`

- Ancestors of **E**: `B`, `A`

- Descendants of **B**: `D`, `E`

- Depth of **F**: `2` (A `→` C `→` F) [Count edges]

- Width at Level 2: 3 nodes (`D`, `E`, `F`) [We start levels from 0 just like an array index]


## Binary Trees

- Exactly 1 root node.
- At most 2 children per node.
- Exactly 1 path between the **Root** Node -> **Any** Node.

### Learnings from [stucty.net](https://structy.net/problems/binary-tree-intro)

- Tree with **SINGLE** or **NO** node is also the binary tree.
- Use parent-child relationship when describing the relationships among the nodes.
- Use leaf nodes while talking about the end nodes which don't have any children.
- It is common to set children using `null`(No children) or `node.left`, `node.right` for any parent node.

### Binary Tree Terms

1. **Complete Binary Tree:** 

    - Every level is completely filled, except possibly the last!

    - All nodes on the last level are as far left as possible.
    
    - Example:

        ````
                1
               / \
              2   3
             / \
            4   5
        ````
        > Here, every level except the last is full, and the last one is filled from left to right. So it’s complete.

2. **Balanced Binary Tree:** 

    - Here we care about height balance, not about left-to-right filling.

    - The difference in height between left and right subtrees at every node ≤ 1.

    - It keeps operations like search, insert, and delete **fast (≈ O(log n)).**

    - Example:

        ````
                 1
                / \
               2   3
              / \   \
             4   5   6
                      \
                       7
        ````
        > Left and right subtrees differ in height by at most one everywhere. So it’s balanced. But it’s not complete because the last level isn’t filled left-to-right.

- **In easy words**
    - A **complete tree** ensures all **levels are filled from left to right**.
    - A **balanced tree** ensures **both sides stay roughly the same height**.


## Time Complexities

| **Operation**          | **Best / Avg (Balanced)** | **Worst (Skewed)** | **Notes / Explanation**                                                                  |
| ---------------------- | ------------------------- | ------------------ | ---------------------------------------------------------------------------------------- |
| **Search**             | `O(log n)`                | `O(n)`             | In a balanced tree, we skip half nodes each step. In a skewed tree, we check every node. |
| **Insertion**          | `O(log n)`                | `O(n)`             | Balanced trees keep height short, so inserting is faster.                                |
| **Deletion**           | `O(log n)`                | `O(n)`             | Works like insertion — faster when tree height is balanced.                              |
| **Traversal**          | `O(n)`                    | `O(n)`             | Every node must be visited once — same for all trees.                                    |
| **Height Calculation** | `O(n)`                    | `O(n)`             | We go through all nodes once to find height.                                             |


> A skewed tree is a type of binary tree that is completely unbalanced — all the nodes go in one direction, either only to the left or only to the right. It looks more like a linked list than a tree.

Example (Left skew)

````
        1
       /
      2
     /
    3
````

## Patterns

1. Breadth First Search (BFS)
2. Depth First Search (DFS)
