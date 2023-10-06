package com.hillel.homeworks.lesson_03;

import java.util.Arrays;
import com.hillel.homeworks.Utils;

public class Lesson_03_Tasks_With_Strings_and_Arrays {
	private static String lessonName = "Lesson_03_Tasks_With_Strings_and_Arrays".replace('_', ' ').toUpperCase();
	private static final String TASK01 = " Implement method numJewelsInStones which uses 2 parameters:\n"
			+ "- String jewels: String of unique simbols where every symbol mean one jevel\n"
			+ "- String stones: String of symbols each of them mean one stone or jevel.\n"
			+ "Jevels may be represented by a..zA..Z\n"
			+ "Method should return quantity of jevels in the set of stones\nFor example:\nJewels = \"aAb\"\nStones = \"cacAcA\"\nOutput: 3";
	private static final String TASK02 = "Implement method which has input parameter int[] which contains positive and negative values.\n"
			+ "Method returns sorted array which consist of squares of input array elements.\nUsage of Arrays.sort is forbiden.\n"
			+ "For example:\nInput: [-4,-1,0,3,10]\nOutput: [0,1,9,16,100]";
	private static final String TASK03 = "Given the string of any symbol, transform it to lower case.\nUsage String toLowerCase() is forbiden.\n"
			+ "For example:\nInput: \"#1AmC\"\nOutput: \"#1amc\"";

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(lessonName, true,'*','*', '*'));
		utils.execute(TASK01, Lesson_03_Tasks_With_Strings_and_Arrays::task01);
		utils.execute(TASK02, Lesson_03_Tasks_With_Strings_and_Arrays::task02);
		utils.execute(TASK03, Lesson_03_Tasks_With_Strings_and_Arrays::task03);
	}

	private static void task01() {
		String jewels = "aAb";
		String stones = "cacAcA";
		System.out.println("Jewels= " + jewels + "; stones= " + stones + "\nnum of jewels in stones = "
				+ numJewelsInStones(jewels, stones));

	}

	private static void task02() {
		int[] input = { -4, -1, 0, 3, 10 };
		int[] output = new int[input.length];
		if (isSorted(input)) {
			for (int i = 0; i < input.length; i++) {
				output[i] = input[i] * input[i];
			}
			System.out.println(Arrays.toString(input));
			sort(output);
			System.out.println(Arrays.toString(output));
		}
	}

	private static void task03() {
		String inString = "#1AmC";
        System.out.println(inString);
        System.out.println(toLowerCase(inString));
	}

	//for task01
	static boolean isStringCorrect(String inputString) {
		for (int i = 0; i < inputString.length(); i++) {
			char tmp = inputString.charAt(i);
			if (!(tmp >= 'A' && tmp <= 'Z') && !(tmp >= 'a' && tmp <= 'z')) {
				return false;
			}
		}
		return true;
	}

	static int numJewelsInStones(String jewels, String stones) {
		int count = 0;
		if (isStringCorrect(jewels) && isStringCorrect(stones)) {
			for (char c : stones.toCharArray()) {
				if (jewels.indexOf(c) >= 0) {
					count++;
				}
			}
			return count == 0 ? -1 : count;
		} else
			return -1;
	}

	//for task02
	static boolean isSorted(int[] inputArray) {
		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] > inputArray[i + 1]) {
				return false;
			}
		}
		return true;
	}

	static void sort(int[] toSort) {
		for (int left = 0; left < toSort.length; left++) {
			int value = toSort[left];
			int i = left - 1;
			for (; i >= 0; i--) {
				if (value < toSort[i]) {
					toSort[i + 1] = toSort[i];
				} else {
					break;
				}
			}
			toSort[i + 1] = value;
		}
	}

	//for task03
	static String toLowerCase(String myString){
        StringBuilder outString= new StringBuilder();
        for (char c : myString.toCharArray() ){  	
            if (c >= 'A' && c <= 'Z') {
                outString.append((char)(c+32));
            } else outString.append(c);
        }
        return outString.toString();
    }
}
