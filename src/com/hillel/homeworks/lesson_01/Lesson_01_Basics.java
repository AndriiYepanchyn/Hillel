package com.hillel.homeworks.lesson_01;
import com.hillel.homeworks.Utils;

public class Lesson_01_Basics {
	private static String LESSON_NAME = "Lesson_01_Basics".replace('_', ' ').toUpperCase();
	private static final String TASK01 = "Print number for 1 to 100 performing next conditions:\r\n"
			+ "	  1. If number multiple 3, print instead of number word hello\r\n"
			+ "	  2. If number multiple 5, print instead of number word World\r\n"
			+ "	  3. If number multiple 15, print instead of number word hello World";
	
	private static final String TASK02 = "Fill the array of 10 elements by random numbers between 10 and 20, print avarage of array";
	private static final String TASK03 = "Print string in format (1)(2)(3) from 1 to 30 using StringBuilder";

	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(LESSON_NAME, true,'*','*', '*'));
		utils.execute(TASK01, Lesson_01_Basics::task01);
		utils.execute(TASK02, Lesson_01_Basics::task02);
		utils.execute(TASK03, Lesson_01_Basics::task03);
	}

	private static void task01() {
		 for (int i = 1; i <= 100; i++) {
	            if (i % 15 == 0) {
	                System.out.println("Hello World;  ");
	            } else if (i % 5 == 0) {
	                System.out.print("World;  ");
	            } else if (i % 3 == 0) {
	                System.out.print("hello;  ");
	            } else {
	                System.out.print(i+";  ");
	            }
	        }	
		 System.out.println();
	}
	
	private static void task02() {
		int size = 10;
        int[] array = new int[size];
        double middleValue = 0.0;

        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 11 + 10));
            System.out.print(array[i] + ";  ");
            middleValue = middleValue + array[i];
        }
        System.out.println();
        System.out.println("Middle Value = " + (middleValue / 10));		
	}
	
	private static void task03() {
		 StringBuilder longString = new StringBuilder("");
         for (int i = 1; i <= 30; i++)
            longString.append("(" + i + ")");
        System.out.println(longString);			
	}
}
