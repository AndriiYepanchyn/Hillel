package main.java.lesson_08;

import java.util.ArrayList;

import main.java.Utils;

public class Lesson_08_Trees {
	private static String LESSON_NAME = "Lesson_08_Trees".replace('_', ' ').toUpperCase();

	private static final String TASK01 = "Write method wich returns Nth value of the Fibbonachy Row";
	private static final String TASK02 = "Implement Binary Search tree and implement method merge(tree1, tree2)";

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(LESSON_NAME, true, '*', '*', '*'));
		utils.execute(TASK01, Lesson_08_Trees::task01);
		utils.execute(TASK02, Lesson_08_Trees::task02);
	}

	private static void task01() {
		for (int i = 2; i < 20; i++) {
			System.out.println(i + "th element of the Fibonnachy Row is:  " + fibonachyOrdinal(i));
		}
	}

	private static void task02() {
		
		BinarySearchTreeNode firstTree = new BinarySearchTreeNode(2);
		firstTree.insert(1);
		firstTree.insert(3);
		
		System.out.println("Testing create tree and printTree");
		firstTree.printTree();
		
		System.out.println("Testing insertValue");
		firstTree.insert(10);		
		firstTree.printTree();
		
		BinarySearchTreeNode secondTree = new BinarySearchTreeNode(20);
		secondTree.insert(7);
		secondTree.insert(4);
		secondTree.insert(9);
		secondTree.insert(6);
		secondTree.insert(35);
		secondTree.insert(31);
		secondTree.insert(28);
		secondTree.insert(40);
		secondTree.insert(38);
		secondTree.insert(52);
		
		System.out.println("Testing getOrdredNodes() on second Tree");
		secondTree.printTree();
		System.out.println("Recursive " + secondTree.getOrderedNodesRecursive());
		System.out.println("Iterative in deprth " + secondTree.getOrderedNodesIterativeInDepth());
		System.out.println("Iterative in wide " + secondTree.getOrderedNodesIterativeInWide());
		System.out.println("Min value = " + secondTree.getMinValue());
		System.out.println("Max value = " + secondTree.getMaxValue());
		System.out.println("Max depth = " + secondTree.maximumDepth());
		
		BinarySearchTreeNode copy = firstTree.copy();
		System.out.println("copied tree");
		copy.printTree();
		copy.remove(3);
		System.out.println("copied after removing");
		copy.printTree();
		System.out.println("first tree");
		firstTree.printTree();
			
		System.out.println("Testing delete node");
		secondTree.printTree();
		secondTree.remove(38);
		secondTree.printTree();
		secondTree.remove(52);
		

		System.out.println("Merging firstTree and secondTree");
		firstTree.printTree();
		System.out.println("\n" + "-".repeat(60));
		secondTree.printTree();
		System.out.println("\n" + "-".repeat(60));
		BinarySearchTreeNode result = BinarySearchTreeNode.merge(firstTree, secondTree);
		System.out.println("\nresult = ");
		result.printTree();
		System.out.println("\n" + "-".repeat(60));
		System.out.println("\nresult after removing 22 = ");
		result.remove(22);
		result.printTree();
		System.out.println("\n" + "-".repeat(60));
		System.out.println("\nfirstTree  and secondTree for comparation");
		firstTree.printTree();
		System.out.println("\n" + "-".repeat(60));
		secondTree.printTree();
		result.printTree();
		
	}

//	 Helper for task01
	private static long fibonachyOrdinal(int ordinal) {
		if (ordinal < 1) {
			return -1;
		}
		if (ordinal < 3) {
			return 1;
		}
		ArrayList<Long> fibonachy = new ArrayList<>();
		fibonachy.add(0, 1L);
		fibonachy.add(1, 1L);
		for (int i = 2; i < ordinal; i++) {
			int last = fibonachy.size() - 1;
			fibonachy.add((fibonachy.get(last) + fibonachy.get(last - 1)));
		}

		return fibonachy.get(fibonachy.size() - 1);
	}
}
