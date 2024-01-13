import java.util.*;

public class Insertion {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n, i, j, key;
        Random randomnumber = new Random();
        System.out.print("Enter the number of elements to sort: ");
        n = in.nextInt();
        int arr1[] = new int[n]; // to be sorted using Insertion sort
        for (i = 0; i < n; i++) {
            // System.out.print("For index "+(i+1)+", enter value: ");
            // arr1[i] = in.nextInt();
            arr1[i] = randomnumber.nextInt(1000);
        }
        System.out.print("The random-generated array is ");
        for (i = 0; i < n; i++) {
            System.out.print("\t" + arr1[i]);
        }
        System.out.println("\n\n");
        long start1 = System.currentTimeMillis();
        for (i = 0; i < n; i++) {
            key = arr1[i];
            j = i - 1;
            while (j >= 0 && key < arr1[j]) {
                arr1[j + 1] = arr1[j];
                j = j - 1;
            }
            arr1[j + 1] = key;
        }
        long end1 = System.currentTimeMillis();
        long time1 = end1 - start1;
        System.out.print("The first array after Insertion sort is ");
        for (i = 0; i < n; i++) {
            System.out.print("\t" + arr1[i]);
        }
        System.out.println("\n");
        System.out.println("The number of elements are " + n);
        System.out.println("Time taken for Insertion Sort is " + time1 + " milliseconds.");
    }
}
