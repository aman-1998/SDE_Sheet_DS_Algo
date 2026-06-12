package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import practice.dsa.sheet.part6.utility.Node;

public class Top_View_Of_BT {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 30);
		root = Insertion_In_BST.insert(root, 20);
		root = Insertion_In_BST.insert(root, 40);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 25);
		root = Insertion_In_BST.insert(root, 35);
		root = Insertion_In_BST.insert(root, 50);
		root = Insertion_In_BST.insert(root, 22);
		root = Insertion_In_BST.insert(root, 45);
		
		List<Integer> res = topView(root);
		
		res.stream().forEach(t -> System.out.print(t + " "));
	}

	/*
	 * T = O(n)
	 * S = O(n)
	 */
	public static List<Integer> topView(Node root) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Coordinate2> map = new HashMap<>();
		Queue<Coordinate2> queue = new LinkedList<>();
		
		if(root != null) {
			queue.add(new Coordinate2(root, 0, 0));
			
			while(!queue.isEmpty()) {
				Coordinate2 poppedCoordinate = queue.poll();
				if(poppedCoordinate.node.left != null) {
					queue.add(new Coordinate2(poppedCoordinate.node.left, 
							poppedCoordinate.x - 1, poppedCoordinate.y + 1));
				}
				
				if(poppedCoordinate.node.right != null) {
					queue.add(new Coordinate2(poppedCoordinate.node.right, 
							poppedCoordinate.x + 1, poppedCoordinate.y + 1));
				}
				
				if(!map.containsKey(poppedCoordinate.x)) {
					map.put(poppedCoordinate.x, poppedCoordinate);
				}
			}
			
			List<Coordinate2> list = new ArrayList<>();
			//list = (List<Coordinate2>)map.values();
			for(Map.Entry<Integer, Coordinate2> entry : map.entrySet()) {
				list.add(entry.getValue());
			}
			
			res = list.stream().sorted(Comparator.comparing((Coordinate2 coordinate) -> coordinate.x))
								.map(coordinate -> coordinate.node.data)
								.collect(Collectors.toCollection(ArrayList::new));
		}
		
		return res;
	}
}

class Coordinate2 {
	
	public Node node;
	public int x;
	public int y;
	
	public Coordinate2(Node node, int x, int y) {
		this.node = node;
		this.x = x;
		this.y = y;
	}
}
