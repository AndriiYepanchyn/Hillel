package main.java.lesson_10;


import main.java.Utils;

public class Lesson_10_JavaFx {
	private static String LESSON_NAME = "Lesson_10_JavaFx".replace('_', ' ').toUpperCase();

	private static final String TASK01 = "Нарисовать простую сцену - домик, солнце";
	private static final String TASK02 = "Нарисовть шар который сам двигается и отбивается от краев экрана";
	private static final String TASK03 = "нарисовать несколько шаров которые двигаются, отбиваются от краев и друг от друга";
	
	public static void run() {
		Utils utils = new Utils();
		System.out.println(Utils.wrapMessage(LESSON_NAME, true, '*', '*', '*'));
		utils.execute(TASK01, Lesson_10_JavaFx::task01);
		utils.execute(TASK02, Lesson_10_JavaFx::task02);
		utils.execute(TASK03, Lesson_10_JavaFx::task03);
	}
	
	private static void task01() {
		
	}

	private static void task02() {
		
	}
	
	private static void task03() {
		
	}
	
//	Helper for task

}
