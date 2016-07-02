import java.util.*;
import java.io.*;

class Solution {

	private static final String FILE_NAME = "input.txt";

	public static void main (String[] args) {
		try {
			Scanner sc = new Scanner(new File(FILE_NAME));

			int N_vertices = sc.nextInt();
			int N_edges = sc.nextInt();

			Edge[] edges = new Edge [N_edges];

			for (int i = 0; i < N_edges; i++) {
				int src = sc.nextInt();
				int dst = sc.nextInt();
				int weight = sc.nextInt();

				Edge edge = new Edge(src, dst, weight);

				edges[i] = edge;
			}

			Graph G = new Graph(edges, N_vertices);
			Edge[] mst = G.MST_Kruskal();

			int sum = 0;
			for (Edge e : mst) {
				System.out.println(e.toString());
				sum += e.weight;
			}

			System.out.println("TOTAL MINIMUM WEIGHT: " + sum);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}
}
