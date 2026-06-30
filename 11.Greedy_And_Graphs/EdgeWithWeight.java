package practice.dsa.sheet.part8.utility;

public class EdgeWithWeight {
	public int v1;
	public int v2;
	public int wt;
	
	public EdgeWithWeight(int v1, int v2, int wt) {
		this.v1 = v1;
		this.v2 = v2;
		this.wt = wt;
	}

	@Override
	public String toString() {
		return "EdgeWithWeight[v1=" + v1 + ", v2=" + v2 + ", wt=" + wt + "]";
	}
}
