package com.hillel.homeworks.lesson_04;

import com.hillel.homeworks.Utils;

public class Lesson_04_Implementing_DataStructures {
	private static final String TASK00 = "Написать интерфейс IntList и его реализацию IntLinkedList, "
			+ "который также должен реализовывать интерфейсы IntQueue и IntStack.";
	private static final String TASK01 = "add(int element)";
	private static final String TASK02 = "add(int index, int element)";
	private static final String TASK03 = "clear()";
	private static final String TASK04 = "get(int index)";
	private static final String TASK05 = "isEmpty()";
	private static final String TASK06 = "remove(int index)";
	private static final String TASK07 = "removeByValue(int value)";
	private static final String TASK08 = "set(int index, int element)";
	private static final String TASK09 = "size()";
	private static final String TASK10 = "subList(int fromIndex, int toIndex)";
	private static final String TASK11 = "toArray()";
	private static final String TASK12 = "push(int value)";
	private static final String TASK13 = "pop()";
	private static final String TASK14 = "peek()";
	private static final String TASK15 = "element()";
	
	
	private static IntLinkedList list, tmp ; 
	
	
	public static void run() {
		Utils utils = new Utils();

		utils.execute(TASK00 + TASK01, Lesson_04_Implementing_DataStructures::task01);
		utils.execute(TASK02, Lesson_04_Implementing_DataStructures::task02);
		utils.execute(TASK03, Lesson_04_Implementing_DataStructures::task03);
		utils.execute(TASK04, Lesson_04_Implementing_DataStructures::task04);
		utils.execute(TASK05, Lesson_04_Implementing_DataStructures::task05);
		
	}
	
	private static void task01() {
//		add(int element)
		list =  new IntLinkedList();
		System.out.println("list was: " + list);
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println("list became: " + list);
	}
	
	private static void task02() {
//		add(int index, int element)
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size());
		System.out.println("add 1 at index 6");
		tmp.add(6,1);
		System.out.println("list became: " + tmp);
		System.out.println("add 1 at index 8");
		tmp.add(8,1);
		System.out.println("list became: " + tmp);
		System.out.println("add 1 at index -1");
		tmp.add(-1,1);
		System.out.println("list became: " + tmp);
		
	}
	
	private static void task03() {
//		clear()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size());
		tmp.clear();
		System.out.println("list clear");
		System.out.println("list became: " + tmp + ", size = " + tmp.size());
	}

	private static void task04() {
//		get(int index)
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size());
		System.out.println("list get( 3) = " + tmp.get(3));
		System.out.println("list get( 0) = " + tmp.get(0));
		System.out.println("list get( 5) = " + tmp.get(5));
		System.out.println("list get(-1) = " + tmp.get(-1));
		System.out.println("list get( 9) = " + tmp.get(9));
		
	}
	
	private static void task05() {
//		isEmpty()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		tmp.clear();
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
	}
	
	private static void task06() {
//		remove(int index)
	}
	
	private static void task07() {
//		removeByValue(int value)
	}
	
	private static void task08() {
//		set(int index, int element)
	}
	
	private static void task09() {
//		size()
	}
	
	private static void task10() {
//		subList(int fromIndex, int toIndex)
	}
	
	private static void task11() {
//		toArray()
	}
	
	private static void task12() {
//		push(int value)
	}
	
	private static void task13() {
//		pop()
	}
	
	private static void task14() {
//		peek()
	}
	
	private static void task15() {
//		element()
	}
	
}
