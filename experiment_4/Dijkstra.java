import java.util.*;

public class Dijkstra {
    static final int n = 6;

    int minimum_distance_from_source(int distance[], Boolean visited[]) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int v = 0; v < n; v++)
            if (visited[v] == false && distance[v] <= min) {
                min = distance[v];
                min_index = v;
            }
        return min_index;
    }

    void print_solution(int distance[], int n) {
        System.out.print("Vertex    Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.print("\n" + i + "\t\t  " + distance[i]);
    }

    void dijkstra(int graph[][], int source) {
        int distance[] = new int[n];
        // distance of n vertices from the source
        Boolean visited[] = new Boolean[n];
        // to check if each one of the n vertices has been visited or not
        for (int i = 0; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
            // initializing the distance of n vertices from source to be infinity
            visited[i] = false;
            // initializing the truth value of visit of n vertices to be false
        }
        distance[source] = 0;
        // distance of source vertex from itself is 0
        for (int count = 0; count < n - 1; count++) {
            // finding shortest path for each vertex
            int u = minimum_distance_from_source(distance, visited);
            // finding the minumum distance of uth vertex from source
            visited[u] = true;
            // uth vertex has been visited
            for (int v = 0; v < n; v++)
                if (!visited[v] && graph[u][v] != 0 && distance[u] != Integer.MAX_VALUE
                        && distance[u] + graph[u][v] < distance[v])
                    distance[v] = distance[u] + graph[u][v];
        }
        print_solution(distance, n);
    }

    public static void main(String args[]) {
        int graph[][] = new int[][] { { 0, 2, 4, 0, 0, 0 },
                { 2, 0, 1, 7, 0, 0 },
                { 4, 1, 0, 0, 3, 0 },
                { 0, 7, 0, 0, 2, 1 },
                { 0, 0, 3, 2, 0, 5 },
                { 0, 0, 0, 1, 5, 0 } };
        Dijkstra obj = new Dijkstra();
        int source_index = 0;
        long start = System.currentTimeMillis();
        obj.dijkstra(graph, source_index);
        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.print("\nTime taken by Dijkstra's Algorithm is " + time + " milliseconds");
    }
}
