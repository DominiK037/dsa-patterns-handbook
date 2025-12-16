[← Back](../Graph.md)

-----

# Pattern: Graph Breadth First Search (BFS)

**BFS is the "Ripple Effect" algorithm.**
Imagine dropping a stone into a calm pond. The ripples expand outward in perfect circles, layer by layer. It touches everything at distance 1, then everything at distance 2, and so on.

* **The Tool:** **Queue** (FIFO - First In, First Out).
* **The Rule:** Go **Wide**, then Deep. "I will visit all my immediate neighbors before I visit *their* neighbors."

-----

## The Core Concept

BFS guarantees that the **first time** you visit a node, you have reached it via the **shortest path** (in terms of number of edges).

* **Tree vs. Graph BFS:** Just like DFS, graphs have cycles. You **must** use a `Visited Set` to avoid processing the same node infinitely.

-----

## The Logic (Iterative Skeleton)

Memorize this loop. It is the only way to implement standard BFS.

1. **Start:** Push starting node(s) to Queue and mark `Visited`.
2. **Loop:** While Queue is not empty...
3. **Layer Check (Optional but Recommended):** Get the current `size` of the Queue. This represents exactly one "layer" of distance.
4. **Process:** Dequeue nodes, process them, and enqueue their **unvisited** neighbors.

### Skeleton Code (Java)

```java
public int bfs(int startNode, int target, Map<Integer, List<Integer>> graph) {
    Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    
    queue.offer(startNode);
    visited.add(startNode); // CRITICAL: Mark immediately upon adding
    int distance = 0;

    while (!queue.isEmpty()) {
        int size = queue.size(); // Snapshot current layer size
        
        // Process this entire layer
        for (int i = 0; i < size; i++) {
            int currentNode = queue.poll();
            if (currentNode == target) return distance;

            for (int neighbor : graph.getOrDefault(currentNode, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); // Mark BEFORE adding to queue
                    queue.offer(neighbor);
                }
            }
        }
        distance++; // Finished one layer, increment distance
    }
    return -1; // Not found
}
```

-----

## BFS Sub-Patterns

These are the "Big 4" applications where BFS is standard.

### 1\. Shortest Path (Unweighted)

**Mental Model:** The GPS avoiding tolls.
You want to get from City A to City B. All roads are exactly 1 mile long. BFS explores all 1-mile roads first, then all 2-mile roads. Therefore, if you find City B, you are mathematically guaranteed to have found the shortest route.

* **Goal:** Find the minimum number of edges to reach a target.
* **The "Why":** DFS might find a path, but it could be a zigzagging mess of 100 steps. BFS finds the straight line.
* **Logic:**
  * Maintain a `distance` variable.
  * Increment `distance` only after processing an entire **Level** (using the `queue.size()` loop).
  * Return `distance` immediately when the target is popped.

### 2\. Multi-Source BFS ("The Zombie Apocalypse")

**Mental Model:** Rotting Oranges / Virus Outbreak.
Imagine 3 cities are infected simultaneously. The virus spreads to adjacent cities every hour. How long until the whole world is infected?

* **Goal:** Find the minimum time to cover the graph starting from *multiple* points at once.
* **The "Why":** You don't run BFS 3 separate times. You want the separate "ripples" to expand in parallel and merge.
* **Logic:**
    1. Instead of adding *one* start node to the Queue, add **ALL** infected nodes to the Queue at `t=0`.
    2. Mark them all as visited.
    3. Run the standard BFS loop. The layers will naturally expand from all sources simultaneously.

### 3\. Topological Sort (Kahn’s Algorithm)

**Mental Model:** The Factory Assembly Line.
You have a list of tasks. Some tasks depend on others. You can only start a task if *zero* prerequisites are remaining. When you finish a task, you send the materials to the next station, potentially allowing that station to start.

* **Goal:** Linear ordering of dependencies (DAG).
* **The "Why":** Unlike DFS Topo Sort (which uses recursion/stack), Kahn's algorithm is iterative and intuitive: "Find nodes with 0 dependencies, process them, and 'delete' them to free up new nodes."
* **Logic:**
    1. Calculate **In-Degree** (number of incoming edges) for every node.
    2. Add all nodes with `In-Degree == 0` to the Queue.
    3. While Queue is not empty:
          * Pop node, add to result list.
          * "Remove" edges: Decrement In-Degree of all neighbors.
          * If a neighbor's In-Degree hits 0, add it to the Queue.

### 4\. Bipartite Check ("Graph Coloring")

**Mental Model:** Alternating Stripes.
You want to paint the graph nodes `Red` and `Blue` in layers. Layer 0 is Red, Layer 1 is Blue, Layer 2 is Red.

* **Goal:** Check if graph can be divided into two sets with no internal connections.
* **The "Why":** BFS naturally processes in layers. Layer $N$ nodes should only connect to Layer $N+1$ or $N-1$. If a node in Layer $N$ connects to another node in Layer $N$, you have an "Odd Cycle" and the graph is not bipartite.
* **Logic:**
  * Use an array `colors[]` initialized to 0.
  * Color start node `1` (Red).
  * When moving to neighbor:
    * If uncolored: Color it `-1` (Blue, opposite of current).
    * If colored: Check if `color[neighbor] == color[current]`. If yes, return `False`.

-----

## What BFS is BAD At

* **Deep Searches:** If the target is deep in the graph and unique (e.g., solving a Sudoku puzzle), BFS consumes massive memory storing all the shallow layers. DFS is better for memory here.
* **Weighted Graphs (Weights \> 1):** BFS assumes every hop is equal. If edges have weights like 5, 10, 2, BFS breaks. You must use **Dijkstra’s Algorithm**.

-----

## Complexity Analysis

* **Time Complexity:** $O(V + E)$
  * *Reason:* Every vertex is enqueued/dequeued once. Every edge is checked once.
* **Space Complexity:** $O(V)$ (specifically, the Width of the graph).
  * *Reason:* In the worst case (a Star Graph), the Queue might hold $V-1$ nodes at once. This is generally **more memory intensive** than DFS.

-----

## Common Pitfalls

* **Visited Array Placement:** This is the \#1 bug. You must mark `Visited` **at the moment you push to Queue**.
  * *Wrong:* Push A $\to$ Pop A $\to$ Mark A. (Result: Node A might be added 10 times by different neighbors before it gets popped).
  * *Right:* Mark A $\to$ Push A.
* **Memory Limit Exceeded (MLE):** On huge grids, BFS can blow up memory because the Queue grows exponentially. If you just need to "find a path" and not the shortest one, DFS is safer for memory.
* **Level Tracking:** If you forget the `size = queue.size()` inner loop, you lose the ability to track "Distance" or "Time steps." You just have a flat list of nodes.

-----
