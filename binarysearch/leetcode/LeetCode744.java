package binarysearch.leetcode;

public final class LeetCode744 {
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int midIndex = start + (end - start) / 2;
            char midValue = letters[midIndex];
            
            //  We are not checking for equality here, as we need to find the smallest letter greater than target. Which we are doing by placing the left & right pointers accordingly.
            if (midValue < target) {    //  Search in the right half.
                start = midIndex + 1;
            } else {                       //  Search in the left half.
                end = midIndex - 1;
            }
        }
        //  If target is greater than or equal to the last element, return the first element.
        return letters[start % letters.length];
    }
}

//  Problem Link: https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
//  Time Complexity: O(log N) where N is the number of elements in the array.
//  Space Complexity: O(1) as we are not using any extra space, apart from a few variables which are also considered constant space.