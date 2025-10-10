class IntervalListIntersections986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();

        int firstPointer = 0;
        int secondPointer = 0;

        while (firstPointer < firstList.length && secondPointer < secondList.length) {
            int firstStart = firstList[firstPointer][0];
            int firstEnd = firstList[firstPointer][1];
            int secondStart = secondList[secondPointer][0];
            int secondEnd = secondList[secondPointer][1];

            // Find overlapping region, if any
            int overlappingStart = Math.max(firstStart, secondStart);
            int overlappingEnd = Math.min(firstEnd, secondEnd);

            // If overlappingStart <= overlappingEnd, it means the intervals overlap
            if (overlappingStart <= overlappingEnd) {
                intersections.add(new int[] { overlappingStart, overlappingEnd });
            }

            // Move the pointer of the interval that ends first
            if (firstEnd < secondEnd) {
                firstPointer++;
            } else {
                secondPointer++;
            }
        }

        return intersections.toArray(new int[intersections.size()][]);
    }
}

//  Time complexity: O(n)
//      We are visiting each interval once, so : O(n)
//      Accesing arrays by indices is constant : O(1)
//      Converting the list into array needs to make 1 iteration : O(n)

//  Space complexity: O(k)
//      Using a list for storing overlapping intersections : < O(n)