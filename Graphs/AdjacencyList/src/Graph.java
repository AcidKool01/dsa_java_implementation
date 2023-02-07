import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int st, int en) {
        adj.get(st).add(en);
        adj.get(en).add(st);
    }

    public static void bfs(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Boolean> visited = new ArrayList<>(V);
        for(int i=0; i<V; i++) {
            visited.add(false);
        }
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(1);
        visited.set(1, true);
        System.out.println("BFS of the Given Graph:");

        while(!q.isEmpty()) {
            int u = q.remove();
            System.out.print(u + " ");
            for (Integer v: adj.get(u)) {
                if(!visited.get(v)) {
                    q.add(v);
                }
                visited.set(v, true);
            }
        }
    }

    public static void dfsUtil(ArrayList<ArrayList<Integer>> adj, ArrayList<Boolean> visited, int u) {
        if(!visited.get(u)) {
            System.out.print(u+ " ");
            visited.set(u, true);

            for (Integer v: adj.get(u)) {
                if(!visited.get(v)) {
                    dfsUtil(adj, visited, v);
                }
            }
        }
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<Boolean> visited = new ArrayList<>(V);
        for (int i=0; i<V; i++) {
            visited.add(i, false);
        }
        System.out.println("DFS of the Graph:");
        dfsUtil(adj, visited, 1);
    }

    public static void printList(ArrayList<ArrayList<Integer>> adj) {
        for (int i=1; i<adj.size(); i++) {
            System.out.print(i);
            for (Integer x: adj.get(i)) {
                System.out.print(" ----> " + x.intValue());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<Integer>());
        }

        addEdge(adj, 1, 2);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);

        printList(adj);
        bfs(adj, V);
        System.out.println();
        dfs(adj, V);

    }
}
