package main.java;

import java.util.Scanner;

public class Utils implements Executor<String, Runnable> {
	public static int DEFAULT_LINE_LENGHT = 85;

	/**
	* This method wrap in one task description and method which proceed the solution.
	*
	* @param description - contains the task condition and supportive information.
	* @param method  - method which will proceed the solution.
	 */
	public void execute(String description, Runnable method) {
		String taskNumber = method.getClass().getName();
		taskNumber = taskNumber.substring(taskNumber.lastIndexOf('$') + 1, taskNumber.lastIndexOf('/'));

		String startOfTaskMessage = "TASK No: " + taskNumber + "\n" + description;
		System.out.println(wrapMessage(startOfTaskMessage, false, '-', '-', '\u0000'));
		method.run();
		String endOfTask = "Task No: " + taskNumber + " is finished";
		System.out.println(wrapMessage(endOfTask, false, '=', '=', '\u0000'));
	}

	/**
	 * This method allow to add pause between tasks, which can be interrupted by pressing any key.
	 */
	public static void endOfTest() {
		System.out.println("Press any key");
		try (Scanner voidscan = new Scanner(System.in)) {
			voidscan.nextLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * wrapMassage - wrap message with bounds created from mentioned chars
	 * 
	 * @param message    - String which is to be wrapped.
	 * @param isWide     - true if its necessary to add empty line before and after
	 *                   the message, false otherwise
	 * @param signBefore - this char will create line as upper bound
	 * @param signAfter  - this char will create line as bottom bound
	 * @param signInLine - this char creates line as vertical bound
	 * @return String formatted as bounded text.
	 */
	public static String wrapMessage(String message, boolean isWide, char signBefore, char signAfter, char signInLine) {
		int len = Utils.DEFAULT_LINE_LENGHT;
		StringBuilder answer = new StringBuilder();
		String lineBefore = String.valueOf(signBefore).repeat(len) + "\n";
		String empty = isWide ? signInLine + " ".repeat(len - 2) + signInLine + "\n" : "";
		String lineAfter = String.valueOf(signAfter).repeat(len);

		answer.append(lineBefore);
		answer.append(empty);

		while (message.length() >= len - 4) {
			String substring;
			int index = message.indexOf("\n");
			if (index > -1 && index < len - 4) {
				index++;
				substring = message.substring(0, index);
				answer.append(signInLine + " " + substring + " " + signInLine);
			} else {
				index = len - 4;
				substring = message.substring(0, index);
				answer.append(signInLine + " " + substring + " " + signInLine + "\n");
			}
			message = message.substring(index, message.length());
		}
		if (message.length() < len - 4) {
			String before = signInLine + " ";
			String after = " ".repeat(len - message.length() - 3) + signInLine + "\n";
			answer.append(before + message + after);

		}
		answer.append(empty);
		answer.append(lineAfter);
		return answer.toString();
	}

}
