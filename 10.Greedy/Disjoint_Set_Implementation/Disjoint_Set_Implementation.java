package practice.dsa.sheet.part8;

public class Disjoint_Set_Implementation {
	
	public static void main(String[] args) {
		
		int n = 7; // Nodes numbered from 1 to 7. Exclude 0.
		DisjointSet ds = new DisjointSet(n+1);
		
		System.out.println("Ultimate parent or representative element for union of 1 and 2 : " + ds.unionBySize(1, 2));
		System.out.println("Ultimate parent or representative element for union of 2 and 3 : " + ds.unionBySize(2, 3));
		System.out.println("Ultimate parent or representative element for union of 4 and 5 : " + ds.unionBySize(4, 5));
		System.out.println("Ultimate parent or representative element for union of 6 and 7 : " + ds.unionBySize(6, 7));
		System.out.println("Ultimate parent or representative element for union of 5 and 6 : " + ds.unionBySize(5, 6));
		
		System.out.println("===> Ultimate parent or representative element of set containing 6  : " + ds.findSet(6));
		
		System.out.println("Ultimate parent or representative element for union of 3 and 7 : " + ds.unionBySize(3, 7));
		
		System.out.println("===> Ultimate parent or representative element of set containing 6 : " + ds.findSet(6));
		
		System.out.println("===> Ultimate parent or representative element of set containing 6 : " + ds.findSet(2));
	}
}

class DisjointSet {
	
	private int[] size;
	
	private int[] parent;
	
	public DisjointSet(int n) {
		this.size = new int[n];
		this.parent = new int[n];
		
		for(int i = 1; i <= n-1; i++) {
			this.parent[i] = i;
			this.size[i] = 1;
		}
	}
	
	/*
	 * T = O(n) in worst case
	 * 
	 * T = O(1) in amortized or average case (important)
	 * 
	 * S = O(2n) = O(n) ; parent arr + size arr
	 */
	public int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		parent[x] = findSet(parent[x]);
		return parent[x];
	}
	
	/*
	 * T = O(n) in worst case
	 * 
	 * T = O(1) in amortized or average case (because of union by size + path compression)
	 * 
	 * S = O(2n) = O(n) ; parent arr + size arr
	 * 
	 * Because of union by size, with n vertices the max height of the 
	 * tree can go upto O(log n)
	 */
	public int unionBySize(int x, int y) {
		
		int resParent = 0;
		int up_x = findSet(x);
		int up_y = findSet(y);
		
		if(size[up_x] >= size[up_y]) {
			parent[up_y] = up_x;
			size[up_x] = size[up_x] + size[up_y];
			resParent = up_x;
		} else {
			parent[up_x] = up_y;
			size[up_y] = size[up_y] + size[up_x];
			resParent = up_y;
		}
		
		return resParent;
	}
	
}
