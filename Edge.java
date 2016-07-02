class Edge implements Comparable <Edge> {
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
