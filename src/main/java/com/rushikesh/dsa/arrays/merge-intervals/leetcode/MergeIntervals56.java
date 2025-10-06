class MergeIntervals56 {
    public static int[][] merge(int[][] intervals) {

        //  Sort intervals with their startTime.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            int previousEnd = mergedIntervals.getLast()[1];

            // If intervals overlap, merge them by extending the end time
            if (previousEnd >= start) {
                mergedIntervals.getLast()[1] = Math.max(previousEnd, end);
            } else {
                mergedIntervals.add(new int[][]  start, end});
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}

//  Time complexity: O(n log n)
//      sorting all intervals by start time  : O(n log n)
//      single pass to merge overlapping ones: O(n)
//      .getLast() is constant time          : O(1)
//      Converting a list toArray            : O(n)
//      We normally look at the worst time complexity, that is why O(2n) gets cancelled by O(n log n).

//  Space complexity: O(n)
//      Space complexity is also going to be O(n) because we are creating a new List to add & work with 'n' intervals.