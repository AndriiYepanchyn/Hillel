package com.hillel.homeworks.lesson_04;

import com.hillel.homeworks.Utils;
import java.util.Arrays;

public class Lesson_04_Implementing_DataStructures {
	private static String lessonName = "Lesson_04_Implementing_DataStructures".replace('_', ' ').toUpperCase();
	private static final String TASK00 = "Write inteface IntList and it's impementation IntLinkedList, it should also imlements IntQueue and IntStack:";
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
	private static final String TASK16 = "remove()";
	
	private static IntLinkedList list, tmp ;

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(lessonName, true,'*','*', '*'));
		utils.execute(TASK00 +"\n"+ TASK01, Lesson_04_Implementing_DataStructures::task01);
		utils.execute(TASK02, Lesson_04_Implementing_DataStructures::task02);
		utils.execute(TASK03, Lesson_04_Implementing_DataStructures::task03);
		utils.execute(TASK04, Lesson_04_Implementing_DataStructures::task04);
		utils.execute(TASK05, Lesson_04_Implementing_DataStructures::task05);
		utils.execute(TASK06, Lesson_04_Implementing_DataStructures::task06);
		utils.execute(TASK07, Lesson_04_Implementing_DataStructures::task07);
		utils.execute(TASK08, Lesson_04_Implementing_DataStructures::task08);
		utils.execute(TASK09, Lesson_04_Implementing_DataStructures::task09);
		utils.execute(TASK10, Lesson_04_Implementing_DataStructures::task10);
		utils.execute(TASK11, Lesson_04_Implementing_DataStructures::task11);
		utils.execute(TASK12, Lesson_04_Implementing_DataStructures::task12);
		utils.execute(TASK13, Lesson_04_Implementing_DataStructures::task13);
		utils.execute(TASK14, Lesson_04_Implementing_DataStructures::task14);
		utils.execute(TASK15, Lesson_04_Implementing_DataStructures::task15);
		utils.execute(TASK16, Lesson_04_Implementing_DataStructures::task16);
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
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove middle element ");
		tmp.remove(3);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove last element ");
		tmp.remove(4);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove first element ");
		tmp.remove(0);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove out of bounds element ");
		tmp.remove(-2);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove element from empty list");
		tmp.clear();
		tmp.remove(-2);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
	}

	private static void task07() {
//		removeByValue(int value)

		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove by value 3 ");
		tmp.remove(3);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("remove by value 100 ");
		tmp.remove(100);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());

	}
	
	private static void task08() {
//		set(int index, int element)
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("set value 100 at index 3 ");
		tmp.set(3, 100);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("set value 999 at index 0 ");
		tmp.set(0, 999);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		System.out.println("set value 555 at index -1 ");
		tmp.set(-1, 555);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
	}
	
	private static void task09() {
//		size()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
	}
	
	private static void task10() {
//		subList(int fromIndex, int toIndex)
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		tmp.subList(2,4);
		System.out.println("indexes from 2 to 4 (not including");
		System.out.println("list became: " + tmp.subList(2,4));
	}
	
	private static void task11() {
//		toArray()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());

		System.out.println("list became: " + Arrays.toString(tmp.toArray()));
	}
	
	private static void task12() {
//		push(int value)
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		tmp.push(100);
		System.out.println("list became: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
	}
	
	private static void task13() {
//		pop()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		int value = tmp.pop();
		System.out.println("list became: " +tmp + ",  poped element = " + value);
	}
	
	private static void task14() {
//		peek()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		tmp.peek();
		System.out.println("list became: " +tmp + ",  peeked element = " + tmp.pop());
	}
	
	private static void task15() {
//		element()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		int value = tmp.element();
		System.out.println("list became: " +tmp + ",   element() = " + value);
	}

	private static void task16() {
//		element()
		tmp = new IntLinkedList(list);
		System.out.println("list was: " + tmp + ", size = " + tmp.size() + ", isEmpty: "+ tmp.isEmpty());
		int value = tmp.remove();
		System.out.println("list became: " +tmp + ",   remove() = " + value);
	}
}
