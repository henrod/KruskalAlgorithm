import java.util.*;

class Graph {

	static class Vertex {
		public int index;

		public Vertex (int index) {
			this.index = index;
		}

		@Override
		public boolean equals (Object obj) {
			if (obj == null) return false;

			if (!Vertex.class.isAssignableFrom(obj.getClass())) {
        		return false;
    		}

			final Vertex v = (Vertex) obj;
			return v.index == this.index;
		}

		@Override
		public int hashCode() {
		    int hash = 3;
		    hash = 53 * hash + (new Integer(this.index).hashCode());
		    return hash;
		}
	}

	public static class Edge implements Comparable <Edge> {
		public Vertex u;
		public Vertex v;
		public int w;

		public Edge (int u, int v, int w) {
			this.u = new Vertex(u);
			this.v = new Vertex(v);
			this.w = w;
		}

		@Override
		public int compareTo (Edge e) {
			return this.w - e.w;
		}

		@Override
		public String toString() {
			String str = "FROM: " + this.u.index +
						" TO: " + this.v.index +
						" WEIGHT: " + this.w;
			return str;
		}
	}

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
		HashSet<Edge> A = new HashSet<>();
		LinkedList<HashSet<Vertex>> forest = new LinkedList<>();

		for (int i = 0; i < V; i++) {
			HashSet<Vertex> set = new HashSet<>();
			set.add(vertices[i]);
			forest.add(set);
		}

		Arrays.sort(edges);

		for (Edge e : edges) {
			HashSet<Vertex> tree = null;
			for (HashSet<Vertex> t : forest) {
				if (t.contains(e.u)) {
					tree = t;
					break;
				}
			}

			if (!tree.contains(e.v)) {
				A.add(e);
				forest.remove(tree);

				for (HashSet<Vertex> t : forest) {
					if (t.contains(e.v)) {
						t.addAll(tree);
						break;
					}
				}
			}
		}

		Edge[] MST = new Edge [A.size()];
		Iterator<Edge> itr = A.iterator();
		int i = 0;
		while (itr.hasNext()) {
			MST[i] = itr.next();
			i += 1;
		}

		return MST;
	}
}
