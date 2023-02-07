import java.util.ArrayList;

public class Graph {
    static class Edge {
        int src;
        int dest;
        int cost;

        Edge () {

        }

        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    int vertices=0;
    int edges=0;
    ArrayList<Edge> edge = new ArrayList<Edge>(edges);

    Graph(int vertices, int edges) {
        this.edges = edges;
        this.vertices = vertices;

        for (int i=0; i<edges; i++) {
            edge.add(i, new Edge());
        }
    }

    public void addGraph(Edge[] e) {
        for (int i=0; i<e.length; i++) {
            edge.set(i, e[i]);
        }
    }

    public void printGraph() {
        for (int i=0; i<edge.size(); i++) {
            System.out.println(edge.get(i).src + " ----> " + edge.get(i).dest);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5, 8);
        Edge[] e = new Edge[8];
        e[0] = new Edge(1, 2, 1);
        e[1] = new Edge(1, 3, 1);
        e[2] = new Edge(1, 4, 1);
        e[3] = new Edge(2, 4, 1);
        e[4] = new Edge(2, 5, 1);
        e[5] = new Edge(3, 4, 1);
        e[6] = new Edge(3, 5, 1);
        e[7] = new Edge(4, 5, 1);

        g.addGraph(e);
        g.printGraph();
    }
}
