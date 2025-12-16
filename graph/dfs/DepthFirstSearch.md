[← Back](./Graph.md)

-----

# Pattern: Graph Depth First Search (DFS)

**DFS is the "Maze Solver" algorithm.**
Imagine you are in a maze. You pick a path and keep walking until you hit a dead end. Then, you retrace your steps (backtrack) to the last intersection and try a different path.

* **The Tool:** **Recursion** (or a Stack).
* **The Rule:** Go **Deep**, then Backtrack. "I will finish this entire lineage before I talk to my sibling."

-----

## The Core Concept

DFS explores the graph by diving as deep as possible into the graph structure before turning back.

* **Tree vs. Graph DFS:** In a Tree, you never worry about seeing the same node twice (no cycles). In a Graph, **Cycles exist**. If you don't keep a list of where you've been (`Visited Set`), you will run in circles forever until your program crashes.

-----

## The Logic (Recursive Skeleton)

Memorize this pattern. It is the backbone of 40% of Graph interview questions.

1. **Check:** Have I been here before? If yes, stop (Base Case).
2. **Mark:** Mark current node as `Visited` immediately.
3. **Process:** Do whatever the problem asks (count, print, check value).
4. **Recurse:** Loop through neighbors. If a neighbor is **not** visited, call DFS on it.

### Skeleton Code (Java)

```java
// The wrapper function to handle disconnected components
public void solve(int numNodes, Map<Integer, List<Integer>> graph) {
    Set<Integer> visited = new HashSet<>();
    
    // Loop through ALL nodes to handle disconnected islands
    for (int i = 0; i < numNodes; i++) {
        if (!visited.contains(i)) {
            dfs(i, visited, graph);
        }
    }
}

// The actual recursive logic
private void dfs(int node, Set<Integer> visited, Map<Integer, List<Integer>> graph) {
    // 1. Mark as visited
    visited.add(node);
    
    // 2. Iterate through neighbors (Adjacency List)
    for (int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
        // 3. Only visit if we haven't been there yet
        if (!visited.contains(neighbor)) {
            dfs(neighbor, visited, graph);
        }
    }
}
```

-----

## Deep Dive: The 4 DFS Sub-Patterns

These are the "Big 4" applications where DFS is the undisputed king.

### 1\. Connected Components ("The Flood Fill")

**Mental Model:** Pouring water.
Imagine the graph is a bumpy terrain. If you pour water (trigger DFS) on a specific spot, it will flow to fill every connected crevice (node) in that "basin" (component). It cannot jump over walls to a separate basin. To find the next basin, you must pick a dry spot and pour water again.

* **Goal:** Count how many separate islands/basins exist.
* **The "Why":** Standard loops can't follow irregular shapes. DFS naturally "floods" a shape until it hits boundaries (visited nodes or no edges).
* **Logic:**
    1. Iterate through every node `0` to `N`.
    2. If a node is **not visited**, increment `IslandCount` and trigger `DFS(node)`.
    3. The DFS call will mark *all* reachable nodes in that island as visited.
    4. The loop continues. Next time it finds an unvisited node, it must be a *new* island.

### 2\. Cycle Detection ("The Snake")

**Mental Model:** A Snake biting its own tail.
You are walking down a path, leaving breadcrumbs behind you. If you ever encounter a breadcrumb that is *fresh* (dropped during this current walk), you have walked in a circle.

* **Goal:** Determine if the graph contains a loop.
* **The "Why":** Simple `Visited` sets aren't enough for directed graphs. You need to distinguish between "I visited this yesterday" (safe cross-edge) and "I visited this 5 minutes ago and am still processing it" (cycle).
* **Logic:**
  * **State 0 (White):** Unvisited.
  * **State 1 (Gray):** Visiting (Currently in the recursion stack).
  * **State 2 (Black):** Visited (Finished processing).
  * **The Trigger:** If you see a neighbor that is **Gray**, you found a cycle. If you see Black, it's just a path merging with an old path (safe).

### 3\. Topological Sort ("The Wardrobe")

**Mental Model:** Getting Dressed.
You cannot put on your shoes before your socks. You cannot put on your jacket before your shirt. Topological sort puts these tasks in a linear line: Socks $\to$ Shoes $\to$ Shirt $\to$ Jacket.

* **Goal:** Linear ordering of dependencies (DAG - Directed Acyclic Graph).
* **The "Why":** You only know a task is "ready" when all its dependencies (children) are done. DFS Post-Order naturally finishes children before parents.
* **Logic:**
    1. Run DFS.
    2. **Crucial Step:** Do NOT add the node to your list when you *start* visiting it.
    3. Recursively visit all children.
    4. Add the node to a **Stack** only when it is **finished** (about to return from recursion).
    5. At the end, pop the stack. The deepest dependency (Socks) will be at the bottom of the recursion, added first, but popping reverses it to the correct order (Start $\to$ End).

### 4\. Bipartite Check ("The Graph Coloring")

**Mental Model:** The 2-Color Map.
Can you color every node either Red or Blue such that no two Red nodes touch and no two Blue nodes touch?

* **Goal:** Validating if a graph can be split into two opposing sets (e.g., Users vs. Products, Boys vs. Girls).
* **The "Why":** You need to enforce a strict alternating constraint. DFS enforces this by passing the "expected color" down to the child.
* **Logic:**
    1. Color the start node `Red`.
    2. For every neighbor, try to color it `Blue` (opposite).
    3. **Conflict:** If the neighbor is *already* colored and the color is `Red` (same as current), the graph is **Not Bipartite**. Return `False`.
    4. If the neighbor is uncolored, recurse with the opposite color.

-----

## What DFS is BAD At (Don't Use It Here)

* **Shortest Path Finding:** DFS is blind to distance. It will happily traverse 10,000 nodes deep to find a target that was actually just 1 neighbor away. **Use BFS for Shortest Path.**
* **Minimum Spanning Tree:** DFS is not optimized for calculating minimal edge weights across a network. Use **Prim’s** or **Kruskal’s**.

-----

## Complexity Analysis

* **Time Complexity:** $O(V + E)$
  * *Reason:* You visit every Vertex ($V$) once and traverse every Edge ($E$) once.
* **Space Complexity:** $O(V)$
  * *Reason:* The `Visited` set takes $O(V)$. The Recursion Stack can grow to $O(V)$ in the worst case (a straight line graph).

-----

## Common Pitfalls

* **The "Disconnected" Trap:** Beginners write `dfs(0)` and think they are done. If the graph has separate islands, `dfs(0)` will miss them. You **must** loop through all nodes in the wrapper.
* **Backtracking vs. DFS:**
  * **Standard DFS:** Mark `visited` and **never unmark**. (Used for reachability/islands).
  * **Backtracking:** Mark `visited`, recurse, then **unmark** (remove from visited). (Used for finding *all possible* paths). Do not confuse these.
* **Modifying Input Graph:** Some solutions modify the input graph (e.g., removing edges). This is risky. Always clarify with the interviewer if this is allowed.

-----
