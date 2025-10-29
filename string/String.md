# String

## Introduction

- String is a sequence of chars(characters)

- Strings are similar to Arrays, it's just change of variable type in my opinion.

- Most of the patterns which we use to solve array related questions, can be used to string related questions too.


## Common terms

- Palindrom: A word or sequence that reads the same way from start to end & end to start.
    - **Valid Palidrome**: `"s o s"` **|** start to end -> `"s o s"` **|** end to start -> `"s o s"` **|**

    - **Invalid Palidrome**: `"c a t"` **|** start to end -> `"c a t"` **|** end to start -> `"t a c"` **|**

- Anagram: It is a string formed by rearranging all the characters of another string so that each character appears the same number of times in both.

    - `"listen"` & `"silent"` are anagrams because they contain the same letters with identical frequencies.

        ````
            'l' -> 1,
            'i' -> 1,
            's' -> 1,
            't' -> 1,
            'e' -> 1,
            'n' -> 1
        ````

    - Approaches to check Palidrome:

        - Compare strings after sorting.
        - Frequency counting of characters with the help of hash tables (My favourite)

## Time complexities

| Operation | Time Complexity | Notes |
|------------|----------------|-------|
| Access Character (`charAt(i)`) | `O(1)` | Direct access using index. |
| Length of String (`length()`) | `O(1)` | Stored internally, no traversal needed. |
| Compare Strings (`equals()`) | `O(n)` | Compares each character until mismatch or end. |
| Concatenation (`+`, `concat()`) | `O(n)` | Creates a new String since Strings are immutable. Use `StringBuilder` for repeated concatenations. |
| Substring (`substring()`) | `O(k)` | Copies `k` characters to a new String. |
| Search (`indexOf()`, `contains()`) | `O(n)` | Scans string sequentially to find match. |
| Split / Join (`split()`, `String.join()`) | `O(n)` | Processes full string for delimiter matching or joining. |
| Palindrome Check | `O(n)` | Compare characters from both ends using `charAt()`. |
| Anagram Check | `O(n)` | Use frequency array (`int[26]`) or HashMap for counting characters. |


## Things to look out for during interviews

- Are there upper cases only?
- Are there lower cases only?
- Can have both upper & lower cases?
- May contain special characters?


## Corner cases

- I will add these as I revise questions on strings.


## Patterns

1. Two Pointers
2. Sliding Window
3. Hashmaps
4. String manipulation