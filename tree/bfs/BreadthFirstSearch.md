[← Back to Tree Overview](../Tree.md)

-----

# Pattern: Breadth First Search (BFS) / Level Order Traversal

**BFS is about horizontal exploration.** While DFS dives deep, BFS scans wide. If a problem asks you to process a tree "level by level," find the "shortest path" in an unweighted graph/tree, or connect "next" pointers, you must use BFS.

* **The Tool:** You **cannot** use recursion easily here. You must use a **Queue** (FIFO - First In, First Out).
* **The Mindset:** Process all nodes at Depth $D$ before touching any node at Depth $D+1$.

-----

## The Core Concept

BFS processes the tree layer by layer. It starts at the root, visits all immediate children, then visits all grandchildren, and so on.

### Why it works

The Queue data structure preserves the order of discovery. By adding children to the *back* of the line while processing parents from the *front*, you guarantee that you finish the current generation before starting the next one.

-----

## The Logic (Iterative Skeleton)

This is the **only** way to implement standard BFS. Know the `size` loop pattern, without it, you cannot distinguish between levels.

```java
// Standard BFS Skeleton (Java)
public List<List<Integer>> bfs(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        // 1. Snapshot the size of the current level
        // CRITICAL: This tells you how many nodes belong to the CURRENT level
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();

        // 2. Process ONLY nodes of this level
        for (int i = 0; i < levelSize; i++) {
            TreeNode currentNode = queue.poll();
            
            // 3. Business Logic (e.g., add to list)
            currentLevel.add(currentNode.val);

            // 4. Add children for the NEXT level
            if (currentNode.left != null) queue.offer(currentNode.left);
            if (currentNode.right != null) queue.offer(currentNode.right);
        }
        
        // Level is complete. Move to next.
        result.add(currentLevel);
    }

    return result;
}
```

-----

## When to Use (The Checklist)

Use BFS immediately if the problem asks for:

1. **Level-based Logic:** "Print level order," "Find average of each level," "Zigzag traversal."
2. **Geometry/View:** "Right side view of a tree" (Last element of each BFS level).
3. **Shortest Path:** "Minimum depth of a binary tree." (BFS is faster than DFS here because BFS stops as soon as it finds the *first* leaf, whereas DFS might traverse the whole tree).
4. **Modifying Links:** "Connect next right pointers."

-----

## Complexity Analysis

* **Time Complexity:** $O(N)$
  * *Reason:* Every node is added to the Queue once and removed once.
* **Space Complexity:** $O(W)$ (where $W$ is the maximum Width of the tree).
  * *Reason:* In a perfect binary tree, the leaf level holds $N/2$ nodes. Your Queue will hold roughly half the tree nodes at the peak.
  * *Note:* This is distinct from DFS, which uses $O(H)$ space. In a wide, balanced tree, BFS uses *more* memory than DFS.

-----

## Common Pitfalls

* **Forgetting `levelSize`:** If you just loop `while(!queue.isEmpty())` without the inner `for` loop using `levelSize`, you lose the concept of "levels." You are just visiting nodes flatly. You won't be able to solve "Right Side View" or "Level Average" problems.
* **Using a Stack:** If you swap the Queue for a Stack, you have accidentally implemented DFS (specifically, iterative DFS). The logic collapses.
* **Null Children:** Always check `if (child != null)` before adding to the Queue. If you add nulls, your code will crash or process "empty" nodes unnecessarily.
* **Queue Implementation:** In Java, use `LinkedList` or `ArrayDeque` as your Queue. Do not use legacy classes like `Vector`.

-----
