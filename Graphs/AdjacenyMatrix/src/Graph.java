import java.util.ArrayList;

public class Graph {

    public static void addEdge(ArrayList<ArrayList<Integer>> adj, int st, int en) {
        adj.get(st).set(en, 1);
        adj.get(en).set(st, 1);
    }

    public static void printList(ArrayList<ArrayList<Integer>> adj) {
        for (int i=1; i<adj.size(); i++) {
            System.out.print(i);
            for (int j=1; j<adj.get(i).size(); j++) {
                if(adj.get(i).get(j)==1) {
                    System.out.print(" -----> " + j);
                }
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        int V=6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);
        for (int i=0; i<V; i++) {
            adj.add(new ArrayList<Integer>(V));
        }

        for (int i=0; i<V; i++) {
            for (int j=0; j<V; j++) {
                adj.get(i).add(j, 0);
            }
        }

//        for (int i=0; i<V; i++) {
//            for (int j=0; j<V; j++) {
//                System.out.print(adj.get(i).get(j) + " ");
//            }
//            System.out.println();
//        }

        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
        addEdge(adj, 1, 4);

        printList(adj);
    }
}
