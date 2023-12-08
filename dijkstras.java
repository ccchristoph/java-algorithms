import java.util.*;

class Graph {
	private int V;
	private ArrayList<ArrayList<iPair>> adj;

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

	void shortestPathArray(int src) {
		int[] dist = new int[V];
		ArrayList<Boolean> unvisited = new ArrayList<>();
		ArrayList<Integer> previous = new ArrayList<>();


		for(int i = 0; i < V; i++){
			dist[i] = Integer.MAX_VALUE;
			unvisited.add(true);
			previous.add(-1);
		}
        dist[src] = 0;

		while(unvisited.contains(true)){
			// Find the smallest distance in unvisited (in the first iteration, this will be src)
			int min = Integer.MAX_VALUE;
			int minIndex = -1;
			for(int i = 0; i < V; i++){
				if(unvisited.get(i)){
					if(dist[i] < min){
					min = dist[i];
					minIndex = i;
					}
				}
			}
			ArrayList<iPair> curr_node = adj.get(minIndex);
			unvisited.set(minIndex, false);

			for(int i = 0; i < curr_node.size(); i++){
				int n = curr_node.get(i).first;
				int w = curr_node.get(i).second;
				if(unvisited.get(n)){
					int new_dist = dist[minIndex] + w;
					if(new_dist < dist[n]){
						dist[n] = new_dist;
						previous.set(n, minIndex);
					}
				}
			}
		}

		System.out.println("Vertex: \tS.P from " + src + "\tPrev Node");
		for(int i = 0; i < V; i++){
			System.out.println(i + "\t\t" +  dist[i] + "\t\t" + previous.get(i));
		}
	}

	void shortestPathOptimized(int src) {
		
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

		g.shortestPathArray(0);
	}
}
