import java.util.*;

class Graph {

	public static class Edge implements Comparable <Edge> {
		public Integer u;
		public Integer v;
		public int w;

		public Edge (int u, int v, int w) {
			this.u = new Integer(u);
			this.v = new Integer(v);
			this.w = w;
		}

		@Override
		public int compareTo (Edge e) {
			return this.w - e.w;
		}

		@Override
		public String toString() {
			String str = "FROM: " + this.u +
						" TO: " + this.v +
						" WEIGHT: " + this.w;
			return str;
		}
	}

	public Edge[] edges;
	public int V;
	public int E;

	public Graph (Edge[] edges, int V) {
		this.E = edges.length;
		this.edges = edges;
		this.V = V;
	}

	public Edge[] MST_Kruskal () {
		HashSet<Edge> A = new HashSet<>();
		LinkedList<HashSet<Integer>> forest = new LinkedList<>();

		for (int i = 0; i < V; i++) {
			HashSet<Integer> set = new HashSet<>();
			set.add(i + 1);
			forest.add(set);
		}

		Arrays.sort(edges);

		for (Edge e : edges) {
			HashSet<Integer> tree = null;
			for (HashSet<Integer> t : forest) {
				if (t.contains(e.u)) {
					tree = t;
					break;
				}
			}

			if (!tree.contains(e.v)) {
				A.add(e);
				forest.remove(tree);

				for (HashSet<Integer> t : forest) {
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
