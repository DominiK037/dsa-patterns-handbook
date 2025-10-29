# Hash Table(HashMap)


## Cache this in Mind

- Stores data in **key-value pairs** which allows super fast reads & writes.

- Works by using hash function to convert a `key` from string/interger into numerical value called a **hashcode**, which determines where the value is stored in the memory. When you later use the same key, the hashcode helps locate the value instantly without scanning the whole collection.

- In short, the HashMap gives you instant lookups by trading a bit of extra memory for speed.

- Works in in-memory (RAM) but is non-contiguous.


## My Understanding

- HashMap is primarily implemented using a combination of three data structures:

    1. Array of Buckets: Internally HashMap maintans an array where each element (called as bucket) holds key-value pairs that hash to that specific index.

    2. Linked List (for collisions in java 7 & earlier): When multiple keys are hashed to the same bucket, instead of deleting existing value/s on that bucket, we can add new values by creating linked list containing all the existing & new values of that specific bucket.
    `Time complexity gets worst here: O(n)`

    3. Balanced Tree (Red-Black Tree from java 8+): If too many keys collide in a single bucket (typically ≥ 8), the linked list in that bucket is converted into a Red-Black Tree to improve lookup from `O(n)` to `O(log n)`.

    > Note: Collisions can be handled by either LinkedList/BalancedTree or Probing.


## Advantages

- Access, Insertion and Deletion is `constant time O(1)` in an average cases

- Can store any object type as key/value.


## Disadvantages

- May have collisions.

- Unordered storage(): Does not maintain insertion order (use LinkedHashMap if needed).

- High memory consumption (Few data structures are used behind the scenes)


## Time complexities

| Operation | Time Complexity | Notes |
|------------|----------------|-------|
| Insertion (`put(key, value)`) | `O(1)` average, `O(log n)` worst | (Average) Uses hash function to find the correct bucket. (Worst) When a bucket is treeified (≥8 entries), insertion and balancing take `O(log n)`. Rehashing occurs when load factor (default 0.75) is exceeded. |
| Retrieval (`get(key)`) | `O(1)` average, `O(log n)` worst | (Average) Direct lookup using key’s hash. (Worst) If the bucket is a Red-Black Tree, lookup follows tree traversal. |
| Deletion (`remove(key)`) | `O(1)` average, `O(log n)` worst | (Average) Removes entry from its bucket. (Worst) Rebalancing may occur in treeified buckets. |
| Contains Key (`containsKey(key)`) | `O(1)` average, `O(log n)` worst | Follows the same lookup path as `get()`. |
| Contains Value (`containsValue(value)`) | `O(n)` | Scans all entries since values are not hashed or indexed. |
| Iteration (`forEach`, `entrySet()`) | `O(n)` | Traverses every key-value pair sequentially. |



----

## Resources & Sequence I followed:

1. Honestly, eventual learning. No single source alone helped me to get into details of the HashMap. So I recommend explore resources as per your requirements & style!

2. I will add Leetcode questions which helped me understanding, under the hood functioning of the HashMap as I start revising those!