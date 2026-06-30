package practice.dsa.sheet.part8.utility;

public class WeightedNode {
	
	public int vertex;
	public int weight;
	public WeightedNode next;
	
	public WeightedNode(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "WeightedNode[vertex=" + vertex + ", weight=" + weight + "]";
	}
}
