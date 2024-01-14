import java.util.*;

public class bin_srch_rec {
    static int num;

    int recursive_binary_search(int a[], int s, int l, int h) {
        num++;
        int mid;
        mid = (l + h) / 2;
        if (s == a[mid]) {
            return mid;
        } else if (s < a[mid]) {
            return recursive_binary_search(a, s, l, mid - 1);
        } else if (s > a[mid]) {
            return recursive_binary_search(a, s, mid + 1, h);
        }
        return -1;
    }
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n, i, j, key, search, pos;
        Random randomnumber = new Random();
        System.out.print("Enter the number of elements: ");
        n = in.nextInt();
        System.out.println("");
        int arr[] = new int[n];
        System.out.println("The random-generated array is: ");
        for (i = 0; i < n; i++) {
            // System.out.print("For index "+(i+1)+", enter value: ");
            // arr[i] = in.nextInt();
            arr[i] = randomnumber.nextInt(10000);
            System.out.print("\t" + arr[i]);
        }
        System.out.println();
        System.out.println("Sorting using Insertion sort, ");
        for (i = 0; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && key < arr[j]) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        System.out.println("The sorted array is:\n ");
        for (i = 0; i < n; i++) {
            System.out.print("\t" + arr[i]);
        }
        System.out.println("");
        System.out.print("Enter the number which you want to search: ");
        search = in.nextInt();
        int low, high;
        low = 0;
        high = n;
        bin_srch_rec obj = new bin_srch_rec();
        long start = System.nanoTime();
        pos = obj.recursive_binary_search(arr, search, low, high);
        if (pos == -1)
            System.out.println("The element was not found.");
        else {
            System.out.println("The element " + search + " has been found after " + num + " function calls.");
            System.out.println("Position is " + pos);
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("The time taken for the binary search using RECURSIVE METHOD is " + time + " nanoseconds.");
        in.close();
    }
}
