[← Go back](/sorting/Sorting.md)

# Counting Sort

- You are given an input array and a known maximum value (the range).
    - Example: if the largest number in the input is `k`, the range is `(0…k)`.

- Create a count array of size `k + 1`.
    - Each index represents a number.
    - Each value represents how many times that number appears.

- Iterate through the input array:
    - For each element `x`, increment `count[x]`.
    - This step counts frequencies of all numbers.

- Build the sorted output:
    - Walk through the count array from index `0 → k`.
    - For every index `i`, append `i` exactly `count[i]` times.
    - This reconstructs the sorted array directly.
                
- Counting sort works only when the range is small.

- You can make Counting Sort stable by converting the count array into a prefix-sum array, which tells the last position where each element should appear in the final sorted output.

### Complexities

- **Time Complexity:** O(n + k) where n is the number of elements in the input array and k is the range of the input (maxValue).

- **Space Complexity:** O(k) for the count array and O(n) for the output array, resulting in O(n + k) overall. So final space complexity is O(n + k).


### Resources

- Watch any video on a YouTube to understand basic CountingSort.

- Using prefix-sum on CoutingSort makes it stable, so understand it first.

- If you're familiar with prefix-sum, then I have a code attached for it below. I just read the working on a ChatGPT, and it made everything clear so this wouldn't be hard if you're used to playing around indices. I still hate it hahahaha!

- Explained **prefix-sum** [CountingSort code](/sorting/countingsort/CountingSort.java)