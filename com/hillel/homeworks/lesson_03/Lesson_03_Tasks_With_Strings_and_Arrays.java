package com.hillel.homeworks.lesson_03;

import java.util.Arrays;
import com.hillel.homeworks.Utils;

public class Lesson_03_Tasks_With_Strings_and_Arrays {
	private static final String TASK01 = " Написать метод numJewelsInStones который принимает 2 параметра:\n"
			+ "- String jewels: строка, каждый символ который символизирует драгоценный камень, символы уникальны\n"
			+ "- String stones: строка, каждый символ который символизирует камень.\n"
			+ "Строки могут состоять только из символов a..zA..Z\n"
			+ "Метод должне вернуть количество другоценных камней в строке stones.\n" + "Пример:\n"
			+ "jewels = \"aAb\"\n" + "stones = \"caсAcA\"\n" + "Output: 3";
	private static final String TASK02 = "Входящий параметр: отсортированный массив типа int который содержит отрицательные и положительные значения.\n"
			+ "Вернуть отсортированный массив который состоит из квадратов значений.\n"
			+ "Не использовать при этом стандартный метод sort.\n" + "Пример:\n" + "Input: [-4,-1,0,3,10]\n"
			+ "Output: [0,1,9,16,100]";
	private static final String TASK03 = "Дана строк состоящая из любых символов. Не используя стандартный метод String.toLowerCase() перевести все большие латинские буквы в маленькие.\n"
			+ "Пример:\n" + "Input: \"#1AmC\"\n" + "Output: \"#1amc\"";

	public static void run() {
		Utils utils = new Utils();

		utils.execute(TASK01, Lesson_03_Tasks_With_Strings_and_Arrays::task01);
//		Utils.endOfTest();
		utils.execute(TASK02, Lesson_03_Tasks_With_Strings_and_Arrays::task02);
//		Utils.endOfTest();
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
