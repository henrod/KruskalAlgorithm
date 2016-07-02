class DisjointSet {
	private int[] set;

	public DisjointSet(int N) {
		set = new int[N + 1];
		for (int i = 1; i <= N; i++)
			set[i] = i;
	}

	public int find(int p) {
		return set[p];
	}

	public void union(int p, int q) {
		int root = set[q];
		for (int i = 1; i < set.length; i++) {
			if (set[i] == root) {
				set[i] = set[p];
			}
		}
	}
}
