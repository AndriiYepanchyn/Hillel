package com.hillel.homeworks;

import java.util.Scanner;

public class Utils implements Executor<String, Runnable> {
	public void execute(String description, Runnable method) {
		StackTraceElement[] el = Thread.currentThread().getStackTrace();

		try {
			String className = el[2].getClassName();
			String taskNumber = method.getClass().getName();
			taskNumber = taskNumber.substring(taskNumber.lastIndexOf('$') + 1, taskNumber.lastIndexOf('/'));
			System.out.println("\nStart " + className.substring(className.lastIndexOf('.') + 1) + ".  ");
//			System.out.println("Task #: " + taskNumber);

			System.out.println("------------------------------------------------------");
			System.out.println("TASK# " + taskNumber +": " + description);
			System.out.println("------------------------------------------------------");
			method.run();
			System.out.println("================ Task # " + taskNumber + " is finished ================\n");

		} catch (SecurityException | IllegalArgumentException e1) {
			e1.printStackTrace();
		}
	}

	public static void endOfTest() {
		System.out.println("Press any key");
		Scanner voidscan = new Scanner(System.in);
		String myString = voidscan.nextLine();
	}
}
