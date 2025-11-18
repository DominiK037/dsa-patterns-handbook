package sorting.countingsort;

public class CountingSort {
    public static int[] countingSort(int[] nums) {
        //  Empty array has no max
        if (nums.length == 0) {
            return nums;
        }

        //  Find max value (range)
        int maxValue = 0;   //  Negavtive numbers can't be handled by counting sort
        for (int num : nums) {
            if (num > maxValue) {
                maxValue = num;
            }
        }

        //  Create count array and store frequencies
        int[] count = new int[maxValue + 1];
        for (int num : nums) {
            count[num]++;
        }

        //  Make count array a prefix sum array
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }

        int[] output = new int[nums.length];

        //  Build the output array from the end to maintain stability
        for (int i = nums.length - 1; i >= 0; i--) {
            //  current number, starting from the end
            int num = nums[i];
            // This would be a last position of current number in the output array
            int position = count[num] - 1;
            //  Place the number at its position
            output[position] = num;
            //  Decrease the count for current number, as we've placed one occurrence of it. So position will change for next occurrence now.
            count[num]--;
        }

        return output;
    }

    //  Testing the counting sort implementation
    public static void main(String[] args) {

        int[] t1 = {2, 5, 3, 0, 2, 3, 0, 3};
        int[] t2 = {4, 4, 1, 0, 1, 3};
        int[] t3 = {9, 9, 9, 9};
        int[] t4 = {0, 1, 2, 3, 4};
        int[] t5 = {4, 3, 2, 1, 0};

        System.out.println("Test 1 → " + java.util.Arrays.toString(countingSort(t1)));
        System.out.println("Test 2 → " + java.util.Arrays.toString(countingSort(t2)));
        System.out.println("Test 3 → " + java.util.Arrays.toString(countingSort(t3)));
        System.out.println("Test 4 → " + java.util.Arrays.toString(countingSort(t4)));
        System.out.println("Test 5 → " + java.util.Arrays.toString(countingSort(t5)));
    }
}
