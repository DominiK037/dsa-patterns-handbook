## Pattern: Merge Intervals

### **How do I recognize this pattern?** 
  
- Problems involving **"intervals".**
- Find overlapping intervals.
- Merge intervals.

### About Intervals:

- Interval could be **an array/list** of two or more elements.


- Each element represents a subset of time stamps.


- Ex: `[[startTime, endTime], [startTime, endTime]]`


- I prefer sorting intervals with their `startTime`. Because, it becomes much easier to compare `startTime` & `endTime` of neighbouring intervals.


### Given two intervals (`x` & `y`), they can relate to each other in below ways.


  1. `x` & `y` do not overlap.

     `(x.endTime < y.startTime)`


  2. `x` & `y` overlaps, but `x` ends before `y`.
      
      `(x.endTime > y.startTime) && (x.endTime < y.endTime)`


  3. `x` & `y` overlaps, but `x` ends after `y`.

     `(x.endTime > y.startTime) && (x.endTime > y.endTime)`

   
  4. `x` completely overlaps `y`.

     `(x.startTime < y.startTime) && (x.endTime > y.endTime)`


  5. `x` gets completely overlapped by `y`.

     `(x.startTime == y.startTime) && (x.endTime < y.endTime)`

### Variations & Time Complexities Are Discussed Question-wise!

> Resources & Sequence I followed:

1. [chanda-abdul-github-repository](https://github.com/Chanda-Abdul/Several-Coding-Patterns-for-Solving-Data-Structures-and-Algorithms-Problems-during-Interviews/blob/main/%E2%9C%85%20%20Pattern%2004%20:%20Merge%20Intervals.md)
2. Draw on notebook/whiteboard for better understanding **(Important)**
3. [Merge Intervals](https://leetcode.com/problems/merge-intervals/description/) (56-Medium | Solution Available✅)
4. [build-visualisation-from-neetcode-approach](https://youtu.be/44H3cEC2fFM?si=fC9UFZBUmgaHmyev)
5. [Insert Interval](https://leetcode.com/problems/insert-interval/description/) (57-Medium | Solution Available✅)
6. [Non Overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/) (435-Medium | Solution Available✅)
7. [Interval List Intersection](https://leetcode.com/problems/interval-list-intersections/description/) (986-Medium | Solution Available✅)
