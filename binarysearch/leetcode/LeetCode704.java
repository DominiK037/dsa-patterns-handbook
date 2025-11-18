package binarysearch.leetcode;

public final class LeetCode704 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        //  Using only '<'' will cause missing the last element, since we are checking midIndex based on left & right. So if left & right don't meet, we will miss checking the last element.
        while (left <= right) {
            //  To prevent integer overflow.
            int midIndex = left + (right - left) / 2;
            int midValue = nums[midIndex];

            if (midValue == target) {
                return midIndex;
            } else if  (target > midValue) {    //  Search in the right half.
                left = midIndex + 1;
            } else {                       //  Search in the left half.
                right = midIndex - 1;
            }
        }
        //  If target is not present, return -1.
        return -1;
    }
}

//  Problem Link: https://leetcode.com/problems/binary-search/description/
//  Time Complexity: O(log N) where N is the number of elements in the array.
//  Space Complexity: O(1) as we are not using any extra space, apart from a few variables which are also considered constant space.