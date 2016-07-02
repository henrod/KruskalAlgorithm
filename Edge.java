class Edge implements Comparable <Edge> {
	public Vertex src;
	public Vertex dst;
	public int weight;

	public Edge (int src, int dst, int weight) {
		this.src = new Vertex(src);
		this.dst = new Vertex(dst);
		this.weight = weight;
	}

	@Override
	public int compareTo (Edge e) {
		return this.weight - e.weight;
	}

	@Override
	public String toString() {
		String str = "FROM: " + this.src.index +
					" TO: " + this.dst.index +
					" WEIGHT: " + this.weight;
		return str;
	}
}
