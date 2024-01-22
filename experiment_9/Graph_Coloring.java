import java.util.*;

public class Graph_Coloring {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int num_vert;
        System.out.println("Enter the number of vertices in the graph: ");
        num_vert = in.nextInt();
        // int graph[][] = new int[num_vert][num_vert];
        /*
         * for (int i = 0; i < num_vert; i++) {
         * for (int j = 0; j < num_vert; j++) {
         * System.out.print("\nEnter value for [" + i + "][" + j + "]: ");
         * graph[i][j] = in.nextInt();
         * }
         * }
         */
        // It is tedious to enter each element of a graph many times for
        // different test cases. So, initializing graph at once before running.
        /*
         * int graph[][] = { { 0, 1, 1, 0, 0, 1, 1, 1 },
         * { 1, 0, 0, 1, 0, 1, 0, 1 },
         * { 1, 0, 0, 1, 1, 0, 1, 1 },
         * { 0, 1, 1, 0, 1, 0, 0, 1 },
         * { 0, 0, 1, 1, 0, 0, 0, 0 },
         * { 1, 1, 0, 0, 0, 0, 0, 0 },
         * { 1, 0, 1, 0, 0, 0, 0, 0 },
         * { 1, 1, 1, 1, 0, 0, 0, 0 } };
         */
        int graph[][] = { { 0, 1, 1, 0 },
                { 1, 0, 1, 1 },
                { 1, 1, 0, 1 },
                { 0, 1, 1, 0 } };
        System.out.print("\nDisplaying entry:\n ");
        for (int i = 0; i < num_vert; i++) {
            for (int j = 0; j < num_vert; j++) {
                System.out.print("\t" + graph[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\nEnter the maximum chromatic number for the graph: ");
        int m = in.nextInt();
        long start = System.currentTimeMillis();
        graphColoring(num_vert, graph, m);
        long end = System.currentTimeMillis();
        System.out.print("\nTime taken for Graph Coloring Algorithm for graph with " + num_vert + " vertices is "
                + (end - start) + " milliseconds.");
        in.close();
    }

    static void graphColoring(int num_vert, int graph[][], int m) {
        Scanner in = new Scanner(System.in);
        int color[] = new int[num_vert];
        color[0] = 0; // Assign first color for the first node
        boolean colorUsed[] = new boolean[num_vert]; // Used to check whether color is used or not
        int col_assigned = 0;

        for (int i = 1; i < num_vert; i++)
            color[i] = -1; // initialize all other vertices are unassigned

        for (int i = 0; i < num_vert; i++)
            colorUsed[i] = false; // initially any colors are not chosen

        for (int u = 1; u < num_vert; u++) { // for all other NODE - 1 vertices
            for (int v = 0; v < num_vert; v++) {
                if (graph[u][v] == 1) {
                    if (color[v] != -1) // when one color is assigned, make it unavailable
                        colorUsed[color[v]] = true;
                }
            }

            int col;
            for (col = 0; col < num_vert; col++)
                if (!colorUsed[col]) // find a color which is not assigned
                    break;

            color[u] = col; // assign found color in the list
            col_assigned++;

            for (int v = 0; v < num_vert; v++) { // for next iteration make color availability to false
                if (graph[u][v] == 1) {
                    if (color[v] != -1)
                        colorUsed[color[v]] = false;
                }
            }
        }
        System.out.print("The total number of colors assigned is " + col_assigned);
        if (col_assigned <= m) {
            System.out.print(
                    "\nIt is possible to color the graph as the number of colors assigned is less than or equal to maximum chromatic number.");
        } else {
            System.out.print(
                    "\nIt is not possible to color the graph as the number of colors assigned greater than the maximum chromatic number.");
        }

        for (int u = 0; u < num_vert; u++) {
            System.out.print("\nVertex " + u + " is assigned with color " + color[u]);
        }
        in.close();
    }
}
