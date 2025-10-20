class MeetingRoomsTwo253 {
    public static int minMeetingRooms(int[][] intervals) {
        int totalMeetings = intervals.length;

        // Separate start times and end times into two arrays
        int[] starts = new int[totalMeetings];
        int[] ends = new int[totalMeetings];

        for (int i = 0; i < totalMeetings; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int roomsNeeded = 0;
        int ongoingMeetings = 0;
        int startIndex = 0;
        int endIndex = 0;

        while (startIndex < totalMeetings) {
            //  Next meeting starts before the earliest meeting ends → need a new room
            if (starts[startIndex] < ends[endIndex]) {
                ongoingMeetings++;
                startIndex++;
            }
            //  A meeting has ended before the next one starts → free up a room
            else {
                ongoingMeetings--;
                endIndex++;
            }
            // Maximum number of rooms used at any time
            roomsNeeded = Math.max(roomsNeeded, ongoingMeetings);
        }

        return roomsNeeded;
    }
}

//  Time complexity: O(n log n)
//      Visiting each interval to fill starts & ends array: O(n)
//      Sorting is gonna take: O(n log n)
//      Once again visiting intervals again: O(n)

//  Space complexity: O(n)
//      Using 2 different arrays for saving interval's starts & ends: O(2n)
//      Sorting is going to take extra space: O(n)