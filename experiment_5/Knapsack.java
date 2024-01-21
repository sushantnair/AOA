import java.util.*;

public class Knapsack {
    // Sort by profit in descending order
    void Merge_Arrays_Profit(Item arr[], int start, int mid, int end) {
        int leftarr_end = mid;
        int rightarr_start = mid + 1;
        int l = start;
        while ((l <= leftarr_end) && (rightarr_start <= end)) {
            if (arr[start].pf > arr[rightarr_start].pf) {
                start++;
            } else {
                Item temp = arr[rightarr_start];
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

    void Merge_Sort_Profit(Item arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        Merge_Sort_Profit(arr, start, mid);
        Merge_Sort_Profit(arr, mid + 1, end);
        Merge_Arrays_Profit(arr, start, mid, end);
    }

    // sort by weight in ascending order
    void Merge_Arrays_Weight(Item arr[], int start, int mid, int end) {
        int leftarr_end = mid;
        int rightarr_start = mid + 1;
        int l = start;
        while ((l <= leftarr_end) && (rightarr_start <= end)) {
            if (arr[start].wt < arr[rightarr_start].wt) {
                start++;
            } else {
                Item temp = arr[rightarr_start];
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

    void Merge_Sort_Weight(Item arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        Merge_Sort_Weight(arr, start, mid);
        Merge_Sort_Weight(arr, mid + 1, end);
        Merge_Arrays_Weight(arr, start, mid, end);
    }

    // sort by profit by weight in descending order
    void Merge_Arrays_Profit_Weight(Item arr[], int start, int mid, int end) {
        int leftarr_end = mid;
        int rightarr_start = mid + 1;
        int l = start;
        while ((l <= leftarr_end) && (rightarr_start <= end)) {
            if (arr[start].pw > arr[rightarr_start].pw) {
                start++;
            } else {
                Item temp = arr[rightarr_start];
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

    void Merge_Sort_Profit_Weight(Item arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        Merge_Sort_Profit_Weight(arr, start, mid);
        Merge_Sort_Profit_Weight(arr, mid + 1, end);
        Merge_Arrays_Profit_Weight(arr, start, mid, end);
    }

    void Max_Profit(Item arr[], float max_size) {
        fresh(arr);
        float current_size = 0, max_profit = 0;
        int i = 0;
        while (i < arr.length && current_size < max_size) {
            float space_available = max_size - current_size;
            if (arr[i].wt <= space_available) {
                arr[i].wei_cons = 1;
                current_size = current_size + arr[i].wt;
                max_profit = max_profit + arr[i].pf;
            } else if (arr[i].wt > space_available) {
                float size_constant = space_available / arr[i].wt;
                arr[i].wei_cons = size_constant;
                current_size = max_size;
                max_profit = max_profit + (arr[i].pf * size_constant);
            }
            i++;
        }
        System.out.print("\nThe Maximum Profit is " + max_profit);
        String solution = "", weight = "";
        for (i = 0; i < arr.length; i++) {
            solution = solution + (arr[i].wei_cons + " ");
            weight = weight + (arr[i].wt + " ");
        }
        System.out.print("\nWeights = { " + weight + " }");
        System.out.print("\nSolution = { " + solution + " }\n");
    }

    void fresh(Item arr[]) {
        for (int i = 0; i < arr.length; i++)
            arr[i].wei_cons = 0;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num;
        float weight, profit, size;
        System.out.print("Enter the number of items in knapsack: ");
        num = in.nextInt();
        Item arr[] = new Item[num];
        System.out.print("\nEnter the details of each item.");
        for (int i = 0; i < num; i++) {
            System.out.print("\nFor item " + (i + 1) + ", enter: ");
            System.out.print("\nWeight: ");
            weight = in.nextFloat();
            System.out.print("\nProfit: ");
            profit = in.nextFloat();
            arr[i] = new Item(weight, profit);
        }
        System.out.print("\nEnter the size of knapsack: ");
        size = in.nextFloat();
        Knapsack obj = new Knapsack();
        long start = System.currentTimeMillis();
        System.out.print("\nCase I (Maximum Profit): ");
        obj.Merge_Sort_Profit(arr, 0, arr.length - 1);
        obj.Max_Profit(arr, size);
        System.out.print("\nCase II (Minimum Weight): ");
        obj.Merge_Sort_Weight(arr, 0, arr.length - 1);
        obj.Max_Profit(arr, size);
        System.out.print("\nCase III (Profit By Weight): ");
        obj.Merge_Sort_Profit_Weight(arr, 0, arr.length - 1);
        obj.Max_Profit(arr, size);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print("\nTime taken is " + time + " milliseconds.");
    }
}

class Item {
    float wt, pf, pw, wei_cons;

    Item(float wt, float pf) {
        this.wt = wt;
        this.pf = pf;
        pw = pf / wt;
    }
}
