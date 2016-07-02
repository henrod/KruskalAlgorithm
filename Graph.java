import java.util.*;

class Graph {

	public Edge[] edges;
	public Vertex[] vertices;
	public int V;
	public int E;

	public Graph (Edge[] edges, int V) {
		this.E = edges.length;
		this.edges = edges;

		this.V = V;
		vertices = new Vertex [V];
		for (int i = 0; i < V; i++) {
			vertices[i] = new Vertex(i + 1);
		}
	}

	public Edge[] MST_Kruskal () {
		List<Edge> A = new LinkedList<>();
		DisjointSet set = new DisjointSet(V);
		Arrays.sort(edges);

		for (Edge e : edges) {
			if (set.find(e.u.index) != set.find(e.v.index)) {
				A.add(e);
				set.union(e.u.index, e.v.index);
			}
		}

		Edge[] MST = new Edge[A.size()];
		return A.toArray(MST);
	}
}
