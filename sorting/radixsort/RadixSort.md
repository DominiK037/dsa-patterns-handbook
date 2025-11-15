[← Go back](/sorting/Sorting.md)

# Radix Sort (LSD – Least Significant Digit First)

- Radix Sort is a sorting algorithm that works digit by digit, starting from the rightmost digit (least significant digit) and moving towards the leftmost digit (most significant digit).

- It uses a stable sort (like counting sort) at each digit position.

- Steps:

    1. **Equalize Digit Length**
        - Make sure all numbers have the same number of digits.
        - Add leading zeros to shorter numbers.
        - Example: if the largest number has 3 digits,
            - `7` → `007`
            - `45` → `045`
            - `123` → `123`

    2. **Sort by Least Significant Digit** (start with units place)
        - Sort all numbers based on the last digit (units place).
        - Group numbers by their units digit (0–9).
        - Rebuild the array using these groups in order 0 → 9.

    3. **Use a Stable Sort**
        - While sorting by a digit, if two numbers have the same digit, their original order must be preserved.
        - This is called a **stable sort**.
        - Stability is important so that sorting by the next digit still works correctly.

    4. **Move to the Next Digit** (tens, hundreds, and so on..)
        - Continue from least significant digit (LSD) to most significant digit (MSD). 
        - Each time, use the same stable digit-wise sorting.

    5. **After the Most Significant Digit, the Array is Sorted**
        - Once you finish sorting by the leftmost digit, the entire array will be in sorted order.

### Complexities:

- Time Complexity: `O(d * (n + k))`, because the algorithm processes each of the `d` digits, and for every digit it performs a stable sort over `n` items and `k` possible digit values.

- Space Complexity: `O(n + k)` extra space is needed for buckets `k` (0–9) and for holding output during each digit sort.