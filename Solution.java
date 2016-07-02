import java.util.*;
import java.io.*;

class Solution {

	private static final String FILE_NAME = "input.txt";

	public static void main (String[] args) {
		try {
			Scanner sc = new Scanner(new File(FILE_NAME));

			int N = sc.nextInt();
			int M = sc.nextInt();

			Edge[] edges = new Edge [M];

			for (int i = 0; i < M; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				int w = sc.nextInt();

				Edge edge = new Edge(u, v, w);

				edges[i] = edge;
			}

			Graph G = new Graph(edges, N);
			Edge[] mst = G.MST_Kruskal();

			int sum = 0;
			for (Edge e : mst) {
				System.out.println(e.toString());
				sum += e.w;
			}

			System.out.println("TOTAL MINIMUM WEIGHT: " + sum);
		} catch (FileNotFoundException e) {
			System.out.println(e.toString());
		}
	}
}
