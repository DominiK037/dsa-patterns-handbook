class NonOverlappingIntervals435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        int eraseIntervals = 0;
        int prevEnd = intervals[0][1];

        for (int index = 1; index < intervals.length; index++) {
            int start = intervals[index][0];
            int end = intervals[index][1];

            //  If the current interval doesn't overlap, update prevEnd for the next comparison
            if (start >= prevEnd) {
                prevEnd = end;
            }
            //  If the current interval overlaps with previous interval, one interval must be removed
            else {
                eraseIntervals++;
                //  Choose to keep which ends earlier & remove which ends later
                prevEnd = Math.min(end, prevEnd);
            }
        }

        return eraseIntervals;
    }
}

//  Time complexityL O(n log n)
//      Sorting all intervals by start time: O(n log n)
//      We are only visiting each interval once with the help of index so: O(n)

//  Space complexity: O(1)
//      Sorting uses memory, but since we have literal value(int) small constant extra space would be needed: O(1)
//      If we had to sort objects then space complexity would be: O(n)
