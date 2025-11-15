package sorting.quicksort;

public class QuickSort {
    //  Testing QuickSort implementation
    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62};

        quickSort(arr, 0, arr.length - 1);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        //  Base case: If the array has one or no elements, it's already sorted
        if (end <= start) {
            return;
        }
        //  Get the pivot first        
        int pivotIndex = partition(arr, start, end);
        quickSort(arr, start, pivotIndex - 1);  //  Sort left subarray
        quickSort(arr, pivotIndex + 1, end);    //  Sort right subarray

    }

    //  Return the location of the pivot.
    private static int partition(int[] arr, int start, int end) {
        //  Choosing the last element as pivot
        int pivot = arr[end];
        int i = start - 1;  //  Pointer for the smaller element
        
        for (int j = start; j < end; j++) {
            //  Not using <= to make it unstable sort, i.e., equal elements may not retain their relative order
            if (arr[j] < pivot) {
                i++;    //  Increment first
                //  Then swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //  Place the pivot in the correct position
        i++;
        //  By now, 'i' will be at the position where pivot needs to be placed i.e., all elements before 'i' are smaller than pivot and all elements after 'i' are greater than or equal to pivot
        int temp = arr[i];
        arr[i] = pivot;
        arr[end] = temp;

        return i;
    }
}


