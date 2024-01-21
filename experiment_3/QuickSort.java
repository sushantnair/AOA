import java.util.*;

public class QuickSort {
    int sub_problem_processing(int arr[], int start, int end) {
        int pivot = arr[end];
        int i = (start - 1);
        for (int j = start; j <= end - 1; j++) {
            // if current element is smaller than pivot
            if (arr[j] < pivot) {
                i++; // increment index of smaller element
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp1 = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = temp1;
        return (i + 1);
    }

    void sub_problem_definition(int arr[], int start, int end) {
        if (start < end) {
            int p = sub_problem_processing(arr, start, end); // p is partitioning index
            sub_problem_definition(arr, start, p - 1);
            sub_problem_definition(arr, p + 1, end); // divide and conquer approach
        }
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
        EXPT_03_QuickSort obj = new EXPT_03_QuickSort();
        long start = System.currentTimeMillis();
        obj.sub_problem_definition(arr, 0, n - 1);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print("\nAfter sorting by Quick Sort, the array elements are ");
        for (int i = 0; i < n; i++) {
            System.out.print("\t" + arr[i]);
        }
        System.out.print("\nThe number of elements in array are " + n + ".");
        System.out.print("\nThe time taken by Quick Sort is " + time + " milliseconds.");
    }
}
