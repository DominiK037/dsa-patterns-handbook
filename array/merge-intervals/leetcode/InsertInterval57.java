class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> validIntervals = new ArrayList<>();

        int index = 0;
        int MAX_INTERVALS = intervals.length;

        // Add all intervals that end before newInterval starts
        while ((index < MAX_INTERVALS) && (newInterval[0] > intervals[index][1])) {
            validIntervals.add(intervals[index]);
            index++;
        }

        // Merge all intervals that overlap with newInterval
        while ((index < MAX_INTERVALS) && (newInterval[1] >= intervals[index][0])) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }

        // Add the merged newInterval
        validIntervals.add(newInterval);

        // Add remaining intervals
        while (index < MAX_INTERVALS) {
            validIntervals.add(intervals[index]);
            index++;
        }

        return validIntervals.toArray(new int[validIntervals.size()][]);
    }
}

//  Time complexity: O(n)
//      We are only visiting each interval once with the help of index: O(n)
//      All of the accessing to the elements from given arrays        : O(1)
//      Converting a list toArray                                     : O(n)
//      We only take worst time complexity so O(2n) will be converted to O(n)

//  Space complexity: O(n)
//      we need to return a list containing all the merged 'n' intervals