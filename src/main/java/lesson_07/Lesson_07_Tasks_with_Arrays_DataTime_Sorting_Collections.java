package main.java.lesson_07;

import main.java.Utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Scanner;

public class Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections {
	private static String LESSON_NAME = "Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections".replace('_', ' ').toUpperCase();
    
	private static final String TASK01 = "Create 2-dimentional array M*N and fill it by random numbers. Sort array in such way, that in left upper corner would be minimum value. "
    		+ "And all other values increases from left to right line by line.";
	
    private static final String TASK02 = "There is a txt file. calculate how many lines, words, and symbols it contains.";
    
    private static final String TASK03 = "There is a string like \"22.01.2019 19:15:00\". " +
            "Write method which convert it into format \"22 Jan, 7:15 PM\". Consider case with invalid input and implement validation.";
    private static final String TASK04 = "There is a List of objects which of them has 2 fields: int и String. Remove that objects which has dublicate int value. Only one of dublicate objects should remain.";

    public static void run() {
        Utils utils = new Utils();
        System.out.println(Utils.wrapMessage(LESSON_NAME, true,'*','*', '*'));
        utils.execute(TASK01, Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections::task01);
        utils.execute(TASK02, Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections::task02);
        utils.execute(TASK03, Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections::task03);
        utils.execute(TASK03, Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections::task03_1);
        utils.execute(TASK04, Lesson_07_Tasks_with_Arrays_DataTime_Sorting_Collections::task04);
    }


    @SuppressWarnings("unused")
	private static void task01() {
    	int[][] arrayToSort = createArray();
    	int[] flatArray = Arrays.stream(arrayToSort)
    	        .flatMapToInt(Arrays::stream)
    	        .sorted()
    	        .toArray();
    	
    	System.out.println("Initial array");
    	print2dArray(arrayToSort);
    	System.out.println(Utils.wrapMessage("",false,'-','\u0000','\u0000'));
    	
    	int dimentionN = arrayToSort.length;
    	int dimentionM = arrayToSort[0].length;
    	int[][]sortedArr = new int[dimentionN][dimentionM];
    	for(int i =0; i < dimentionN; i++) {
    		System.arraycopy(flatArray, i*dimentionM, sortedArr[i], 0, dimentionM);
    	}
    	System.out.println("Sorted array");
    	print2dArray(sortedArr);
    	
    }

    @SuppressWarnings("unused")
	private static void task02() {
		StringBuilder wholeText = new StringBuilder();
		int linesCount = 0;
		int wordsCount = 0;
		int signsCount = 0;
		try (FileReader newReader = new FileReader("src/com/hillel/homeworks/lesson_07/FileForAnalisys.txt");
				Scanner scanner = new Scanner(newReader);) {
			while (scanner.hasNextLine()) {
				wholeText.append(scanner.nextLine()).append("\n");
				linesCount++;
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        System.out.println("Lines read from file: " + linesCount + "\n");
        
        linesCount = 0;
        for (Character c : wholeText.toString().toCharArray()) {
            if (c == '\n') linesCount++;
        }
        System.out.println("Lines has been written into variable separated by \\n: " + linesCount);

        String[] intireLines = wholeText.toString().split("\n");
        System.out.println("Lines get by String split \\n: " + intireLines.length);
       
        System.out.println(".".repeat(Utils.DEFAULT_LINE_LENGHT));

        if (wholeText.charAt(1) != ' ') {
            wordsCount = 1;
        }
        for (int i = 1; i < wholeText.length() - 1; i++) {
            if (wholeText.charAt(i) == ' ' && wholeText.charAt(i + 1) != ' ') wordsCount++;
        }
        System.out.println("Words counted: " + wordsCount);
        System.out.println(".".repeat(Utils.DEFAULT_LINE_LENGHT));
        System.out.println("Characters: " + wholeText.length());
    }

    @SuppressWarnings("finally")
	private static void task03() {
    	String[] timedate={
    			"22.01.2019 19:15:43",    // Correct pattern
    			" 22.01.2019 19:15:43 ",  // Correct pattern with spaces
    			"01.01.1970 00:00:00",    // Minimal correct date
    			"31.12.9999 23:59:59",    // Maximum correct date
    			"29.02.1980 23:59:59",    // correct February date Lead year
    			"22.01.2019 19:15:43D",   // Incorrect pattern
    			"01.01.1650 09:00:00" ,    // Incorrect year
    			"41.01.2023 12:13:10",    // Incorrect day
    			"21.15.2023 09:13:10",    // Incorrect month
    			"29.02.1981 23:59:59",    // incorrect February date not lead year
    			"21.10.2023 39:13:10",    // Incorrect hour
    			"21.05.2023 09:83:10",    // Incorrect minutes
    			"21.05.2023 09:03:90"    // Incorrect seconds
    			};
    	for (String tsString : timedate) {
				try {
						MyTimeStamp ts = new MyTimeStamp(tsString);
						System.out.println(tsString + " = " + ts.convertToMMM());
					}
				 catch (IllegalArgumentException e) {
					e.printStackTrace();
				} finally {
					continue;
				}
    	}
    	
    }

    private static void task03_1() {
    	// This case parse incorrect input date changing the result. For example 41.01.2023 will be converted into February 10th.
    	String inputFormat = "dd.MM.yyyy HH:mm:ss";
    	String outputFormat = "dd MMMM, hh:mm a";
    	String[] timedate={
    			"22.01.2019 19:15:43",    // Correct pattern
    			" 22.01.2019 19:15:43 ",  // Correct pattern with spaces
    			"01.01.1970 00:00:00",    // Minimal correct date
    			"31.12.9999 23:59:59",    // Maximum correct date
    			"29.02.1980 23:59:59",    // correct February date Lead year
    			"22.01.2019 19:15:43D",   // Incorrect pattern
    			"01.01.1650 09:00:00" ,    // Incorrect year
    			"41.01.2023 12:13:10",    // Incorrect day
    			"21.15.2023 09:13:10",    // Incorrect month
    			"29.02.1981 23:59:59",    // incorrect February date not lead year
    			"21.10.2023 39:13:10",    // Incorrect hour
    			"21.05.2023 09:83:10",    // Incorrect minutes
    			"21.05.2023 09:03:90"    // Incorrect seconds
    			};
    	
    	try {
    		SimpleDateFormat inputFormatter = new SimpleDateFormat(inputFormat);
    		SimpleDateFormat outputFormatter = new SimpleDateFormat(outputFormat, Locale.FRENCH); //UA and RU are not supported
    		for(String s : timedate) {
    			Date date = inputFormatter.parse(s);
    			System.out.println("Input = " + s + "; output = " + outputFormatter.format(date));	
    		}
    	}catch(ParseException e) {
    		e.printStackTrace();
    	}
    }
    
    private static void task04() {
    	//Also can be solved throught the Overriding equals and hashcode, adding list to set and converting it back to list.
        LinkedList<SimpleObject> listWithDoublicates = new LinkedList<>();
        listWithDoublicates.add(new SimpleObject(1, "Dog-2"));
        listWithDoublicates.add(new SimpleObject(1, "Dog"));
        listWithDoublicates.add(new SimpleObject(2, "Cat"));
        listWithDoublicates.add(new SimpleObject(2, "Cat"));
        listWithDoublicates.add(new SimpleObject(3, "Cat 2"));
        listWithDoublicates.add(new SimpleObject(3, "Cat 3"));
        listWithDoublicates.add(new SimpleObject(3, "Elephant"));
        listWithDoublicates.add(new SimpleObject(4, "Bird -2"));
        listWithDoublicates.add(new SimpleObject(4, "Bird"));
        listWithDoublicates.add(new SimpleObject(5, "Crocodile"));

        System.out.println("Initial list: \n" + listWithDoublicates + "\n");
        System.out.println("List of distinct objects:\n" + getDistinctObjects(listWithDoublicates));


    }

    
//  Helper for task 1
    
	private static int[][] createArray() {
		int dimentionN; //rows
		int dimentionM; //Columns
		Scanner newScan = new Scanner(System.in);
		System.out.println("Inpurt N dimention:...");
		dimentionN = newScan.nextInt();
		System.out.println("Inpurt M dimention:...");
		dimentionM = newScan.nextInt();
		int[][] randomArray = new int[dimentionN][dimentionM];
		for (int i = 0; i < dimentionN; i++) {
			for (int j = 0; j < dimentionM; j++) {
				randomArray[i][j] = (int) (Math.random() * 100);
			}
		}
		return randomArray;
	}
	
	private static void print2dArray(int[][] arr) {
		int dimentionN = arr.length;
		int dimentionM = arr[0].length;
		for (int i = 0; i < dimentionN; i++) {
			for (int j = 0; j < dimentionM; j++) {
				System.out.printf("%4d; ",arr[i][j]);
			}
			System.out.println();
		}
	}

	
    private static LinkedList<SimpleObject> getDistinctObjects(LinkedList<SimpleObject> values) {
        HashMap<Integer, SimpleObject> map = new HashMap<>();
        for (SimpleObject element : values) {
            int key = element.getValue();
            map.put(key, element);
        }

        return new LinkedList<>(map.values());
    }
    
}
