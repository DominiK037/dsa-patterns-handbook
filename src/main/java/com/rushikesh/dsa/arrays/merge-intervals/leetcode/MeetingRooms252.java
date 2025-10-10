class MeetingRooms252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        //  Sort intervals with their startTime.
        Arrays.sort(intervals, (intervalOne, intervalTwo) -> Integer.compare(intervalOne[0], intervalTwo[0]));

        for (int index = 1; index < intervals.length; index++) {
            int prevEnd = intervals[index - 1][1];
            int start = intervals[index][0];

            if (start < prevEnd) {
                return false;
            }
        }

        return true;
    }
}

//  Time complexity: O(n log n)
//      Arraay sorting takes : O(n log n)
//      We are visiting each interval once in for loop: O(n)
//      Accessing array element is : O(1)
//      O(n log n) is worst than O(n) so time complexity would be O(n log n)

//  Space complexity: O(n)
//      Sorting will take fixed amount of space since we have literal values i.e ints but still: O(n)
//      Variables are taking constant space: O(1)