// Java program to print DFS traversal
// from a given graph
import java.util.*;

// This class represents a
// directed wegihted graph using adjacency
// list representation
class Graph {
	private int V;

	// Array of lists for
	// Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	@SuppressWarnings("unchecked") Graph(int v)
	{
		V = v;
		adj = new LinkedList[v]; // Iinitializing an array of linked lists
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>(); // Inizializing a new linked list
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w)
	{
		// Add w to v's list.
		adj[v].add(w);
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[])
	{
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Loop over all adjacent nodes (direct neighbours)
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	// DFS traversal function
	void DFS(int v)
	{
		// false by default in java)
		boolean visited[] = new boolean[V];

		DFSUtil(v, visited);
	}

	// BFS traversal function
	void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue
            = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
 
		int step = 1;
        while (queue.size() != 0) {
			step += 1;
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            // System.out.print(s + " ");
			System.out.println("Vertex: " + s + "\tLeave:" + step);
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
					step += 1;
					System.out.println("Vertex: " + n + "\tEnter:" + step);
                    queue.add(n);

                }
            }
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

		Graph g = new Graph(2);

		g.addEdge(0, 1);
		g.addEdge(1, 0);

        
		System.out.println(
			"\n Following is Depth First Traversal "
			+ "(starting from vertex 0)");
		g.DFS(0);

		System.out.println(
			"\n Following is Breadth First Traversal "
			+ "(starting from vertex 0)");
		g.BFS(0);

		
	}
}
