import java.util.*;

class Graph {

	public Edge[] edges;
	public Vertex[] vertices;

	public Graph (Edge[] edges, int V) {
		this.edges = edges;
		vertices = new Vertex [V];
		
		for (int i = 0; i < V; i++) {
			vertices[i] = new Vertex(i + 1);
		}
	}

	public Edge[] MST_Kruskal () {
		List<Edge> A = new LinkedList<>();
		DisjointSet set = new DisjointSet(vertices.length);
		Arrays.sort(edges);

		for (Edge e : edges) {
			if (set.find(e.src.index) != set.find(e.dst.index)) {
				A.add(e);
				set.union(e.src.index, e.dst.index);
			}
		}

		Edge[] MST = new Edge[A.size()];
		return A.toArray(MST);
	}
}
