# Graph Fundamentals

**A Graph is just a collection of "things" and the "relationships" between them.**
Unlike a Tree, a Graph has **no rules**. It has no root, no parent-child hierarchy, and it can circle back on itself.

* **The Analogy:** Think of **Airports** (Nodes) and **Flights** (Edges).
* **The Trap:** Because there is no root, you can start anywhere. Because there are cycles, you can get stuck in an infinite loop if you don't track where you've been.

---

## The Anatomy (Key Terminology)

You cannot solve graph problems if you don't know the vocabulary.

| Term | Symbol | Definition | Real World Example |
| :--- | :--- | :--- | :--- |
| **Vertex (Node)** | $V$ | The entity or object. | A User, A City, A Webpage. |
| **Edge** | $E$ | The line connecting two vertices. | A "Follow", A Road, A Hyperlink. |
| **Degree** | - | Number of edges connected to a node. | Number of friends/followers. |
| **Path** | - | A sequence of edges to get from A to B. | Route from Home $\to$ Work. |

---

## The Variants (Know Your Graph)

The *type* of graph dictates which algorithm you use.

### 1. Directed vs. Undirected

* **Undirected (Two-Way Street):** If A connects to B, then B automatically connects to A.
  * *Example:* Facebook Friends. (If I am your friend, you are mine).
* **Directed (One-Way Street):** A connection from A to B does **not** imply B to A.
  * *Example:* Instagram/Twitter. (I can follow Elon Musk, but he doesn't follow me).

### 2. Weighted vs. Unweighted

* **Unweighted:** All edges are equal. The "cost" to travel is just 1 hop.
* **Weighted:** Edges have a value (Weight, Cost, Distance).
  * *Example:* Google Maps. The road from A to B might take **5 mins** (Weight = 5), while A to C takes **20 mins** (Weight = 20).

### 3. Cyclic vs. Acyclic

* **Cyclic:** You can start at Node A, follow a path, and eventually **return** to Node A.
* **Acyclic:** You can never return to where you started (e.g., Trees, Dependency Graphs).

---

## How to Store a Graph (The Interview Standard)

Computers don't see "circles and lines." They need data structures. You have two choices.

### 1. Adjacency Matrix (The Grid)

A 2D Array `matrix[V][V]`.

* If Node `i` connects to Node `j`, set `matrix[i][j] = 1` (or the weight).
* **Pros:** Instant lookup ($O(1)$) to check "Are A and B connected?"
* **Cons:** **Huge Memory Waste.** If you have 10,000 nodes but only a few edges, you still allocate a $10,000 \times 10,000$ grid. Complexity is $O(V^2)$.
* *Verdict:* **Rarely used** unless the graph is dense (almost everything connects to everything).

### 2. Adjacency List (The List of Neighbors)

A Map or Array where every Node stores a list of its immediate neighbors.

* `Map<Integer, List<Integer>> graph`
* **Pros:** Memory Efficient ($O(V + E)$). You only store edges that actually exist.
* **Cons:** Slower lookup ($O(\text{Degree})$) to check connection.
* *Verdict:* **Industry Standard.** Use this for 95% of problems.

### Comparison Table

| Feature | Adjacency List (Map) | Adjacency Matrix (2D Array) |
| :--- | :--- | :--- |
| **Space** | $O(V + E)$ (Efficient) | $O(V^2)$ (Heavy) |
| **Check Connection** | Slower (Iterate list) | $O(1)$ (Instant) |
| **Iterate Neighbors** | Fast (Direct access) | Slow (Scan entire row) |
| **Best For** | Sparse Graphs (Most real data) | Dense Graphs |

---

## Common Pitfalls

1. **Disconnected Components:** Unlike a Tree, a Graph isn't guaranteed to be one big piece. You might have "islands" of nodes.
    * *Fix:* When traversing, you can't just start at Node 0. You must loop through `All Nodes` and trigger a search if the node hasn't been visited yet.
2. **The Infinite Loop:** Since graphs have cycles, if you blindly follow edges (like in a Tree), you will crash.
    * *Fix:* You **MUST** maintain a `Visited` Set (HashSet/Boolean Array). If you see a node in the set, skip it.
3. **Self-Loops:** A node can have an edge pointing to itself. Watch out for this edge case.

---

## Patterns

1. [Depth-First Search (DFS)](./dfs/DepthFirstSearch.md)
2. [Breadth-First Search (BFS)](./bfs/BreadthFirstSearch.md)
