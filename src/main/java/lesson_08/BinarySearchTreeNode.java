package main.java.lesson_08;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeNode {
	private BinarySearchTreeNode left ;
	private BinarySearchTreeNode right;
	private Integer value;
	
//	+
	BinarySearchTreeNode(Integer val){
		value = val;
		left = null;
		right = null;
	}
	
	public BinarySearchTreeNode() {}

//	helper
	private static boolean nodeExists(BinarySearchTreeNode node) {
		return node != null && node.value != null;
	}
	
//	+
	public BinarySearchTreeNode search(int value) {
		if(!nodeExists(this)) return null;
		if(this.value == value) return this;
		if(value < this.value && nodeExists(this.left)) {
			return this.left.search(value);
		}
		if(value > this.value && nodeExists(this.right)) {
		return this.right.search(value);
		}
		return null;
	}
	
//	+
	public BinarySearchTreeNode search(BinarySearchTreeNode node){
		return search(node.value);
	}
	
//	+
	public void insert(int value) {
		if (!nodeExists(this)) {
			createNode(this, value);
		} else if (value < this.value) {
			if (this.left == null) {
				this.left = new BinarySearchTreeNode(value);
			} else {
				this.left.insert(value);
			}
		} else if (value >= this.value) {
			if (this.right == null) {
				this.right = new BinarySearchTreeNode(value);
			} else {
				this.right.insert(value);
			}
		}
	}
	
//	+
	public void insertNode(BinarySearchTreeNode node) {
		if (!nodeExists(node)) {
			createNode(this, value);
		} else if (node.value < this.value) {
			if (this.left == null) {
				this.left = node;
			} else {
				this.left.insert(node.value);
			}
		} else if (value >= this.value) {
			if (this.right == null) {
				this.right = node;
			} else {
				this.right.insert(node.value);
			}
		}
	}

//	+
	private void createNode(BinarySearchTreeNode node, int value) {
		//TODO may throw NPE
		node.left = new BinarySearchTreeNode();
		node.right = new BinarySearchTreeNode();
		node.value = value;
	}
	
//	+
	public Integer getValue() {
		return this.value;
	}
	
//	+
	public BinarySearchTreeNode getMinNode() {
		if(!nodeExists(this)) return null;
		if(!nodeExists(this.left)) return this;
		return this.left.getMinNode();
	}
	
	public Integer getMinValue() {
		return this.getMinNode().value;
	}
	
//	+
	public BinarySearchTreeNode getMaxNode() {
		if(!nodeExists(this)) return null;
		if(!nodeExists(this.right)) return this;
		return this.right.getMaxNode();
	}
	
	public Integer getMaxValue(){
		return this.getMaxNode().value;
	}
	
//  +
	public List<BinarySearchTreeNode> getOrderedNodesRecursive(){
		List<BinarySearchTreeNode> result = new ArrayList<BinarySearchTreeNode>();
		
		if(!nodeExists(this)) return result;
		if(nodeExists(this.left)) {
		result.addAll(this.left.getOrderedNodesRecursive());
		}
		result.add(this);
		if(nodeExists(this.right)) {
		result.addAll(this.right.getOrderedNodesRecursive());
		}
		
		return result;		
	}
	
	public BinarySearchTreeNode copy() {
		BinarySearchTreeNode result = new BinarySearchTreeNode();
		Stack<BinarySearchTreeNode> nodes = new Stack<BinarySearchTreeNode>();
		nodes.push(this);
		
		while(!nodes.isEmpty()) {
			BinarySearchTreeNode node = nodes.pop();
			if(nodeExists(node.right)) {
				nodes.push(node.right);
			}
			if(nodeExists(node.left)) {
				nodes.push(node.left);
			}
			if(!nodeExists(node)) continue;
			result.insert(node.value);
		}	
		
		return result;
	}
	
	public List<BinarySearchTreeNode> getOrderedNodesIterativeInDepth(){
		List<BinarySearchTreeNode> result = new ArrayList<BinarySearchTreeNode>();
		Stack<BinarySearchTreeNode> nodes = new Stack<BinarySearchTreeNode>();
		nodes.push(this);
		
		while(!nodes.isEmpty()) {
			BinarySearchTreeNode node = nodes.pop();
			if(nodeExists(node.right)) {
				nodes.push(node.right);
			}
			if(nodeExists(node.left)) {
				nodes.push(node.left);
			}
			result.add(node);
			
			
		}
		return result;
	}
	
	public List<BinarySearchTreeNode> getOrderedNodesIterativeInWide(){
		List<BinarySearchTreeNode> result = new ArrayList<BinarySearchTreeNode>();
		Deque<BinarySearchTreeNode> nodes = new LinkedList<BinarySearchTreeNode>();
		nodes.add(this);
		
		while(!nodes.isEmpty()) {
			BinarySearchTreeNode node = nodes.remove();
			result.add(node);
			if(nodeExists(node.left)) {
				nodes.add(node.left);
			}
			if(nodeExists(node.right)) {
				nodes.add(node.right);
			}
		}
		return result;
	}
	
	public static BinarySearchTreeNode merge(BinarySearchTreeNode tree1, BinarySearchTreeNode tree2) {
		BinarySearchTreeNode result = tree1.copy();
		if(!nodeExists(tree2)) return result;
		if(!nodeExists(result)) return tree2;
		Integer val2 = tree2.value == null ? 0 : tree2.value;
		result.value+=val2;
		result.left = merge(result.left, tree2.left);
		result.right = merge(result.right, tree2.right);
		return result;
	}
	
	public int maximumDepth() {
		int max = this == null ? 0 : 1;
		int leftDepth = 0;
		int rightDepth = 0;
		if (!nodeExists(this))
			return 0;
		if (nodeExists(this.left)) {
			leftDepth += 1 + this.left.maximumDepth();
			max = max < leftDepth ? leftDepth : max;
		}
		if (nodeExists(this.right)) {
			rightDepth += 1 + this.right.maximumDepth();
			max = max < rightDepth ? rightDepth : max;
		}
		return max;
	}
	
 	/**
 	 * Taken from https://javarush.com/groups/posts/3111-strukturih-dannihkh-dvoichnoe-derevo-v-java
 	 */
	public void printTree() {
//		Iterative
		Stack<BinarySearchTreeNode> globalStack = new Stack<BinarySearchTreeNode>(); 
		globalStack.push(this);
		int gaps = (int) Math.pow(2, maximumDepth()); 
		boolean isRowEmpty = false;

		while (!isRowEmpty) {
			Stack<BinarySearchTreeNode> localStack = new Stack<BinarySearchTreeNode>(); 
			isRowEmpty = true;

			System.out.print(" ".repeat(gaps)); // fill the line from start till first element in row
			while (!globalStack.isEmpty()) {
				BinarySearchTreeNode temp = (BinarySearchTreeNode) globalStack.pop(); 
				if (nodeExists(temp)) {
					System.out.print(temp.getValue()); 
					localStack.push(temp.left); 
					localStack.push(temp.right);
					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("__");
					localStack.push(null);
					localStack.push(null);
				}
				System.out.print(" ".repeat(gaps * 2-2)); // fill gaps between elements
			}
			System.out.println();
			gaps /= 2;
			while (!localStack.isEmpty())
				globalStack.push(localStack.pop());
		}
	}
	
//  +	
	public boolean remove(int valueToremove){
		BinarySearchTreeNode nodeToDelete = search(valueToremove);
		if(!nodeExists(nodeToDelete)) return false;
		
		int childernCount = nodeToDelete.getChildrenCount();
		if(childernCount < 2) {
			nodeToDelete.removeNodeWithOneOrZeroChild();
		} else {
			BinarySearchTreeNode minNode = nodeToDelete.right.getMinNode();
			nodeToDelete.value = minNode.value;
			minNode.removeNodeWithOneOrZeroChild();
		}
		return true;
	}	
	
//  +
 	private void removeNodeWithOneOrZeroChild(){
		BinarySearchTreeNode childOrNill = this.getChildOrNill();
		if (nodeExists(childOrNill)) {
			this.value = childOrNill.value;
			this.left = childOrNill.left;
			this.right = childOrNill.right;
		} else {
			this.value = null;
			this.left = null;
			this.right = null;
		}
	}
	
// 	+
	private int getChildrenCount() {
		int count = 0;
		if(nodeExists(this.left)) count++;
		if(nodeExists(this.right)) count++;
		return count;
	}
	
//	+
	private BinarySearchTreeNode getChildOrNill() {
		return nodeExists(this.left)? this.left : this.right;
	}
	
//	+
	public String toString() {
		String leftStr = left == null? "null" : left.value.toString();
		String rightStr = right == null? "null" : right.value.toString();
		return "[" + value + "]";
	}
}
