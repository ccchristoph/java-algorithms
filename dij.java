import java.util.*;

class Graph {
	private int V;
	private List<List<iPair>> adj;

	Graph(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}

	void addEdge(int u, int v, int w) {
		adj.get(u).add(new iPair(v, w));
		adj.get(v).add(new iPair(u, w));
	}

	void shortestPath(int src) {
		PriorityQueue<iPair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.first));
		int[] dist = new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);

		pq.add(new iPair(0, src));
		dist[src] = 0;

		while (!pq.isEmpty()) {
			int u = pq.poll().second;

			for (iPair v : adj.get(u)) {
				if (dist[v.first] > dist[u] + v.second) {
					dist[v.first] = dist[u] + v.second;
					pq.add(new iPair(dist[v.first], v.first));
				}
			}
		}

		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}

	static class iPair {
		int first, second;

		iPair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}


	public static void main(String[] args) {
		int V = 5;
		Graph g = new Graph(V);

		g.addEdge(0, 1, 6);
		g.addEdge(0, 3, 1);
		g.addEdge(1,2,5);
		g.addEdge(1,3,2);
		g.addEdge(1,4,2);
		g.addEdge(2, 4, 5);
		g.addEdge(3, 4, 1);

		g.shortestPath(0);
	}
}
