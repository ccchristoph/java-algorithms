
import java.util.*;

// This class represents a
// directed weighted graph using adjacency
// list representation
class Graph {
	private int V;
	private ArrayList<Edge> EdgeList;

    // Dynamic Graph class without initialization
	Graph(int v)
	{
        this.V = v;
		EdgeList = new ArrayList<>(); // Dyanmic Array List of Edges
	}

	// Function to add an edge into the graph
	void addEdge(int u, int v, int w) {
		EdgeList.add(new Edge(u, v, w));
        EdgeList.add(new Edge(v, u, w));
	}


	void BellmanFord(int start)
	{
		int dist[] = new int[V];
        for(int i = 0; i < V; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[start] = 0;

        for(int N = 0; N < V - 1; N++){
            for(int e = 0; e < EdgeList.size(); e++){
                int src = EdgeList.get(e).src;
                int dest = EdgeList.get(e).dest;
                int w = EdgeList.get(e).weight;

                int curr_dist = dist[dest];
                int new_dist = dist[src] + w;
                if(new_dist < curr_dist){
                    dist[dest] = new_dist; 
                }
            }

        }
        System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

    static class Edge {
		int src, dest, weight;

		Edge(int src, int dest, int weight) {
			this.src = src;
			this.dest = dest;
            this.weight = weight;
		}
	}

	public static void main(String args[])
	{
		//Graph g = new Graph(4);
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(1, 2);
		// g.addEdge(2, 0);
		// g.addEdge(2, 3);
		// g.addEdge(3, 3);
		// g.addEdge(3, 2);

		// Graph g = new Graph(5);
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(1, 2);
		// g.addEdge(1, 3);
		// g.addEdge(2, 4);
		// g.addEdge(3, 4);

		// Graph g = new Graph(9);

		// g.addEdge(0, 2);
		// g.addEdge(0, 5);
		// g.addEdge(0, 6);
		// g.addEdge(1, 0);
		// g.addEdge(2, 3);
		// g.addEdge(2, 4);
		// g.addEdge(2, 6);
		// g.addEdge(2, 7);
		// g.addEdge(3, 4);
		// g.addEdge(4, 1);
		// g.addEdge(6, 1);
		// g.addEdge(6, 7);
		// g.addEdge(7, 1);
		// g.addEdge(7, 4);
		// g.addEdge(8, 1);
		// g.addEdge(8, 2);
		// g.addEdge(8, 6);

		int V = 5;
		Graph g = new Graph(V);

		g.addEdge(0, 1, 6);
		g.addEdge(0, 3, 1);
		g.addEdge(1,2,5);
		g.addEdge(1,3,2);
		g.addEdge(1,4,2);
		g.addEdge(2, 4, 5);
		g.addEdge(3, 4, 1);

		g.BellmanFord(0);

	}
}
