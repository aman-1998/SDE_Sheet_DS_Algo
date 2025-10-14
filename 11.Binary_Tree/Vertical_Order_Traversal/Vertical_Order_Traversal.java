package practice.dsa.sheet.part6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

import practice.dsa.sheet.part6.utility.Node;

public class Vertical_Order_Traversal {
	
	public static void main(String[] args) {
		
		Node root = null;
		root = Insertion_In_BST.insert(root, 8);
		root = Insertion_In_BST.insert(root, 5);
		root = Insertion_In_BST.insert(root, 10);
		root = Insertion_In_BST.insert(root, 4);
		root = Insertion_In_BST.insert(root, 6);
		root = Insertion_In_BST.insert(root, 9);
		root = Insertion_In_BST.insert(root, 14);
		root = Insertion_In_BST.insert(root, 11);
		root = Insertion_In_BST.insert(root, 15);
		
		List<List<Integer>> res2 = verticalTraversal(root);
		res2.stream().forEach(t -> System.out.print(t + " "));
	}
	
	/*
	 * T = O(n + diameter*h*log h)
	 * S = O(n)
	 */
	public static List<List<Integer>> verticalTraversal(Node root) {
        
		Queue<Coordinate> queue = new LinkedList<>();
		Map<Integer, List<Coordinate>> nodesMap = new TreeMap<>();
		
		if(root != null) {
			queue.add(new Coordinate(root, 0, 0));
			while(!queue.isEmpty()) { // T = O(n)
				Coordinate popped = queue.poll();
				
				if(popped.node.left != null) {
					queue.add(new Coordinate(popped.node.left, popped.x - 1, popped.y + 1));
				}
				
				if(popped.node.right != null) {
					queue.add(new Coordinate(popped.node.right, popped.x + 1, popped.y + 1));
				}
				
				List<Coordinate> list = nodesMap.get(popped.x);
				if(list == null) {
					list = new ArrayList<>();
					list.add(popped);
					nodesMap.put(popped.x, list);
				} else {
					list.add(popped);
				}
			}
		}
		
		List<List<Integer>> res = new ArrayList<>();
		for(Map.Entry<Integer, List<Coordinate>> entry : nodesMap.entrySet()) { // T = O(diameter)
			List<Coordinate> list = entry.getValue();
			//List<Integer> tempList = list.stream().sorted(Comparator.comparing((Coordinate coordinate) -> coordinate.y)
			//		     						  .thenComparing(Comparator.comparing(coordinate -> coordinate.node.data)))
			//			 						  .map(coordinate -> coordinate.node.data).collect(Collectors.toList());
			//res.add(tempList);
			
			Collections.sort(list, Comparator.comparing((Coordinate coordinate) -> coordinate.y)
					  					     .thenComparing(Comparator.comparing(coordinate -> coordinate.node.data)));
			
			List<Integer> tempList = new ArrayList<>();
			for(Coordinate coordinate : list) { // T = O(h*log h) ; h = height
				tempList.add(coordinate.node.data);
			}
			res.add(tempList);
		}
		
		return res;
    }
}

class Coordinate {
	public Node node;
	public int x;
	public int y;
	
	public Coordinate(Node node, int x, int y) {
		this.node = node;
		this.x = x;
		this.y = y;
	}
}
