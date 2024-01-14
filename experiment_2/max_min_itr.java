import java.util.*;

public class max_min_itr {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = 1000;
        int arr[] = new int[n];
        Random randomnumber = new Random();
        System.out.print("The randomly-generated array is\n");
        for (int i = 0; i < n; i++) {
            arr[i] = randomnumber.nextInt(1000);
            System.out.print("\t" + arr[i]);
        }
        int max = arr[0];
        int min = arr[0];
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.print("\nThe number of elements in the array is 1000.");
        System.out.print("\nThe minimum is " + min);
        System.out.print("\nThe maximum is " + max);
        System.out.print("\nThe time taken for Min Max Algorithm using Iterative approach is " + time);
        in.close();
    }
}
