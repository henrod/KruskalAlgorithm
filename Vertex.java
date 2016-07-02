class Vertex {
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
