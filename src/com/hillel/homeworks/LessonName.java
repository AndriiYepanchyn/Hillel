package com.hillel.homeworks;

public class LessonName {
	public static void print(Class<?> clazz) {
		int len =Utils.DEFAULT_LINE_LENGHT;
		String dots = "*".repeat(len);
		String empty = "*" + " ".repeat(len-2) + "*";
		String clazzName = clazz.getSimpleName().replace('_', ' ').toUpperCase();
		
		int spacesTotal = len-clazzName.length()-2;
		String before = "*" + " ".repeat(spacesTotal/2);
		String after = " ".repeat(len-clazzName.length() - before.length()-1)+"*";
		
		System.out.println(dots);
		System.out.println(empty);		
		System.out.println(before + clazzName + after);
		System.out.println(empty);
		System.out.println(dots);
	}
}
