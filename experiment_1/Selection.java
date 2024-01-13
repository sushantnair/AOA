import java.util.*;

public class Selection {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n, i, j, min, temp;
        Random randomnumber = new Random();
        System.out.print("Enter the number of elements to sort: ");
        n = in.nextInt();
        int arr2[] = new int[n]; // to be sorted using Selection sort
        for (i = 0; i < n; i++) {
            // System.out.print("For index "+(i+1)+", enter value: ");
            // arr1[i] = in.nextInt();
            arr2[i] = randomnumber.nextInt(1000);
        }
        System.out.println("\n\n");
        System.out.print("The random-generated array is ");
        for (i = 0; i < n; i++) {
            System.out.print("\t" + arr2[i]);
        }
        System.out.println("");
        long start2 = System.currentTimeMillis();
        for (i = 0; i < n - 1; i++) {
            min = i;
            for (j = i + 1; j < n; j++)
                if (arr2[j] < arr2[min])
                    min = j;
            temp = arr2[min];
            arr2[min] = arr2[i];
            arr2[i] = temp;
        }
        long end2 = System.currentTimeMillis();
        long time2 = end2 - start2;
        System.out.println("");
        System.out.print("The second array after Selection sort is ");
        for (i = 0; i < n; i++) {
            System.out.print("\t" + arr2[i]);
        }
        System.out.println("\n");
        System.out.println("The number of elements are " + n);
        System.out.println("Time taken for Selection Sort is " + time2 + " milliseconds.");
    }
}
