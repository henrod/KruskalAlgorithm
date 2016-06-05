import java.util.*;

class Solution {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		Graph.Edge[] edges = new Graph.Edge [M];

		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt();

			Graph.Edge edge = new Graph.Edge(u, v, w);

			edges[i] = edge;
		}

		Graph G = new Graph(edges, N);
		Graph.Edge[] mst = G.MST_Kruskal();

		int sum = 0;
		for (Graph.Edge e : mst) {
			sum += e.w;
		}

		System.out.println(sum);
	}
}
