import java.util.*;

public class MergeSort {
    static void Merge_Arrays(int arr[], int start, int mid, int end) {
        int leftarr_end = mid;
        int rightarr_start = mid + 1;
        int l = start;
        while ((l <= leftarr_end) && (rightarr_start <= end)) {
            if (arr[start] < arr[rightarr_start]) {
                start++;
            } else {
                int temp = arr[rightarr_start];
                for (int j = rightarr_start - 1; j >= start; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[start] = temp;
                start++;
                leftarr_end++;
                rightarr_start++;
            }
        }
    }

    static void Merge_Sort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        Merge_Sort(arr, start, mid);
        Merge_Sort(arr, mid + 1, end);
        Merge_Arrays(arr, start, mid, end);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements for array: ");
        int n = in.nextInt();
        int arr[] = new int[n];
        Random randomnumber = new Random();
        System.out.print("\nThe randomly-generated array is ");
        for (int i = 0; i < n; i++) {
            arr[i] = randomnumber.nextInt(1000);
            System.out.print("\t" + arr[i]);
        }
        long start = System.currentTimeMillis();
        Merge_Sort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print("\nAfter sorting by Merge Sort, the array elements are ");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + arr[i]);
        }
        System.out.print("\nThe number of elements in array are " + n + ".");
        System.out.print("\nThe time taken by Merge Sort is " + time + " milliseconds.");
    }
}
