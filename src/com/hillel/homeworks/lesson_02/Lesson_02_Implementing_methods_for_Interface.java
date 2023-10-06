package com.hillel.homeworks.lesson_02;

import com.hillel.homeworks.Utils;

public class Lesson_02_Implementing_methods_for_Interface {
	private static String lessonName = "Lesson_02_Implementing_methods_for_Interface".replace('_', ' ').toUpperCase();
	private static final String TASK00 = "Create interface IntList and implement it as IntArrayList like it implemented in List<Integer>.";
	private static final String TASK01 = "Implement method add(int element)";
	private static final String TASK02 = "Implement method add(int index, int element)";
	private static final String TASK03 = "Implement method clear()";
	private static final String TASK04 = "Implement method get(int index)";
	private static final String TASK05 = "Implement method isEmpty()";
	private static final String TASK06 = "Implement method remove(int index)";
	private static final String TASK07 = "Implement method removeByValue(int val)";
	private static final String TASK08 = "Implement method set(int index, int element)";
	private static final String TASK09 = "Implement method size()";
	private static final String TASK10 = "Implement method subList(int from, int to)";
	private static IntList tmpList = new IntArrayList();
	static {
		tmpList.add(1);
		tmpList.add(2);
		tmpList.add(3);
		tmpList.add(4);
		tmpList.add(5);
		tmpList.add(6);
	}

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(lessonName, true, '*', '*', '*'));
		utils.execute(TASK00 + "\n" + TASK01, Lesson_02_Implementing_methods_for_Interface::task01);
		utils.execute(TASK02, Lesson_02_Implementing_methods_for_Interface::task02);
		utils.execute(TASK03, Lesson_02_Implementing_methods_for_Interface::task03);
		utils.execute(TASK04, Lesson_02_Implementing_methods_for_Interface::task04);
		utils.execute(TASK05, Lesson_02_Implementing_methods_for_Interface::task05);
		utils.execute(TASK06, Lesson_02_Implementing_methods_for_Interface::task06);
		utils.execute(TASK07, Lesson_02_Implementing_methods_for_Interface::task07);
		utils.execute(TASK08, Lesson_02_Implementing_methods_for_Interface::task08);
		utils.execute(TASK09, Lesson_02_Implementing_methods_for_Interface::task09);
		utils.execute(TASK10, Lesson_02_Implementing_methods_for_Interface::task10);
	}

	private static void task01() {
//		Implement method add(int element)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Adding random element from range (0,1,2) to list");
		mylist.add((int) (Math.random() * 3));
		System.out.println("List became: " + mylist);
	}

	private static void task02() {
//		Implement method add(int index, int element)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Adding 5 to first, last, and middle position in list");
		mylist.add(0, 5);
		int size = mylist.size();
		if (size > 0) {
			mylist.add(mylist.size(), 5);
			mylist.add((mylist.size() - 1) / 2 + 1, 5);
		} else {
			mylist.add(0, 5);
		}

		System.out.println("List became: " + mylist);
		System.out.println("Adding 8 out of bounds");
		mylist.add(-1, 8);
		mylist.add(mylist.size() + 3, 8);
		System.out.println("List became: " + mylist);
	}

	private static void task03() {
//		Implement method clear()
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Now its cleared");
		mylist.clear();
		System.out.println("List became: " + mylist);
	}

	private static void task04() {
//		Implement method get(int index)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Getting element from first, last, and middle position in list");
		System.out.println("Index = 0: " + mylist.get(0));
		System.out.println("Index = " + (mylist.size() / 2) + ": " + mylist.get((mylist.size() / 2)));
		System.out.println("Index = " + (mylist.size() - 1) + ": " + mylist.get(mylist.size() - 1));
		System.out.println("Getting element from out of range in the list");
		System.out.println("element = : " + mylist.get(-1));
	}

	private static void task05() {
//		Implement method isEmpty()
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Is list empty = " + mylist.isEmpty());
		mylist.clear();
		System.out.println("Clear list = " + mylist);
		System.out.println("Is list empty = " + mylist.isEmpty());
	}

	private static void task06() {
//		Implement method remove(int index)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Remove value at index 2:  " + mylist.remove(2));
		System.out.println("List became: " + mylist);
	}

	private static void task07() {
//		Implement method removeByValue(int val)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Remove value = 4");
		mylist.removeByValue(4);
		System.out.println("Current list = " + mylist);
	}

	private static void task08() {
//		Implement method set(int index, int element)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Set 1st value = 10");
		mylist.set(0, 10);
		System.out.println("Current list = " + mylist);
	}

	private static void task09() {
//		Implement method size()
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("list size= " + mylist.size());
	}

	private static void task10() {
//		Implement method subList(int from, int to)
		IntList mylist = new IntArrayList(tmpList);
		System.out.println("List was =  " + mylist);
		System.out.println("Get sublist of first and second value");
		System.out.println("Current list = " + mylist.subList(0, 1));
	}
}
