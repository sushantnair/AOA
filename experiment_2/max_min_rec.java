import java.util.*;

class MaxMin {
    public int max, min;

    public MaxMin(int max, int min) {
        this.max = max;
        this.min = min;
    }
}

public class max_min_rec {
    static void Max_Min_Recursive(int arr[], int i, int j, MaxMin mm) {
        if (i == j) {
            if (mm.max < arr[i]) {
                mm.max = arr[i];
            }
            if (mm.min > arr[j]) {
                mm.min = arr[j];
            }
            return;
        }
        if (j - i == 1) {
            if (arr[i] < arr[j]) {
                if (mm.min > arr[i]) {
                    mm.min = arr[i];
                }
                if (mm.max < arr[j]) {
                    mm.max = arr[j];
                }
            } else {
                if (mm.min > arr[j]) {
                    mm.min = arr[j];
                }
                if (mm.max < arr[i]) {
                    mm.max = arr[i];
                }
            }
            return;
        }
        int mid = (i + j) / 2;
        Max_Min_Recursive(arr, i, mid, mm);
        Max_Min_Recursive(arr, mid + 1, j, mm);
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = 1000;
        int arr[] = new int[n];
        Random randomnumber = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = randomnumber.nextInt(1000);
            System.out.print("\t" + arr[i]);
        }
        System.out.println("");
        MaxMin mm = new MaxMin(0, 1000);
        long start = System.nanoTime();
        Max_Min_Recursive(arr, 0, n - 1, mm);
        long end = System.nanoTime();
        long time = end - start;
        System.out.print("The number of elements in the array is 1000.");
        System.out.print("\nThe minimum is " + mm.min);
        System.out.print("\nThe maximum is " + mm.max);
        System.out.print("\nThe time taken for Min Max Algorithm using Recursive approach is " + time);
    }
}
