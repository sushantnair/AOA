import java.util.*;

public class bin_srch_itr {
    void iterative_binary_search(int a[], int s) {
        // System.out.println("The array involved in search operation is, ");
        // for(int i = 0; i < a.length; i++)
        // {
        // System.out.print("\t"+a[i]);
        // }
        // System.out.println("\nAnd, the element to search is: "+s);
        long start = System.nanoTime();
        int low, mid, high, it;
        it = 0;
        low = 0;
        high = a.length;
        mid = (low + high) / 2;
        while (low <= high) {
            if (s == a[mid]) {
                System.out.println("The element " + s + " has been found after " + it + " iterations.");
                break;
            } else if (s < a[mid]) {
                high = mid - 1;
            } else if (s > a[mid]) {
                low = mid + 1;
            }
            mid = (low + high) / 2;
            it++;
        }
        long end = System.nanoTime();
        long time = end - start;
        System.out.println("The time taken for the binary search using ITERATIVE METHOD is " + time + " nanoseconds.");
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        Random randomnumber = new Random();
        int n, i, j, key, search;
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
        bin_srch_itr obj = new bin_srch_itr();
        obj.iterative_binary_search(arr, search);
        in.close();
    }
}
